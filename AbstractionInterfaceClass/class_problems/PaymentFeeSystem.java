package AbstractionInterfaceClass.class_problems;

import java.util.Scanner;

abstract class Payment {
    double amount;
    Payment(double amount) {
        this.amount = amount;
    }
    abstract double getFinalAmount();
    abstract String getType();
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }
    double getFinalAmount() {
        return amount + (amount * 0.02);
    }
    String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }
    double getFinalAmount() {
        return amount + (amount * 0.01);
    }
    String getType() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) {
        super(amount);
    }
    double getFinalAmount() {
        return amount;
    }
    String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentFeeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment p;

            if (type.equals("CARD")) {
                p = new CardPayment(amount);
            } else if (type.equals("WALLET")) {
                p = new WalletPayment(amount);
            } else {
                p = new BankTransferPayment(amount);
            }

            double finalAmount = p.getFinalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", p.getType(), finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
