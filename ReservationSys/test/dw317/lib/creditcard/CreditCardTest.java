package dw317.lib.creditcard;

public class CreditCardTest {
	public static void main(String[] args) {

		System.out.println("Invalid Luhn Algoritim 1: " + checkNumber("5513456201321561"));
		System.out.println("Invalid Luhn Algoritim 2: " + checkNumber("5212314640134656"));

		System.out.println("Invalid Character 1: " + checkNumber("51cdefghijklmnop"));
		System.out.println("Invalid Character 1: " + checkNumber("52--------------"));

		String num1 = "5513456201321562";
		String num2 = "5466059972905055";
		String num3 = "5343376124497057";
		System.out.println("Same Number & Different Object 1: " + compareNumbers(num1, num1));
		System.out.println("\nSame Number & Different Object 2: " + compareNumbers(num2, num2));
		System.out.println("\nSame Number & Different Object 3:" + compareNumbers(num3, num3));

		System.out.println("\nDifferent Number & Different Object 1: " + compareNumbers(num1, num2));
		System.out.println("\nDifferent Number & Different Object 2: " + compareNumbers(num2, num3));
		System.out.println("\nDifferent Number & Different Object 3: " + compareNumbers(num1, num3));

		MasterCard card1 = new MasterCard(num1);
		MasterCard card2 = new MasterCard(num2);
		System.out.println("\nSame Object 1: " + comparetObject(card1, card1));
		System.out.println("\nSame Object 2: " + comparetObject(card2, card2));

		System.out.println("\nDifferent Class 1:" + comparetObject(card1, new Visa("4005736743548261")));
		System.out.println("\nDifferent Class 2:" + comparetObject(card2, new Amex("377934476786954")));

		System.out.println("\ntoString 1: " + card1.toString());
		System.out.println("\ntoString 2:" + card2.toString());

		System.out.println("\ngetType 1: " + card1.getType());
		System.out.println("\ngetType 2: " + card2.getType());
		
		System.out.println("\ngetNumber 1: " + card1.getNumber());
		System.out.println("\ngetNumber 2: " + card2.getNumber());
	}

	private static String checkNumber(String number) {
		try {
			MasterCard card = new MasterCard(number);
		} catch (IllegalArgumentException e) {
			return e + "\n";
		}

		return number + " this is a valid credit card.\n";
	}

	private static boolean compareNumbers(String num1, String num2) {
		MasterCard card1 = new MasterCard(num1);
		MasterCard card2 = new MasterCard(num2);
		return card1.equals(card2);
	}

	private static boolean comparetObject(MasterCard card, Object o) {
		return card.equals(o);
	}
}
