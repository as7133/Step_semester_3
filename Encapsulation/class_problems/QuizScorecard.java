package Encapsulation.class_problems;

class Scorecard {
    private boolean[] results;
    private int totalQuestions;
    private int answersRecorded;

    Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.answersRecorded = 0;
    }

    void recordAnswer(boolean isCorrect) {
        if (answersRecorded >= totalQuestions) {
            System.out.println("Answer rejected: all questions already recorded.");
            return;
        }
        results[answersRecorded] = isCorrect;
        answersRecorded++;
    }

    int getScore() {
        int score = 0;
        for (int i = 0; i < answersRecorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}

public class QuizScorecard {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Final score: " + sc.getScore());
    }
}
