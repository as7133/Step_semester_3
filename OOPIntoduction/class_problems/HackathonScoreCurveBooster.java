package OOPIntoduction.class_problems;
import java.util.Arrays;
public class HackathonScoreCurveBooster {
        public static void main(String[] args) {
            int[] scores = {70,85,60}; //length = 3
            int bonus = 10;
            boostScores(scores, bonus);
            System.out.println(Arrays.toString(scores));
        }
         static void boostScores(int[] scores, int bonus) {
            for (int i = 0; i < scores.length; i++) {
                scores[i] = scores[i] + bonus;
            }
        }
    }

