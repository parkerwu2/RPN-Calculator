package com.parker.exception;

import com.parker.operator.OperatorEnum;

/**
 * Created by parker on 2019/3/9.
 */
public class InsufficientParameterException extends Exception {
    public InsufficientParameterException(OperatorEnum oe, int pos){
        super(new StringBuilder("operator ").append(oe.getValue()).append(" (position: ").append(pos)
                .append("): insucient parameters").toString());
    }
}
