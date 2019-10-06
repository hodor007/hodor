/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.thrift.thriftZookeeper.zkserver;

/**
 * TODO: description
 * Date: 2019-10-03
 *
 * @author zhengpeng
 */
public interface ThriftServerIpResolve {

    // 获取服务所在机器的Ip
    String getServerIp() throws Exception;

    String getServerIp(boolean publicIpOnly) throws Exception;

    void reset();

    //当IP变更时,将会调用reset方法
    static interface IpRestCalllBack{
        public void rest(String newIp);
    }

}
