package dw317.lib.creditcard;

public class AmexTest {

	public static void main(String[] args) {
		System.out.println("Null Check: " + checkNumber(null));

		System.out.println("Valid Number 1: " + checkNumber("377308500585007"));
		System.out.println("Valid Number 2: " + checkNumber("372112243287797"));

		System.out.println("Invalid Starting Digit 1: " + checkNumber("302348292918281"));
		System.out.println("Invalid Starting Digit 2: " + checkNumber("191232929191929"));

		System.out.println("Invalid Number Length 1: " + checkNumber("37123123123215"));
		System.out.println("Invalid Number Length 2: " + checkNumber("34"));

	}

	private static String checkNumber(String number) {
		try {
			Amex card = new Amex(number);
		} catch (IllegalArgumentException e) {
			return e + "\n";
		}

		return number + " this is a valid credit card.\n";
	}

}