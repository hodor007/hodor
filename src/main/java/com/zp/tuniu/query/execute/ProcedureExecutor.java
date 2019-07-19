/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.query.execute;

import javax.annotation.Resource;

import java.util.List;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.zp.tuniu.IProcedure;

/**
 * TODO: description
 * Date: 2019-07-18
 *
 * @author zhengpeng
 */
@Component
public class ProcedureExecutor {

    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public <OriginalRequest, OriginalResponse> OriginalResponse execute(List<? extends IProcedure> procedures,
                                                                        OriginalRequest request,
                                                                        OriginalResponse response) {
        procedures.forEach(procedure -> {
            threadPoolTaskExecutor.submit(() -> {
//                Object req = procedure.requestDecorator().decorator(request);
//                Object resp = procedure.handle(req);
//                procedure.responseDecorator().decorator(resp, response);
                procedure.responseDecorator().decorator(procedure.handle(procedure.requestDecorator().decorator(request)), response);
            });
        });

        return response;
    }


}
