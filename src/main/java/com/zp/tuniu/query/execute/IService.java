/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.query.execute;

import com.zp.tuniu.query.QueryReq;
import com.zp.tuniu.query.QueryResp;

/**
 * TODO: description
 * Date: 2019-07-18
 *
 * @author zhengpeng
 */
public interface IService {

    QueryResp queryResource(QueryReq req);

}
