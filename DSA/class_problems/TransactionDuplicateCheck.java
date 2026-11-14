package DSA.class_problems;

import java.util.HashSet;

public class TransactionDuplicateCheck {

    static boolean hasDuplicate(String[] transactionIds) {

        HashSet<String> set = new HashSet<>();

        for (String id : transactionIds) {

            if (set.contains(id))
                return true;

            set.add(id);
        }

        return false;
    }

    public static void main(String[] args) {

        String[] txn1 = {
                "TXN1001",
                "TXN1002",
                "TXN1003",
                "TXN1002",
                "TXN1004"
        };

        String[] txn2 = {
                "TXN2001",
                "TXN2002",
                "TXN2003"
        };

        System.out.println(hasDuplicate(txn1));
        System.out.println(hasDuplicate(txn2));
    }
}