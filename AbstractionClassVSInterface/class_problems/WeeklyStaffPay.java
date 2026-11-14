package AbstractionClassVSInterface.class_problems;

import java.util.*;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTime extends Staff {
    double salary;

    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double calculatePay() {
        return salary;
    }
}

class Hourly extends Staff {
    double hours, rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours <= 40)
            return hours * rate;
        else
            return (40 * rate) + ((hours - 40) * rate * 1.5);
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Staff> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();

            if (type.equals("FULLTIME")) {
                String name = sc.next();
                double salary = sc.nextDouble();
                list.add(new FullTime(name, salary));
            } else if (type.equals("HOURLY")) {
                String name = sc.next();
                double hours = sc.nextDouble();
                double rate = sc.nextDouble();
                list.add(new Hourly(name, hours, rate));
            } else if (type.equals("INTERN")) {
                String name = sc.next();
                double stipend = sc.nextDouble();
                list.add(new Intern(name, stipend));
            }
        }

        double total = 0;

        for (Staff s : list) {
            double pay = s.calculatePay();
            total += pay;
            System.out.printf("%s: %.2f%n", s.name, pay);
        }

        System.out.printf("Total Payroll: %.2f%n", total);
    }
}