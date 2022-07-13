/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.zp.basic.selfException;


import lombok.Data;

import java.util.Objects;

/**
 * 基础异常类  message不会抛给前端的均使用此异常（业务异常、三方依赖接口异常等）
 * 此异常message不会抛给前端
 *
 * @author limengzhu
 * @version CargoAppException.java, v 0.1 2020-08-19 10:42  Exp $$
 */
@Data
public class CargoAppException extends RuntimeException {

    private int code;

    public CargoAppException(){
        super(ResponseCode.SYSTEM_WRONG.getMsg());
        this.code = ResponseCode.SYSTEM_WRONG.getCode();
    }

    public CargoAppException(Throwable t){
        super(ResponseCode.SYSTEM_WRONG.getMsg(), t);
        this.code = ResponseCode.SYSTEM_WRONG.getCode();
    }

    public CargoAppException(int code, String message, Throwable t) {
        super(message, t);
        this.code = code;
    }

    public CargoAppException(String message, Throwable t) {
        super(message, t);
        this.code = ResponseCode.SYSTEM_WRONG.getCode();;
    }

    public CargoAppException(int code, String message) {
        super(message);
        this.code = code;
    }

    public CargoAppException(String message) {
        super(message);
        this.code = ResponseCode.SYSTEM_WRONG.getCode();
    }

    public CargoAppException(ResponseCode responseCode) {
        super(Objects.isNull(responseCode) ? ResponseCode.SYSTEM_WRONG.getMsg() : responseCode.getMsg());
        this.code =  Objects.isNull(responseCode) ? ResponseCode.SYSTEM_WRONG.getCode() : responseCode.getCode();
    }

    public CargoAppException(ResponseCode responseCode, Throwable t) {
        super(Objects.isNull(responseCode) ? ResponseCode.SYSTEM_WRONG.getMsg() : responseCode.getMsg(), t);
        this.code =  Objects.isNull(responseCode) ? ResponseCode.SYSTEM_WRONG.getCode() : responseCode.getCode();
    }

    @Override
    public String toString() {
        return "CargoAppException{" +
                "code=" + code +
                "code=" + this.getMessage() +
                '}';
    }
}