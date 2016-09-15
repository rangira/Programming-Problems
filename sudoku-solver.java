package zappos;

public class sudoku_9
{
  static int [][] ar = {
		  		 {1,0,0,0,0,0,0,0,0},
		         {0,0,0,0,0,0,0,0,0},
		         {0,0,0,1,0,0,0,0,0},
		         {0,0,0,0,0,0,0,0,0},
		         {0,0,0,0,0,0,0,0,0},
		         {0,0,0,0,0,0,0,0,0},
		         {0,0,0,0,0,0,0,0,0},
		         {0,0,0,0,0,0,0,0,0},
		         {0,0,0,0,0,0,0,0,0},
		         
  				};
  
  
  boolean solve (int [][]ar)
  {
	  int[] temp = findUn();
	  
	  
		if (temp != null){
		int row =temp[0];
		int col =temp[1];
	 
		
		for(int n =1;n<10;n++){
			if (checkRow(ar,row,n) && checkCol(ar,col,n) && checkBox(ar,row,col,n)){
				
	 
				ar[row][col]=n;
				if (solve(ar)){
					return true;
				}
				ar[row][col]=0;
			}
		}
	}else
		return true;
	return false;
  }
  
  public static int[] findUn(){
	  
	  int[] t = new int[2];
	  	for (int i =0;i<ar.length;i++){
	   
	  		for(int j =0;j<ar.length;j++){
	  			if (ar[i][j]==0){
	  				t[0]=i;
	  				t[1]=j;
	  				return t;
	  			}
	  		}
	  	}
	  	return null;
	  }



  
  public  boolean checkRow(int[][] m, int r,int n)
  {
	  for (int col=0; col<9; col++)
		  if (m[r][col]== n)
			  return false;
	  return true;
		
 }
  
 public  boolean checkCol (int [][]m, int c, int n)
 {
	 
	 for (int row=0; row<9; row++)
		if (m[row][c] == n)
		   return false;
	 return true;
 }
 
 
 public  boolean checkBox(int[][]m,int r, int c, int n)
 {
	 
	 for(int row=r/3*3; row<r/3*3+3; row++)
		           for (int col=c/3*3; col<c/3*3+3; col++)
		                 if (m[row][col] == n)
		                      return false;
	 return true;
		                      
 }
 
 public void print ()
 {
	 for (int i=0;i<9;i++)
	 {
		 for(int j=0;j<9;j++)
			 System.out.print(ar[i][j]+ " ");
		 System.out.println();
	 }
 }
 
 public void print ( int [][]m)
 {
	 for (int i=0;i<9;i++)
	 {
		 for(int j=0;j<9;j++)
			 System.out.print(m[i][j]+ " ");
		 System.out.println();
	 }
	 System.out.println("===================================================================="); 
 }
 
 public static void main(String args [])
 {
	 sudoku_9 s = new sudoku_9();
	 s.solve (ar);
	 s.print();
 }
 
  
  
	
}
