package com.zp.zky.opc;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfig;
import org.eclipse.milo.opcua.sdk.client.api.identity.AnonymousProvider;
import org.eclipse.milo.opcua.stack.client.UaTcpStackClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;

import java.io.File;
import java.security.KeyPair;
import java.security.cert.X509Certificate;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;

/**
 * @author zhengpeng
 * @ClassName OpcClient
 * @Description TODO
 * @date 2021年09月15日 13:43
 */
@Slf4j
public class OpcClient {

    static String  EndPointUrl = "opc.tcp://127.0.0.1:49320";

    public static void main(String[] args) throws Exception {
        operateOpcUa();
    }

    public static void operateOpcUa() throws Exception {

        //定义证书文件路径
        File cerfile = new File("example-client.pfx");

        CerLoad cerLoad = new PKCS12LoadImp();    //加载pfx证书文件的实例
        Runner runner = new ReadExample();   //Runner对象
        //CerLoad cerLoad = new DerPemLoadImp();    加载der和pem证书文件的实例
        X509Certificate certificate  =cerLoad.getCer(cerfile);  //获取证书对象
        KeyPair keyPair = cerLoad.getKeyPair(cerfile);          //获取密钥对 对象

        //搜索OPC节点
        EndpointDescription[] endpointDescriptions = null;
        System.out.println("开始OPC连接...");
        try{
            endpointDescriptions = UaTcpStackClient.getEndpoints(EndPointUrl).get();
            System.out.println(endpointDescriptions[0]);
        }catch (Throwable e){
//            log.warn("获取端点失败",e);
            return;
        }

        EndpointDescription endpointDescription = endpointDescriptions[0];

        //创建OpcUaClientConfig 配置对象
        OpcUaClientConfig config = OpcUaClientConfig.builder()
                .setApplicationName(LocalizedText.english("demo"))
                .setApplicationUri("urn:eclipse:milo:examples:client")
                .setCertificate(certificate)
                .setKeyPair(keyPair)
                .setEndpoint(endpointDescription)
                .setIdentityProvider(new AnonymousProvider())
                .setRequestTimeout(uint(5000))
                .build();

        //利用OpcUaClientConfig创建OPC UA客户端
        OpcUaClient opcClient = new OpcUaClient(config);
        try {
            runner.Run(opcClient);
        }catch (Exception e){
            System.out.println("发生异常: "+e);
        }
    }

}
