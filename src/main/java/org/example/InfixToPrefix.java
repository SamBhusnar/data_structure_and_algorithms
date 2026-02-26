package org.example;

import com.sun.source.tree.LiteralTree;

import java.util.Scanner;

public class InfixToPrefix {
    int top;
    int size;
    int []items;
    public InfixToPrefix(int size){
        this.size=size;
        items=new int[size];
        top=-1;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty ! ");
            return -1;
        }
        return items[top--];
    }
    public void push(int element){
        if(isFull()){
            System.out.println("Stack is full ! ");
            return;
        }
        items[++top]=element;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==size-1;
    }
    public static void main(){
        Scanner sc = new Scanner(System.in);
        InfixToPrefix main = new InfixToPrefix(50);
        char []infix = new char[50];
        char []prefix = new char[50];
        int i=0,j=0;
        String input = sc.nextLine();
        // convert from string to char array
        int k = 0;
        for (; k < input.length(); k++) {
            infix[k]=input.charAt(k);
        }
        infix[k++]='\0';

         while (infix[i]!='\0'){
            if(infix[i]=='('||infix[i]=='+'||infix[i]=='-'||infix[i]=='*'||infix[i]=='/'){
                main.push(infix[i]);
            }else if(infix[i]==')'){
              while (main.items[main.top]!='('){
                  int pop = main.pop();
                  if(pop!='('){
                      prefix[j++]=(char)pop;
                  }
              }
              main.pop();
            }else{
                prefix[j++]=(char)infix[i];
            }
            i++;
         }
         if(main.top!=-1){
             while (main.top!=-1){
                 int pop = main.pop();
                 prefix[j++]=(char)pop;
             }
         }
        System.out.println("Infix Expression : "+input);
        System.out.println("size of prefix : "+prefix.length);
        System.out.println("PostFix Expression : "+prefix);
        for (int l = 0; l < prefix.length; l++) {
            System.out.print(prefix[l]);
        }
        System.out.println('\0');
        System.out.print("Infix : ");
        System.out.println(infix);
        System.out.print("prefix : ");
        System.out.println(prefix);
    }
}
