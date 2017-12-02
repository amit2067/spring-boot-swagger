package uk.springboot.swagger.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"uk.springboot.swagger.demo"})
@SpringBootApplication
public class SpringBootSwaggerApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringBootSwaggerApp.class, args);
    }
}
