package tech.cqxqg.youcai.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
import tech.cqxqg.youcai.persistence.entity.UserCss;
import tech.cqxqg.youcai.persistence.mapper.UserCssMapper;
import tech.cqxqg.youcai.persistence.service.MpUserCssService;

@Service
public class MpUserCssServiceImpl extends ServiceImpl<UserCssMapper, UserCss>
        implements MpUserCssService {
}
