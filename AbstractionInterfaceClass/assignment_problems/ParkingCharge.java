package AbstractionInterfaceClass.assignment_problems;

import java.util.*;

abstract class Vehicle {
    protected int hours;
    public Vehicle(int hours) { this.hours = hours; }
    public abstract double charge();
}

class Bike extends Vehicle {
    public Bike(int hours) { super(hours); }
    public double charge() { return hours * 10; }
}

class Car extends Vehicle {
    public Car(int hours) { super(hours); }
    public double charge() { return 30 + (hours-1)*20; }
}

class Truck extends Vehicle {
    public Truck(int hours) { super(hours); }
    public double charge() { return Math.max(100, hours*50); }
}

public class ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;
        for(int i=0;i<n;i++){
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            int hrs = Integer.parseInt(parts[1]);
            Vehicle v = switch(type) {
                case "BIKE" -> new Bike(hrs);
                case "CAR" -> new Car(hrs);
                default -> new Truck(hrs);
            };
            double ch = v.charge();
            System.out.printf("%s: %.2f%n", type, ch);
            total += ch;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

