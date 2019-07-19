/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.query.execute;

import javax.annotation.Resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.tuniu.query.IQueryService;
import com.zp.tuniu.query.QueryReq;
import com.zp.tuniu.query.QueryResp;
import com.zp.tuniu.query.another.IAnoQueryService;
import com.zp.tuniu.query.another.QueryAnoReq;
import com.zp.tuniu.query.another.QueryAnoResp;

/**
 * TODO: description
 * Date: 2019-07-18
 *
 * @author zhengpeng
 */
@Service
public class IServiceImpl implements IService {

    @Resource
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
