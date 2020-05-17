package uk.springboot.swagger.demo;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("uk.springboot.swagger.demo"))
                .paths(regex(".*"))
                .build()
                .apiInfo(metaData());
    }
	
    private ApiInfo metaData() {
    	
    	return new ApiInfoBuilder().title("Spring Boot Swagger Integration")
                .description("Spring Boot Swagger Integration")
                .contact(new Contact("Amit Batra", "test", "amit@gmail.com"))
                .license("1.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0.0")
                .build();
    }
	
	
}