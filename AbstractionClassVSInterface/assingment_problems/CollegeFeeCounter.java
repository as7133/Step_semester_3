package AbstractionClassVSInterface.assingment_problems;

import java.util.*;

interface BusUser {
    double TRANSPORT_FEE = 12000;
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double getFee();
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double getFee() {
        return 40000 + TRANSPORT_FEE;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double getFee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double getFee() {
        return 20000 + TRANSPORT_FEE;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for(int i=0;i<n;i++) {
            String type = sc.next();
            String name = sc.next();

            Student s;

            if(type.equals("DAY_SCHOLAR"))
                s = new DayScholar(name);
            else if(type.equals("HOSTELLER"))
                s = new Hosteller(name);
            else
                s = new Scholar(name);

            double fee = s.getFee();
            total += fee;

            System.out.printf("%s: %.2f%n", name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}