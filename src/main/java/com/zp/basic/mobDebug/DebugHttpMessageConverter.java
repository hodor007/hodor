/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.basic.mobDebug;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Description:
 * Date: 2019-02-27
 *
 * @author zhengpeng
 */
public class DebugHttpMessageConverter extends AbstractHttpMessageConverter {

    private static final String RESPONSE = "response";
    private static final String REQUEST_LOGS = "requestLogs";

    public DebugHttpMessageConverter() {
        //new MediaType("application", "json", Charset.forName("UTF-8")),
        super( MediaType.ALL);
    }

    /**
     * 指示该转换器是否支持给定的类
     */
    @Override
    protected boolean supports(Class clazz) {
        return true;
    }
    /**
     *
     * 功能描述: 读取实际对象
     *
     * @Param: clazz
     * @Param: inputMessage
     * @return: java.lang.Object
     * @auther: zhengpeng
     * @date: 2019/2/27 13:19
     */
    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(inputMessage.getBody(),clazz);
    }

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> result = new HashMap<>();
        RequestLogs requestLogs = LogSoldier.getRequestLogs();
        byte[] encodedParam;
        result.put(RESPONSE, object);
        if(requestLogs!=null && requestLogs.isIfDebug()){
            result.put(REQUEST_LOGS, requestLogs);
        }
        encodedParam=mapper.writeValueAsString(result).getBytes("UTF-8");
        outputMessage.getBody().write(encodedParam);
    }
}
