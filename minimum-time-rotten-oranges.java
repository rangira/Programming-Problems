 
import java.util.*;
import java.lang.*;
import java.io.*;
 
 
class BfsApplication
{
	static final int R=3,C=5;
	class ele{
		int x,y;
		ele(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	// function to check whether a cell is valid / invalid
	boolean isvalid(int i, int j)
	{
	    return (i >= 0 && j >= 0 && i < R && j < C);
	}
 
	// Function to check whether the cell is delimiter
	// which is (-1, -1)
	boolean isdelim(ele temp)
	{
	    return (temp.x == -1 && temp.y == -1);
	}
 
	// Function to check whether there is still a fresh
	// orange remaining
	boolean checkall(int arr[][])
	{
	    for (int i=0; i<R; i++)
	       for (int j=0; j<C; j++)
	          if (arr[i][j] == 1)
	             return true;
	    return false;
	}
 
	// This function finds if it is possible to rot all oranges or not.
	// If possible, then it returns minimum time required to rot all,
	// otherwise returns -1
	int rotOranges(int arr[][])
	{
	    // Create a queue of cells
	    LinkedList<ele> Q = new LinkedList<ele>()  ;
 
	    int ans = 0;
 
	    // Store all the cells having rotten orange in first time frame
	    for (int i=0; i<R; i++)
	    {
	       for (int j=0; j<C; j++)
	       {
	            if (arr[i][j] == 2)
	            {
 
	                //System.out.println(temp.x+" "+temp.y);
	                Q.add(new ele(i,j));
	            }
	        }
	    }
 
 
 
	    // Separate these rotten oranges from the oranges which will rotten
	    // due the oranges in first time frame using delimiter which is (-1, -1)
	    ele temp = new ele(0,0);
	   // temp.x = -1;
	    //temp.y = -1;
	    Q.add(new ele(-1,-1));
 
 
	    // Process the grid while there are rotten oranges in the Queue
	    while (Q.size()!=0)
	    {
	        // This flag is used to determine whether even a single fresh
	        // orange gets rotten due to rotten oranges in current time
	        // frame so we can increase the count of the required time.
	        boolean flag = false;
	 		temp=Q.poll();
 
	        // Process all the rotten oranges in current time frame.
	        while (!isdelim(temp))
	        {
 
 
	            //Q.poll();
 
	            // Check right adjacent cell that if it can be rotten
	            if (isvalid(temp.x+1, temp.y) && arr[temp.x+1][temp.y] == 1)
	            {
	                // if this is the first orange to get rotten, increase
	                // count and set the flag.
	                if (!flag) {ans++; flag = true;}
 
	                // Make the orange rotten
	                arr[temp.x+1][temp.y] = 2;
 
	                // push the adjacent orange to Queue
	                temp.x++;
	                Q.add(new ele(temp.x,temp.y));
 
	                temp.x--; // Move back to current cell
	            }
 
	            // Check left adjacent cell that if it can be rotten
	            if (isvalid(temp.x-1, temp.y) && arr[temp.x-1][temp.y] == 1) {
	                if (!flag) {ans++; flag = true;}
	                arr[temp.x-1][temp.y] = 2;
	                temp.x--;
	                Q.add(new ele(temp.x,temp.y)); // push this cell to Queue
	                temp.x++;
 
	            }
 
	            // Check top adjacent cell that if it can be rotten
	            if (isvalid(temp.x, temp.y+1) && arr[temp.x][temp.y+1] == 1) {
	                if (!flag) {ans++; flag = true;}
	                arr[temp.x][temp.y+1] = 2;
	                temp.y++;
	                Q.add(new ele(temp.x,temp.y)); // Push this cell to Queue
	                temp.y--;
 
	            }
 
	            // Check bottom adjacent cell if it can be rotten
	            if (isvalid(temp.x, temp.y-1) && arr[temp.x][temp.y-1] == 1) {
	                if (!flag) {ans++; flag = true;}
	                arr[temp.x][temp.y-1] = 2;
	                temp.y--;
	                Q.add(new ele(temp.x,temp.y)); // push this cell to Queue
	                temp.y++;
	            }
	 			//pops the element and stores in temp
				temp=Q.poll();
	        }
 
	    	//We arrive here if the last element popped was delimiter
 
	        // If oranges were rotten in current frame than separate the
	        // rotten oranges using delimiter for the next frame for processing.
	        if (Q.size()!=0) {
	           // temp.x = -1;
	            //temp.y = -1;
	            Q.add(new ele(-1,-1));
	        }
 
	        // If Queue was empty than no rotten oranges left to process so exit
	    }
 
	    // Return -1 if all arranges could not rot, otherwise ans.
	    if(checkall(arr))
	     return -1;
	     else
	     return ans;
	}
 
 
	public static void main (String[] args) 
	{
		BfsApplication b = new BfsApplication();
		int arr[][] = new int[][]{ {2, 1, 0, 2, 1},
	                     {1, 0, 1, 2, 1},
	                     {1, 0, 0, 2, 1}};
	    int ans = b.rotOranges(arr);
	    if (ans == -1)
	        System.out.println( "All oranges cannot rot");
	    else
	        System.out.println( "Time required for all oranges to rot => " + ans);
 
	}
}
 
