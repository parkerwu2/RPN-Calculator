package com.parker.operator;

/**
 * Created by parker on 2019/3/9.
 */
public class OperatorFactory {
    public static Operator generateOperator(OperatorEnum operatorEnum){
        switch (operatorEnum){
            case Plus:
                return new PlusOperator();
            case Substract:
                return new SubstractOperator();
            case Multiply:
                return new MultiplyOperator();
            case Divide:
                return new DivideOperator();
            case Sqrt:
                return new SqrtOperator();
            case Clear:
                return new ClearOperator();
            default:
                return null;
        }
    }
}
