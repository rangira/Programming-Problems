package zappos;

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone1
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(new Integer(1));
		l.add(new Integer(2));
		l.add(new Integer(3));
		System.out.println(generatePerm (l));
	}
	
	  public static List<List<Integer>> generatePerm(List<Integer> original) {
     if (original.size() == 0) { 
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       result.add(new ArrayList<Integer>());
       return result;
     }
     Integer firstElement = original.remove(0);
     System.out.println("firstElement = "+firstElement);
     List<List<Integer>> returnValue = new ArrayList<List<Integer>>();
     List<List<Integer>> permutations = generatePerm(original);
     
     //for (List<Integer>l : permutations)
    	 System.out.println("permutations = "+permutations.toString());
     for (List<Integer> smallerPermutated : permutations) {
    	 System.out.println("smallerPermutated = "+ smallerPermutated.toString());
    	 for (Integer l : smallerPermutated)
        	 System.out.println("integer in smallerPermutated = "+l.toString());
       for (int index=0; index <= smallerPermutated.size(); index++) {
    	 System.out.println("inside the second loop");
         List<Integer> temp = new ArrayList<Integer>(smallerPermutated);
         System.out.println("firstElement = "+firstElement);
         System.out.println("index = "+index);
         temp.add(index, firstElement);
         
         for (Integer l : temp)
        	 System.out.println("integer in temp = "+l.toString());
         returnValue.add(temp);
       }
     }
     
     System.out.println("================================");
     System.out.println("returnValue = "+returnValue.toString());
     return returnValue;
   }
}
