/* Given the integer form the largest number which can be made from the digits*/
/*  Given a Integer, find the maximum number that can be formed from the digits.

Input: 8754365
Output: 8765543  */



import java.util.stream.*;
import java.util.*;
 
 
 class Sol{

    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		System.out.println(largestNumberFunctional(8754365));
		System.out.println(largestNumber(11900));
	}
	
	
	//Java 8 solution
	
	static int largestNumberFunctional(int i) {
            return Integer.parseInt(
                    Arrays.stream((i + "")
                            .split(""))
                            .sorted((x,y)->y.compareTo(x))
                            .collect(Collectors.joining())
            );
 
    }

    //Conventional Solution
    static int largestNumber(int number) {
        String strings[]=(number+"").split("");
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String t1, String t2) {
                return t2.compareTo(t1);
            }
        });
        StringBuilder sb=new StringBuilder(strings.length);
        for(String t:strings) sb.append(t);
        return Integer.parseInt(sb.toString());
    }
}
