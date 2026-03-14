package org.example.queue;

import java.util.Scanner;

public class Dequeue_ord {
    int []items;
    int left,right;
    int max;
    public Dequeue_ord(int size){
        this.max=size;
        this.items=new int[size];
        this.right=this.left=-1;
    }
    public void insertRight(int element){
        if(right==max-1){
            System.out.println("Ord is overflow");
        }else{
            right++;
            items[right]=element;
        }
    }
    public  void insertLeft(int element){
        if(right==max-1){
            System.out.println("Ord is overflow");
        }else{
            for (int i = right+1; i >=left+2 ; i--) {
                items[i]=items[i-1];
            }
            items[left+1]=element;
            right++;
        }
    }
    public  int remove(){
        if(left==right){
            System.out.println("Ord is underflow");
            return -1;
        }else{
           return items[++left];
        }
    }
    public  void display(){
        System.out.print("[");
        for (int i = left+1; i <=right ; i++) {
            System.out.print(items[i]);
            if(i%max<max-1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
    public  static  void main(){
        Scanner sc=new Scanner(System.in);
        Dequeue_ord queue=new Dequeue_ord(5);
        while (true){
            System.out.println("\nPress 1 for insert left\nPress 2 for insert right\nPress 3 for remove \nPress 4 for display\nPress 5 for exit");
            int inp = sc.nextInt();
            switch (inp){
                case 1:
                    System.out.println("Enter any element");
                    int element = sc.nextInt();
                    queue.insertLeft(element);
                    break;
                case 2:
                    System.out.println("Enter any element");
                    int elementRight = sc.nextInt();
                    queue.insertRight(elementRight);
                    break;
                case 3:
                    int removedRight=queue.remove();
                    if(removedRight!=-1){
                        System.out.println(removedRight+" element was removed");
                    }
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input ! please insert appropriate input");
            }

        }
    }

}
