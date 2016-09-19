/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
			List<Integer> l1 = Arrays.asList(1,2,3);
		    List<Integer> l2 = Arrays.asList(4,5);
		    List<Integer> l3 = Arrays.asList(6,7);
		
		    List<List<Integer>> lists = new ArrayList<List<Integer>>();
		    lists.add(l1);
		    lists.add(l2);
		    lists.add(l3);
		
		    Set<List<Integer>> combs = getCombinations(lists);
		    for(List<Integer> list : combs) {
		        System.out.println(list.toString());
		    }
		    
		    List<String> l4 = Arrays.asList("l","la","lal");
		    List<String> l5 = Arrays.asList("r","re");
		    
		
		    List<List<String>> lists1 = new ArrayList<List<String>>();
		    lists1.add(l4);
		    lists1.add(l5);
		    
		
		    Set<List<String>> combs1 = getCombinations1(lists1);
		    for(List<String> list1 : combs1) {
		        System.out.println(list1.toString());
		    }
	}
	
    static <Integer> Set<List<Integer>> getCombinations(List<List<Integer>> lists) {
    Set<List<Integer>> combinations = new HashSet<List<Integer>>();
    Set<List<Integer>> newCombinations;

    int index = 0;

    // extract each of the integers in the first list
    // and add each to ints as a new list
    for(Integer i: lists.get(0)) {
        List<Integer> newList = new ArrayList<Integer>();
        newList.add(i);
        combinations.add(newList);
    }
    index++;
    while(index < lists.size()) {
        List<Integer> nextList = lists.get(index);
        newCombinations = new HashSet<List<Integer>>();
        for(List<Integer> first: combinations) {
            for(Integer second: nextList) {
                List<Integer> newList = new ArrayList<Integer>();
                newList.addAll(first);
                newList.add(second);
                newCombinations.add(newList);
            }
        }
        combinations = newCombinations;

        index++;
    }

    return combinations;
}



static <String> Set<List<String>> getCombinations1(List<List<String>> lists) {
    Set<List<String>> combinations = new HashSet<List<String>>();
    Set<List<String>> newCombinations;

    int index = 0;

    // extract each of the integers in the first list
    // and add each to ints as a new list
    for(String i: lists.get(0)) {
        List<String> newList = new ArrayList<String>();
        newList.add(i);
        combinations.add(newList);
    }
    index++;
    while(index < lists.size()) {
        List<String> nextList = lists.get(index);
        newCombinations = new HashSet<List<String>>();
        for(List<String> first: combinations) {
            for(String second: nextList) {
                List<String> newList = new ArrayList<String>();
                newList.addAll(first);
                newList.add(second);
                newCombinations.add(newList);
            }
        }
        combinations = newCombinations;

        index++;
    }

    return combinations;
}
}
