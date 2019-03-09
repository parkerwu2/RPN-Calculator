package com.parker;

import com.parker.exception.DivideZeroException;
import com.parker.exception.InsufficientParameterException;
import com.parker.operator.Operator;
import com.parker.operator.OperatorEnum;
import com.parker.operator.OperatorFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by parker on 2019/3/9.
 */
public class Calculator {
    // the current stack
    private Mystack stack;
    // store the history stack
    private Stack<String> previousStacks;
    public Calculator(){
        stack = new Mystack();
        previousStacks = new Stack<String>();
    }

    // put new result into the history
    private void saveStack(Mystack stack){
        StringBuilder stringBuilder = new StringBuilder();
        for (BigDecimal bigDecimal : stack) {
            stringBuilder.append(bigDecimal).append(CommonConstant.SEPARATE);
        }
        previousStacks.push(stringBuilder.toString());
    }

    // undo the last operator
    private void backOnestep(){
        previousStacks.pop();
        String last = previousStacks.peek();
        String[] values = last.split(CommonConstant.SEPARATE);
        if (values != null){
            stack.clear();
            for (String value : values) {
                stack.push(new BigDecimal(value));
            }
        }

    }

    // main process
    public void process(String line) throws Exception {
        String[] words = line.split(CommonConstant.SEPARATE);
        if (words != null){
            for (String word : words) {
                OperatorEnum oe = OperatorEnum.getEnumByValue(word);
                // process operator
                if (oe != null){
                    // process undo
                    if (oe == OperatorEnum.Undo){
                        backOnestep();
                    } else {
                        // process other operator
                        Operator operator = OperatorFactory.generateOperator(oe);
                        try {
                            operator.process(stack);
                            saveStack(stack);
                        } catch (DivideZeroException e) {
                            System.out.println(e.getMessage());
                            break;
                        } catch (InsufficientParameterException e){
                            System.out.println(e.getMessage());
                            break;
                        }
                    }
                } else {
                    // process real numbers
                    BigDecimal bigDecimal = new BigDecimal(word);
                    bigDecimal.setScale(CommonConstant.SCALE, BigDecimal.ROUND_DOWN);
                    stack.push(bigDecimal);
                    saveStack(stack);
                }
            }
            // out put the stack content
            showStack();
        }
    }
    private void showStack(){
        // according to the requirement, store 15, show 10
        DecimalFormat df = new DecimalFormat("#.##########");
        StringBuilder sb = new StringBuilder();
        sb.append("stack:");
        for (BigDecimal value : stack) {
            sb.append(df.format(value)).append(CommonConstant.SEPARATE);
        }
        System.out.println(sb.toString());
    }

    public Mystack getStack() {
        return stack;
    }

    public void setStack(Mystack stack) {
        this.stack = stack;
    }

    public Stack<String> getPreviousStacks() {
        return previousStacks;
    }

    public void setPreviousStacks(Stack<String> previousStacks) {
        this.previousStacks = previousStacks;
    }
}
