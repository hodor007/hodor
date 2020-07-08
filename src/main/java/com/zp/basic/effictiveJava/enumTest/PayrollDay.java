package com.zp.basic.effictiveJava.enumTest;

import lombok.Getter;

/**
 * @author :  pengzheng
 * create at:  2020-06-01  17:40
 * @description:  34    38(接口实现也可以每个单独实现)
 */
@Getter
public enum PayrollDay implements OperationService {

    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private PayType payType;

    PayrollDay() {
        this(PayType.WEEKDAY);
    }

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    public double apply(double x, double y) {
        return 0;
    }

    private enum PayType {

        WEEKDAY {
            @Override
            int overtimePay(int mins, int payRate) {
                return mins * payRate;
            }
        },
        WEEKEND {
            @Override
            int overtimePay(int mins, int payRate) {
                return mins * payRate * 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);
    }

}