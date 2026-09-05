public class W2PracticeProblem5 {

    static String normalizeReference(String raw) {

        raw = raw.trim();

        String bankCode = raw.substring(0, 3);
        String remaining = raw.substring(3);

        return bankCode.toUpperCase() + remaining;
    }

    static String validateAndFormat(String reference) {

        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(reference.substring(0, 3));
        result.append("] DATE: ");
        result.append(reference.substring(3, 9));
        result.append(" | SEQ: ");
        result.append(reference.substring(9, 14));

        return result.toString();
    }

    public static void main(String[] args) {

        String raw = " hdf03022600042 ";

        String reference = normalizeReference(raw);

        System.out.println(validateAndFormat(reference));
    }
}