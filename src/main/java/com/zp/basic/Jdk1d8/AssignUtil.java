/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.basic.Jdk1d8;

import org.springframework.util.StringUtils;

/**
 * Description:
 * Date: 2019-02-19
 *
 * @author zhengpeng
 */
public abstract class AssignUtil {

    public <T> void invokeFunction(T req, Function<T> function ){
            if(!StringUtils.isEmpty(req)){
                function.invoke(req);
            }
    }

    public <T> void invokeFunction1(T req, Function<T> function ){
        if(!StringUtils.isEmpty(req)){
            function.invoke(req);
        }
    }
}
