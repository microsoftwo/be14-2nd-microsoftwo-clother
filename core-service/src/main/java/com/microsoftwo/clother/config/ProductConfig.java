package com.microsoftwo.clother.config;

import org.apache.ibatis.annotations.Mapper;
import org.modelmapper.ModelMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages =  "com.microsoftwo.clother.product", annotationClass = Mapper.class)
public class ProductConfig {

}
