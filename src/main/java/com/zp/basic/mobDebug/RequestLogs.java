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

import com.alibaba.fastjson.JSON;

/**
 * Description:日志类（aop获取的日志）
 * Date: 2019-02-22
 *
 * @author zhengpeng
 */
@Component
@Scope("request")  //request表示该针对每一次HTTP请求都会产生一个新的bean，同时该bean仅在当前HTTP request内有效
public class RequestLogs implements InitializingBean {

    private boolean ifDebug;
    private String requestUri;
    private String parameters;
    private Map<String, Method> dependentMethod;

    public boolean isIfDebug() {
        return ifDebug;
    }

    public void setIfDebug(boolean ifDebug) {
        this.ifDebug = ifDebug;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public Map<String, Method> getDependentMethod() {
        return dependentMethod;
    }

    public void setDependentMethod(Map<String, Method> dependentMethod) {
        this.dependentMethod = dependentMethod;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        parameters = JSON.toJSONString(request.getParameterMap());
        requestUri = request.getRequestURI();
        dependentMethod = new LinkedHashMap();
    }

     static class Method{
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
