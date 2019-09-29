/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.zfz.query.execute;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.tuniu.zfz.query.QueryReq;
import com.zp.tuniu.zfz.query.QueryResp;
import com.zp.tuniu.zfz.query.another.IAnoQueryService;
import com.zp.tuniu.zfz.query.another.QueryAnoReq;
import com.zp.tuniu.zfz.query.another.QueryAnoResp;

/**
 * TODO: description
 * Date: 2019-07-18
 *
 * @author zhengpeng
 */
@Service
public class IServiceImpl implements IService {

    @Autowired
//    private List<IQueryService> queryServices;
    private List<IAnoQueryService> anoQueryServices;

    @Autowired
    private ProcedureExecutor procedureExecutor;

    @Override
    public QueryResp queryResource(QueryReq req) {
        QueryResp resp = new QueryResp();
        return procedureExecutor.execute(anoQueryServices, req, resp);
    }

    @Override
    public QueryAnoResp queryResource(QueryAnoReq req) {
        QueryAnoResp resp = new QueryAnoResp();
        return procedureExecutor.execute(anoQueryServices, req, resp);
    }
}
