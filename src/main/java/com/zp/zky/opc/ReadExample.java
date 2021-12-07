package com.zp.zky.opc;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.nodes.Node;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaMonitoredItem;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaSubscription;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MonitoringMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemCreateRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoringParameters;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadValueId;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;

/**
 * @author zhengpeng
 * @ClassName ReadExample
 * @Description TODO
 * @date 2021年09月16日 10:47
 */
@Slf4j
public class ReadExample implements Runner {

    @Override
    public void Run(OpcUaClient opcUaClient) throws Exception {
        opcUaClient.connect().get();
//        NodeId nodeId = new NodeId(2, "模拟器示例.函数.Ramp8");
        NodeId nodeId = new NodeId(2, "通道 1.设备 1._System");
//        createSubscription(opcUaClient, nodeId);
        getValue(opcUaClient, nodeId);
//        Thread.sleep(1000);
//        writeData(opcUaClient, nodeId, 1.0);
//        Thread.sleep(1000);
//        writeData(opcUaClient, nodeId, 2.0);
//        Thread.sleep(10000);
        List<Node> nodes = opcUaClient.getAddressSpace().browse(nodeId).get();
        nodes.forEach(node -> {
            try {
                System.out.println(node.getNodeId().get().getIdentifier());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private void writeData(OpcUaClient opcUaClient, NodeId nodeId, double data) throws InterruptedException, java.util.concurrent.ExecutionException {
        //创建Variant对象和DataValue对象
        Variant v = new Variant(data);
        DataValue dataValue = new DataValue(v, null, null);

        StatusCode statusCode = opcUaClient.writeValue(nodeId, dataValue).get();
    }

    private void getValue(OpcUaClient opcUaClient, NodeId nodeId) throws InterruptedException, java.util.concurrent.ExecutionException {

        DataValue value = opcUaClient.readValue(0.0, TimestampsToReturn.Both, nodeId).get();

        System.out.println("读取到的值为" + (Double) value.getValue().getValue());
    }

    private void createSubscription(OpcUaClient client, NodeId nodeId) throws InterruptedException, java.util.concurrent.ExecutionException {
        //创建发布间隔1000ms的订阅对象 requestedPublishingInterval和samplingInterval区别 https://stackoverflow.com/questions/41183394/what-does-the-requestedpublishinginterval-in-milo-mean
        UaSubscription subscription = client.getSubscriptionManager().createSubscription(500.0).get();

        //创建订阅的变量
        ReadValueId readValueId = new ReadValueId(nodeId, AttributeId.Value.uid(), null, null);

        //创建监控的参数
        MonitoringParameters parameters = new MonitoringParameters(
                uint(1), // 用来标识每个创建的监控项，所以对于不同的监控变量这个值必须不同，并且唯一。
                0.0,     // sampling interval 采样周期，单位为毫秒
                null,       // filter, null means use default
                uint(10),   // queue size 存放数据的队列
                true        // discard oldest
        );

        //创建监控项请求
        //该请求最后用于创建订阅。
        MonitoredItemCreateRequest request = new MonitoredItemCreateRequest(readValueId, MonitoringMode.Reporting, parameters);

        List<MonitoredItemCreateRequest> requests = new ArrayList<>();
        requests.add(request);

        //创建监控项，并且注册变量值改变时候的回调函数。
        List<UaMonitoredItem> items = subscription.createMonitoredItems(
                TimestampsToReturn.Both,
                requests,
                (item, id) -> {
                    item.setValueConsumer((item1, value) -> {
//                        log.info("subscription=====nodeid :" + item1.getReadValueId().getNodeId());
//                        log.info("subscription=====value :" + value.getValue().getValue());
                    });
                }
        ).get();
    }
}
