/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.spring.handlerMethodArgumentResolver.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Description:
 * Date: 2019-01-11
 *
 * @author zhengpeng
 */

@Configuration
public class ClientResourcesConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new JsonPathArgumentResolver());
    }
}
