/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu;

/**
 * TODO: description
 * Date: 2019-07-17
 *
 * @author zhengpeng
 */
public interface IProcedure<OriginRequest, OriginResponse, ProcedureRequest, ProcedureResponse> {

    RequestDecorator<OriginRequest, ProcedureRequest> requestDecorator();

    ProcedureResponse handle(ProcedureRequest request);

    ResponseDecorator<ProcedureResponse, OriginResponse> responseDecorator();

}
