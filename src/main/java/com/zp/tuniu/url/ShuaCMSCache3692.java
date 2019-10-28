/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.url;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

import static org.apache.commons.io.IOUtils.toByteArray;

/**
 * TODO: description
 * Date: 2019-10-25
 *
 * @author zhengpeng
 */
public class ShuaCMSCache3692 {

    private static List<Integer> hotCityCodes = new ArrayList<>(
            Arrays.asList(200, 3000, 2500, 1602, 3402, 1615, 3415, 1619, 619, 602, 2802, 300, 1402, 1902, 2702, 1202));

    private static String url = "http://admin.tuniu.org/api/cms/app/channel?data={\"pageId\":%s,\"cityCode\":%s,\"force\":true}";

    public static void main(String[] args) {
        get(3692);
    }

    public static void get(int pageId) {
        hotCityCodes.forEach(hotCityCode -> {
            String path = String.format(url, pageId, hotCityCode);
            URL url;
            try {
                url = new URL(path);
                System.out.println(url);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(2 * 1000);
                conn.setRequestMethod("GET");
                InputStream inStream = conn.getInputStream();
                byte[] data = toByteArray(inStream);
                String result = new String(data, "UTF-8");
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }
}
