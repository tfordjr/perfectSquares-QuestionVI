///******************************************************************************//
// This program should be run with Java compiler on OnlineGDB
//
// CMP SCI 4500-001  HW3 ASSIGNMENT - QUESTION VI
// TERRY FORD HW3 ASSIGNMENT   09/16/22
//
// Product Description:
// This Program is designed to make solutions to the infamous Question VI! Enter a limit and starting at 1 up to
// that limit, the Program will find values such that r = (a^2 + b^2)/(ab + 1) is an integer. Additionally, the
// Program will check to see if r is a perfect square. The Program will report its findings to the user on completion.
//
// Data structures in Program:
// The data structures in this program are very simple. userValidate will use while loop and try/catch blocks
// to validate user input. Then there are two sets of identical nested for loops found in main(). These nested
// for loops are identical except the first will display (a, b) pairs as they are found, and the second will
// instead time the process. Int a, b were changed to long a, b because int overflow in the
// numerator (a^2 + b^2) was tampering with results.
//
//
// Source Code used:
//      System time info :   https://stackoverflow.com/questions/3382954/measure-execution-time-for-a-java-method
// *******************************************************************************/
package edu.umsl;

import java.util.*;
import java.util.Scanner;

public class perfectSquare {
    public static void main(String[] args) {

        System.out.println("This program will allow you to discover information about Question VI " +
                "by iterating through a/b pairs and sharing the results with the user.");
        long X = inputValidate();

        int rIntCount = 0, rSquareCount = 0;    // Significant R value counters.

            // Main Nested Loop with display
        for (long a = 1; a <= X; a++) {         // Nested loop iterates through every possible a/b pair up to limit
            for (long b = 1; b <= X; b++) {
                double r = ((a*a + b*b)/((a * b) + 1.0));    // Assigned result of equation to double r
                if (r % 1 == 0 && r != 0) {                  // If r is an int and r != 0
                    rIntCount++;
                    if (Math.sqrt(r) % 1 == 0) {
                        System.out.println("a/b pair (" + a + ", " + b + ") result in perfect square " +
                                "r = " + (int)r + " = " + (int)Math.sqrt(r) + "^2");
                        rSquareCount++;
                    }
                }
            }
        }

        System.out.println("\nIterating through a/b pairs a second time...");

        rIntCount = 0;      // Significant R value counters.
        rSquareCount = 0;

        long start = System.currentTimeMillis();        // Time begins

            // Timed Second Nested Loops without display
        for (long a = 1; a <= X; a++) {
            for (long b = 1; b <= X; b++) {
                double r = ((a*a + b*b)/((a * b) + 1.0));
                if (r % 1 == 0 && r != 0) {
                    rIntCount++;
                    if (Math.sqrt(r) % 1 == 0) {
                        rSquareCount++;
                    }
                }
            }
        }
            // Presenting User with results
        System.out.println("\nLargest value allowed for a and b: " + X + " and number of pairs tested: " + (X*X));
        System.out.println("How many (a,b) pairs made (a^2 + b^2)/(ab + 1) an integer: " + rIntCount);
        System.out.println("How many of those integers were perfect squares: " + rSquareCount);
        System.out.println("Evaluation took " + ((System.currentTimeMillis() - start)/ 1000.0) + " seconds!");
        System.out.println("\tBye!");
    }

    public static int inputValidate() {      // INPUT VALIDATE METHOD
        int input = 0;
        boolean retry;
        do {
            System.out.print("Please enter a limit for X: ");
            Scanner sc = new Scanner(System.in);
            retry = false;

            try {                               // try/catch block to prevent throwing an exception
                input = sc.nextInt();
            } catch (Exception ex) {
                System.out.println("Exceptions handled. Please only input integer value.");
                retry = true;
            }

            if (input < 1 || input > 100001) {    // Size checking 1-100000 inclusive
                retry = true;
                System.out.println("Must choose positive integer value of 100,000 or less.");
            }
        } while (retry);
        return input;
    }
}