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
public class InvalidParamException extends AbstractApiException {

//    private static final long serialVersionUID = 8492374252697203328L;

    public static final int ERROR_CODE = 710003;

    public InvalidParamException(String message) {
        super(message, ERROR_CODE);
    }

    public InvalidParamException(String message, Throwable throwable) {
        super(message, ERROR_CODE, throwable);
    }

    public InvalidParamException(Object data, String message) {
        super(data, message, ERROR_CODE);
    }

    public InvalidParamException(Object data, String message, Throwable throwable) {
        super(data, message, ERROR_CODE, throwable);
    }
}
