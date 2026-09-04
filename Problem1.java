public class Problem1 {

    static void checkDuplicateSeats(int[] seatNumbers) {

        boolean foundDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {

            // Check if this number appeared before
            boolean alreadyChecked = false;

            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyChecked = true;
                    break;
                }
            }

            if (alreadyChecked) {
                continue;
            }

            // Compare with remaining numbers
            for (int j = i + 1; j < seatNumbers.length; j++) {

                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println(
                        "Duplicate Seat Number Found: " + seatNumbers[i]
                    );
                    foundDuplicate = true;
                    break;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {

        int[] seats = {101, 102, 103, 102, 105};

        checkDuplicateSeats(seats);
    }
}