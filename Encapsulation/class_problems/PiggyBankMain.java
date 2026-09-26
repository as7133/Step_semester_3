package Encapsulation.class_problems;

class PiggyBank {
    private double savings;
    private final String id;

    PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive.");
        } else {
            savings += amount;
            System.out.println("Savings = " + savings);
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw rejected: amount must be positive.");
        } else if (amount > savings) {
            System.out.println("Withdraw rejected: insufficient savings.");
        } else {
            savings -= amount;
            System.out.println("Savings = " + savings);
        }
    }

    double getSavings() {
        return savings;
    }

    String getId() {
        return id;
    }
}
public class PiggyBankMain {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
        System.out.println("Final savings in " + pb.getId() + ": " + pb.getSavings());
    }
}
