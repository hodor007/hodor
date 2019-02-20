/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.basic.awt;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Description:
 * Date: 2019-01-23
 *
 * @author zhengpeng
 */
public class AwtFontbgTest {

    private final static String SAVE_PATH = "D:\\test";

    public static void main(String[] args) throws Exception {
        InputStream bgImageStream = new FileInputStream(SAVE_PATH + "\\tp.png");
        BufferedImage bgImage = ImageIO.read(bgImageStream);
        Graphics2D g = bgImage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        int x,y;
        x=24;
        y=236;
        Font font = new Font("微软雅黑", Font.PLAIN, 12);
        g.setFont(font);
        String temp="采用完全独立于编程语言的文本格式来存的";
//        g.setColor(Color.decode("#333"));
//        g.fillRect(x,y,
//                g.getFontMetrics().stringWidth(temp), g.getFontMetrics().getHeight());
//
//        //获得宽、高画底色
//        g.fillRect(x-10,y-10,g.getFontMetrics().stringWidth(temp)+20,g.getFontMetrics().getHeight()+20);
        g.setColor(Color.decode("#3385ff"));
        //正常显示字符串，刚好在底色框内
        g.drawString(temp,x,y+g.getFontMetrics().getAscent());
        AwtTest.showImage(bgImage);
//        System.out.println(bgImage.getWidth()+"=="+bgImage.getHeight());
    }
}
