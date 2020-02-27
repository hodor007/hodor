package com.zp.ymm.lion;

/**
 * @author :  pengzheng
 * create at:  2020-02-26  09:59
 * @description:
 */
public class ZkPathUtil {
    private static final String PATH_SEPARATOR = "/";
    private static final String CONFIG_PATH = "/DP/CONFIG";
    private static final String CONFIG_TIMESTAMP = "TIMESTAMP";

    private ZkPathUtil() {
    }

    public static String generateLionZKPAth(String key) {
        return generateLionZKPAth(key, (String) null);
    }

    public static String generateLionZKPAth(String key, String group) {
        String path = "/DP/CONFIG/" + key;
        if (null != group) {
            path = path + "/" + group;
        }

        return path;
    }

    public static String getTimestampPath(String lionZKPath) {
        return lionZKPath + "/" + "TIMESTAMP";
    }

    public static String getKeyFromPath(String lionZKPath) {
        if (lionZKPath != null && lionZKPath.startsWith("/DP/CONFIG")) {
            String key = lionZKPath.substring("/DP/CONFIG".length() + 1);
            int idx = key.indexOf("/");
            if (idx != -1) {
                key = key.substring(0, idx);
            }

            return key;
        } else {
            return null;
        }
    }

    public static String getGroupFromPath(String lionZKPath) {
        String noGroupPath = generateLionZKPAth(getKeyFromPath(lionZKPath), (String) null);
        return lionZKPath.equals(noGroupPath) ? null : lionZKPath.substring(noGroupPath.length() + 1);
    }
}