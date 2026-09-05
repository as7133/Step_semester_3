package Array.class_problems;
import java.util.Arrays;
import java.util.Scanner;
public class BuyAndSellStock{
        public static void printStockAnalysis(int[] prices) {
            if (prices == null || prices.length == 0)
            {
                System.out.println("0 (prices only fall, so no trade is profitable)");
                return;
            }
            int minPrice = Integer.MAX_VALUE;
            int minDay = -1;
            int maxProfit = 0;
            int buyDay = -1;
            int buyPrice = -1;
            int sellDay = -1;
            int sellPrice = -1;

            for (int i = 0; i < prices.length; i++) {
                // Days are 1-indexed in the sample image
                int currentDay = i + 1;
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                    minDay = currentDay;
                }
                else if (prices[i] - minPrice > maxProfit) {
                    maxProfit = prices[i] - minPrice;
                    buyDay = minDay;
                    buyPrice = minPrice;
                    sellDay = currentDay;
                    sellPrice = prices[i];
                }
            }
            if (maxProfit > 0) {
                System.out.printf("%d (buy on day %d at price %d, sell on day %d at price %d)\n",
                        maxProfit, buyDay, buyPrice, sellDay, sellPrice);
            } else {
                System.out.println("0 (prices only fall, so no trade is profitable)");
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number of days: ");
            int n = sc.nextInt();
            int[] prices = new int[n];
            System.out.println("Enter the stock prices separated by spaces:");
            for (int i = 0; i < n; i++) {
                prices[i] = sc.nextInt();
            }
            System.out.print("\nOutput: ");
            printStockAnalysis(prices);
            sc.close();
        }
    }