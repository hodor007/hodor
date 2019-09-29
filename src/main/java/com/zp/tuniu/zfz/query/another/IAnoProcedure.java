/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.zfz.query.another;

import com.zp.tuniu.zfz.RequestDecorator;
import com.zp.tuniu.zfz.ResponseDecorator;

/**
 * TODO: description
 * Date: 2019-07-18
 *
 * @author zhengpeng
 */
public interface IAnoProcedure<OriginRequest, OriginResponse, ProcedureRequest, ProcedureResponse> {

    RequestDecorator<OriginRequest, ProcedureRequest> requestDecorator();

    ProcedureResponse handle(ProcedureRequest request);

    ResponseDecorator<ProcedureResponse, OriginResponse> responseDecorator();

}
