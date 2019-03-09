package com.parker.operator;

import com.parker.Mystack;

import java.math.BigDecimal;

/**
 * Created by parker on 2019/3/9.
 */
public class ClearOperator implements Operator {
    @Override
    public void process(Mystack mystack) {
        mystack.clear();
    }
}
