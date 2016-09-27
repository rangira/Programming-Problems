package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class SubsetIterator<E> {
    private final List<E> set;
    private final int max;
    private int index;
    
    
    public SubsetIterator(List<E> originalList) {
        set = originalList;
        max = (1 << set.size());
        index = 0;
    }
    
    
    public boolean hasNext() {
        return index < max;
    }
    
    
    public List<E> next() {
        List<E> newSet = new ArrayList<E>();
        int flag = 1;      
        for (E element : set) {
            if ((index & flag) != 0) {
            	//System.out.println("element = "+ element);
                newSet.add(element);
            }
            flag <<= 1;
        }
        ++index;
        return newSet;
    }
    
    

    public static void main(String[] args) {
        List<String> set = Arrays.asList("a","b","c","d");//,"e","f","g","h","i","j","k","l","m","n");
        SubsetIterator<String> it = 
                new SubsetIterator<String>(set);      
        while (it.hasNext()) {
        	 List<String> l = it.next();
        	 StringBuffer listString = new StringBuffer();

        	 
        	 //if(l.size() == 1)
        	 //{
        		 for (String s : l)
           	     listString.append(s);
        		 System.out.println(listString);
        	 //}
        } 
    }
}
