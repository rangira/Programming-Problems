class rotateMat
{
	public static void main(String args[])
	{
		 int mat[][] =
			    {
			        {1, 2, 3, 4},
			        {5, 6, 7, 8},
			        {9, 10, 11, 12},
			        {13, 14, 15, 16}
			    };
		 print(rotate(mat));
		 //print(rotate2(mat));
	}
	static int [][] rotate(int [][] input){

		int n =input.length;
		int m = input[0].length;
		int [][] output = new int [m][n];

		for (int i=0; i<n; i++)
			for (int j=0;j<m; j++)
				//output [j][n-1-i] = input[i][j];//anticlockwise
				output [m-j-1][i] = input[i][j];//clockwise
		return output;
		}
	
	
	static void print(int [][] m)
	{
	  for(int i=0;i<m.length;i++){
		  for(int j=0;j<m[0].length;j++){
			  System.out.print(m[i][j]+ "  ");
			  
		  }
		  System.out.println();
	  }
	}
}
