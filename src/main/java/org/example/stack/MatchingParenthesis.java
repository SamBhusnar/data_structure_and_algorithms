package org.example.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class MatchingParenthesis {
    private int top;
    private int size;
    private int[] items;

    MatchingParenthesis(int size) {
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
        System.out.println("Enter Infix expression ");
        String input = sc.nextLine();
        char[] infix = new char[input.length() + 1];
        MatchingParenthesis stack = new MatchingParenthesis(100);
        int i = 0;
        for (; i < input.length(); i++) {
            infix[i] = input.charAt(i);
        }
        infix[i++] = '\0';
        i = 0;
        int t = 0;
        while (infix[i] != '\0') {
            if (infix[i] == '(' || infix[i] == '{' || infix[i] == '[') {
                stack.push(infix[i]);
            } else if (infix[i] == ')' || infix[i] == '}' || infix[i] == ']') {
                int pop = stack.pop();
                if (((pop == '(') != (infix[i] == ')')) || ((pop == '{') != (infix[i] == '}')) || ((pop == '[') != (infix[i] == ']'))) {
                    t = 1;
                    break;
                }
            }
            i++;
        }
        if (!stack.isEmpty() || t == 1) {
            System.out.println("Invalid or Imbalanced Expression ");
        } else {
            System.out.println("valid or Balanced Expression ");
        }
    }
}
