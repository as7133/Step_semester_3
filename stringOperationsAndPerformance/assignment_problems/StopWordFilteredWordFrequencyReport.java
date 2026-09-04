package stringOperationsAndPerformance.assignment_problems;
import java.util.*;
public class StopWordFilteredWordFrequencyReport {
        static void printFilteredWordFrequency(String feedback) {
            String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
            feedback = feedback.toLowerCase();
            feedback = feedback.replace(".", "");
            feedback = feedback.replace(",", "");
            String[] words = feedback.split("\\s+");
            HashMap<String, Integer> frequency = new HashMap<>();
            for (String word : words) {
                boolean isStopWord = false;
                for (String stopWord : stopWords) {
                    if (word.equals(stopWord)) {
                        isStopWord = true;
                        break;
                    }
                }
                if (!isStopWord) {
                    if (frequency.containsKey(word)) {
                        frequency.put(word, frequency.get(word) + 1);
                    } else {
                        frequency.put(word, 1);
                    }
                }
            }
            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter feedback: ");
            String feedback = sc.nextLine();
            printFilteredWordFrequency(feedback);
            sc.close();
        }
    }

