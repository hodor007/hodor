/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.basic.mobDebug;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Date: 2019-02-22
 *
 * @author zhengpeng
 */
@Service
public class SpringTool implements ApplicationContextAware {
    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }
}
