/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	
	public static void main(String args[])
	{
		 ArrayList<ArrayList<Integer>> result = combinationSum(new int[]{1,6,7},15) ;
		 for ( ArrayList<Integer>ar : result)
		 {
		 	System.out.println(Arrays.asList(ar));
		 }
	}
static public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
 
    if(candidates == null || candidates.length == 0) return result;
 
    ArrayList<Integer> current = new ArrayList<Integer>();
    Arrays.sort(candidates);
 
    combinationSum(candidates, target, 0, current, result);
 
    return result;
}
 
static public void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
   if(target == 0){
       ArrayList<Integer> temp = new ArrayList<Integer>(curr);
       result.add(temp);
       return;
   }
 
   for(int i=j; i<candidates.length; i++){
       if(target < candidates[i]) 
            return;
 
       curr.add(candidates[i]);
       combinationSum(candidates, target - candidates[i], i, curr, result);
       curr.remove(curr.size()-1); 
   }
}
}
