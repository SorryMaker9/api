package tech.cqxqg.youcai.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
import tech.cqxqg.youcai.persistence.entity.ChinaSecurities;
import tech.cqxqg.youcai.persistence.mapper.ChinaSecuritiesMapper;
import tech.cqxqg.youcai.persistence.service.MpChinaSecuritiesService;

@Service
public class MpChinaSecuritiesServiceImpl extends ServiceImpl<ChinaSecuritiesMapper, ChinaSecurities>
implements MpChinaSecuritiesService {

}
