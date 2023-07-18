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

        //检查用回顾是否登录
        if (StringUtils.isBlank(userId)) {
            throw new StockException(StockResultCode.USER_NOT_LOGIN);
        }

        //检查公司是否存在
        boolean firmExist = this.isExistSecuritiesFirmById(userSecuritiesFirmsDTO.getSecuritiesFirmId());
        if (!firmExist) {
            throw new StockException(StockResultCode.FIRM_NOT_EXIST);
        }

        //检查用户证券公司记录是否存在
        boolean userFirmExist = this.isExistUserFirmByUserIdAndFirmId(userSecuritiesFirmsDTO.getUserId(),
                                                                      userSecuritiesFirmsDTO.getSecuritiesFirmId());

        if (userFirmExist) {
            throw new StockException(StockResultCode.USER_FIRM_EXIST);
        }

        UserSecuritiesFirms userSecuritiesFirms = new UserSecuritiesFirms();

        BeanUtils.copyProperties(userSecuritiesFirmsDTO, userSecuritiesFirms);

        ConvertUtil.convertProperties(userSecuritiesFirmsDTO, userSecuritiesFirms);

        userSecuritiesFirms.setUserId(Long.valueOf(userId));

        mpUserSecuritiesFirmsService.save(userSecuritiesFirms);

        //证券公司用户数加一
        updateSecuritiesUsers(userSecuritiesFirmsDTO.getSecuritiesFirmId(), UserCountEnum.ADD);

        if (userSecuritiesFirmsDTO.getIsDefault()) {
            //设置默认
            updateDefault(userSecuritiesFirms.getUserId(), userSecuritiesFirms.getId());
        }


    }

    @Override
    public Pagination<UserSecuritiesFirmsVo> getPage(Integer page, Integer pageSize) {

        String userId = RequestContext.getUserId();

        if (pageSize > StockConstants.MAX_PAGE_SIZE) {
            //每页最大显示20条
            pageSize = StockConstants.MAX_PAGE_SIZE;
        }

        Page<UserSecuritiesFirms> firmsPage = new Page<>(page, pageSize);

        LambdaQueryWrapper<UserSecuritiesFirms> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(StringUtils.isNotBlank(userId),UserSecuritiesFirms::getUserId, Long.valueOf(userId));

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

        Integer total = mpUserSecuritiesFirmsService.count(wrapper);

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

        UserSecuritiesFirms securitiesFirms = this.getUserSecuritiesFirms(userSecuritiesFirmsCommand.getId());

        if (securitiesFirms == null){
            //记录不存在
            throw new StockException(StockResultCode.USER_FIRM_NOT_EXIST);
        }

        //校验修改的记录是否为当前用户的
        if (!securitiesFirms.getUserId().equals(Long.valueOf(userId))){
            throw new StockException(StockResultCode.USER_AND_FIRM_NO_ACCORD);
        }

        UserSecuritiesFirms userSecuritiesFirms = new UserSecuritiesFirms();

        BeanUtils.copyProperties(userSecuritiesFirmsCommand, userSecuritiesFirms);

        ConvertUtil.convertProperties(userSecuritiesFirmsCommand, userSecuritiesFirms);

        mpUserSecuritiesFirmsService.updateById(userSecuritiesFirms);

        if (userSecuritiesFirms.getIsDefault()) {
            //设置默认
            updateDefault(userSecuritiesFirms.getUserId(), userSecuritiesFirms.getId());
        }
    }

    @Override
    public void deleteUserSecuritiesFirm (Long id){

        String userId = RequestContext.getUserId();

        if (StringUtils.isBlank(userId)){
            throw new StockException(StockResultCode.USER_NOT_LOGIN);
        }

        UserSecuritiesFirms userSecuritiesFirms = getUserSecuritiesFirms(id);

        if (userSecuritiesFirms == null){
            throw new StockException(StockResultCode.USER_FIRM_NOT_EXIST);
        }

        //判断删除的记录是否属于当前用户
        if (!userSecuritiesFirms.getUserId().equals(Long.valueOf(userId))) {
            throw new StockException(StockResultCode.USER_AND_FIRM_NO_ACCORD);
        }

        mpUserSecuritiesFirmsService.removeById(id);
        //证券公司用户数减一
        updateSecuritiesUsers(userSecuritiesFirms.getSecuritiesFirmId(), UserCountEnum.MINUS);

    }




    /**
     * 查询用户证券公司的用户胡公司id
     */
    private UserSecuritiesFirms getUserSecuritiesFirms(Long id) {

        if (id == null){
            return null;
        }

        LambdaQueryWrapper<UserSecuritiesFirms> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.select(UserSecuritiesFirms::getSecuritiesFirmId,
                            UserSecuritiesFirms::getUserId)
                    .eq(UserSecuritiesFirms::getId, id);

        return mpUserSecuritiesFirmsService.getOne(queryWrapper);
    }


    /**
     * 修改证券公司记录数
     * @param securitiesFirmId 证券公司id
     * @param operation 修改操作
     */
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

    /**
     * 根据用户id和证券公司id查询
     * @param userId 用户id
     * @param firmId 证券公司id
     * @return true:存在 false:不存在
     */
    private boolean isExistUserFirmByUserIdAndFirmId (Long userId, Long firmId){

        LambdaQueryWrapper<UserSecuritiesFirms> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(UserSecuritiesFirms::getUserId, userId)
                .eq(UserSecuritiesFirms::getSecuritiesFirmId, firmId);

        int count = this.mpUserSecuritiesFirmsService.count(wrapper);

        return ExistTypeEnum.NO_EXIST.ordinal() != count;
    }

    /**
     * 根据证券公司id查询公司
     * @param firmId 证券公司id
     * @return true:存在 false:不存在
     */
    private boolean isExistSecuritiesFirmById (Long firmId){

        if (firmId == null) {
            return false;
        }
        LambdaQueryWrapper<SecuritiesFirms> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(SecuritiesFirms::getId, firmId);

        int count = mpSecuritiesService.count(wrapper);

        return ExistTypeEnum.NO_EXIST.ordinal() != count;
    }

    /**
     * 修改用户的默认设置
     * @param userId 用户id
     * @param id 用户证卷公司id
     */
    private void updateDefault(Long userId, Long id){

        LambdaUpdateWrapper<UserSecuritiesFirms> wrapper = new LambdaUpdateWrapper<>();

        wrapper.set(UserSecuritiesFirms::getIsDefault, false)
                .eq(UserSecuritiesFirms::getUserId, userId)
                .ne(UserSecuritiesFirms::getId, id);

        mpUserSecuritiesFirmsService.update(wrapper);
    }


}