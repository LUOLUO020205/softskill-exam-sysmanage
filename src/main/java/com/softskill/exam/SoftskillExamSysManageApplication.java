package com.softskill.exam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.softskill.exam")
@MapperScan(basePackages = "com.softskill.exam.dao")
@SpringBootApplication
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@ServletComponentScan
public class SoftskillExamSysManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftskillExamSysManageApplication.class, args);
    }

   /*

    extends SpringBootServletInitializer
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(SoftskillExamH5Application.class).run(args);
    }*/
}
