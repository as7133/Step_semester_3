package AbstractionInterfaceClass.assignment_problems;

import java.util.*;

abstract class Customer {
    protected double amount;
    public Customer(double amount) { this.amount = amount; }
    public abstract double finalAmount();
}

class Student extends Customer {
    public Student(double amount) { super(amount); }
    public double finalAmount() { return amount * 0.9; }
}

class Staff extends Customer {
    public Staff(double amount) { super(amount); }
    public double finalAmount() { return amount * 0.95; }
}

class Guest extends Customer {
    public Guest(double amount) { super(amount); }
    public double finalAmount() { return amount + 10; }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;
        for(int i=0;i<n;i++){
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            double amt = Double.parseDouble(parts[1]);
            Customer c = switch(type) {
                case "STUDENT" -> new Student(amt);
                case "STAFF" -> new Staff(amt);
                default -> new Guest(amt);
            };
            double fa = c.finalAmount();
            System.out.printf("%s: %.2f%n", type, fa);
            total += fa;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

