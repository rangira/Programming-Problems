/*Thumbtack helps Professionals (Pros) grow their business by identifying new customers. Upon registering on Thumbtack, a Pro specifies which categories of services they provide. To help match customer requests with qualified Pros, Thumbtack maintains a list of Pros grouped by service categories.

Given a list of pros and their category preferences, return the list of Pros for each category.

Example

For pros = ["Jack", "Leon", "Maria"] and

preferences = [["Computer repair", "Handyman", "House cleaning"],
               ["Computer lessons", "Computer repair", "Data recovery service"],
               ["Computer lessons", "House cleaning"]]
the answer is

proCategorization(pros, preferences) = [[["Computer lessons"], ["Leon", "Maria"]],
                                        [["Computer repair"], ["Jack", "Leon"]],
                                        [["Data recovery service"], ["Leon"]],
                                        [["Handyman"], ["Jack"]],
                                        [["House cleaning"], ["Jack", "Maria"]]]
[input] array.string pros

A sorted non-empty array of unique strings consisting of English letters.
Here and below we assume that strings are sorted lexicographically. String A is lexicographically smaller than string B either if A is a prefix of B (and A ≠ B), or if there exists an index i (0 ≤ i < min(x.length, y.length)), such that Ai < Bi, and for any j (0 ≤ j < i) Aj = Bj. The lexicographic comparison of strings is implemented by operator < in modern programming languages.

[input] array.array.string preferences

Array of the same length as pros. For each valid i preferences[i] is a sorted array of unique elements, representing the categories the ith Pro provides services in.
[output] array.array.array.string

Array of category descriptions sorted by category names. Each category should be listed in the following format: [[<category>], [<Pro1>, <Pro2>...]] where <category> is a category name, and <Proi> is a Pro that provides services in it.
Each category present in preferences should be returned, and Pros in each subarray should be sorted.*/



import java.util.*;
import java.lang.*;
import java.io.*;


	String[][][] proCategorization(String[] pros, String[][] preferences)
	{
		Map<String,ArrayList<String>> m=new HashMap<String,ArrayList<String>>();
		Map<String,ArrayList<String>> m1=new HashMap<String,ArrayList<String>>();
		Set<String> s=new HashSet<String>();
 
		for(int i=0;i<preferences.length;i++)
		{
			String [] ar;
			ar=preferences[i];
			for(String j:ar)
				s.add(j);
		}
 
		List<String> sorted= new ArrayList<String>(s);
		Collections.sort(sorted);
 
		for(int i=0;i<pros.length;i++)
		{
			ArrayList<String> temp=new ArrayList<String>(Arrays.asList(preferences[i]));
			m.put(pros[i],temp);
		}
 
		System.out.println("Current map:");
		System.out.println(m);
 
		for(int i=0;i<sorted.size();i++)
		{    ArrayList<String> t1=new ArrayList<String>();
			Iterator it=m.entrySet().iterator();
			while(it.hasNext())
			{
				Map.Entry pair=(Map.Entry)it.next();
				ArrayList<String> t;
				t=(ArrayList<String>)pair.getValue();
				if(t.contains(sorted.get(i)))
					t1.add((String)pair.getKey());
			}
			Collections.sort(t1);
			m1.put(sorted.get(i),t1);
		}
 
		Map <String,ArrayList<String>> tm=new TreeMap<String,ArrayList<String>>(m1);
		System.out.println("Updated map:");
		System.out.println(tm);
		String[][][] ret= new String [sorted.size()][][];
		for (int i=0; i<sorted.size(); i++) {
			ret[i] = new String[2][];
			ret[i][0] = new String[] { sorted.get(i) };
			ret[i][1] = tm.get(sorted.get(i)).toArray(new String[0]);
		}
		return ret;
	}
 
 