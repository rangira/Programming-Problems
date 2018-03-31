/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
   public static void main(String args[]){
     System.out.println(letterCombinations("123"));
   }
   
   
   static List<List<String>> substrings(String input) {
    // Base case: There's only one way to split up a single character
    // string, and that is ["x"] where x is the character.
    if (input.length() == 1)
        return Collections.singletonList(Collections.singletonList(input));
 
    // To hold the result
    List<List<String>> result = new ArrayList<>();
 
    // Recurse (since you tagged the question with recursion ;)
    for (List<String> subresult : substrings(input.substring(1))) {
 
        // Case: Don't split
        List<String> l2 = new ArrayList<>(subresult);
        l2.set(0, input.charAt(0) + l2.get(0));
        result.add(l2);
 
        // Case: Split
        List<String> l = new ArrayList<>(subresult);
        l.add(0, input.substring(0, 1));
        result.add(l);
    }
 
    return result;
}
   public static void DFS(List<Integer> digits, List<String> result, StringBuffer s, int start,
		HashMap<Integer, String> map) {
			System.out.println("1 = "+digits);
			System.out.println("2 = "+digits.size());
			System.out.println("3 = "+start);

	if (start == digits.size())
		result.add(s.toString());
	else {
		//String tmp = map.get(digits.charAt(start) - '0');
		if(map.containsKey(digits.get(start))){
			System.out.println("start = "+ start);
			System.out.println("map.get(digits.get(start)) = "+ digits.get(start)+ "hhc");
			String tmp = map.get(digits.get(start));
			for (int i = 0; i < tmp.length(); i++) {
				s.append(tmp.charAt(i));
				DFS(digits, result, s, start + 1, map);
				s.deleteCharAt(s.length() - 1);
			}
		}
	}
}

public static List<String> letterCombinations(String digits) {
	if (digits == null || digits.length() == 0)
		return new ArrayList<String>();
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	map.put(0, "");
	map.put(1, "");
	map.put(2, "abc");
	map.put(3, "de");
	map.put(4, "ghi");
	map.put(5, "jkl");
	map.put(6, "mno");
	map.put(7, "pqrs");
	map.put(8, "tuv");
	map.put(9, "wxyz");
	map.put(23,"om");
	map.put(34,"wy");
	List<String> result = new ArrayList<String>();
	StringBuffer s = new StringBuffer();
	List<List<String>> substrs = substrings("234");
	for(int i=0; i<substrs.size();i++){
		List<Integer> digint = new ArrayList<Integer>();
		substrs.get(i).stream().forEach(el -> digint.add(Integer.parseInt(el)));
		DFS(digint, result, s, 0, map);
		System.out.println(i);

	}
	return result;
}

}
