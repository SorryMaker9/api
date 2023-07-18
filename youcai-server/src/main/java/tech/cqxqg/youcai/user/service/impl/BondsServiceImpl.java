package tech.cqxqg.youcai.user.service.impl;

import com.swak.frame.dto.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tech.cqxqg.youcai.persistence.entity.ChinaSecurities;
import tech.cqxqg.youcai.persistence.entity.UserCsBuys;
import tech.cqxqg.youcai.persistence.service.MpSecuritiesService;
import tech.cqxqg.youcai.persistence.service.MpUserCsBuysService;
import tech.cqxqg.youcai.user.dto.BondsDto;
import tech.cqxqg.youcai.user.dto.SecuritiesVo;
import tech.cqxqg.youcai.user.service.BondsService;
import tech.cqxqg.youcai.user.service.SecuritiesService;
import tech.cqxqg.youcai.user.utils.UserTokenUtil;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BondsServiceImpl implements BondsService {

    @Resource
    private SecuritiesService securitiesService;

    @Resource
    private MpUserCsBuysService mpUserCsBuysService;
    @Override
    public Result<Void> buyBonds(BondsDto bondsDto) throws ParseException {
        SecuritiesVo securitiesVo = securitiesService.selectSecuritiesByCode(bondsDto.getCode());
        if (securitiesVo == null) {
            return Result.fail(1401, "没有查询到该股票");
        }
        if (securitiesVo.getStockAmount() - bondsDto.getNumber() < 0) {
            return Result.fail(1401, "股票数量不足");
        }
        UserCsBuys userCsBuys = new UserCsBuys();
        userCsBuys.setCode(bondsDto.getCode());
        //获取股票交易所类型
        String type = bondsDto.getCode().substring(0, 1);

        //暂时获取不到登录用户数据，用123456代替
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date buyTime = sf.parse(bondsDto.getBuyTime());
        Date lineTime = sf.parse("2022-4-29 00:00:00");
        if (buyTime.compareTo(lineTime) >= 0) {
            //4月29之后
            if ("6".equals(type) || "0".equals(type) || "3".equals(type)) {
                //买入过户费 = 买入价 * 买入数量 * 0.02%
                //买入证券佣金=买入价*买入数量*佣金率；当证券佣金数小于5时，则为5

                Integer price = bondsDto.getBuyPrice().multiply(BigDecimal.valueOf(bondsDto.getNumber())).multiply(BigDecimal.valueOf(0.02 / 100)).intValue();
                userCsBuys.setPrice(price);
                //暂时没有证券公司，费率暂时为0
                userCsBuys.setCsfFee(0);
            } else if ("8".equals(type)) {
                //买入过户费=买入价*买入数量*0.025%
                //买入证券佣金=买入价*买入数量*佣金率；当证券佣金数小于5时，则为5
                Integer price = bondsDto.getBuyPrice().multiply(BigDecimal.valueOf(bondsDto.getNumber())).multiply(BigDecimal.valueOf(0.025 / 100)).intValue();
                userCsBuys.setPrice(price);
                //暂时没有证券公司，费率暂时为0
                userCsBuys.setCsfFee(0);
            }
        } else {
            //4月29之前
            //买入过户费=买入价*买入数量*0.01%
            //买入证券佣金=买入价*买入数量*佣金率；当证券佣金数小于5时，则为5
            userCsBuys.setCsfFee(0);
            Integer price = bondsDto.getBuyPrice().multiply(BigDecimal.valueOf(bondsDto.getNumber())).multiply(BigDecimal.valueOf(0.025 / 100)).intValue();
            userCsBuys.setPrice(price);
            //暂时没有证券公司，费率暂时为0
            userCsBuys.setCsfFee(0);
        }
        userCsBuys.setBoughtAt(buyTime);
        userCsBuys.setCreatedAt(new Date());
        userCsBuys.setUserId(123456);

        return mpUserCsBuysService.save(userCsBuys) ? Result.success() : Result.fail(1401, "插入数据失败");
    }
}
