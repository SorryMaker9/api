package tech.cqxqg.youcai.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import tech.cqxqg.youcai.persistence.entity.UserCsBuys;

@Repository
public interface UserCsBuysMapper extends BaseMapper<UserCsBuys> {
    UserCsBuys selectUserCsBuysByUserIdAndCode(Integer userId, String code);

    int recoveryById(UserCsBuys userCsBuys);
}
