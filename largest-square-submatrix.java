public class MaximumSizeSquareSubmatrixWithAllOnes {
2	
3	    private static int maximumSizeSquareSubmatrixWithAllOnes(int[][] matrix) {
4	        int maxSize = 0;
5	        int r = matrix.length;
6	        int c = matrix[0].length;
7	         
8	        int[][] table = new int[r][c];
9	
10	        for (int i = 0; i < r; i++) {
11	            for (int j = 0; j < c; j++) {
12	                 
13	                if (i == 0 || j == 0) {
14	                    table[i][j] = matrix[i][j];
15	                    maxSize = table[i][j] > maxSize ? table[i][j] : maxSize;
16	                }
17	                 
18	                else if (matrix[i][j] == 0) {
19	                    table[i][j] = 0;
20	                }
21	                 
22	                else {
23	                    table[i][j] = min(table[i - 1][j - 1], table[i - 1][j], table[i][j - 1]) + 1;
24	                    maxSize = table[i][j] > maxSize ? table[i][j] : maxSize;
25	                }
26	            }
27	        }
28	
29	        return maxSize;
30	    }
31	
32	    private static int min(int i, int j, int k) {
33	        return i <= j && i <= k ? i : (j <= i && j <= k ? j : k);
34	    }
35	
36	    public static void main(String[] args) {
37	        int matrix[][] = { { 0, 1, 1, 0, 1, 1 },
38	                           { 1, 1, 0, 1, 1, 1 },
39	                           { 0, 1, 1, 1, 0, 0 },
40	                           { 1, 1, 1, 1, 0, 0 },
41	                           { 1, 1, 1, 1, 1, 0 },
42	                           { 0, 1, 1, 1, 0, 1 }
43	                         };
44	        System.out.println(maximumSizeSquareSubmatrixWithAllOnes(matrix));
45	    }
46	}
