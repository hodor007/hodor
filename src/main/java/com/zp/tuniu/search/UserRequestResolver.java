/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.search;

/**
 * TODO: description
 * Date: 2019-09-27
 *
 * @author zhengpeng
 */
public interface UserRequestResolver<T extends UserRequest> {

     SearchListRequest build(T userRequest,
                            SearchListRequest searchListRequest);

}
