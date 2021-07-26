package me.koobin.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)// Swagger 를 설정의 핵심이 되는 Bean.
                .select() // ApiSelectorBuilder 를 생성.
                .apis(RequestHandlerSelectors.any()) // API 스펙이 작성되어 있는 패키지를 지정.
                .paths(PathSelectors.ant("/api/**")) // apis() 로 선택되어진 API 중 path 조건에 맞는 API 들을 다시 필터링하여 문서화.
                .build();
    }
}
