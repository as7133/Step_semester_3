package Array.assignment_problems;
import java.util.*;
public class SubarraySumEqualsK {
        public static int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> prefixCount = new HashMap<>();
            prefixCount.put(0, 1);
            int count = 0;
            int prefixSum = 0;
            for (int num : nums) {
                prefixSum += num;
                if (prefixCount.containsKey(prefixSum - k)) {
                    count += prefixCount.get(prefixSum - k);
                }

                prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
            }
            return count;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of elements: ");
            int n = sc.nextInt();
            int[] nums = new int[n];
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++)
            {
                nums[i] = sc.nextInt();
            }
            System.out.print("Enter target sum k: ");
            int k = sc.nextInt();
            int result = subarraySum(nums, k);
            System.out.println("Number of subarrays with sum =" + result);
        }
    }


