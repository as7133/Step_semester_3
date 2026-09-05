package Array.class_problems;
import java.util.Scanner;
import java.util.Arrays;
public class MergeTwoSortedArrays {
        static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
            int[] result = new int[arr1.length + arr2.length];
            // Copy elements from first array
            for (int i = 0; i < arr1.length; i++) {
                result[i] = arr1[i];
            }

            // Copy elements from second array
            for (int i = 0; i < arr2.length; i++) {
                result[arr1.length + i] = arr2[i];
            }

            // Sort the combined array
            Arrays.sort(result);

            return result;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter size of first array:");
            int n1 = sc.nextInt();

            int[] arr1 = new int[n1];

            System.out.println("Enter elements of first array:");
            for (int i = 0; i < n1; i++) {
                arr1[i] = sc.nextInt();
            }

            System.out.println("Enter size of second array:");
            int n2 = sc.nextInt();

            int[] arr2 = new int[n2];

            System.out.println("Enter elements of second array:");
            for (int i = 0; i < n2; i++) {
                arr2[i] = sc.nextInt();
            }

            int[] result = mergeSortedArrays(arr1, arr2);

            System.out.print("Merged and sorted array: [");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);

                if (i < result.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }