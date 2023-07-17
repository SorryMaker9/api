package tech.cqxqg.youcai.user;

import tech.cqxqg.youcai.core.enums.Constants;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("tech.cqxqg.youcai.persistence.mapper")
@ComponentScan(Constants.BASE_PACKAGE)
public class UserServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServerApplication.class, args);
		
	}
}
