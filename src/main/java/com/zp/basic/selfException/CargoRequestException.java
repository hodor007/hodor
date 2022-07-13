/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.zp.basic.selfException;

import lombok.Data;

import java.util.Objects;

/**
 * 基础异常类  message需要抛给前端的均使用此异常
 * 此异常message会抛给前端
 *
 * @author limengzhu
 * @version CargoRequestException.java, v 0.1 2020-08-19 10:42  Exp $$
 */

@Data
public class CargoRequestException extends CargoAppException {

//    private Supplier<DialogResponse> responseSupplier;

    private int code;

    public CargoRequestException(){
        super(ResponseCode.PARAMS_ERROR.getMsg());
        this.code = ResponseCode.PARAMS_ERROR.getCode();
    }

    public CargoRequestException(Throwable t){
        super(ResponseCode.PARAMS_ERROR.getMsg(), t);
        this.code = ResponseCode.PARAMS_ERROR.getCode();
    }

    public CargoRequestException(int code, String message, Throwable t) {
        super(message, t);
        this.code = code;
    }

    public CargoRequestException(String message, Throwable t) {
        super(message, t);
        this.code = ResponseCode.PARAMS_ERROR.getCode();;
    }

    public CargoRequestException(int code, String message) {
        super(message);
        this.code = code;
    }

    public CargoRequestException(String message) {
        super(message);
        this.code = ResponseCode.PARAMS_ERROR.getCode();
    }

    public CargoRequestException(ResponseCode responseCode) {
        super(Objects.isNull(responseCode) ? ResponseCode.PARAMS_ERROR.getMsg() : responseCode.getMsg());
        this.code =  Objects.isNull(responseCode) ? ResponseCode.PARAMS_ERROR.getCode() : responseCode.getCode();
    }

    public CargoRequestException(ResponseCode responseCode, Throwable t) {
        super(Objects.isNull(responseCode) ? ResponseCode.PARAMS_ERROR.getMsg() : responseCode.getMsg(), t);
        this.code =  Objects.isNull(responseCode) ? ResponseCode.PARAMS_ERROR.getCode() : responseCode.getCode();
    }

//    public CargoRequestException supplyResponse(Supplier<DialogResponse> responseSupplier) {
//        this.responseSupplier = responseSupplier;
//        return this;
//    }

    @Override
    public Throwable fillInStackTrace() {
        if(super.getCause() == null){
            return this;
        } else {
            return super.fillInStackTrace();
        }
    }

//    @Override
//    public String toString() {
//        return "CargoRequestException{" +
//                "responseSupplier=" + responseSupplier +
//                ", code=" + code +
//                ", msg=" + this.getMessage()+
//                '}';
//    }
}