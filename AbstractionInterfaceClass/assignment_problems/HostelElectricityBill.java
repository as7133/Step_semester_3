package AbstractionInterfaceClass.assignment_problems;

import java.util.*;

abstract class Room {
    protected int units;
    public Room(int units) { this.units = units; }
    public abstract double bill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) { super(units); }
    public double bill() { return units * 8; }
}

class SharedRoom extends Room {
    private int occupants;
    public SharedRoom(int units, int occupants) { super(units); this.occupants = occupants; }
    public double bill() { return (units * 6.0) / occupants; }
}

class AcRoom extends Room {
    public AcRoom(int units) { super(units); }
    public double bill() { return units * 10 + 200; }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;
        for(int i=0;i<n;i++){
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            Room r;
            if(type.equals("SHARED")){
                int units = Integer.parseInt(parts[1]);
                int occ = Integer.parseInt(parts[2]);
                r = new SharedRoom(units, occ);
            } else if(type.equals("SINGLE")){
                r = new SingleRoom(Integer.parseInt(parts[1]));
            } else {
                r = new AcRoom(Integer.parseInt(parts[1]));
            }
            double b = r.bill();
            System.out.printf("%s: %.2f%n", type, b);
            total += b;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
