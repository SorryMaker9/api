package tech.cqxqg.youcai.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swak.frame.dto.PageInfo;
import com.swak.frame.dto.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tech.cqxqg.youcai.core.filter.RequestContext;
import tech.cqxqg.youcai.persistence.entity.SecuritiesFirms;
import tech.cqxqg.youcai.persistence.entity.UserSecuritiesFirms;
import tech.cqxqg.youcai.persistence.service.MpSecuritiesService;
import tech.cqxqg.youcai.persistence.service.MpUserSecuritiesFirmsService;
import tech.cqxqg.youcai.user.common.ExistTypeEnum;
import tech.cqxqg.youcai.user.common.UserCountEnum;
import tech.cqxqg.youcai.user.constants.StockConstants;
import tech.cqxqg.youcai.user.constants.StockResultCode;
import tech.cqxqg.youcai.user.converter.UserSecuritiesFirmConverter;
import tech.cqxqg.youcai.user.dto.dto.UserSecuritiesFirmsDTO;
import tech.cqxqg.youcai.user.dto.request.UserSecuritiesFirmsCommand;
import tech.cqxqg.youcai.user.dto.vo.UserSecuritiesFirmsVo;
import tech.cqxqg.youcai.user.exception.StockException;
import tech.cqxqg.youcai.user.service.UserSecuritiesFirmService;
import tech.cqxqg.youcai.user.util.ConvertUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;



@Service
public class UserSecuritiesFirmServiceImpl implements UserSecuritiesFirmService {


    @Resource
    private MpUserSecuritiesFirmsService mpUserSecuritiesFirmsService;

    @Resource
    private UserSecuritiesFirmConverter userSecuritiesFirmConverter;
    @Resource
    private MpSecuritiesService mpSecuritiesService;


    @Override
    public void saveUserSecuritiesFirm(UserSecuritiesFirmsDTO userSecuritiesFirmsDTO) {

        String userId = RequestContext.getUserId();

        if (StringUtils.isBlank(userId)) {
            throw new StockException(StockResultCode.USER_NOT_LOGIN);
        }

        boolean firmExist = this.isExistSecuritiesFirmById(userSecuritiesFirmsDTO.getSecuritiesFirmId());
        if (!firmExist) {
            throw new StockException(StockResultCode.FIRM_NOT_EXIST);
        }

        boolean userFirmExist = this.isExistUserFirmByUserIdAndFirmId(userSecuritiesFirmsDTO.getUserId(), userSecuritiesFirmsDTO.getSecuritiesFirmId());
        if (userFirmExist) {
            throw new StockException(StockResultCode.USER_FIRM_EXIST);
        }

        UserSecuritiesFirms userSecuritiesFirms = new UserSecuritiesFirms();

        BeanUtils.copyProperties(userSecuritiesFirmsDTO, userSecuritiesFirms);

        ConvertUtil.convertProperties(userSecuritiesFirmsDTO, userSecuritiesFirms);

        userSecuritiesFirms.setUserId(Long.valueOf(userId));

        mpUserSecuritiesFirmsService.save(userSecuritiesFirms);

        updateSecuritiesUsers(userSecuritiesFirmsDTO.getSecuritiesFirmId(), UserCountEnum.ADD);

        updateDefault(userSecuritiesFirms.getUserId(), userSecuritiesFirms.getId());


    }

    @Override
    public Pagination<UserSecuritiesFirmsVo> getPage(Integer page, Integer pageSize) {

        String userId = RequestContext.getUserId();
        if (StringUtils.isBlank(userId)) {
            throw new StockException(StockResultCode.USER_NOT_LOGIN);
        }

        if (pageSize > StockConstants.MAX_PAGE_SIZE) {
            pageSize = StockConstants.MAX_PAGE_SIZE;
        }

        Page<UserSecuritiesFirms> firmsPage = new Page<>(page, pageSize);

        LambdaQueryWrapper<UserSecuritiesFirms> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(UserSecuritiesFirms::getUserId, Long.valueOf(userId));

        Page<UserSecuritiesFirms> pages = mpUserSecuritiesFirmsService.page(firmsPage, wrapper);

        Pagination<UserSecuritiesFirmsVo> voPagination = new Pagination<>();

        PageInfo pageInfo = PageInfo.newPageInfo(page, pageSize);

        List<UserSecuritiesFirms> records = pages.getRecords();

        if (records.isEmpty()) {
            voPagination.setPage(pageInfo);
            return voPagination;
        }

        List<UserSecuritiesFirmsVo> userSecuritiesFirmsVos = new ArrayList<>(records.size());

        for (UserSecuritiesFirms record : records) {

            UserSecuritiesFirmsVo userSecuritiesFirmsVo = new UserSecuritiesFirmsVo();
            BeanUtils.copyProperties(record, userSecuritiesFirmsVo);
            ConvertUtil.convertProperties(record, userSecuritiesFirmsVo);
            userSecuritiesFirmsVos.add(userSecuritiesFirmsVo);
        }

        Integer total = this.mpUserSecuritiesFirmsService.count(wrapper);

        pageInfo.setTotalSize(total.longValue());

        voPagination.setList(userSecuritiesFirmsVos);

        voPagination.setPage(pageInfo);

        return voPagination;


    }

