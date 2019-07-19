/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.query.another;

import org.springframework.stereotype.Service;

import com.zp.tuniu.RequestDecorator;
import com.zp.tuniu.ResponseDecorator;
import com.zp.tuniu.query.QueryResp;
import com.zp.tuniu.query.vo.QueryPlaneReq;
import com.zp.tuniu.query.vo.QueryPlaneResp;

/**
 * TODO: description
 * Date: 2019-07-19
 *
 * @author zhengpeng
 */
@Service
public class QueryAnoPlaneServiceImpl implements IAnoQueryService<QueryPlaneReq, QueryPlaneResp> {
    @Override
    public RequestDecorator<QueryAnoReq, QueryPlaneReq> requestDecorator() {
        return queryAnoReq -> new QueryPlaneReq(queryAnoReq.getName());
    }

    @Override
    public QueryPlaneResp handle(QueryPlaneReq queryPlaneReq) {
        return new QueryPlaneResp(queryPlaneReq.getName());
    }

    @Override
    public ResponseDecorator<QueryPlaneResp, QueryAnoResp> responseDecorator() {
        return (queryPlaneResp, queryAnoResp) -> queryAnoResp.setPlaneName("plane == "+queryPlaneResp.getName());
    }
}
