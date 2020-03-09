package com.zp.dao;

/**
 * @author :  pengzheng
 * create at:  2020-03-08  20:37
 * @description:
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.zp.dao.mapper"})
public class DaoConfig {
}
