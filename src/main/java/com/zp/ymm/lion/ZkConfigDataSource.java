package com.zp.ymm.lion;

import com.zp.basic.classload.SelfClassload;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundPathable;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorEventType;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * @author :  pengzheng
 * create at:  2020-02-26  09:30
 * @description:
 */

public class ZkConfigDataSource {

    private static final Logger log = LoggerFactory.getLogger(ZkConfigDataSource.class);

    private String zkServerUrl = "127.0.0.1:2181";

    private CuratorFramework curatorFramework;

    public void init() {
        log.info(">>>>>>>> lion zookeeper address: {}", this.zkServerUrl);
        this.curatorFramework = CuratorFrameworkFactory.newClient(this.zkServerUrl, 60000, 30000, new RetryNTimes(2147483647, 1000));
        this.curatorFramework.getConnectionStateListenable().addListener(new ConnectionStateListener() {
            public void stateChanged(CuratorFramework client, ConnectionState newState) {
                log.info(">>>>>>>> lion zookeeper state changed to {}", newState);
                if (newState == ConnectionState.CONNECTED) {

                } else if (newState == ConnectionState.RECONNECTED) {

                } else {

                }

            }
        });
        this.curatorFramework.getCuratorListenable().addListener(new ZkConfigDataSource.ConfigDataWatcher());
        this.curatorFramework.start();


    }

    private class ConfigDataWatcher implements CuratorListener {
        private ConfigDataWatcher() {
        }

        @Override
        public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
            if (event.getType() == CuratorEventType.WATCHED) {
                WatchedEvent we = event.getWatchedEvent();
                if (we.getPath() != null) {
                    log.info(">>>>>>> lion zookeeper event received, path: {}, event {}", we.getPath(), we.getType());
                    this.process(event.getWatchedEvent());
                }
            }
        }

        private void process(WatchedEvent event) {
            String path = event.getPath();
            String key = ZkPathUtil.getKeyFromPath(path);

            try {
                try {
                    int eventType = 0;
                    String value = null;
                    Long version = -1L;
                    if (event.getType() == Watcher.Event.EventType.NodeCreated) {
                        eventType = 1;


                        value = ZkConfigDataSource.this.getDataOfPath(path);

                    } else if (event.getType() == Watcher.Event.EventType.NodeDataChanged) {
                        eventType = 2;


                        value = ZkConfigDataSource.this.getDataOfPath(path);
                    } else if (event.getType() == Watcher.Event.EventType.NodeDeleted) {
                        eventType = 3;
                        value = null;
                        version = -1L;
                    }

                    log.info(">>>>>>> lion zk config ds change info eventType:{}, key:{}, version:{}", new Object[]{Integer.valueOf(eventType), key, version});
                    // 保存value的值入缓存
                    ConfigCache.getInstance().saveNodeValue(key, value, false);
                } catch (Exception var21) {
                    log.error("process zk event error", var21);
                }

            } finally {
                try {
                    ZkConfigDataSource.this.watch(path);
                } catch (Exception var19) {
                }

            }
        }

    }


    public String getDataOfPath(String path) throws Exception {
        byte[] data = this.getDataWithWatch(path);
        return data == null ? null : new String(data, Charset.forName("UTF-8"));
    }


    private byte[] getDataWithWatch(String path) throws Exception {
        try {
            return (byte[]) ((BackgroundPathable) this.curatorFramework.getData().watched()).forPath(path);
        } catch (KeeperException.NoNodeException var3) {
            this.watch(path);
            return null;
        }
    }

    private void watch(String path) throws Exception {
        ((BackgroundPathable) this.curatorFramework.checkExists().watched()).forPath(path);
    }
}