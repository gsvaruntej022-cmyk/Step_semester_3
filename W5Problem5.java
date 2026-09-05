import java.util.Arrays;

public class W5Problem5 implements Comparable<W5Problem5> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public W5Problem5(String name, int matchesPlayed,
                       double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Rule 1: Experience-only rule
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Rule 2: Matches + fitness rule
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    // Sort by batting average in descending order
    @Override
    public int compareTo(W5Problem5 other) {

        return Double.compare(
            other.battingAverage,
            this.battingAverage
        );
    }

    public String getName() {
        return name;
    }

    static String draftAndRank(W5Problem5[] players) {

        int count = 0;

        // Count draftable players
        for (W5Problem5 player : players) {

            if (isDraftable(player.matchesPlayed) ||
                isDraftable(player.matchesPlayed, player.injured)) {

                count++;
            }
        }

        // Create array for draftable players
        W5Problem5[] draftable = new W5Problem5[count];

        int index = 0;

        for (W5Problem5 player : players) {

            if (isDraftable(player.matchesPlayed) ||
                isDraftable(player.matchesPlayed, player.injured)) {

                draftable[index] = player;
                index++;
            }
        }

        // Sort using compareTo()
        Arrays.sort(draftable);

        // Create output
        String result = "";

        for (int i = 0; i < draftable.length; i++) {

            result += (i + 1) + ". " + draftable[i].getName();

            if (i < draftable.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        W5Problem5[] players = {

            new W5Problem5("Virat", 15, 48.0, false),

            new W5Problem5("Rahul", 7, 55.0, false),

            new W5Problem5("Sameer", 3, 60.0, false),

            new W5Problem5("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}