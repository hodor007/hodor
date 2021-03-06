/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.zfz.query.execute;

import com.zp.tuniu.zfz.query.QueryReq;
import com.zp.tuniu.zfz.query.QueryResp;
import com.zp.tuniu.zfz.query.another.QueryAnoReq;
import com.zp.tuniu.zfz.query.another.QueryAnoResp;

/**
 * TODO: description
 * Date: 2019-07-18
 *
 * @author zhengpeng
 */
public interface IService {

    QueryResp queryResource(QueryReq req);

    QueryAnoResp queryResource(QueryAnoReq req);

}
