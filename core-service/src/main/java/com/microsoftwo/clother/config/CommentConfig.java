package com.microsoftwo.clother.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.microsoftwo.clother.comment", annotationClass = Mapper.class)
public class CommentConfig {
}
