/**
 * 
 */
package group6.hotel.business;

import static java.lang.System.out;

import java.util.Optional;

import dw317.lib.Email;
import dw317.lib.Name;
import dw317.lib.creditcard.CreditCard;
import dw317.lib.creditcard.CreditCard.CardType;


/**
 * @author Kevin
 *
 */
public class DawsonCustomerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		testDawsonCustomer();
		testCompareTo();
		testEquals();
		testGetCreditCard();
		testName();
		testEmail();
		testToString();

	}
	
	public static void testDawsonCustomer()
	{
		testDawsonCustomer("Case 1 - Valid Data "
				+ "(David Ferguson david_ferguson1@google.ca)", "David", "Ferguson"
				, "david_ferguson1@google.ca",  true);
		
		testDawsonCustomer("Case 2 - Invalid Data - Null first name"
				+ "(null Ferguson david_ferguson1@google.ca)", null, "Ferguson"
				, "david_ferguson1@google.ca",  false);
		
		testDawsonCustomer("Case 3 - Invalid Data - Null last name"
				+ "(Thomas null david_ferguson1@google.ca)", "David", null
				, "david_ferguson1@google.ca",  false);
		
		testDawsonCustomer("Case 4 - Invalid Data - Null email"
				+ "(David Ferguson null)", "David", "Ferguson"
				, null,  false);
		
		testDawsonCustomer("Case 4 - Invalid Data - Bad email"
				+ "(David Ferguson david_ferguson1@@google.ca)", "David", "Ferguson"
				, "david_ferguson1@@google.ca",  false);
		
		testDawsonCustomer("Case 5 - Invalid Data - Bad first name"
				+ "(Dav!d Ferguson david_ferguson1@google.ca)", "Dav!d", "Ferguson"
				, "david_ferguson1@google.ca",  false);
		
		testDawsonCustomer("Case 6 - Invalid Data - Bad last name"
				+ "(David F david_ferguson1@google.ca)", "David", "F"
				, "david_ferguson1@google.ca",  false);
		
		testDawsonCustomer("Case 7 - Invalid Data - Everything null "
				+ null, null, null
				, null,  false);
		
		testDawsonCustomer("Case 8 - Invalid Data - Bad email"
				+ "(David Ferguson david_fe..rguson1@google.ca)", "David", "Ferguson"
				, "david_fe..rguson1@google.ca",  false);
		
		
		
	}
	
	
	public static void testDawsonCustomer(String testCase, String firstName, 
			String lastName, String email, boolean expectValid)
	{
		out.println("\t" + testCase);
		
		try
		{
			DawsonCustomer customer1 = new DawsonCustomer(firstName, lastName, email);
			
			out.println("\tThe DawsonCustomer was created: " + customer1);
			out.println();
			
			if (!expectValid)
				out.println("\t" + "==== FAILED TEST ==== Expected Invalid!");
			
		}
		catch (IllegalArgumentException e)
		{
			out.println("\t" + e.getMessage());
			out.println();
		}
		catch (Exception e)
		{
			out.println("\tUnexpected Exception!!! " + e.getClass() + "\n" +
					e.getMessage());
			out.println();
		}
	}
	
private static void testCompareTo() {
		
		out.println("\nTesting compareTo method.");
		
		DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson",
				"david_ferguson1@google.ca");
		DawsonCustomer c2 = new DawsonCustomer("David", "Ferguson",
				"david_ferguson1@google.ca");
		int comparison = c1.compareTo(c2);
		
		out.println("\tCase 1 - Both are the same (david_ferguson1@google.ca " +
				"david_ferguson1@google.ca)");
		out.println("\tThe p instance was created: " + c1);
		out.println("\tThe p2 instance was created: " + c2);
		
		if(comparison == 0)
			out.println("\t==== SUCCESS ==== Value is: " + comparison);
		else
			out.println("\t==== FAILED TEST ==== Error! Value is supposed" +
					" to be 0: " + comparison);
		
		out.println();
		
		out.println("\tCase 2 - c2 is null (david_ferguson1@google.ca null)");
		c2 = null;
		out.println("\tThe p instance was created: " + c1);
		out.println("\tThe p2 instance was created: " + c2);
		comparison = c1.compareTo(c2);
		
		if(comparison < 0)
			out.println("\t==== SUCCESS ==== Value is: " + comparison);
		else
			out.println("\t==== FAILED TEST ==== Error! Value is supposed" +
					" to be negative: " + comparison);
		
		out.println();
		
		out.println("\tCase 3 - Same name, different email (david_ferguson1@google.ca "+
				"david_ferguson1@google.ca)");
		c2 = new DawsonCustomer("David", "Ferguson", "david_ferguson11@google.ca");
		out.println("\tThe p instance was created: " + c1);
		out.println("\tThe p2 instance was created: " + c2);
		comparison = c1.compareTo(c2);
		
		if(comparison < 0)
			out.println("\t==== SUCCESS ==== Value is: " + comparison);
		else
			out.println("\t==== FAILED TEST ==== Error! p value is supposed"
					+ " to be larger: " + comparison);
	}

