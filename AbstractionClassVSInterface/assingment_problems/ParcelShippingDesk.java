package AbstractionClassVSInterface.assingment_problems;

import java.util.*;

interface Insurable {
    double getInsurance();
}

abstract class Parcel {
    double weight, value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double getCharge();
    abstract String getType();
}

class Standard extends Parcel {
    Standard(double w, double v) {
        super(w, v);
    }

    double getCharge() {
        return 40 + 10 * weight;
    }

    String getType() {
        return "STANDARD";
    }
}

class Express extends Parcel implements Insurable {
    Express(double w, double v) {
        super(w, v);
    }

    double getCharge() {
        return 80 + 15 * weight;
    }

    public double getInsurance() {
        return value * 0.02;
    }

    String getType() {
        return "EXPRESS";
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double w, double v) {
        super(w, v);
    }

    double getCharge() {
        return (40 + 10 * weight) + 50;
    }

    public double getInsurance() {
        return value * 0.02;
    }

    String getType() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grand = 0;

        for(int i=0;i<n;i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double v = sc.nextDouble();

            Parcel p;

            if(type.equals("STANDARD"))
                p = new Standard(w,v);
            else if(type.equals("EXPRESS"))
                p = new Express(w,v);
            else
                p = new Fragile(w,v);

            double charge = p.getCharge();
            double insurance = 0;

            if(p instanceof Insurable)
                insurance = ((Insurable)p).getInsurance();

            double total = charge + insurance;
            grand += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    p.getType(), charge, insurance, total);
        }

        System.out.printf("Grand Total: %.2f%n", grand);
    }
}