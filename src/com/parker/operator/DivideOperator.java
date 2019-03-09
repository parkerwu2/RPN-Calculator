package com.parker.operator;

import com.parker.CommonConstant;
import com.parker.Mystack;
import com.parker.exception.DivideZeroException;
import com.parker.exception.InsufficientParameterException;

import java.math.BigDecimal;

/**
 * Created by parker on 2019/3/9.
 */
public class DivideOperator implements Operator {
    @Override
    public void process(Mystack mystack) throws Exception {
        if (mystack.peek().equals(BigDecimal.ZERO)) {
            throw new DivideZeroException("divide fail due to divide zero");
        }
        if (mystack.size() < 2){
            throw new InsufficientParameterException(OperatorEnum.Divide, mystack.size());
        }
        BigDecimal next = mystack.pop();
        BigDecimal first = mystack.pop();
        BigDecimal result = first.divide(next, CommonConstant.SCALE, BigDecimal.ROUND_DOWN);
        mystack.push(result);
    }
}
