package Encapsulation.class_problems;

class AttendanceSheet {
    private String[] presentStudents;
    private int maxSize;
    private int count;

    AttendanceSheet(int maxSize) {
        this.maxSize = maxSize;
        this.presentStudents = new String[maxSize];
        this.count = 0;
    }

    void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }
        if (count < maxSize) {
            presentStudents[count] = name;
            count++;
        } else {
            System.out.println("Attendance sheet full.");
        }
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class Attendance {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Is Ben present " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present " + sheet.isPresent("Chen"));
    }
}
