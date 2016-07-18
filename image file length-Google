
import java.util.*;
class Solution{
    
    public static void main(String args[]){
        
        Scanner input = new Scanner(System.in);
        String s ="";
        while (input.hasNext()){
            s+=input.nextLine()+"\n";
        }
        System.out.println(printSum(s));
    }
public static int printSum(String s){
	  String[] arr=s.split("\n");
	  int sum=0, spaces=0;
	  
	  for(int i=arr.length-1;i>=0;i--){
		String line=arr[i];
		if(line.contains(".gif") | line.contains(".jpeg") ){
			spaces=line.length()-line.trim().length();
		}
		if(spaces> line.length()-line.trim().length() ){
			sum+=line.trim().length()+1;
			spaces--;
		}
	}
	return sum;
}
}

/*
INPUT :
dir1
 dir11
 dir12
  picture.jpeg
  dir 121
   file1.txt
dir2
 file2.gif


*/
