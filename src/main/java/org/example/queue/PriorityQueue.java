package org.example.queue;

import java.util.Scanner;

public class PriorityQueue {
    int items[],priorities[],front,rear;
    int max;
    public PriorityQueue(int max){
        this.max=max;
        this.items=new int[max];
        this.priorities=new int[max];
        this.front=this.rear=-1;
    }
    // only three operations that is insert,remove and display
    public void insert(int element,int priority){
        if(front==rear){
            System.out.println("Priority queue is overflow");
        }else{
            rear++;
            items[rear]=element;
            priorities[rear]=priority;
        }

    }
    public  int remove(){
        int m,pos=0;
        if(front==rear){
            System.out.println("Priority queue is underflow");
            return  -1;
        }else{
            m=priorities[front+1];
            for (int i = front+1; i <=rear ; i++) {
                if(m<priorities[i]){
                    m=priorities[i];
                    pos=i;
                }
            }
            for (int i = pos; i < rear; i++) {
                items[i]=items[i+1];
                priorities[i]=priorities[i+1];
            }
            rear--;
            return m;
        }
    }
    public  void display(){
        System.out.print("priority: [");
        for (int i = front+1; i <rear ; i++) {
            System.out.print(priorities[i]+" ");

        }
        System.out.println("]");
        System.out.print("Elements : [");
        for (int i = front+1; i <=rear; i++) {
            System.out.print(items[i]+" ");
        }
        System.out.println("]");
    }
    public  static  void main(){
        Scanner sc=new Scanner(System.in);
        PriorityQueue queue=new PriorityQueue(5);
        while (true){
            System.out.println("\nPress 1 for insert\nPress 2 for remove\nPress 3 for display\nPress 4 for exit");
            int input = sc.nextInt();
            switch (input){
                case  1:
                    System.out.println("Enter priority");
                    int priority=sc.nextInt();
                    System.out.println("Enter element");
                    int element=sc.nextInt();
                    queue.insert(element,priority);
                    break;
                case 2:
                    int removed= queue.remove();
                    if(removed!=-1){
                        System.out.println(removed+" Element was removed ");
                    }
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input ! please insert appropriate input");

            }
        }
    }


}
