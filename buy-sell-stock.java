public class BuyAndSellStocks 
2	{
3	    public static int maximumProfit(int[] stockPrices)
4	    {
5	        int profit = 0;
6	        int minimumPrice = Integer.MAX_VALUE;
7	         
8	        for(int i = 0; i < stockPrices.length; i++)
9	        {
10	            profit = Math.max(profit, stockPrices[i] - minimumPrice);
11	            minimumPrice = Math.min(stockPrices[i], minimumPrice);
12	        }
13	        
14	        return profit;
15	    }
16	
17	    public static void main(String args[])
18	    {
19	        int[] stockPrices = {100, 80, 120, 130, 70, 60, 100, 125};
20	        
21	        System.out.println("maximum profit that could be obtained is: "  + maximumProfit(stockPrices));
22	    }
23	}
