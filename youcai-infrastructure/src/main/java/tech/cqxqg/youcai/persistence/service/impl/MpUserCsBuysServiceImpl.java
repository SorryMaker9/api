package tech.cqxqg.youcai.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
import tech.cqxqg.youcai.persistence.entity.UserCsBuys;
import tech.cqxqg.youcai.persistence.mapper.UserCsBuysMapper;
import tech.cqxqg.youcai.persistence.service.MpUserCsBuysService;

@Service
public class MpUserCsBuysServiceImpl extends ServiceImpl<UserCsBuysMapper, UserCsBuys>
        implements MpUserCsBuysService {
}
