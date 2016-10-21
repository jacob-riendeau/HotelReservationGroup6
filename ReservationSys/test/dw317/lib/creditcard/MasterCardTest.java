package dw317.lib.creditcard;

public class MasterCardTest {

	public static void main(String[] args) {
		System.out.println("Null Check: " + checkNumber(null));

		System.out.println("Valid Number 1: " + checkNumber("5513456201321562"));
		System.out.println("Valid Number 2: " + checkNumber("5466059972905055"));

		System.out.println("Invalid Starting Digit 1: " + checkNumber("4413456201321561"));
		System.out.println("Invalid Starting Digit 2: " + checkNumber("1413456223232561"));

		System.out.println("Invalid Number Length 1: " + checkNumber("5513456201321561231"));
		System.out.println("Invalid Number Length 2: " + checkNumber("55"));

	}

	private static String checkNumber(String number) {
		try {
			MasterCard card = new MasterCard(number);
		} catch (IllegalArgumentException e) {
			return e + "\n";
		}

		return number + " this is a valid credit card.\n";
	}

}