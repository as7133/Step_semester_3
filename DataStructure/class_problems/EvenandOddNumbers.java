package DataStructure.class_problems;

import java.util.*;

public class EvenandOddNumbers {
    public static void main(String[] args) {

        int[] arr = {3, 8, 12, 5, 7, 10};

        int even = 0;
        int odd = 0;

        for(int num : arr) {
            if(num % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}