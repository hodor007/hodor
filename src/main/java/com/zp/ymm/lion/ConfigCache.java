package com.zp.ymm.lion;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zp.ms.Single;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author :  pengzheng
 * create at:  2020-02-26  10:04
 * @description:
 */
public class ConfigCache {

    private ConfigCache() {
    }

    ;

    private static volatile ConfigCache configCache;

    public static ConfigCache getInstance() {
        if (configCache == null) {
            synchronized (ConfigCache.class) {
                if (configCache == null) {
                    configCache = new ConfigCache();
                    configCache.init();
                }
            }
        }
        return configCache;
    }

    private Map<String, String> nodeValue = Maps.newConcurrentMap();

    private List<ConfigChange> configChangeList = Lists.newArrayList();

    private ZkConfigDataSource zkConfigDataSource;

    private void init() {
        zkConfigDataSource = new ZkConfigDataSource();
        zkConfigDataSource.init();
    }

    public void addChange(ConfigChange configChange) {
        if (configChange != null) {
            configChangeList.add(configChange);
        }
    }

    public void saveNodeValue(String key, String value, boolean isFirst) {
        nodeValue.put(key, value);
        if (!isFirst) {
            // 通知
            configChangeList.forEach(configChange -> configChange.onChange(key, value));
        }
    }

    public String getNodeVlue(String key) {
        String value = nodeValue.get(key);
        if (StringUtils.isNotEmpty(value)) {
            return value;
        }
        // 根据path 获取zookeeper 节点信息
        try {
            value = zkConfigDataSource.getDataOfPath(ZkPathUtil.generateLionZKPAth(key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


}