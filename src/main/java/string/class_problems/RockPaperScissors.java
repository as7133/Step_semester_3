package string.class_problems;

import java.util.Random;
import java.util.Scanner;

    public class RockPaperScissors {

        static String playRound(String playerMove, String computerMove) {

            if (playerMove.equals(computerMove)) {
                return "Draw";
            }

            if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                    (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                    (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
                return "Player Wins";
            }

            return "Computer Wins";
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            Random random = new Random();

            String[] moves = {"Rock", "Paper", "Scissors"};

            int playerWins = 0;
            int computerWins = 0;
            int draws = 0;

            int rounds = 5;

            String[] playerMoves = new String[rounds];
            String[] computerMoves = new String[rounds];
            String[] results = new String[rounds];

            for (int i = 0; i < rounds; i++) {

                System.out.print("Round " + (i + 1) +
                        " - Enter Rock, Paper or Scissors: ");

                String playerMove = sc.nextLine();

                playerMoves[i] = playerMove;

                computerMoves[i] = moves[random.nextInt(3)];

                results[i] = playRound(playerMove, computerMoves[i]);

                System.out.println("Computer Move: " + computerMoves[i]);
                System.out.println("Result: " + results[i]);
                System.out.println();

                if (results[i].equals("Player Wins")) {
                    playerWins++;
                } else if (results[i].equals("Computer Wins")) {
                    computerWins++;
                } else {
                    draws++;
                }
            }

            System.out.println("----- FINAL SUMMARY -----");
            System.out.println("Round\tPlayer Move\tComputer Move\tResult");

            for (int i = 0; i < rounds; i++) {
                System.out.println((i + 1) + "\t" +
                        playerMoves[i] + "\t\t" +
                        computerMoves[i] + "\t\t" +
                        results[i]);
            }

            double winPercentage = (playerWins * 100.0) / rounds;

            System.out.println("\nPlayer Wins   : " + playerWins);
            System.out.println("Computer Wins : " + computerWins);
            System.out.println("Draws         : " + draws);
            System.out.printf("Player Win Percentage: %.2f%%\n", winPercentage);

            sc.close();
        }
    }

