
package dw317.lib.creditcard;

/**
 * @author Jacob Riendeau
 * @version Phase I
 */
public abstract class AbstractCreditCard implements CreditCard {
	private static final long serialVersionUID = 42031768871L;
	private final CardType cardType;
	private final String number;

	/**
	 * Initiates credit card while verifying the validity of the credit card
	 * @param cardType credit card type.
	 * @param number credit card number.
	 */
	public AbstractCreditCard(CardType cardType, String number) throws IllegalArgumentException{
		this.number = validateLuhnAlgorithm(number);
		this.cardType = cardType;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (this.getClass() != object.getClass()) {
			return false;
		}
		if (this.cardType != ((AbstractCreditCard) object).getType()) {
			return false;
		}

		if (!this.number.equals(((AbstractCreditCard) object).getNumber())) {
			return false;
		}

		return true;
	}
	
	public String getNumber() {
		return this.number;
	}

	public CardType getType() {
		return this.cardType;
	}

	public String toString() {
		return cardType.toString() + "*" + number;
	}

	// change it using long integer manipulation
	/**
	 * Validates the credit card number using the Luhn Algorithm.
	 * @author Jacob Riendeau
	 * @param number credit card number
	 * @return number: valid credit card number
	 * @throws IllegalArgumentException String number contains invalid characters.
	 * @throws IllegalArgumentException Credit card number is invalid.
	 */
	private String validateLuhnAlgorithm(String number) throws IllegalArgumentException{
		// Declares numberLong, used to manipulate digits
		Long numberLong;

		// Convert number String to a Long while verifying if it is a String of numbers.
		try {
			numberLong = Long.parseLong(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(number + ": is not a string of digits.");
		}

		// variable to add the digits
		int sum = 0;
		// Validate starting from the least-significant digit.
		for (int i = 1; i < number.length();i++) {

			// ii is the digit of numberLong at position i.
			int ii = (int) (numberLong / (long) Math.pow(10, i) % 10);

			// For each odd digit:
			if (i % 2 != 0) {
				// Multiply the digit by 2
				ii *= 2;
				// If the multiplication is greater than 9 subtract 9, if not
				// add the previously multiplied number
				sum += ii > 9 ? ii - 9 : ii;
			} else {
				sum += ii;
			}
		}
		// Check if the sum of the previously added number and least-significant
		// digit is a multiple of 10, if it fails the test throws an exception
		// if not returns the number String
		if ((numberLong % 10 + sum) % 10 != 0) {
			{
				throw new IllegalArgumentException(
						number + ": invalid credit card number, does not respect Luhn Algorithm.");
			}
		}
		return number;
	}
}
