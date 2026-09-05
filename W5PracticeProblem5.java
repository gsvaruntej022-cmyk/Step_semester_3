import java.util.Arrays;

public class W5PracticeProblem5 implements Comparable<W5PracticeProblem5> {

    private String name;
    private double cgpa;
    private int codingScore;

    public W5PracticeProblem5(String name, double cgpa, int codingScore) {

        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // Rule 1: CGPA-only eligibility
    static boolean isEligible(double cgpa) {

        return cgpa >= 7.5;
    }

    // Rule 2: CGPA + coding score eligibility
    static boolean isEligible(double cgpa, int codingScore) {

        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Composite score
    double getCompositeScore() {

        return (cgpa * 10) + (codingScore * 0.5);
    }

    // Sort by composite score in descending order
    @Override
    public int compareTo(W5PracticeProblem5 other) {

        return Double.compare(
            other.getCompositeScore(),
            this.getCompositeScore()
        );
    }

    public String getName() {
        return name;
    }

    static String shortlistAndRank(W5PracticeProblem5[] candidates) {

        int count = 0;

        // Count eligible candidates
        for (W5PracticeProblem5 candidate : candidates) {

            if (isEligible(candidate.cgpa) ||
                isEligible(candidate.cgpa, candidate.codingScore)) {

                count++;
            }
        }

        // Create shortlisted array
        W5PracticeProblem5[] shortlisted =
                new W5PracticeProblem5[count];

        int index = 0;

        // Add eligible candidates
        for (W5PracticeProblem5 candidate : candidates) {

            if (isEligible(candidate.cgpa) ||
                isEligible(candidate.cgpa, candidate.codingScore)) {

                shortlisted[index] = candidate;
                index++;
            }
        }

        // Sort using compareTo()
        Arrays.sort(shortlisted);

        // Create final output
        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            result += (i + 1) + ". "
                    + shortlisted[i].getName()
                    + " ("
                    + shortlisted[i].getCompositeScore()
                    + ")";

            if (i < shortlisted.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        W5PracticeProblem5[] candidates = {

            new W5PracticeProblem5("Aisha", 8.2, 40),

            new W5PracticeProblem5("Rohit", 6.8, 65),

            new W5PracticeProblem5("Meena", 6.0, 90),

            new W5PracticeProblem5("Karan", 7.5, 20)
        };

        System.out.println(
            shortlistAndRank(candidates)
        );
    }
}