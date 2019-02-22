/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.basic.mobDebug;

import javax.servlet.http.HttpServletRequest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Description:日志类（aop获取的日志）
 * Date: 2019-02-22
 *
 * @author zhengpeng
 */
@Component
@Scope("request")
public class RequestLogs implements InitializingBean {

    private String requestUri;
    private String parameters;
    private Map<String, Method> dependentMethod;

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        parameters = JSON.toJSONString(request.getParameterMap());
        requestUri = request.getRequestURI();
        dependentMethod = new LinkedHashMap();
    }

    private class Method{
        private Object request;
        private Object response;

        public Object getRequest() {
            return request;
        }

        public void setRequest(Object request) {
            this.request = request;
        }

        public Object getResponse() {
            return response;
        }

        public void setResponse(Object response) {
            this.response = response;
        }
    }
}
