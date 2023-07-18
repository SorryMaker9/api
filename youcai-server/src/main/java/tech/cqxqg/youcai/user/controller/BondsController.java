package tech.cqxqg.youcai.user.controller;

import com.swak.frame.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.cqxqg.youcai.user.dto.BondsDto;
import tech.cqxqg.youcai.user.service.BondsService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@Slf4j
@Validated
@RestController
@RequestMapping("/bonds")
public class BondsController {

    @Resource
    private BondsService bondsService;
    @PostMapping(value = "/buy")
    public Result<Void> buyBonds(@RequestBody BondsDto bondsDto) throws ParseException {

        return bondsService.buyBonds(bondsDto);
    }
}
