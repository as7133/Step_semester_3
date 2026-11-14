package AbstractionClassVSInterface.assingment_problems;

import java.util.*;

abstract class Ticket {
    static final double FEE = 20;
    int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    abstract String getType();

    double amount() {
        return count * (getPrice() + FEE);
    }
}

class Regular extends Ticket {
    Regular(int count) {
        super(count);
    }

    double getPrice() {
        return 150;
    }

    String getType() {
        return "REGULAR";
    }
}

class Premium extends Ticket {
    Premium(int count) {
        super(count);
    }

    double getPrice() {
        return 250;
    }

    String getType() {
        return "PREMIUM";
    }
}

class Recliner extends Ticket {
    Recliner(int count) {
        super(count);
    }

    double getPrice() {
        return 400;
    }

    String getType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Ticket> list = new ArrayList<>();
        double total = 0;

        for(int i=0;i<n;i++) {
            String type = sc.next();
            int count = sc.nextInt();

            if(type.equals("REGULAR"))
                list.add(new Regular(count));
            else if(type.equals("PREMIUM"))
                list.add(new Premium(count));
            else
                list.add(new Recliner(count));
        }

        for(Ticket t : list) {
            double amt = t.amount();
            total += amt;
            System.out.printf("%s: %.2f%n", t.getType(), amt);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}