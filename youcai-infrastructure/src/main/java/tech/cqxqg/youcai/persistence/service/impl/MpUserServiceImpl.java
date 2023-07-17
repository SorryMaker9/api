package tech.cqxqg.youcai.persistence.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tech.cqxqg.youcai.persistence.service.MpUserService;
import tech.cqxqg.youcai.persistence.entity.SysUser;
import tech.cqxqg.youcai.persistence.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class MpUserServiceImpl extends ServiceImpl<UserMapper, SysUser>
        implements MpUserService {


}