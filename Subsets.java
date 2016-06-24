import java.util.ArrayList;
import java.util.List;



/*
We must show that
(n0)+(n1)+(n2)+⋯+(nn)=2n
(n0)+(n1)+(n2)+⋯+(nn)=2n
is the number of subsets of an nn-element set SS where n≥0n≥0.

Every subset of SS is a kk-subset of SS where k=0,1,2,...,nk=0,1,2,...,n. We know that (nk)(nk) equals the number of kk-subsets of S. Thus by the Addition Principle
(n0)+(n1)+(n2)+⋯+(nn)
(n0)+(n1)+(n2)+⋯+(nn)
equals the number of subsets to the set SS. We can count the same thing by observing that each element of the set SS has two choices, either they are in a subset or they are not in a subset. Let S={x1,x2,x3,...,xn}S={x1,x2,x3,...,xn}. So, x1x1 is either in a subset or it is not in a subset, x2x2 is either in a subset or it is not in a subset,..., xnxn is either in a subset or it is not in a subset. Thus by the Multiplication Principle there are 2n2n ways we can form a subset of the set SS. Hence (n0)+(n1)+(n2)+⋯+(nn)=2n(n0)+(n1)+(n2)+⋯+(nn)=2n.

Another approach is to consider the Binomial Theorem
(x+y)n=∑k=0n(nk)xn−kyk.
(x+y)n=∑k=0n(nk)xn−kyk.
Letting x=1x=1 and y=1y=1 we obtain
2n=∑k=0n(nk).


The number of subsets of a set with n elements is 2n. If we have, for example, the string "abc", we will have 2n = 23 = 8 subsets.

The number of states that can be represented by n bits is also 2n. We can show there is a correspondence between enumerating all possible states for n bits and all possible subsets for a set with n elements:

   2 1 0   2 1 0
   c b a    bits
0          0 0 0
1      a   0 0 1
2    b     0 1 0
3    b a   0 1 1
4  c       1 0 0
5  c   a   1 0 1
6  c b     1 1 0 
7  c b a   1 1 1
If we consider line 5, for example, bits 2 and 0 are active. If we do abc.charAt(0) + abc.charAt(2) we get the subset ac.

To enumerate all possible states for n bits we start at 0, and sum one until we reach 2n - 1. In this solution we will start at 2n - 1 and decrement until 0, so we don't need another parameter just to keep the number of subsets, but the effect is the same:*/

public class Subsets {
	
	public static void main(String args[]){
		
		powerSet("rudra");
		
	}
	
	static void powerSet(String s) {
	    // the number of subsets is 2^n
	    long numSubsets = 1L << s.length();
	    System.out.println(numSubsets);
	    System.out.println( powerSet(s, numSubsets - 1));
	}

	static List<String> powerSet(String s, long active) {
	    if (active < 0) {
	        // Recursion base case
	        // All 2^n subsets were visited, stop here and return a new list
	        return new ArrayList<>();
	    }

	    StringBuilder subset = new StringBuilder();
	    for (int i = 0; i < s.length(); i++) {
	        // For each bit
	    	System.out.println("active "+ active);
	    	System.out.println(" Binary active   "+ Long.toBinaryString( active));
	        if (isSet(active, i)) {
	            // If the bit is set, add the correspondent char to this subset
	            subset.append(s.charAt(i));
	            System.out.println("subset inside loop "+ subset);
	            
	        }
	    }
	    
	    System.out.println("subset  ===================>  "+subset);
	    // Make the recursive call, decrementing active to the next state,
	    // and get the returning list
	    List<String> subsets = powerSet(s, active - 1);
	    // Add this subset to the list of subsets
	    subsets.add(subset.toString());
	    return subsets;
	}

	static boolean isSet(long bits, int i) {
	    // return true if the ith bit is set
		 System.out.println("bits and i  --- "+ Long.toBinaryString(bits)+" "+i);
		 System.out.println("After shifting   "+Long.toBinaryString(1L << i));
		 System.out.println((bits & (1L << i)));
	    return (bits & (1L << i)) != 0;
	}

}

