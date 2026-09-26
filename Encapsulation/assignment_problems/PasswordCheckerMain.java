package Encapsulation.assignment_problems;

class PasswordChecker {
    private final String password;

    PasswordChecker(String password) {
        this.password = password;
    }

    String getStrength() {
        int length = password.length();
        boolean hasDigit = password.matches(".*\\d.*");

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return hasDigit ? "Medium+" : "Medium";
        } else {
            return hasDigit ? "Strong+" : "Strong";
        }
    }
}

public class PasswordCheckerMain {
    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println(pc1.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println(pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abc12345");
        System.out.println(pc3.getStrength());

        PasswordChecker pc4 = new PasswordChecker("securePass12345");
        System.out.println(pc4.getStrength());
    }
}
