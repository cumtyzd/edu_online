package com.danshen.eduservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * service-edu配置类
 *
 */
@Configuration
@MapperScan("com.danshen.eduservice.mapper")
public class EduConfig {
}
