package tech.cqxqg.youcai.user.controller;

import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.cqxqg.youcai.user.dto.dto.BondsDto;
import tech.cqxqg.youcai.user.dto.BondsVo;
import tech.cqxqg.youcai.user.dto.UserCsBuysVo;
import tech.cqxqg.youcai.user.dto.request.UserCsBuysPageReq;
import tech.cqxqg.youcai.user.service.BondsService;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.HashMap;

@Slf4j
@Validated
@RestController
@RequestMapping("/bonds")
public class BondsController {

    @Resource
    private BondsService bondsService;
    @PostMapping(value = "/buy")
    public Result<BondsVo> buyBonds(@RequestBody @Validated BondsDto bondsDto) throws ParseException {

        return bondsService.buyBonds(bondsDto);
    }
    @PostMapping(value = "/sell")
    public Result<HashMap<String,Object>> sellBonds(@RequestBody @Validated BondsDto bondsDto) throws ParseException {
        return bondsService.sellBonds(bondsDto);
    }
    @GetMapping(value = "/list")
    public Result<Pagination<UserCsBuysVo>> queryUserCsBuyList(@ModelAttribute @Validated UserCsBuysPageReq query){
        return bondsService.queryUserCsBuyList(query);
    }
    @DeleteMapping(value = "/delete/{id}")
    public Result<Void> deleteBuyBondsRecord(@PathVariable(value = "id")Integer id){

        return bondsService.deleteBuyBondsRecordById(id);
    }
}
