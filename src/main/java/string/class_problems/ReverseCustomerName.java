package string.class_problems;

import java.util.Scanner;
public class ReverseCustomerName {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter customer name: ");
            String originalName = sc.nextLine();

            String reversedName = reverseCustomerName(originalName);
            System.out.println("Original Name: " + originalName);
            System.out.println("Reversed Name: " + reversedName);
            sc.close();
        }

        public static String reverseCustomerName(String customerName) {
            StringBuilder reversed = new StringBuilder();

            for (int i = customerName.length() - 1; i >= 0; i--) {
                reversed.append(customerName.charAt(i));
            }

            return reversed.toString();
        }
    }

