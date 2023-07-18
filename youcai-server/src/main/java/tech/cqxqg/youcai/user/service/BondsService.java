package tech.cqxqg.youcai.user.service;

import com.swak.frame.dto.Result;
import tech.cqxqg.youcai.user.dto.BondsDto;

import java.text.ParseException;

public interface BondsService {
    public Result<Void> buyBonds(BondsDto bondsDto) throws ParseException;
}
