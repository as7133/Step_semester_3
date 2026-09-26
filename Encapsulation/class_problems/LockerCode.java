package Encapsulation.class_problems;

class Locker {
    private String code;
    private final int lockerNumber;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    void changeCode(String currentCode, String newCode) {
        if (this.code.equals(currentCode)) {
            this.code = newCode;
            System.out.println("Code change successful.");
        } else {
            System.out.println("Code change rejected: incorrect current code.");
        }
    }

    int getLockerNumber() {
        return lockerNumber;
    }
}

public class LockerCode {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
        System.out.println("Locker number: " + l.getLockerNumber());
    }
}
