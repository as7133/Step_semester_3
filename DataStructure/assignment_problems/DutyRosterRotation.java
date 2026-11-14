package DataStructure.assignment_problems;

import java.util.Arrays;

public class DutyRosterRotation {

    static String[] rotateRoster(String[] names, int k) {

        int n = names.length;
        k = k % n;

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {

        String[] names = {"A", "B", "C", "D", "E"};
        int k = 2;

        String[] rotated = rotateRoster(names, k);

        System.out.println(Arrays.toString(rotated));
    }
}