package com.parker.operator;

import com.parker.CommonConstant;
import com.parker.Mystack;
import com.parker.exception.InsufficientParameterException;

import java.math.BigDecimal;

/**
 * Created by parker on 2019/3/9.
 */
public class PlusOperator implements Operator {
    @Override
    public void process(Mystack mystack) throws Exception {
        if (mystack.size() < 2){
            throw new InsufficientParameterException(OperatorEnum.Plus, mystack.size());
        }
        BigDecimal next = mystack.pop();
        BigDecimal first = mystack.pop();
        BigDecimal result = first.add(next);
        result.setScale(CommonConstant.SCALE, BigDecimal.ROUND_DOWN);
        mystack.push(result);
    }
}
