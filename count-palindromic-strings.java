import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class AllDistinctPalindromicSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		String inp = s.next();
		
		HashMap<String, Boolean> distinct_palin = new HashMap<>();
		
		for(int c=0;c<inp.length();c++){
			int i=c;
			int j = i+1;
			while(i>=0&&j<inp.length()&&inp.charAt(i)==inp.charAt(j)){
			   distinct_palin.put(inp.substring(i, j+1), true);
			   i--;
			   j++;
			}
			i=c-1;
			j=c+1;
			while(i>=0&&j<inp.length()&&inp.charAt(i)==inp.charAt(j)){
				distinct_palin.put(inp.substring(i,j+1),true);
				i--;
				j++;
			}
		}
		
		for(int i=0;i<inp.length();i++)
			distinct_palin.put(inp.substring(i, i+1), true);
		
		for(Entry<String, Boolean> e : distinct_palin.entrySet())
			System.out.println(e.getKey());
		
		
		
	}

}
