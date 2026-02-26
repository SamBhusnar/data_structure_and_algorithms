package org.example;

import java.util.Scanner;

public class StackDSA {
    int items[];
    int size;
    int top;
    public StackDSA(int size){
        this.size=size;
        items=new int[size];
        top=-1;
    }
    public  void push(int element){
        if(isFull()){
            System.out.println("Stack overFlow ! ");
            return;
        }
        items[++top]=element;
        System.out.println(top+" is top ! ");
        System.out.println(element+" inserted at "+top);

    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack underFlow ! ");
            return -1;
        }
        return items[top--];
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty ! ");
            return -1;
        }
        return items[top];
    }
    public  void search(int element){

        for (int i = 0; i <=top; i++) {
            if (items[i]==element){
                System.out.println(element+" found at "+i);
                return;
            }

        }
        System.out.println(element+" not found");
    }
    public void traverse(){
        for (int i = top; i >=0; i--) {
            System.out.print("\t\t\t |"+items[i]+" |\n");
        }
    }
    public boolean isFull(){
        return top==size-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
            StackDSA main = new StackDSA(5);
        while (true) {
            System.out.println("Press 1 for push \nPress 2 for pop \nPress 3 for search \nPress 4 for traverse \npress 5 for peek \nPress 6 for exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter element \n ");
                    main.push(sc.nextInt());
                    break;
                case 2:
                    int pop = main.pop();
                    System.out.println(pop+" is popped ! ");
                    break;
                case 3:
                    System.out.println("Enter element to search \n ");
                   main.search(sc.nextInt());

                    break;
                case 4:
                    main.traverse();
                    break;
                case 5:
                    int peek = main.peek();
                    System.out.println(peek+" is peek ! ");
                    break;
                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input ");

            }
        }
    }
}
