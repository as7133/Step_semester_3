package AbstractionClassVSInterface.assingment_problems;

import java.util.*;

interface NightService {
    double nightFare(double fare);
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double rate();
    abstract String getType();

    double fare() {
        return Math.max(100, km * rate());
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double rate() {
        return 10;
    }

    String getType() {
        return "MINI";
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double rate() {
        return 14;
    }

    String getType() {
        return "SEDAN";
    }

    public double nightFare(double fare) {
        return fare * 1.2;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double rate() {
        return 18;
    }

    String getType() {
        return "SUV";
    }

    public double nightFare(double fare) {
        return fare * 1.2;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for(int i=0;i<n;i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if(type.equals("MINI"))
                cab = new Mini(km);
            else if(type.equals("SEDAN"))
                cab = new Sedan(km);
            else
                cab = new SUV(km);

            if(time.equals("NIGHT")) {
                if(cab instanceof NightService) {
                    double fare =
                            ((NightService)cab).nightFare(cab.fare());

                    total += fare;

                    System.out.printf("%s: %.2f%n",
                            type, fare);
                } else {
                    System.out.println(type +
                            ": night service not available");
                }
            } else {
                double fare = cab.fare();
                total += fare;

                System.out.printf("%s: %.2f%n",
                        type, fare);
            }
        }

        System.out.printf("Total: %.2f%n", total);
    }
}