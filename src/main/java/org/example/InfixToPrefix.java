package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
@Slf4j
public class InfixToPrefix {
    private int top;
    private int size;
    private int[] items;

    InfixToPrefix(int size) {
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
        // InfixToPrefix
        //e.g. (A+B)+C ==>
        // requirement
        // Infix expression which is parenthesized
        // 2 diff. stack
        // prefix expression string  to store result
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter PrefixExpression which is parenthesized ! ");
        String input = sc.nextLine();
        char[] infix = new char[input.length() + 1];// add null character i.e. '\0' at last index
        // instead of reversing the array we push character of input string in reverse position

        int i = 0;
        for (; i < input.length(); i++) {// 0 to 14,
            if (i == 0) {
                infix[i] = input.charAt(input.length() - 1);

            } else {
                infix[i] = input.charAt(input.length() - (i + 1));

            }
        }
        infix[i] = '\0';
        // create two stack named opsStack,oprndStack
//        System.out.println("original : "+input);
//        System.out.println("reverse : "+infix);
//        System.out.println(infix);
//        System.out.println("nll char:"+infix[infix.length-1]);
        InfixToPrefix opsStack=new InfixToPrefix(100);
        InfixToPrefix oprndStack=new InfixToPrefix(100);
        i=0;
        while (infix[i]!='\0'){
            if(infix[i]==')'||infix[i]=='+'||infix[i]=='-'||infix[i]=='*'||infix[i]=='/'){
                opsStack.push(infix[i]);
            }else if(infix[i]=='('){
                while(!opsStack.isEmpty()){
                    int r=opsStack.pop();
                    if(r!=')'){
                      oprndStack.push(r);
                  }

              }

            }else {
                oprndStack.push(infix[i]);
            }
            i++;
        }
        if(!opsStack.isEmpty()){
            int k=opsStack.pop();
            while (k!=-1){
                if(k!=-')'){
                    oprndStack.push(k);
                }
            }
        }
        // perform pop operation on oprndStack untill it become empty   and add popped character onto prefix string
        String prefix="";
        while (!oprndStack.isEmpty()){
            int r= oprndStack.pop();
            prefix+=(char)r;

        }
        System.out.println("Infix : "+input);
        System.out.println("Prefix : "+prefix);
         // testing
        //        System.out.println("inp.length() : "+input.length());
        //        System.out.println(input.charAt(0)+ " : 0+last : "+input.charAt(input.length()-1));
    }

}
