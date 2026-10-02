package AbstractionInterfaceClass.class_problems;

import java.util.Scanner;

abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
    abstract String getType();
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        double fare = 2 + (0.10 * distance);
        return Math.min(fare, 10); // cap at $10
    }

    String getType() {
        return "BUS";
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + (0.15 * distance);
    }

    String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    String getType() {
        return "METRO";
    }
}

public class TransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);

            Transport t;
            if (type.equals("BUS")) {
                t = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                t = new Train(distance);
            } else {
                double peakHourFactor = Double.parseDouble(parts[2]);
                t = new Metro(distance, peakHourFactor);
            }

            double fare = t.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", t.getType(), fare);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
