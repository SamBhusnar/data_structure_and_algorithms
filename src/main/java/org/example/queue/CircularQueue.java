package org.example.queue;

import java.util.Scanner;

public class CircularQueue {
    int []items;
    int rear,front;
    int max;
    public  CircularQueue(int max){
        this.max=max;
        this.items=new int[max];
        this.rear=this.front=-1;
    }
    public boolean isFull(){
        if((front==0&&rear==max-1)||(front==rear+1)){
            return  true;
        }
        return false;
    }
    public boolean isEmpty(){
        if(front==-1){
            return true;
        }
        return  false;
    }
    public void insert(int element){
     if(isFull()){
         System.out.println("Queue is overflow");
     }else{
         rear=(rear+1)%max;
         items[rear]=element;
         if(front==-1){
             front=rear;
         }
     }
    }
    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is underflow");
            return -1;
        }else{
            int removed=items[front];
            if(front==rear){
                front=rear=-1;
            }else {
                front = (front + 1) % max;
            }
            return removed;
        }
    }
    public  void display(){
        System.out.print("[");
        for (int i =front  ; i !=rear ; i=(i+1)%max) {
            System.out.print(items[i]);
//            if((rear-(i%max))>=1){
                System.out.print(",");
//            }
        }
        if(rear!=-1) {
            System.out.print(items[rear] );
        }
        System.out.print("]");
    }
    public static void main() {
      Scanner sc=new Scanner(System.in);
      CircularQueue queue=new CircularQueue(5);
      int inp=0;
      while(true){
          System.out.println("\npress 1 for insert\npress 2 for remove\npress 3 for checking isEmpty\npress 4 for isFull\npress 5 for display\npress 6 for exit");
          inp=sc.nextInt();
          switch (inp){
              case 1:
                  System.out.println("Enter any element");
                  int element=sc.nextInt();
                  queue.insert(element);
                  break;
              case 2:
                  int removed=queue.remove();
                  if(removed!=-1){
                      System.out.println(removed+" element was removed");
                  }
                  break;
              case 3:
                  if(queue.isEmpty()){
                      System.out.println("\nQueue is empty!");
                  }else {
                      System.out.println("\nQueue is not empty!");
                  }
                  break;
              case 4:
                  if(queue.isFull()){
                      System.out.println("\nQueue is full!");
                  }else{
                      System.out.println("\nQueue is not full!");
                  }
                  break;
              case 5:
                  queue.display();
                  break;
              case 6:
                  System.exit(0);

              default:
                  System.out.println("Invalid input ! please insert appropriate input");
          }

      }
    }

}
