// A O(n^2) time and O(n^2) extra space method for Pascal's Triangle
void printPascal(int n)
{
  int arr[n][n]; // An auxiliary array to store generated pscal triangle values
 
  // Iterate through every line and print integer(s) in it
  for (int line = 0; line < n; line++)
  {
    // Every line has number of integers equal to line number
    for (int i = 0; i <= line; i++)
    {
      // First and last values in every row are 1
      if (line == i || i == 0)
           arr[line][i] = 1;
      else // Other values are sum of values just above and left of above
           arr[line][i] = arr[line-1][i-1] + arr[line-1][i];
      printf("%d ", arr[line][i]);
    }
    printf("\n");
  }
}
