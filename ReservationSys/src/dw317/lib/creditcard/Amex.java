package dw317.lib.creditcard;

/**
 * 
 * @author Jacob Riendeau
 * @version Phase I
 *
 */
public class Amex extends AbstractCreditCard {
	private static final long serialVersionUID = 42031768871L;

	/**
	 * @param number credit card number.
	 */
	public Amex(String number) {
		super(CardType.AMEX, validateNumber(number));

	}

	/**
	 * 
	 * @param number
	 * @return
	 * @throws IllegalArgumentException
	 */
	private static String validateNumber(String number) throws IllegalArgumentException{
		//checks to see if number is not null
		if (number == null) {
			throw new IllegalArgumentException("number cannot be null.");
		}
		//checks to see number is within the 15 digit range
		if (number.length() != 15) {
			throw new IllegalArgumentException(number + ": does not respect the 15 digit range.");
		}
		//check to see if the first 2 digits are equal to 34 or 37.
		if (!number.substring(0, 2).equals("34") && !number.substring(0, 2).equals("37")) {
			throw new IllegalArgumentException(
					number + ": starting digits " + "\"" + number.substring(0, 2) + "\" must be equal to 34 or 37.");
		}
		//if all else fails return number.
		return number;
	}
}
