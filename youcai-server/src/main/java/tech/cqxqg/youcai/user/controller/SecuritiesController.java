package tech.cqxqg.youcai.user.controller;


import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.cqxqg.youcai.user.dto.SecuritiesVo;
import tech.cqxqg.youcai.user.dto.request.SecuritiesCommand;
import tech.cqxqg.youcai.user.dto.request.SecuritiesPageReq;
import tech.cqxqg.youcai.user.service.SecuritiesService;

import javax.annotation.Resource;


@Slf4j
@Validated
@RestController
@RequestMapping("/securities")
public class SecuritiesController {

    @Resource
    private SecuritiesService securitiesService;

    /**
     * 代码查询
     * @return
     */
    @GetMapping("/find/{code}")
    public SecuritiesVo querySecuritiesByCode(@PathVariable("code") String code){
        return securitiesService.selectSecuritiesByCode(code);
    }
    @GetMapping("/list")
    public Result<Pagination<SecuritiesVo>> querySecuritiesList(@ModelAttribute @Validated SecuritiesPageReq query){
        return securitiesService.querySecuritiesList(query);
    }
    @PostMapping("/add")
    public Result<Void> addSecurities(@RequestBody @Validated SecuritiesCommand securitiesCommand){
        return securitiesService.addSecurities(securitiesCommand);
    }
    @PostMapping("/edit")
    public Result<Void> editSecurities(@RequestBody @Validated SecuritiesCommand securitiesCommand){
        return securitiesService.updateSecurities(securitiesCommand);
    }
    @PostMapping("/sell")
    public Result<Void> sellSecurities(String code, Integer number){
        return securitiesService.sellSecurities(code,number);
    }
}
