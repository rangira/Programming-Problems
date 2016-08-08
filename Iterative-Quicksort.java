/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

class IterativeQuickSort
{
    char [] swap(char arr[],int i,int j)
    {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
        return arr;
    }
 
    /* This function is same in both iterative and
       recursive*/
    int partition (char arr[], int l, int h)
    {
        char x = arr[h];
        int i = (l - 1);
 
        for (int j = l; j <= h- 1; j++)
        {
            if (arr[j] <= x)
            {
                i++;
                // swap arr[i] and arr[j]
                arr = swap(arr,i,j);
            }
        }
        // swap arr[i+1] and arr[h]
        arr = swap(arr,i+1,h);
        return (i + 1);
    }
 
    // Sorts arr[l..h] using iterative QuickSort
    void QuickSort(char arr[], int l, int h)
    {
        // create auxiliary stack
        int stack[] = new int[h-l+1];
 
        // initialize top of stack
        int top = -1;
 
        // push initial values in the stack
        stack[++top] = l;
        stack[++top] = h;
 
        // keep popping elements until stack is not empty
        while (top >= 0)
        {
            // pop h and l
            h = stack[top--];
            l = stack[top--];
 
            // set pivot element at it's proper position
            int p = partition(arr, l, h);
 
            // If there are elements on left side of pivot,
            // then push left side to stack
            if ( p-1 > l )
            {
                stack[ ++top ] = l;
                stack[ ++top ] = p - 1;
            }
 
            // If there are elements on right side of pivot,
            // then push right side to stack
            if ( p+1 < h )
            {
                stack[ ++top ] = p + 1;
                stack[ ++top ] = h;
            }
       }
    }
 
    // A utility function to print contents of arr
    void printArr( char arr[], int n )
    {
        int i;
        for ( i = 0; i < n; ++i )
            System.out.print(arr[i]+" ");
    }
 
    // Driver code to test above
    public static void main(String args[])
    {
        IterativeQuickSort ob = new IterativeQuickSort();
        char arr[] = {'r', 'u', 'd', 'r', 'a', 'n', 'i', 'i'};
        ob.QuickSort(arr, 0, arr.length-1);
        ob.printArr(arr, arr.length);
    }
}
