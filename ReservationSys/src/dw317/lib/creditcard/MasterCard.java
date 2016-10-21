package dw317.lib.creditcard;

/**
 * @author Jacob Riendeau
 * @version Phase I
 */
public class MasterCard extends AbstractCreditCard {
	private static final long serialVersionUID = 42031768871L;

	/**
	 * @author Jacob Riendeau
	 * @param number
	 *            credit card number
	 */
	public MasterCard(String number) {
		super(CardType.MASTERCARD, validateNumber(number));

	}

	/**
	 * @author Jacob Riendeau
	 * @param number
	 *            credit card number.
	 * @return number valid master card
	 * @throws IllegalArgumentException
	 */
	private static String validateNumber(String number)throws IllegalArgumentException {
		// checks to see if number is not null
		if (number == null) {
			throw new IllegalArgumentException("number cannot be null.");
		}
		// checks to see number string has a length of 16
		if (number.length() != 16) {
			throw new IllegalArgumentException(number + ": does not respect the 16 digit range.");
		}
		// Initiate variable x
		int x = 0;
		// Assigns first 2 digits of number to X while making sure they are
		// digits, throws an exception if they are not digits
		try {

			x = Integer.parseInt(number.substring(0, 2));

		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(number + ": starting digits " + x + " must be within the 51-55 range.");
		}
		// checks to see if the first two digits of number(x) is within the
		// 51-55
		// range, throws an exception if it dosen't
		if (x < 51 || x > 55) {
			throw new IllegalArgumentException(
					number + ": starting digits " + "\"" + number.substring(0, 2) + "\" must be within the 51-55 range.");
		}
		// returns number if all else failed
		return number;
	}
}