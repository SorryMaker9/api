package tech.cqxqg.youcai.user.controller;


import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.cqxqg.youcai.user.constants.StockConstants;
import tech.cqxqg.youcai.user.dto.dto.UserSecuritiesFirmsDTO;
import tech.cqxqg.youcai.user.dto.request.UserSecuritiesFirmsCommand;
import tech.cqxqg.youcai.user.dto.vo.UserSecuritiesFirmsVo;
import tech.cqxqg.youcai.user.service.UserSecuritiesFirmService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/stock/UserSecuritiesFirm")
public class UserSecuritiesFirmController {

    @Resource
    private UserSecuritiesFirmService userSecuritiesFirmService;


    @GetMapping({"/page"})
    public Result<Pagination<UserSecuritiesFirmsVo>> page(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                          @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize) {

        Pagination<UserSecuritiesFirmsVo> pagination = userSecuritiesFirmService.getPage(page, pageSize);
        return Result.success(pagination);
    }

    @PostMapping({"/save"})
    public Result<String> save(@Validated @RequestBody UserSecuritiesFirmsDTO userSecuritiesFirmsDTO) {
        userSecuritiesFirmService.saveUserSecuritiesFirm(userSecuritiesFirmsDTO);
        return Result.success(StockConstants.USER_SAVE_SECURITIES_FIRM);
    }

    @PostMapping({"/update"})
    public Result<String> update(@Validated @RequestBody UserSecuritiesFirmsCommand userSecuritiesFirmsCommand) {
        userSecuritiesFirmService.updateUserSecuritiesFirm(userSecuritiesFirmsCommand);
        return Result.success(StockConstants.USER_UPDATE_SECURITIES_FIRM);
    }

    @DeleteMapping({"/delete/{id}"})
    public Result<String> delete(@PathVariable("id") Long id) {
        userSecuritiesFirmService.deleteUserSecuritiesFirm(id);
        return Result.success(StockConstants.USER_DELETE_SECURITIES_FIRM);
    }
    
}
