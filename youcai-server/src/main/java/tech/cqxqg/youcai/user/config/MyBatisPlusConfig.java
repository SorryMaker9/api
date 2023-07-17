package tech.cqxqg.youcai.user.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		interceptor.addInnerInterceptor(paginationInterceptor());
		return interceptor;
	}

	private PaginationInnerInterceptor paginationInterceptor() {
		PaginationInnerInterceptor page = new PaginationInnerInterceptor();
		return page;
	}
}