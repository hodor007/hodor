/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.basic.selfException;

/**
 * Description:
 * Date: 2019-01-11
 *
 * @author zhengpeng
 */
public abstract class AbstractApiException extends  Exception {

    private final Object data;

    private final int code;

    public AbstractApiException(String message, int code) {
        super(message);
        this.data = null;
        this.code = code;
    }

    public AbstractApiException(String message, int code, Throwable throwable) {
        super(message, throwable);
        this.data = null;
        this.code = code;
    }

    public AbstractApiException(Object data, String message, int code) {
        super(message);
        this.data = data;
        this.code = code;
    }

    public AbstractApiException(Object data, String message, int code, Throwable throwable) {
        super(message, throwable);
        this.data = data;
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public int getCode() {
        return code;
    }
}
