package string.assignment_problems;

import java.util.Scanner;
class TypingAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {

        int length = Math.min(original.length(), typed.length());
        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i + 1;
            }
        }

        int totalCharacters = original.length();

        double accuracy = (matched * 100.0) / totalCharacters;

        System.out.println("Matched: " + matched + "/" + totalCharacters);
        System.out.printf("Accuracy: %.2f%%\n", accuracy);

        if (firstMismatch == -1 && original.length() == typed.length())
        {
            System.out.println("No Mismatches");
        } else if (firstMismatch != -1)
        {
            System.out.println("First Mismatch at position " + firstMismatch);
        } else
        {
            System.out.println("Length Mismatch");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter original text: ");
        String original = sc.nextLine();
        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();
        checkTypingAccuracy(original, typed);
        sc.close();
    }
}

