package stringOperationsAndPerformance.class_problems;
import java.util.Scanner;
public class BankTransactionReferenceGeneratorAndValidator {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("=== Bank Transaction Reference Validator ===");
            System.out.println("Enter a transaction reference code (or type 'exit' to quit):");
            while (true) {
                System.out.print("\nInput: ");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting program.");
                    break;
                }
                String normalized = normalizeReference(input);
                String result = validateAndFormat(normalized);
                System.out.println("Output: " + result);
            }
            sc.close();
        }

        public static String normalizeReference(String raw) {
            if (raw == null) return "";
            String trimmed = raw.trim();
            if (trimmed.length() < 3) {
                return trimmed.toUpperCase();
            }
            return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
        }

        public static String validateAndFormat(String reference) {
            if (reference.length() != 14) {
                return "Invalid: wrong length";
            }
            for (int i = 0; i < 3; i++) {
                if (!Character.isLetter(reference.charAt(i))) {
                    return "Invalid: bank code must be 3 letters";
                }
            }
            for (int i = 3; i < 14; i++) {
                if (!Character.isDigit(reference.charAt(i))) {
                    return "Invalid: non-digit body";
                }
            }

            String bankCode = reference.substring(0, 3);
            String day = reference.substring(3, 5);
            String month = reference.substring(5, 7);
            String year = reference.substring(7, 9);
            String sequence = reference.substring(9, 14);

            StringBuilder formatted = new StringBuilder();
            formatted.append("[").append(bankCode).append("] ")
                    .append("DATE: ").append(day).append("/").append(month).append("/").append(year)
                    .append(" | SEQ: ").append(sequence);

            return formatted.toString();
        }
    }

