package tech.cqxqg.youcai.user.config;

import tech.cqxqg.youcai.core.config.JacksonSerializerFeatureCompatibleForJackson;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        final MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        SimpleModule simpleModule = new SimpleModule();
        ObjectMapper objectMapper =  jackson2HttpMessageConverter.getObjectMapper();
        //simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        //simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        jackson2HttpMessageConverter.getObjectMapper().registerModule(simpleModule);
        jackson2HttpMessageConverter.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jackson2HttpMessageConverter.getObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        jackson2HttpMessageConverter.getObjectMapper().setTimeZone(TimeZone.getTimeZone("GMT+8"));
        BeanSerializerModifier beanSerializerModifier = new JacksonSerializerFeatureCompatibleForJackson(JacksonSerializerFeatureCompatibleForJackson.SerializerFeature.WriteNullListAsEmpty);
        jackson2HttpMessageConverter.getObjectMapper().setSerializerFactory(objectMapper.getSerializerFactory().withSerializerModifier(beanSerializerModifier));
        converters.add(0, jackson2HttpMessageConverter);
        super.configureMessageConverters(converters);
    }

    @Bean
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return localeResolver;
    }

}
