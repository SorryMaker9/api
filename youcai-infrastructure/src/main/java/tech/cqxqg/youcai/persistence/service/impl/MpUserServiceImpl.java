package com.demo.persistence.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.persistence.service.MpUserService;
import com.demo.persistence.entity.SysUser;
import com.demo.persistence.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MpUserServiceImpl extends ServiceImpl<UserMapper, SysUser>
        implements MpUserService {


}