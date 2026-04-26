public class RationalNumber {

    private String number;

    public RationalNumber(String number) {

        if (containsLetterRegex(number)) {
            throw new ArithmeticException("Rational number contains a letter");
        }

        if (number.length() == 1) {

            number += "/1";
        }

        long occurrences = number.chars().filter(c -> c == '/').count();

        if (occurrences > 1) {
            throw new ArithmeticException("Rational number contains more than one slash");
        }

        this.number = number;
    }

    @Override
    public String toString() {
        return number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static boolean containsLetterRegex(String s) {
        return s.matches(".*[^\\d/].*");
    }
}