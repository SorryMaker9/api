package tech.cqxqg.youcai.user.service;

import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import tech.cqxqg.youcai.persistence.entity.UserCsBuys;
import tech.cqxqg.youcai.user.dto.BondsDto;
import tech.cqxqg.youcai.user.dto.BondsVo;
import tech.cqxqg.youcai.user.dto.UserCsBuysVo;
import tech.cqxqg.youcai.user.dto.request.UserCsBuysPageReq;

import java.text.ParseException;
import java.util.HashMap;

public interface BondsService {
    public Result<BondsVo> buyBonds(BondsDto bondsDto) throws ParseException;

    public Result<HashMap<String, Object>> sellBonds(BondsDto bondsDto) throws ParseException;

    public UserCsBuysVo queryUserCsBuysByCode(String code);

    public UserCsBuysVo queryUserCsBuysById(Integer id);

    public Result<Pagination<UserCsBuysVo>> queryUserCsBuyList(UserCsBuysPageReq query);
}
