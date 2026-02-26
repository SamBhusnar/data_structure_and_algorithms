package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ArrayDSA {
    static int size=5;
    static int []items=new int[size];
    static int cnt=0;
    public  void remove(int position){
        if(position>=size || position<0){
            System.out.println("Please provide valid input");

        }else if(position>=cnt){
            System.out.println("Element not exist at "+position+" index ");
        }else{
            int z=items[position];
            for (int i = position   ; i < cnt-1   ; i++) {
                items[i]=items[i+1];
            }
            System.out.println(z+" removed from "+position+" index");
            cnt--;
            traverse();
        }
    }
    public void reverse(){
        System.out.print("[ ");
        for (int i = cnt-1  ; i >=0 ; i--) {
            if(i!=cnt-1){
                System.out.print(",");
            }
            System.out.print(items[i]);

        }
        System.out.println("]");
    }

    public void traverse(){
        System.out.print("[");
        for (int i = 0; i < cnt; i++) {
            if(i!=0){
                System.out.print(",");
            }
            System.out.print(items[i]);
        }
        System.out.println("]");
    }

    public boolean search(int element){
        for (int i = 0; i < cnt; i++) {
            if(items[i]==element){
                traverse();
                return  true;
            }
        }
        traverse();
        return  false;
    }
    public void insert(int element){
        if(cnt<size){
            items[cnt]=element;
            cnt++;
        }else{
            System.out.println("Operation can't be performed ! ");
        }
    }
    public static void main() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Press 1 for insert \nPress 2 for remove \nPress 3 for search \nPress 4 for traverse \nPress 5 for reverse\nPress 6 for exit");
            int input = sc.nextInt();
            ArrayDSA main = new ArrayDSA();
            switch (input) {
                case 1:
                    System.out.println("Enter element \n ");
                    main.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Enter index of element \n");
                    main.remove(sc.nextInt());
                    break;
                case 3:
                    System.out.println("Enter element to search \n ");
                    boolean search = main.search(sc.nextInt());
                    if (search) {
                        System.out.println("Element found");
                    } else {
                        System.out.println("Element not found");
                    }
                    break;
                case 4:
                    main.traverse();
                    break;
                case 5:
                    main.reverse();
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
