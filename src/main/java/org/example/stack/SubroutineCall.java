package org.example.stack;

import java.util.Scanner;

public class SubroutineCall {
    public int factorial(int nm) {
        if (nm == 0 || nm == 1) {
            return 1;
        }
        return nm * factorial(nm - 1);
    }

    public static void main() {
        SubroutineCall sm = new SubroutineCall();
        System.out.println("Enter a number to find factorial");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        int factorial = sm.factorial(i);
        System.out.println("factorial: " + factorial);
    }
}
