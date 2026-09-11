package OOPIntoduction.assignment_problems;
public class TopPerformerTracker {
        public static String findMinMaxSpread(int[] scores) {
            if (scores == null || scores.length < 2) {
                return "Invalid input size";
            }
            int min = scores[0];
            int max = scores[0];
            for (int i = 1; i < scores.length; i++) {
                if (scores[i] < min) {
                    min = scores[i];
                } else if (scores[i] > max) {
                    max = scores[i];
                }
            }
            int spread = max - min;
            return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
        }
        public static void main(String[] args) {
            int[] sampleScores = {45, 82, 79, 90, 33, 98, 61};
            System.out.println(findMinMaxSpread(sampleScores));
        }
    }