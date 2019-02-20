/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.basic.awt;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.UUID;

/**
 * Description:
 * Date: 2019-01-22
 *
 * @author zhengpeng
 */
public class AwtTest {

    private final static String SAVE_PATH = "D:\\test";

    public static void main(String[] args) throws Exception {
//        try (InputStream bgImageStream = new FileInputStream(SAVE_PATH + "\\bg.jpg");
//             InputStream textStream = new FileInputStream(SAVE_PATH + "\\text.txt")) {
//            BufferedImage bgImage = ImageIO.read(bgImageStream);
//            String text = readText(textStream, "gbk");
//
//            Graphics2D g = bgImage.createGraphics();
//            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//            g.setColor(Color.BLACK);
//            g.setFont(new Font("黑体", Font.PLAIN, 20));
//            drawString(g,text, 51.7f, 514, 16, 72, 90, true, true);
//            showImage(bgImage);
//        }
        // 创建Graphics2D对象，用在底图对象上绘图
        InputStream bgImageStream = new FileInputStream(SAVE_PATH + "\\tp2.png");
        BufferedImage bgImage = ImageIO.read(bgImageStream);
//        BufferedImage bgImage = ImageIO.read(new URL("https://m.tuniucdn.com/fb2/t1/G5/M00/53/25/Cii-slxJYFGICV1YAAAxdd4zfdcAATeOQP-sYEAADGN056.png"));
        Graphics2D g2d = bgImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // 绘制
        g2d.drawImage(ImageIO.read(new URL("https://m.tuniucdn.com/fb2/t1/G5/M00/D6/22/Cii-tFwTPjOIRWjKABSnYZINqLsAARo3QLFnOEAFKd5948_w960_h960_c1_t0.jpg")), 0, 0, 646, 484, null);
        g2d.dispose();// 释放图形上下文使用的系统资源
        showImage(bgImage);
    }

    /**
     *
     * @param g
     * @param text 文本
     * @param lineHeight 行高
     * @param maxWidth 行宽
     * @param maxLine 最大行数
     * @param left 左边距
     * @param top 上边距
     * @param trim 是否修剪文本（1、去除首尾空格，2、将多个换行符替换为一个）
     * @param lineIndent 是否首行缩进
     */
    private static void drawString(Graphics2D g, String text, float lineHeight, float maxWidth, int maxLine, float left,
                                   float top, boolean trim, boolean lineIndent) {
        if (text == null || text.length() == 0) return;
        if(trim) {
            text = text.replaceAll("\\n+", "\n").trim();
        }
        if(lineIndent) {
            text = "　　" + text.replaceAll("\\n", "\n　　");
        }
        drawString(g, text, lineHeight, maxWidth, maxLine, left, top);
    }

    /**
     *
     * @param g
     * @param text 文本
     * @param lineHeight 行高
     * @param maxWidth 行宽
     * @param maxLine 最大行数
     * @param left 左边距
     * @param top 上边距
     */
    private static void drawString(Graphics2D g, String text, float lineHeight, float maxWidth, int maxLine, float left,
                                   float top) {
        if (text == null || text.length() == 0) return;

        FontMetrics fm = g.getFontMetrics();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            sb.append(c);
            int stringWidth = fm.stringWidth(sb.toString());
            if (c == '\n' || stringWidth > maxWidth) {
                if(c == '\n') {
                    i += 1;
                }
                if (maxLine > 1) {
                    g.drawString(text.substring(0, i), left, top);
                    drawString(g, text.substring(i), lineHeight, maxWidth, maxLine - 1, left, top + lineHeight);
                } else {
                    g.drawString(text.substring(0, i - 1) + "…", left, top);
                }
                return;
            }
        }
        g.drawString(text, left, top);
    }

    public static void showImage(BufferedImage image) throws Exception {
        File file = new File(SAVE_PATH + "\\" + UUID.randomUUID().toString() + ".png");
        FileOutputStream out = new FileOutputStream(file);
        ImageIO.write(image, "png", out);
        out.flush();
        out.close();

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
            System.out.println("显示图片成功");
        } else {
            System.err.println("显示图片失败");
        }

//        Thread.sleep(2000);
//        file.delete();
    }

    private static String readText(InputStream in, String charset) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, charset));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while(null != (line = reader.readLine())) {
            sb.append(line + "\n");
        }
        return sb.toString();
    }

}
