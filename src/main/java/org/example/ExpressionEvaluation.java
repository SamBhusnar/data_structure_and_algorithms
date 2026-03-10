package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
@Slf4j
public class ExpressionEvaluation {

    private int top;
    private int size;
    private int[] items;

    ExpressionEvaluation(int size) {
        top = -1;
        this.size = size;
        this.items = new int[size];
        log.info("Stack is initialized");

    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underFlow!");
            return -1;
        }
        return items[top--];
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack OverFlow!");
        } else {
            items[++top] = element;
        }
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter PostFix expression ! ");
        String input = sc.nextLine();
        ExpressionEvaluation ee = new ExpressionEvaluation(100);
        char[] postfix = new char[input.length() + 1];

        int i = 0;
        for (; i < input.length(); i++) {
            postfix[i] = input.charAt(i);
        }
        System.out.println("__________________________-");
        for (int j = 0; j < input.length(); j++) {
            System.out.println(postfix[j]);
        }
        System.out.println("__________________________-");
        postfix[i] = '\0';
        i = 0;
        while (postfix[i] != '\0') {
            if (postfix[i] != '+' && postfix[i] != '-' && postfix[i] != '*' && postfix[i] != '/') {
                ee.push(((int)postfix[i]-48 ));
            } else  {
                System.out.println("----------------from stack start------------------");
                for (int j = 0; j<=  ee.top; j++) {
                    System.out.println(ee.items[j]);
                }
                System.out.println("----------------from stack end------------------");
                // following popped orders matters
                int b = ee.pop();
                int a = ee.pop();
                char operator = (char) postfix[i];
                System.out.println(a+""+operator+""+b);
                int res = 0;
                if (operator == '+') {
                    res = a + b;
                } else if (operator == '-') {
                    res = a - b;
                } else if (operator == '*') {
                    res = a * b;
                } else if (operator == '/') {
                    res = a / b;
                }
                ee.push( res);
            }
            i++;
        }
        int finalRes=ee.pop();
        System.out.println("reslt : "+finalRes);
    }


}
//45+63-*9/