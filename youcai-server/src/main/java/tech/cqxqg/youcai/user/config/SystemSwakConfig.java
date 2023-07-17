package tech.cqxqg.youcai.user.config;

import tech.cqxqg.youcai.core.enums.Constants;
import com.swak.frame.environment.SystemEnvironmentConfigurable;
import com.swak.frame.eventbus.EventBusConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemSwakConfig  {

    @Bean
    public SystemEnvironmentConfigurable systemConfig() {
        SystemEnvironmentConfigurable systemConfig = new SystemEnvironmentConfigurable(Constants.BASE_PACKAGE);
        systemConfig.setInitializeLocalType(true);
        return systemConfig;
    }

    /**
     * Event Bus线程配置
     * @return
     */
    @Bean
    public EventBusConfig eventBusConfig() {
        EventBusConfig eventBusConfig = new EventBusConfig();
        eventBusConfig.setCorePoolSize(2);
        eventBusConfig.setMaxPoolSize(10);
        eventBusConfig.setQueueCapacity(100);
        return eventBusConfig;
    }
}