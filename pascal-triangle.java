Since calculating the value of a particular position in the triangle uses previously calculated values, this problem can also be solved using recursion. The number at position row i and column j would be represented as pascal(i,j) with I and j starting from 0. There would be two base conditionswhich are related to the first and last elements, which are always one. These two conditions can be expressed as 

pascal ( i, 0 ) = 1
pascal ( i, i ) = 1

Following is the recursive formula used to calculate the remaining elements : 

pascal ( i, j ) = pascal ( i - 1 , j -1 ) + pascal ( i - 1 , j )

Given below is the program which uses the recursive definition of the Pascal's triangle 

import java.util.Scanner;

public class PascalTriangle {

   public static void print(int n) {
       for (int i = 0; i < n; i++) {
           for (int j = 0; j <= i; j++) {
               System.out.print(pascal(i, j) + " ");
           }
           System.out.println();
       }
   }

   public static int pascal(int i, int j) {
       if (j == 0) {
           return 1;
       } else if (j == i) {
           return 1;
       } else {
           return pascal(i - 1, j - 1) + pascal(i - 1, j);
       }

   }

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter the row number upto which Pascal's triangle has to be printed: ");
       int row = scanner.nextInt();
       print(row);
   }
}
