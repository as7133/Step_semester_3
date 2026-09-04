package stringOperationsAndPerformance.class_problems;
import java.util.Scanner;
public class VowelConsonantCounter {
        public static void countVowelsAndConsonants(String text) {
            int vowels = 0;
            int consonants = 0;
            String lowerText = text.toLowerCase();
            for (int i = 0; i < lowerText.length(); i++) {
                char ch = lowerText.charAt(i);
                if (ch == ' ') {
                    continue;
                }
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                }
                else {
                    consonants++;
                }
            }
            System.out.println("Vowels: " + vowels + "| Consonants: " + consonants);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a book title: ");
            String word = sc.nextLine();
            countVowelsAndConsonants(word);
            sc.close();
        }
    }
