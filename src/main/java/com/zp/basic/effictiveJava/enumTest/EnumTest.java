package com.zp.basic.effictiveJava.enumTest;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author :  pengzheng
 * create at:  2020-06-01  16:25
 * @description: EnumSet
 */
public class EnumTest {


    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    // Any Set could be passed in, but EnumSet is clearly best
    public void applyStyles(Set<Style> styles) {
    }

    public static void main(String[] args) {
        new EnumTest().applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }

}