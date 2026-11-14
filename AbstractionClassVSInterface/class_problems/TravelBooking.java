package AbstractionClassVSInterface.class_problems;

import java.util.*;

abstract class Booking {
    static final double BOOKING_FEE = 50;
    double distance;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double baseFare();

    abstract String getMode();

    double totalFare() {
        return baseFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {
    Bus(double distance) {
        super(distance);
    }

    double baseFare() {
        return distance * 2;
    }

    String getMode() {
        return "BUS";
    }
}

class Train extends Booking {
    Train(double distance) {
        super(distance);
    }

    double baseFare() {
        return distance * 1.5;
    }

    String getMode() {
        return "TRAIN";
    }
}

class Flight extends Booking {
    Flight(double distance) {
        super(distance);
    }

    double baseFare() {
        return 2500 + (distance * 4);
    }

    String getMode() {
        return "FLIGHT";
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Booking> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            if (mode.equals("BUS"))
                list.add(new Bus(distance));
            else if (mode.equals("TRAIN"))
                list.add(new Train(distance));
            else if (mode.equals("FLIGHT"))
                list.add(new Flight(distance));
        }

        for (Booking b : list) {
            System.out.printf("%s: %.2f%n",
                    b.getMode(), b.totalFare());
        }
    }
}