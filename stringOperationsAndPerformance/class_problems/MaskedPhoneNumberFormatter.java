package stringOperationsAndPerformance.class_problems;
import java.util.Scanner;
public class MaskedPhoneNumberFormatter {
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        String lastFour = phone.substring(6);
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append(lastFour);
        sb.insert(6, "-");
        return sb.toString();
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a 10-digit phone number: ");
            String userInput = sc.nextLine();
            String result = maskPhoneNumber(userInput);
            System.out.println("Output: " + result);
            sc.close();
        }
    }
