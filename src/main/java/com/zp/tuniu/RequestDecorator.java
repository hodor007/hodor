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
public interface RequestDecorator<OriginRequest, ProcedureRequest> {

    ProcedureRequest decorator(OriginRequest request);

}
