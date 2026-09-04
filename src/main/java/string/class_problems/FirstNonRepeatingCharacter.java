package string.class_problems;

import java.util.Scanner;
public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.nextLine();
        char result = findFirstNonRepeatingChar(input);
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
        sc.close();
    }

    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++)
        {
            freq[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++)
        {
            if (freq[text.charAt(i)] == 1)
            {
                return text.charAt(i);
            }
        }
        return '\0';
    }
}