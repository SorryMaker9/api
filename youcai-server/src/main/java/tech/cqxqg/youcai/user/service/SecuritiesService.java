package tech.cqxqg.youcai.user.service;

import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import tech.cqxqg.youcai.user.dto.SecuritiesVo;
import tech.cqxqg.youcai.user.dto.request.SecuritiesCommand;
import tech.cqxqg.youcai.user.dto.request.SecuritiesPageReq;

public interface SecuritiesService {

    /**
     * 添加股票
     */
    Result<Void> addSecurities(SecuritiesCommand command);

    /**
     * 查询全部股票
     */
    Result<Pagination<SecuritiesVo>> querySecuritiesList(SecuritiesPageReq query);
    /**
     * 根据股票代码查看当前股票
     */
    SecuritiesVo selectSecuritiesByCode(String code);

    /**
     * 修改证券信息
     */
    Result<Void> updateSecurities(SecuritiesCommand command);

    /**
     * 删除股票
     * @param command
     * @return
     */
    Result<Void> deleteSecurities(SecuritiesCommand command);

    /**
     * 卖出证券
     * @param number
     * @return
     */
    Result<Void> sellSecurities(String code,Integer number);

}
