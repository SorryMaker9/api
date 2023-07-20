package tech.cqxqg.youcai.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.cqxqg.youcai.persistence.entity.SecuritiesFirms;
import tech.cqxqg.youcai.persistence.mapper.SecuritiesMapper;
import tech.cqxqg.youcai.persistence.service.MpSecuritiesService;

@Service
public class MpSecuritiesServiceImpl extends ServiceImpl<SecuritiesMapper, SecuritiesFirms> implements MpSecuritiesService {

}
