package com.parker.operator;

import com.parker.CommonConstant;
import com.parker.Mystack;
import com.parker.exception.InsufficientParameterException;

import java.math.BigDecimal;

/**
 * Created by parker on 2019/3/9.
 */
public class SqrtOperator implements Operator {
    @Override
    public void process(Mystack mystack) throws Exception {
        if (mystack.size() < 1){
            throw new InsufficientParameterException(OperatorEnum.Sqrt, mystack.size());
        }
        BigDecimal peek = mystack.pop();
        double value = Math.sqrt(peek.doubleValue());
        BigDecimal result = BigDecimal.valueOf(value);
        result.setScale(CommonConstant.SCALE, BigDecimal.ROUND_DOWN);
        mystack.push(result);
    }
}
