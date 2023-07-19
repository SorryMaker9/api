package tech.cqxqg.youcai.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.cqxqg.youcai.persistence.entity.UserCsSells;
import tech.cqxqg.youcai.persistence.mapper.UserCsSellsMapper;
import tech.cqxqg.youcai.persistence.service.MpUserCsSellsService;

@Service
public class MpUserCsSellsServiceImpl extends ServiceImpl<UserCsSellsMapper, UserCsSells>
        implements MpUserCsSellsService {
}
