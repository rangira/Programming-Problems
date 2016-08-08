
import java.util.Arrays;
import java.util.Random;

 class IterativeMergeSort {

   /////////////////////////////////////////
   // Iterative mergeSort
   /////////////////////////////////////////

   public static void iterativeMergesort(int[] a) {
      int[] aux = new int[a.length];
      for (int blockSize=1; blockSize<a.length; blockSize*=2)
         for (int start=0; start<a.length; start+=2*blockSize)
            merge(a, aux, start, start+blockSize, start+2*blockSize);
   }

   /////////////////////////////////////////
   // Iterative mergeSort without copy
   /////////////////////////////////////////

   public static void iterativeMergesortWithoutCopy(int[] a) {
      int[] from = a, to = new int[a.length];
      for (int blockSize=1; blockSize<a.length; blockSize*=2) {
         for (int start=0; start<a.length; start+=2*blockSize)
            mergeWithoutCopy(from, to, start, start+blockSize, start+2*blockSize);
          int[] temp = from;
          from = to;
          to = temp;
      }
       if (a != from)
         // copy back
         for (int k = 0; k < a.length; k++)
            a[k] = from[k];
   }

    private static void mergeWithoutCopy(int[] from, int[] to, int lo, int mid, int hi) {
       // DK: cannot just return if mid >= a.length, but must still copy remaining elements!
       // DK: add two tests to first verify "mid" and "hi" are in range
       if (mid > from.length) mid = from.length;
       if (hi > from.length) hi = from.length;
       int i = lo, j = mid;
       for (int k = lo; k < hi; k++) {
          if      (i == mid)          to[k] = from[j++];
          else if (j == hi)           to[k] = from[i++];
          else if (from[j] < from[i]) to[k] = from[j++];
          else                        to[k] = from[i++];
       }
       // DO NOT copy back
       // for (int k = lo; k < hi; k++)
       //   a[k] = aux[k];
    }

   /////////////////////////////////////////
   // Recursive mergeSort, adapted from:
   // Sedgewick and Wayne, Introduction to Programming in Java
   // http://www.cs.princeton.edu/introcs/42sort/MergeSort.java.html
   /////////////////////////////////////////

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
       // DK: add two tests to first verify "mid" and "hi" are in range
       if (mid >= a.length) return;
       if (hi > a.length) hi = a.length;
       int i = lo, j = mid;
       for (int k = lo; k < hi; k++) {
          if      (i == mid)     aux[k] = a[j++];
          else if (j == hi)      aux[k] = a[i++];
          else if (a[j] < a[i])  aux[k] = a[j++];
          else                   aux[k] = a[i++];
       }
       // copy back
       for (int k = lo; k < hi; k++)
          a[k] = aux[k];
    }

    public static void recursiveMergesort(int[] a, int[] aux, int lo, int hi) {
       // base case
       if (hi - lo <= 1) return;
       // sort each half, recursively
       int mid = lo + (hi - lo) / 2;
       recursiveMergesort(a, aux, lo, mid);
       recursiveMergesort(a, aux, mid, hi);
       // merge back together
       merge(a, aux, lo, mid, hi);
    }

    public static void recursiveMergesort(int[] a) {
        int n = a.length;
        int[] aux = new int[n];
        recursiveMergesort(a, aux, 0, n);
    }

   /////////////////////////////////////////
   // Main and support methods
   /////////////////////////////////////////

   public static void main(String[] args) {
      System.out.println("First, verify this actually sorts arrays...");
      int n = 17; // pick a size to suit you!
      int[] a = makeRandomArray(n);
      int[] acopy = copyArray(a); // use to verify sort using built-in sort
      System.out.println("Before: " + Arrays.toString(a));
      iterativeMergesortWithoutCopy(a);
      System.out.println("After: " + Arrays.toString(a));
      // now verify the sort worked by comparing to built-in sort
      Arrays.sort(acopy);
      System.out.println("Verified = " + (Arrays.equals(a, acopy)));

      n = 1000*1000; // 1m feels about right
      long time0, time1;
      System.out.println("\nNow, compare times on array of size " + n + ":");
      a = makeRandomArray(n);
      System.out.print("iterativeMergesort: ");
      acopy = copyArray(a);
      time0 = System.currentTimeMillis();
      iterativeMergesort(acopy);
      time1 = System.currentTimeMillis();
      System.out.println((time1-time0) + "milliseconds");

      System.out.print("iterativeMergesortWithoutCopy: ");
      acopy = copyArray(a);
      time0 = System.currentTimeMillis();
      iterativeMergesortWithoutCopy(acopy);
      time1 = System.currentTimeMillis();
      System.out.println((time1-time0) + "milliseconds");

      System.out.print("recursiveMergesort: ");
      acopy = copyArray(a);
      time0 = System.currentTimeMillis();
      recursiveMergesort(acopy);
      time1 = System.currentTimeMillis();
      System.out.println((time1-time0) + "milliseconds");

      System.out.print("Arrays.sort:        ");
      acopy = copyArray(a);
      time0 = System.currentTimeMillis();
      Arrays.sort(acopy);
      time1 = System.currentTimeMillis();
      System.out.println((time1-time0) + "milliseconds");
   }

   public static int[] copyArray(int[] a) {
      int[] copy = new int[a.length];
      System.arraycopy(a, 0, copy, 0, a.length);
      return copy;
   }

   public static int[] makeRandomArray(int n) {
      int[] a = new int[n];
      Random random = new Random();
      for (int i=0; i<a.length; i++)
         // use small #'s for small n for "pretty printing"
         a[i] = ((n < 100) ? random.nextInt(100) : random.nextInt());
      return a;
   }
}
