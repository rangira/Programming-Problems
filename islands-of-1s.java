package zappos;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class islands 
{
	static int mat [][]= { 
					{1,0,1,1,0},
					{0,1,0,0,1},
					{1,0,1,1,0},
					{1,0,1,1,0},
					{0,1,0,0,1}
			
				  };
	
	static int mat1 [][]= { 
			{1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,0,0,0,0,0,0},
			{1,1,1,0,0,0,0,1,1,1},
			{1,1,0,0,1,0,0,1,1,1},
			{1,0,1,0,0,1,1,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,1,1,1},
			{0,0,0,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,1,1,1},
		  };

	public static void main(String args[])
	{
		System.out.println(numIslands(mat1));
	}
	
	public static  int numIslands(int [][] grid) {
        int numR = grid.length;
        if(numR == 0)
            return 0;
        int numC = grid[0].length;
        int numOfIslands = 0;
        int islandSize = 0;
        Map<Integer,Integer> islands = new HashMap<Integer,Integer>();
        
        Stack<Integer> Row = new Stack<Integer>();
        Stack<Integer> Col = new Stack<Integer>();
        for(int i = 0; i < numR; i++){
            for(int j = 0; j < numC; j++){
                if(grid[i][j] == 1){
                	//islandSize++;
                    Row.push(i);
                    Col.push(j);
                    while(!Row.isEmpty() && !Col.isEmpty()){
                        int x = Row.pop();
                        int y = Col.pop();
                        if(grid[x][y] == 1)
                        	islandSize++;
                        
                        grid[x][y] = 0;
                        
                        if(y+1 < numC && grid[x][y+1] == 1){
                        	//islandSize++;
                            Row.push(x);
                            Col.push(y+1);
                        }
                        if(y-1 >= 0 && grid[x][y-1] == 1){
                        	//islandSize++;
                            Row.push(x);
                            Col.push(y-1);
                        }
                        if(x+1 < numR && grid[x+1][y] == 1){
                        	//islandSize++;
                            Row.push(x+1);
                            Col.push(y);
                        }
                        if(x-1 >= 0 && grid[x-1][y] == 1){
                        	//islandSize++;
                            Row.push(x-1);
                            Col.push(y);
                        }
                        
                    }
                    numOfIslands++;
                    if(islandSize != 0)
                    {
	                    if(!islands.keySet().contains(islandSize))
	                    	islands.put(islandSize, 1);
	                    else
	                    {
	                    	int cnt = islands.get(islandSize);
	                    	cnt++;
	                    	islands.put(islandSize,cnt);
	                    }
                    }
                    
                }
                islandSize = 0;
               
            }
        }
        
        System.out.println(islands.toString());
        return numOfIslands;
    }
}
