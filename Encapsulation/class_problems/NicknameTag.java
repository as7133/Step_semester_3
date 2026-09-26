package Encapsulation.class_problems;

class NameTag {
    private final String firstName;
    private final String lastInitial;

    NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastInitial = parts[1].substring(0, 1);
    }

    String getNickname() {
        return firstName + " " + lastInitial + ".";
    }
}

public class NicknameTag {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}
