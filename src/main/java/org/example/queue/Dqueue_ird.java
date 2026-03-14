package org.example.queue;

import java.util.Scanner;

// input restricted dequeue using linear queue(not circular queue)
public class Dqueue_ird {
    int []items;
    int left,right;
    int max;
    public Dqueue_ird(int size){
        this.max=size;
        this.items=new int[size];
        this.right=this.left=-1;
    }
    // insert element from right most end
    public void insert(int element){
        if(right==max-1){
            System.out.println("Ird is overflow");
        }else{
            right++;
            items[right]=element;
        }
    }
        public int remove_left(){
        if(right==left){
            System.out.println("Ird is underflow");
            return  -1;
        }else{
            left++;
           return  items[left];
        }
    }
    public  int remove_right(){
        if(right==left){
            System.out.println("Ird is underflow");
            return  -1;
        }else{
            return items[right--];
        }
    }
    public  void display(){
        System.out.print("[");
        for (int i = left+1; i <=right; i++) {
            System.out.print(items[i]);
            if(i%max<max-1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
    public  static  void main(){
        Scanner sc=new Scanner(System.in);
        Dqueue_ird queue=new Dqueue_ird(5);
        while (true){
            System.out.println("\nPress 1 for insert\nPress 2 for remove left\nPress 3 for remove right\nPress 4 for display\nPress 5 for exit");
            int inp = sc.nextInt();
            switch (inp){
                case 1:
                    System.out.println("Enter any element");
                    int element = sc.nextInt();
                    queue.insert(element);
                    break;
                case 2:
                    int removed=queue.remove_left();
                    if(removed!=-1){
                        System.out.println(removed+" element was removed");
                    }
                    break;
                case 3:
                    int removedRight=queue.remove_right();
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
