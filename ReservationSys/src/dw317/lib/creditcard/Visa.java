package dw317.lib.creditcard;

/**
 * @author Jacob Riendeau
 * @version Phase I
 */
public class Visa extends AbstractCreditCard {
	private static final long serialVersionUID = 42031768871L;

	/**
	 * @param number
	 */
	public Visa(String number) {
		super(CardType.VISA, validateNumber(number));

	}

	
	private static String validateNumber(String number) throws IllegalArgumentException {
		//checks to see if number is not null
		if (number == null) {
			throw new IllegalArgumentException("number cannot be null.");
		}
		//checks to see if number has a length of 16.
		if (number.length() != 16) {
			throw new IllegalArgumentException(number + ": does not respect the 16 digit range.");
		}
		//checks to see if the first digit of number is equal to 4
		if (number.charAt(0) != '4') {
			throw new IllegalArgumentException(number + ": first digit \"" + number.charAt(0) + "\"  must equal to 4.");
		}
		//if all else fails return number
		return number;
	}
}
