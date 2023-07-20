package tech.cqxqg.youcai.persistence.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.cqxqg.youcai.persistence.entity.UserSecuritiesFirms;
import tech.cqxqg.youcai.persistence.mapper.UserSecuritiesFirmMapper;
import tech.cqxqg.youcai.persistence.service.MpUserSecuritiesFirmsService;

@Service
public class MpUserSecuritiesFirmServiceImpl extends ServiceImpl<UserSecuritiesFirmMapper, UserSecuritiesFirms> implements MpUserSecuritiesFirmsService {
}
