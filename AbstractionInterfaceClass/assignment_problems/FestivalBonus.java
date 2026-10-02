package AbstractionInterfaceClass.assignment_problems;

import java.util.*;

abstract class Employee {
    protected String name;
    protected double salary;
    public Employee(String name, double salary) { this.name = name; this.salary = salary; }
    public abstract double bonus();
}

class FullTime extends Employee {
    public FullTime(String name, double salary) { super(name, salary); }
    public double bonus() { return salary * 0.10; }
}

class PartTime extends Employee {
    public PartTime(String name, double salary) { super(name, salary); }
    public double bonus() { return salary * 0.05; }
}

class Intern extends Employee {
    public Intern(String name, double salary) { super(name, salary); }
    public double bonus() { return 2000; }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;
        for(int i=0;i<n;i++){
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            String name = parts[1];
            double sal = Double.parseDouble(parts[2]);
            Employee e = switch(type) {
                case "FULLTIME" -> new FullTime(name, sal);
                case "PARTTIME" -> new PartTime(name, sal);
                default -> new Intern(name, sal);
            };
            double b = e.bonus();
            System.out.printf("%s: %.2f%n", name, b);
            total += b;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
