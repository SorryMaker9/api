package tech.cqxqg.youcai.user.controller;

import tech.cqxqg.youcai.user.dto.UserVo;
import tech.cqxqg.youcai.user.dto.request.UserCommand;
import tech.cqxqg.youcai.user.dto.request.UserPageReq;
import tech.cqxqg.youcai.user.service.UserService;
import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 用户管理模块接口
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 分页查询
     * @param query
     * @return
     */
    @GetMapping("/list")
    public Result<Pagination<UserVo>> queryUserList(@ModelAttribute @Validated UserPageReq query) {
        return userService.queryUserList(query);
    }
    /**
     * 新增用户
     */
    @PostMapping("/add")
    public Result<Void> addUser(@RequestBody @Validated UserCommand command) {
      return userService.addUser(command);
    }

    /**
     * 用户修改
     * @param command
     * @return
     */
    @PutMapping("/edit")
    public Result<Void> editUser(@RequestBody @Validated UserCommand command) {
        return userService.updateUser(command);
    }
}
