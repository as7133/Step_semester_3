package Array.assignment_problems;

import java.util.Scanner;
    public class MaximumSubarray {
        public static int maxSubArray(int[] nums) {
            int maxSoFar = nums[0];
            int currentSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                currentSum = Math.max(nums[i], currentSum + nums[i]);
                maxSoFar = Math.max(maxSoFar, currentSum);
            }
            return maxSoFar;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of elements: ");
            int n = sc.nextInt();
            int[] nums = new int[n];
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int result = maxSubArray(nums);
            System.out.println("Maximum subarray sum: " + result);
        }
    }