private static void testEquals() 
{
	out.println("\nTesting equals method.");
	
	DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson",
			"david_ferguson1@google.ca");
	DawsonCustomer c2 = new DawsonCustomer("David", "Ferguson",
			"david_ferguson1@google.ca");
	
	out.println("\tCase 1 - Both are the same (david_ferguson1@google.ca " +
			"david_ferguson1@google.ca)");
	out.println("\tThe c1 instance was created: " + c1);
	out.println("\tThe c2 instance was created: " + c2);
	boolean equality = c1.equals(c2);
	
	if(equality && c1.hashCode() == c2.hashCode())
		out.println("\t==== SUCCESS ==== Equality is: " + equality);
	else
		out.println("\t==== FAILED TEST ==== Error! Equality is supposed"
				+ " to be true: " + equality);
	
	out.println();
	
	out.println("\tCase 2 - Both reference the same object " +
			"(david_ferguson1@google.ca david_ferguson1@google.ca)");
	c2 = c1;
	out.println("\tThe c1 instance was created: " + c1);
	out.println("\tThe c2 instance was created: " + c2);
	equality = c1.equals(c2);
	
	if(equality && c1.hashCode() == c2.hashCode())
		out.println("\t==== SUCCESS ==== Equality is: " + equality);
	else
		out.println("\t==== FAILED TEST ==== Error! Equality is supposed"
				+ " to be true: " + equality);
	
	out.println();
	
	out.println("\tCase 3 - One object refences null " +
			"(KHAS96112712 null)");
	
	c2 = null;
	out.println("\tThe c1 instance was created: " + c1);
	out.println("\tThe c2 instance was created: " + c2);
	equality = c1.equals(c2);
	
	if(!equality)
		out.println("\t==== SUCCESS ==== Equality is: " + equality);
	else
		out.println("\t==== FAILED TEST ==== Error! Equality is supposed"
				+ " to be true: " + equality);
}

private static void testGetCreditCard()
{
	out.println("\nTesting getCreditCard methods.");
	
	DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson",
			"david_ferguson1@google.ca");
	
	out.println("\tCase 1 - Existing Credit Card");
	c1.setCreditCard(Optional.of(CreditCard.getInstance
			(CardType.VISA, "4024007160303235")));
	out.println("\tThe c1 instance was created: " + c1);
	
	if(c1.getCreditCard().equals(Optional.of(CreditCard.getInstance
			(CardType.VISA, "4024007160303235"))))
		out.println("\t==== SUCCESS ==== CreditCard is: " + 
				c1.getCreditCard());
	else
		out.println("\t==== FAILED TEST ==== Error! CreditCard is " +
				"supposed to be the same.");
	
	out.println();
	
	out.println("\tCase 2 - No CreditCard");
	c1.setCreditCard(Optional.empty());
	out.println("\tThe c1 instance was created: " + c1);
	
	if(c1.getCreditCard().equals(Optional.empty()))
		out.println("\t==== SUCCESS ==== Credit card is: nothing"); 
	else
		out.println("\t==== FAILED TEST ==== Error! CreditCard is " +
				"supposed to be nothing.");
	
	out.println("\tCase 3 - Null CreditCard");
	try
	{
	c1.setCreditCard(null);
	out.println("\tThe c1 instance was created: " + c1);
	}
	catch (Exception e)
	{
		System.out.println("\t" + e.getMessage());
	}
}

private static void testName()
{
	out.println("\nTesting name method.");
	out.println("\tCase 1 - Valid name");
	DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson",
			"david_ferguson1@google.ca");
	out.println("\tThe c1 instance was created: " + c1);
	
	if(c1.getName().equals(new Name("David", "Ferguson")))
		out.println("\t==== SUCCESS ==== Name is: " + c1.getName());
	else
		out.println("\t==== FAILED TEST ==== Error! Name is " +
				"supposed to be the same.");
	
	out.println();
	
	out.println("\tCase 2 - Deep Copy Verification");
	c1.getName().setFirstName("Kevin");
	c1.getName().setLastName("Bui");
	out.println("\t" + c1);
	if(!(c1.getName().equals(new Name("Kevin", "Bui"))))
		out.println("\t==== SUCCESS ====");
	else
		out.println("\t==== FAILED TEST ==== Error! Name is " +
				"supposed to be the different.");

}

private static void testEmail()
{
	out.println("\nTesting Email method.");
	out.println("\tCase 1 - Valid email");
	
	DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson",
			"david_ferguson1@google.ca");
	out.println("\tThe c1 instance was created: " + c1);
	if(c1.getEmail().equals(new Email("david_ferguson1@google.ca")))
		out.println("\t==== SUCCESS ==== Email is: " + c1.getEmail());
	else
		out.println("\t==== FAILED TEST ==== Error! Email is " +
				"supposed to be the same.");
			
}

private static void testToString()
{
	out.println("\nTesting toString method.");
	out.println("\tCase 1 - Email and Name");
	
	DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson",
			"david_ferguson1@google.ca");
	out.println("\tThe c1 instance was created: " + c1);
	if(c1.toString().equals
			("david_ferguson1@google.ca*David*Ferguson**"))
		out.println("\t==== SUCCESS ==== String is: " + c1.toString());
	else
		out.println("\t==== FAILED TEST ==== Error! String " +
				"is supposed to be the same.");
	
	out.println();
	
	out.println("\tCase 2 - Credit Card");
	c1.setCreditCard(Optional.of(CreditCard.getInstance
			(CardType.VISA, "4024007160303235")));
	out.println("\tThe c1 instance was created: " + c1);
	if(c1.toString().equals
			("david_ferguson1@google.ca*David*Ferguson*visa*4024007160303235"))
		out.println("\t==== SUCCESS ==== String is: " + c1.toString());
	else
		out.println("\t==== FAILED TEST ==== Error! String " +
				"is supposed to be the same.");
	
	
}

}
