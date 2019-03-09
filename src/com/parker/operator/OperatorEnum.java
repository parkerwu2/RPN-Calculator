package com.parker.operator;

/**
 * Created by parker on 2019/3/9.
 */
public enum OperatorEnum {
    Plus("+"),
    Substract("-"),
    Multiply("*"),
    Divide("/"),
    Sqrt("sqrt"),
    Undo("undo"),
    Clear("clear");

    private String value;
    private OperatorEnum(String symbol){
        value = symbol;
    }
    public static OperatorEnum getEnumByValue(String value){
        for(OperatorEnum oe : OperatorEnum.values()){
            if (oe.getValue().equals(value)){
                return oe;
            }
        }
        return null;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
