package AbstractionInterfaceClass.assignment_problems;

import java.util.*;
import java.time.*;

abstract class Plan {
    protected String name;
    protected LocalDate start;
    public Plan(String name, LocalDate start) { this.name = name; this.start = start; }
    public abstract LocalDate renewalDate();
}

class Basic extends Plan {
    public Basic(String name, LocalDate start) { super(name, start); }
    public LocalDate renewalDate() { return start.plusDays(30); }
}

class Standard extends Plan {
    public Standard(String name, LocalDate start) { super(name, start); }
    public LocalDate renewalDate() { return start.plusDays(90); }
}

class Premium extends Plan {
    public Premium(String name, LocalDate start) { super(name, start); }
    public LocalDate renewalDate() { return start.plusDays(365); }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            String name = parts[1];
            LocalDate start = LocalDate.parse(parts[2]);
            Plan p = switch(type) {
                case "BASIC" -> new Basic(name, start);
                case "STANDARD" -> new Standard(name, start);
                default -> new Premium(name, start);
            };
            System.out.printf("%s: %s%n", name, p.renewalDate());
        }
    }
}
