package Array.class_problems;

import java.util.Arrays;
import java.util.Scanner;
    public class RotateArray {
        public static int[] rotateArray(int[] nums, int k) {
            if (nums == null || nums.length <= 1) {
                return nums;
            }
            k = k % nums.length;
            int[] newArray = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                newArray[(i + k) % nums.length] = nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = newArray[i];
            }

            return nums;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number of elements in the array: ");
            int size = sc.nextInt();
            int[] nums = new int[size];
            System.out.println("Enter " + size + " integers separated by spaces:");
            for (int i = 0; i < size; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.print("Enter the number of positions to rotate (k): ");
            int k = sc.nextInt();
            int[] result = rotateArray(nums, k);
            System.out.println("Rotated Array: " + Arrays.toString(result));
            sc.close();
        }
    }

