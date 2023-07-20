package tech.cqxqg.youcai.user.controller;


import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.cqxqg.youcai.user.constants.StockConstants;
import tech.cqxqg.youcai.user.dto.dto.SecuritiesFirmDTO;
import tech.cqxqg.youcai.user.dto.request.SecuritiesFirmCommand;
import tech.cqxqg.youcai.user.dto.vo.SecuritiesFirmsVo;
import tech.cqxqg.youcai.user.service.SecuritiesFirmService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/stock/securitiesFirm")
public class SecuritiesFirmController {

    @Resource
    private SecuritiesFirmService securitiesFirmService;


    @GetMapping("/page")
    public Result<Pagination<SecuritiesFirmsVo>> page(@RequestParam(value = "name",required = false) String name,
                                                      @RequestParam(value = "page",defaultValue = "1") Integer page,
                                                      @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize) {
        Pagination<SecuritiesFirmsVo> securitiesFirmList = this.securitiesFirmService.getPage(name, page, pageSize);
        return Result.success(securitiesFirmList);
    }

    @PostMapping("/save")
    public Result<String> save(@Validated @RequestBody SecuritiesFirmDTO securitiesFirmDTO) {
        this.securitiesFirmService.saveSecuritiesFirm(securitiesFirmDTO);
        return Result.success(StockConstants.SAVE_SECURITIES_FIRM);
    }

    @PostMapping("/update")
    public Result<String> update(@Validated @RequestBody SecuritiesFirmCommand securitiesFirmCommand) {
        this.securitiesFirmService.updateSecuritiesFirm(securitiesFirmCommand);
        return Result.success(StockConstants.UPDATE_SECURITIES_FIRM);
    }

    @DeleteMapping("/delete/{id}")
    public Result<String> delete(@PathVariable("id") Long id) {
        this.securitiesFirmService.deleteSecuritiesFirm(id);
        return Result.success(StockConstants.DELETE_SECURITIES_FIRM);
    }
}
