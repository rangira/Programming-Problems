package presisentialGala;

import java.io.IOException;

public class minJumps {

	public static void main(String[] args) throws IOException 
	{
		
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		minJumps(arr);
	}
	
	static void minJumps(int[]arr) throws IOException
	{
		int i=0,cnt=0,maxSteps=0;
		for (;i<arr.length;)
		{
			maxSteps = arr[i];
			int j=leap(arr,i,maxSteps);
			char c = (char) System.in.read();
			if(j!=0)
				cnt++;
			else if(j==0 && (i ==arr.length-1))
				System.out.println("cnt  = "+cnt);
			else if (j==0 && i!=arr.length)
				System.out.println(cnt);
	
			i=i+j;
			if( i >= arr.length-1)
			{
				System.out.println(cnt);
				break;
			}
			
		}
	}
	
	static int leap(int arr[],int i,int maxSteps)
	{
		int j =0;
		for( j=maxSteps;j>=0;j--)
		{
			if(i+j < arr.length)
				break;
		}
		
		return j;
	}

}

