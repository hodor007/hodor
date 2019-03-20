package com.zp.basic.csdn;

import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

/**
 * @Auther: zhengpeng
 * @Date: 2019/3/20 16:12
 * @Description:
 */
public class TestCsdn {

    private static Desktop desktop;

    public static void main(String[] args) {
        String address = "https://blog.csdn.net/m0_37300406/article/details/87204742";
        int i=0;
        while(true){
            if (Desktop.isDesktopSupported()) {//判断是否支持DeskTop
                desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI(address));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(++i>=11){
                try {
                    Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
