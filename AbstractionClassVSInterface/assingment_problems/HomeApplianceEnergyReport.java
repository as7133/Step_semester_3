package AbstractionClassVSInterface.assingment_problems;

import java.util.*;

interface SaverMode {
    double getUnitsWithSaver(double hours);
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double power();
    abstract String getType();

    double units() {
        return power() * hours / 1000;
    }

    double cost() {
        return units() * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double h) {
        super(h);
    }

    double power() {
        return 150;
    }

    String getType() {
        return "FRIDGE";
    }
}

class AC extends Appliance implements SaverMode {
    AC(double h) {
        super(h);
    }

    double power() {
        return 1500;
    }

    String getType() {
        return "AC";
    }

    public double getUnitsWithSaver(double hours) {
        return units() * 0.75;
    }
}

class TV extends Appliance {
    TV(double h) {
        super(h);
    }

    double power() {
        return 100;
    }

    String getType() {
        return "TV";
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) {
        super(h);
    }

    double power() {
        return 500;
    }

    String getType() {
        return "WASHER";
    }

    public double getUnitsWithSaver(double hours) {
        return units() * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for(int i=0;i<n;i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;
            if(sc.hasNext("SAVER")) {
                saver = true;
                sc.next();
            }

            Appliance a;

            if(type.equals("FRIDGE"))
                a = new Fridge(hours);
            else if(type.equals("AC"))
                a = new AC(hours);
            else if(type.equals("TV"))
                a = new TV(hours);
            else
                a = new Washer(hours);

            if(saver) {
                if(a instanceof SaverMode) {
                    double units =
                            ((SaverMode)a).getUnitsWithSaver(hours);
                    double cost = units * 8;
                    totalCost += cost;

                    System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                            type, units, cost);
                } else {
                    System.out.println(type +
                            ": saver mode not supported");
                }
            } else {
                double units = a.units();
                double cost = a.cost();

                totalCost += cost;

                System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                        type, units, cost);
            }
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}