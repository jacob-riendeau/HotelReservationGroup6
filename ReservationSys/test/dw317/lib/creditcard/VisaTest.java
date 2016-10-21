package dw317.lib.creditcard;

public class VisaTest {

	public static void main(String[] args) {
		System.out.println("Null Check: " + checkNumber(null));

		System.out.println("Valid Number 1: " + checkNumber("4716751155691269"));
		System.out.println("Valid Number 2: " + checkNumber("4024007160303235"));

		System.out.println("Invalid Starting Digit 1: " + checkNumber("8237183929129341"));
		System.out.println("Invalid Starting Digit 2: " + checkNumber("1934567829123492"));

		System.out.println("Invalid Number Length 1: " + checkNumber("423456789123456789"));
		System.out.println("Invalid Number Length 2: " + checkNumber("4"));

	}

	private static String checkNumber(String number) {
		try {
			Visa card = new Visa(number);
		} catch (IllegalArgumentException e) {
			return e + "\n";
		}

		return number + " this is a valid credit card.\n";
	}

}