    @Override
    public void updateUserSecuritiesFirm(UserSecuritiesFirmsCommand userSecuritiesFirmsCommand) {

        String userId = RequestContext.getUserId();
        if (StringUtils.isBlank(userId)) {
            throw new StockException(StockResultCode.USER_NOT_LOGIN);
        }

        UserSecuritiesFirms userSecuritiesFirms = new UserSecuritiesFirms();

        BeanUtils.copyProperties(userSecuritiesFirmsCommand, userSecuritiesFirms);

        ConvertUtil.convertProperties(userSecuritiesFirmsCommand, userSecuritiesFirms);

        mpUserSecuritiesFirmsService.updateById(userSecuritiesFirms);

        if (userSecuritiesFirms.getIsDefault()) {
            updateDefault(userSecuritiesFirms.getUserId(), userSecuritiesFirms.getId());
        }
    }

    @Override
    public void deleteUserSecuritiesFirm (Long id){
        String userId = RequestContext.getUserId();
        LambdaQueryWrapper<UserSecuritiesFirms> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.select(UserSecuritiesFirms::getSecuritiesFirmId, UserSecuritiesFirms::getUserId)
                .eq(UserSecuritiesFirms::getId, id);

        UserSecuritiesFirms userSecuritiesFirms = mpUserSecuritiesFirmsService.getOne(queryWrapper);
        if (userSecuritiesFirms != null) {
            if (!userSecuritiesFirms.getUserId().equals(Long.valueOf(userId))) {
                throw new StockException(StockResultCode.USER_AND_FIRM_NO_ACCORD);
            } else {
                mpUserSecuritiesFirmsService.removeById(id);
                updateSecuritiesUsers(userSecuritiesFirms.getSecuritiesFirmId(), UserCountEnum.MINUS);
            }
        }
    }


    private void updateSecuritiesUsers (Long securitiesFirmId, UserCountEnum operation){

        if (securitiesFirmId == null) {
            return;
        }
        boolean firmExist = this.isExistSecuritiesFirmById(securitiesFirmId);
        if (!firmExist) {
            return;
        }

        LambdaUpdateWrapper<SecuritiesFirms> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(SecuritiesFirms::getId, securitiesFirmId);
        switch (operation) {
            case ADD:
                updateWrapper.setSql("count_users = count_users + 1");
                break;
            case MINUS:
                updateWrapper.setSql("count_users = count_users - 1");
                break;
            default:
                throw new StockException(StockResultCode.OPERATION_ABNORMAL);
        }

        mpSecuritiesService.update(updateWrapper);

    }

    private boolean isExistUserFirmByUserIdAndFirmId (Long userId, Long firmId){

        LambdaQueryWrapper<UserSecuritiesFirms> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(UserSecuritiesFirms::getUserId, userId)
                .eq(UserSecuritiesFirms::getSecuritiesFirmId, firmId);

        int count = this.mpUserSecuritiesFirmsService.count(wrapper);

        return ExistTypeEnum.NO_EXIST.ordinal() != count;
    }

    private boolean isExistSecuritiesFirmById (Long firmId){

        if (firmId == null) {
            return false;
        }
        LambdaQueryWrapper<SecuritiesFirms> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(SecuritiesFirms::getId, firmId);

        int count = mpSecuritiesService.count(wrapper);

        return ExistTypeEnum.EXIST.ordinal() == count;
    }

    private void updateDefault(Long userId, Long id){

        LambdaUpdateWrapper<UserSecuritiesFirms> wrapper = new LambdaUpdateWrapper<>();

        wrapper.set(UserSecuritiesFirms::getIsDefault, false)
                .eq(UserSecuritiesFirms::getUserId, userId)
                .ne(UserSecuritiesFirms::getId, id);

        mpUserSecuritiesFirmsService.update(wrapper);
    }


}