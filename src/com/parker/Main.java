package com.parker;

import java.util.Scanner;

public class Main {

    // the entrance, input the numders and operator in the console,
    // input "exit" to exit the programme
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.println("please input the command in the console:");
        while (true){
            String str = in.nextLine();
            if("exit".equals(str)){
                break;
            }
            calculator.process(str);
        }
        //besides the examples in the pdf, we can try some other cases such as: 1 0 /
        // zero can not be divide.
    }
}
