package OOPIntoduction.assignment_problems;
import java.util.Arrays;
public class AutoDraftRanking implements Comparable<AutoDraftRanking> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public AutoDraftRanking(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }
    public static boolean isDraftable(int matchesPlayed)
    {
        return matchesPlayed >= 10;
    }
    public static boolean isDraftable(int matchesPlayed, boolean injured)
    {
        return matchesPlayed >= 5 && !injured;
    }
    @Override
    public int compareTo(AutoDraftRanking other)
    {
        return Double.compare(other.battingAverage, this.battingAverage);
    }
    public static String draftAndRank(AutoDraftRanking[] players) {
        int count = 0;
        for (AutoDraftRanking p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                count++;
            }
        }
        AutoDraftRanking[] draftableArray = new AutoDraftRanking[count];
        int index = 0;
        for (AutoDraftRanking p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftableArray[index++] = p;
            }
        }
        Arrays.sort(draftableArray);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            sb.append((i + 1)).append(". ").append(draftableArray[i].name);
            if (i < draftableArray.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args)
    {
        AutoDraftRanking[] players = {
                new AutoDraftRanking("Virat", 15, 48.0, false),
                new AutoDraftRanking("Rahul", 7, 55.0, false),
                new AutoDraftRanking("Sameer", 3, 60.0, false),
                new AutoDraftRanking("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}