/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.basic.mobDebug;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * Date: 2019-02-25
 *
 * @author zhengpeng
 */

@Aspect
@Configuration
public class MethodAdvice {

    @Around(value = "(execution(public  * com.zp.basic.mobDebug.DebugService.get(..))) " )
    public Object asyncInvoke(ProceedingJoinPoint point) throws Throwable {
        RequestLogs result = LogSoldier.getRequestLogs();
        Map<String, RequestLogs.Method> dependentMethod = new HashMap<String, RequestLogs.Method>();
        RequestLogs.Method method = new RequestLogs.Method();

        method.setRequest(point.getArgs()[0]);
        Object object = point.proceed();

        method.setResponse(object);
        dependentMethod.put(point.getTarget().getClass().getName(),method);
        result.setDependentMethod(dependentMethod);
        return object;
    }

}
