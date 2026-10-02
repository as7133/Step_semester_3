package AbstractionInterfaceClass.class_problems;

import java.util.*;

abstract class Question {
    String text;
    String correctAnswer;
    String studentAnswer;
    int points;

    Question(String text, String correctAnswer, String studentAnswer, int points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double grade();
    abstract String getType();
}

class MCQ extends Question {
    MCQ(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    double grade() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TF extends Question {
    TF(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    double grade() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }

    String getType() {
        return "TF";
    }
}

class Essay extends Question {
    Essay(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    double grade() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase().contains(keyword.trim().toLowerCase())) {
                matchCount++;
            }
        }
        if (matchCount >= 2) return points * 0.75;
        else if (matchCount == 1) return points * 0.50;
        else return 0;
    }

    String getType() {
        return "ESSAY";
    }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;
        Question[] questions = new Question[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 5);
            String type = parts[0];
            String text = parts[1].replace("\"", "");
            String correct = parts[2].replace("\"", "");
            String student = parts[3].replace("\"", "");
            int points = Integer.parseInt(parts[4]);

            if (type.equals("MCQ")) {
                questions[i] = new MCQ(text, correct, student, points);
            } else if (type.equals("TF")) {
                questions[i] = new TF(text, correct, student, points);
            } else {
                questions[i] = new Essay(text, correct, student, points);
            }
        }

        for (Question q : questions) {
            double score = q.grade();
            total += score;
            System.out.printf("%s: %.2f%n", q.getType(), score);
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
