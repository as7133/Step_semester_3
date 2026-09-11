package OOPIntoduction.assignment_problems;
import java.util.Arrays;
public class FantasyTeamScoreMultiplier {
        public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
            playerScores[captainIndex] *= 2.0;
            playerScores[viceCaptainIndex] *= 1.5;
        }
        public static void main(String[] args) {
            double[] scores = {40.0, 55.0, 30.0, 62.0};
            int captainIndex = 1;
            int viceCaptainIndex = 3;
            applyMultipliers(scores, captainIndex, viceCaptainIndex);
            System.out.println(Arrays.toString(scores));
        }
    }