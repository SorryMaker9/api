package tech.cqxqg.youcai.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swak.frame.dto.PageInfo;
import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tech.cqxqg.youcai.core.enums.ResultCode;
import tech.cqxqg.youcai.persistence.entity.UserCsBuys;
import tech.cqxqg.youcai.persistence.entity.UserCsSells;
import tech.cqxqg.youcai.persistence.service.MpUserCsBuysService;
import tech.cqxqg.youcai.persistence.service.MpUserCsSellsService;
import tech.cqxqg.youcai.user.converter.SecuritiesConverter;
import tech.cqxqg.youcai.user.converter.UserCsBuysConverter;
import tech.cqxqg.youcai.user.converter.UserCsSellsConverter;
import tech.cqxqg.youcai.user.dto.BondsDto;
import tech.cqxqg.youcai.user.dto.BondsVo;
import tech.cqxqg.youcai.user.dto.SecuritiesVo;
import tech.cqxqg.youcai.user.dto.UserCsBuysVo;
import tech.cqxqg.youcai.user.dto.request.SecuritiesCommand;
import tech.cqxqg.youcai.user.dto.request.UserCsBuysCommand;
import tech.cqxqg.youcai.user.dto.request.UserCsBuysPageReq;
import tech.cqxqg.youcai.user.dto.request.UserCsSellsCommand;
import tech.cqxqg.youcai.user.service.BondsService;
import tech.cqxqg.youcai.user.service.SecuritiesService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BondsServiceImpl implements BondsService {

    @Resource
    private SecuritiesService securitiesService;

    @Resource
    private MpUserCsBuysService mpUserCsBuysService;

    @Resource
    private UserCsBuysConverter userCsBuysConverter;

    @Resource
    private MpUserCsSellsService mpUserCsSellsService;

    @Resource
    private UserCsSellsConverter userCsSellsConverter;

    @Override
    public Result<BondsVo> buyBonds(BondsDto bondsDto) throws ParseException {

        SecuritiesVo securitiesVo = securitiesService.selectSecuritiesByCode(bondsDto.getCode());
        if (securitiesVo == null) {
            return Result.fail(1401, "没有查询到该股票");
        }
        if(bondsDto.getNumber() <= 0 ){
            return Result.fail(1401, "您输入的购买数量有错，请检查后重新提交");
        }
        if(bondsDto.getBuyPrice() <= 0){
            return Result.fail(1401, "数据错误，请重试");
        }
        if (securitiesVo.getStockAmount() - bondsDto.getNumber() < 0) {
            return Result.fail(1401, "股票数量不足");
        }
        SecuritiesCommand command = new SecuritiesCommand();
        BeanUtils.copyProperties(securitiesVo,command);
        command.setStockAmount(command.getStockAmount() - bondsDto.getNumber());


        UserCsBuys userCsBuys = new UserCsBuys();
        userCsBuys.setCode(bondsDto.getCode());
        //获取股票交易所类型
        String type = bondsDto.getCode().substring(0, 1);
        //TODO 获取用户证券公司

        //暂时获取不到登录用户数据，用123456代替
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date buyTime = sf.parse(bondsDto.getBuyTime());
        Date lineTime = sf.parse("2022-4-29 00:00:00");
        //买入价格 以分为单位
        userCsBuys.setPrice(bondsDto.getBuyPrice());
        userCsBuys.setNumber(bondsDto.getNumber());

        if (buyTime.compareTo(lineTime) <= 0) {
            //2022年4月29之前
            if ("6".equals(type) || "0".equals(type) || "3".equals(type)) {
                //买入过户费 = 买入价 * 买入数量 * 0.02%
                //买入证券佣金=买入价 * 买入数量*佣金率；当证券佣金数小于5时，则为5

                Integer fee = new Double(bondsDto.getBuyPrice() * bondsDto.getNumber() * 0.02 / 100).intValue();
                userCsBuys.setFee1(fee);

            } else if ("8".equals(type)) {
                //买入过户费=买入价*买入数量*0.025%
                //买入证券佣金=买入价*买入数量*佣金率；当证券佣金数小于5时，则为5
                Integer fee = new Double(bondsDto.getBuyPrice() * bondsDto.getNumber() * 0.025 / 100).intValue();
                userCsBuys.setFee1(fee);
            }
        } else {
            //4月29之后
            //买入过户费=买入价*买入数量*0.01%
            //买入证券佣金=买入价*买入数量*佣金率；当证券佣金数小于500时，则为500
            Integer fee = new Double(bondsDto.getBuyPrice() * bondsDto.getNumber() * 0.01 / 100).intValue();
            userCsBuys.setFee1(fee);
        }
        //todo 暂时没有证券公司，费率暂时为500分
        userCsBuys.setCsfFee(500);
        //成本价 = 买入价格 + 手续费（过户费 + 佣金）
        userCsBuys.setCostPrice(userCsBuys.getFee1() + userCsBuys.getCsfFee() + (bondsDto.getBuyPrice() * bondsDto.getNumber()));
        userCsBuys.setBoughtAt(buyTime);
        userCsBuys.setCreatedAt(new Date());
        userCsBuys.setUserId(123456);
        //返回数据
        BondsVo bondsVo = new BondsVo();
        bondsVo.setNumber(bondsDto.getNumber());
        bondsVo.setFee(userCsBuys.getFee1() + userCsBuys.getCsfFee());
        bondsVo.setCostPrice(userCsBuys.getCostPrice());
        securitiesService.updateSecurities(command);
        return mpUserCsBuysService.save(userCsBuys) ? Result.success(bondsVo) : Result.fail(1401, "插入数据失败");
    }

    @Override
    public Result<HashMap<String,Object>> sellBonds(BondsDto bondsDto) throws ParseException {
        //UserCsBuysVo userCsBuysVo = queryUserCsBuysByCode(bondsDto.getCode());
        UserCsBuysVo userCsBuysVo = queryUserCsBuysById(bondsDto.getId());
        if(userCsBuysVo == null){
            return Result.fail(1401, "没有查询到该股票");
        }
        if (userCsBuysVo.getNumber() - bondsDto.getNumber() < 0) {
            return Result.fail(1401, "卖出数量大于买入数量，不可卖出");
        }
        UserCsBuysCommand command = new UserCsBuysCommand();
        BeanUtils.copyProperties(userCsBuysVo, command);
        //todo 售出数量 全部卖出
        command.setNumber(command.getNumber() - bondsDto.getNumber());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        command.setSellStatus(1);
        SimpleDateFormat sfDay = new SimpleDateFormat("yyyy-MM-dd");

        UserCsBuys userCsBuys = userCsBuysConverter.toEntity(command);
        userCsBuys.setUpdatedAt(new Date());


        String type = bondsDto.getCode().substring(0, 1);
        Date buyTime = sf.parse(bondsDto.getBuyTime());
        Date lineTime = sf.parse("2022-4-29 00:00:00");
        UserCsSellsCommand userCsSellsCommand = new UserCsSellsCommand();
        //todo 获取用户信息
        userCsSellsCommand.setUserId(123456);
        //todo 获取证券公司信息

        userCsSellsCommand.setCode(bondsDto.getCode());
        userCsSellsCommand.setNumber(bondsDto.getNumber());
        userCsSellsCommand.setSoldAt(new Date());
        userCsSellsCommand.setPrice(bondsDto.getBuyPrice());

        Integer sellCost = userCsSellsCommand.getPrice() * userCsSellsCommand.getNumber();
        //todo
        Integer buyCost = userCsBuys.getPrice() * bondsDto.getNumber();

        if (buyTime.compareTo(lineTime) <= 0) {
            //2022年4月29之后
            if ("6".equals(type) || "0".equals(type) || "3".equals(type)) {
                //卖出过户费
                userCsSellsCommand.setFee1(new Double(sellCost * 0.02 / 100).intValue());
            } else if ("8".equals(type)) {
                userCsSellsCommand.setFee1(new Double(sellCost * 0.025 / 100).intValue());
            }
        } else {
            //4月29之前
            userCsSellsCommand.setFee1(new Double(sellCost * 0.01 / 100).intValue());
        }
        //todo 印花税
        userCsSellsCommand.setFee2(0);
        //todo 佣金
        userCsSellsCommand.setCsfFee(500);
        //todo 红利率
        userCsSellsCommand.setDividendFee(0);
        //todo 利息
        userCsSellsCommand.setInterests(0);
        //利润 盈亏=卖出数量*卖出价-买入数量*买入价-（卖出过户费+卖出证券佣金+买入过户费+买入佣金）
        userCsSellsCommand.setProfit(sellCost - buyCost - (userCsSellsCommand.getFee1() + userCsSellsCommand.getCsfFee() + userCsBuys.getFee1() + userCsBuys.getCsfFee()));
        //利润率=（卖出价-买入价)/买入价*100%
        Double rate = (double) (sellCost - buyCost) / buyCost * 100;

        userCsSellsCommand.setProfitRate(new BigDecimal(rate));
        //持有天数
        Long day = (userCsSellsCommand.getSoldAt().getTime() - userCsBuys.getBoughtAt().getTime()) / (1000 * 60 * 60 * 24);

        userCsSellsCommand.setHoldingDays(day.intValue());
        userCsBuys.setSellIntro("于" + sfDay.format(new Date()) + "，以" + sellCost + "分价格将" + userCsSellsCommand.getNumber() + "股全部卖出");

        UserCsSells userCsSells = userCsSellsConverter.toEntity(userCsSellsCommand);

        mpUserCsBuysService.updateById(userCsBuys);
        HashMap<String, Object> map = new HashMap<>();
        map.put("fee",userCsSells.getFee1() + userCsSells.getCsfFee());
        map.put("price",userCsSells.getPrice());
        map.put("number",userCsSells.getNumber());
        return mpUserCsSellsService.save(userCsSells) ? Result.success(map) : Result.fail(ResultCode.UPDATE_ERROR);
    }

    @Override
    public UserCsBuysVo queryUserCsBuysByCode(String code) {
        return mpUserCsBuysService.lambdaQuery().eq(StringUtils.isNotEmpty(code), UserCsBuys::getCode, code)
                .list().stream().findFirst().map(userCsBuysConverter::entityToVo).orElse(null);
    }

    @Override
    public UserCsBuysVo queryUserCsBuysById(Integer id) {
        return mpUserCsBuysService.lambdaQuery().eq(id != null,UserCsBuys::getId,id)
                .list().stream().findFirst().map(userCsBuysConverter::entityToVo).orElse(null);
    }

    @Override
    public Result<Pagination<UserCsBuysVo>> queryUserCsBuyList(UserCsBuysPageReq query) {
        QueryWrapper<UserCsBuys> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(query.getUserId() != null , UserCsBuys::getUserId, query.getUserId());
        IPage<UserCsBuys> page = mpUserCsBuysService.page(new Page<>(query.getCurrentPage(), query.getPageSize()), queryWrapper);
        List<UserCsBuysVo> userCsBuysVos = page.getRecords().stream().map(userCsBuysConverter::entityToVo).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(userCsBuysVos)){
            return Result.success(Pagination.builder(Collections.emptyList(), PageInfo.page(query, 0L)));
        }
        return Result.success(Pagination.builder(userCsBuysVos, PageInfo.page(query, page.getTotal())));
    }

}
