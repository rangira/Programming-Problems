Stock Buy Sell to Maximize Profit
The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.


We strongly recommend that you click here and practice it, before moving on to the solution.


If we are allowed to buy and sell only once, then we can use following algorithm. Maximum difference between two elements. Here we are allowed to buy and sell multiple times. Following is algorithm for this problem.
1. Find the local minima and store it as starting index. If not exists, return.
2. Find the local maxima. and store it as ending index. If we reach the end, set the end as ending index.
3. Update the solution (Increment count of buy sell pairs)
4. Repeat the above steps if end is not reached.
CJava
// Program to find best buying and selling days
import java.util.ArrayList;
 
// Solution structure
class Interval 
{
    int buy, sell;
}
 
class StockBuySell 
{
    // This function finds the buy sell schedule for maximum profit
    void stockBuySell(int price[], int n) 
    {
        // Prices must be given for at least two days
        if (n == 1)
            return;
         
        int count = 0;
 
        // solution array
        ArrayList<Interval> sol = new ArrayList<Interval>();
 
        // Traverse through given price array
        int i = 0;
        while (i < n - 1) 
        {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element. 
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;
 
            // If we reached the end, break as no further solution possible
            if (i == n - 1)
                break;
 
            Interval e = new Interval();
            e.buy = i++;
            // Store the index of minima
             
 
            // Find Local Maxima.  Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (price[i] >= price[i - 1]))
                i++;
 
            // Store the index of maxima
            e.sell = i-1;
            sol.add(e);
             
            // Increment number of buy/sell
            count++;
        }
 
        // print solution
        if (count == 0)
            System.out.println("There is no day when buying the stock "
                                                  + "will make profit");
        else
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + sol.get(j).buy
                        +"        " + "Sell on day : " + sol.get(j).sell);
         
        return;
    }
 
    public static void main(String args[]) 
    {
        StockBuySell stock = new StockBuySell();
         
        // stock prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        int n = price.length;
 
        // fucntion call
        stock.stockBuySell(price, n);
    }
}
