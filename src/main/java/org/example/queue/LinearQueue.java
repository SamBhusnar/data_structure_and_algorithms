package org.example.queue;

import java.util.Scanner;
public class LinearQueue {
    int[] items;
    int rear, front, max;

    LinearQueue(int size) {
        this.items = new int[size];
        rear = front = -1;
        max = size;
    }

    public boolean isFull() {
        if (rear == max - 1) {

            return true;
        }

        return false;
    }

    public boolean isEmpty() {
        if (rear == front) {

            return true;
        }

        return false;
    }

    public void insert(int element) {
        if (isFull()) {
            System.out.println("Queue is overflows");
            status();
        } else {
            this.items[++rear] = element;
            status();
        }
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is underflow");
            status();
            return -1;
        } else {
            return this.items[++front];
        }
    }

    public void status(){
        System.out.print("[");
        for (int i = this.front+1; i <=this.rear ; i++) {
            System.out.print(items[i]);
            if(i%max<max-1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        LinearQueue queue = new LinearQueue(5);
        int inp = 0;
        while (true) {

            System.out.println("\nPress 1 for to insert\npress 2 for remove\npress 3 for to check queue is full\n press 4 for to check queue is empty \npress 5 for status\n press 6 for exit\n");
            inp = sc.nextInt();
            switch (inp) {
                case 1:
                    System.out.println("\nEnter element to insert\n");
                    int cinp = sc.nextInt();
                    queue.insert(cinp);
                    break;
                case 2:
                    int remove = queue.remove();
                    if (remove != -1) {
                        System.out.println(remove + "element was removed !");
                    }
                    break;
                case 3:
                    if (queue.isFull()) {
                        System.out.println("\nQueue is full!");
                    } else {
                        System.out.println("\nQueue is not full!");
                    }
                    break;
                case 4:
                    if (queue.isEmpty()) {
                        System.out.println("\nQueue is empty !");
                    } else {
                        System.out.println("\nQueue is not empty !");
                    }
                    break;
                case 5:
                    queue.status();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("\ninvalid input , Please insert appropriate input");
            }
        }
    }
}
