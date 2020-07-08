package com.zp.basic.effictiveJava.enumTest;

import lombok.Getter;

import java.util.function.DoubleBinaryOperator;

/**
 * @author :  pengzheng
 * create at:  2020-06-02  15:01
 * @description: 42
 */
@Getter
public enum Operation2 {

    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);
    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation2(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }

}