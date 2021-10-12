package com.zp.zky.opc;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;

/**
 * @author zhengpeng
 * @ClassName Runner
 * @Description TODO
 * @date 2021年09月16日 10:47
 */
public interface Runner {

    public void Run(OpcUaClient opcUaClient) throws Exception;

}
