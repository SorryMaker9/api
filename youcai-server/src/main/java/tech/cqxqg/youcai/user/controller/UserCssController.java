package tech.cqxqg.youcai.user.controller;


import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.cqxqg.youcai.user.dto.UserCssVo;
import tech.cqxqg.youcai.user.dto.request.UserCssPageReq;
import tech.cqxqg.youcai.user.service.UserCssService;

/**
 * 用户中国证券模块接口
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/user")
public class UserCssController {
    @Autowired
    private UserCssService userCssService;
    @GetMapping(value = "/list")
    public Result<Pagination<UserCssVo>> queryUserCssList(@ModelAttribute @Validated UserCssPageReq query){
        return userCssService.queryUserCssList(query);
    }
}
