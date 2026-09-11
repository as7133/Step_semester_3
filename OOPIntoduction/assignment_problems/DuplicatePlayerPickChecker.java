package OOPIntoduction.assignment_problems;
import java.util.Arrays;
public class DuplicatePlayerPickChecker {
        public static String findDuplicatePick(String[] playerNames) {
            for (int i = 0; i < playerNames.length; i++) {
                for (int j = i + 1; j < playerNames.length; j++) {
                    if (playerNames[i].equals(playerNames[j])) {
                        return "Duplicate Found: " + playerNames[i];
                    }
                }
            }
            return "No Duplicates Found";
        }
        public static void main(String[] args) {
            String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
            System.out.println("Testing Lineup 1: " + Arrays.toString(lineup1));
            System.out.println("Result: " + findDuplicatePick(lineup1));
        }
    }

