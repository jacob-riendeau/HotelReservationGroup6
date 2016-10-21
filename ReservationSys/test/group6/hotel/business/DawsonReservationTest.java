/**
 * 
 */
package group6.hotel.business;

import static java.lang.System.out;

import dw317.hotel.business.RoomType;
import dw317.hotel.business.interfaces.Customer;
import dw317.hotel.business.interfaces.Room;
import dw317.lib.Name;


/**
 * @author Kevin
 *
 */
public class DawsonReservationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		testDawsonReservation();
		testGetCustomer();
		testRoom();
		testGetCheckInDate();
		testGetCheckOutDate();
		testGetNumberDays();
		testOverlap();
		testCompareTo();
		testEquals();
		testToString();
		
	}
	
	public static void testDawsonReservation()
	{
		
		Customer customer = new DawsonCustomer("David", "Ferguson", "david_ferguson1@google.ca");
		DawsonRoom aRoom = new DawsonRoom(102, RoomType.NORMAL);
		
		testDawsonReservation("Case 1 - Valid Data "
				+ "(David Ferguson david_ferguson1@google.ca)", customer, aRoom,
				2015, 9, 24, 2015, 9, 29,  true);
		
		testDawsonReservation("Case 2 - Invalid Data - Check in date after check out date "
				+ "(David Ferguson david_ferguson1@google.ca)", customer, aRoom,
				2015, 9, 24, 2015, 9, 23,  false);	

	}
	
	
	public static void testDawsonReservation(String testCase, Customer aCustomer, Room aRoom, int inYear,
			int inMonth, int inDay, int outYear, int outMonth, int outDay, boolean expectValid)
	{
		out.println("\t" + testCase);
		
		try
		{
			DawsonReservation rev1 = new DawsonReservation(aCustomer, aRoom, inYear, inMonth, inDay,
					outYear, outMonth, outDay);
			
			out.println("\tThe DawsonReservation was created: " + rev1);
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
	
	private static void testGetCustomer()
	{
		out.println("\nTesting getCustomer method.");
		out.println("\tCase 1 - Valid name");
		DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson",
				"david_ferguson1@google.ca");
		out.println("\tThe c1 instance was created: " + c1);
		
		out.println();
		
		out.println("\tCase 1 - Deep Copy Verification");
		c1.getName().setFirstName("Kevin");
		c1.getName().setLastName("Bui");
		c1.getEmail();
		out.println("\t" + c1);
		if(!(c1.getName().equals(new Name("Kevin", "Bui"))))
			out.println("\t==== SUCCESS ====");
		else
			out.println("\t==== FAILED TEST ==== Error! Name is " +
					"supposed to be the different.");

	}
	
	private static void testRoom()
	{
		DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson", "david_ferguson1@google.ca");
		DawsonRoom room1 = new DawsonRoom(102, RoomType.NORMAL);
		DawsonReservation rev1 = new DawsonReservation(c1, room1, 2015,
				9, 24, 2015, 9, 29);
		
		out.println("\nTesting getRoom method.");
		out.println("\tCase 1 - Valid room");
		
		out.println("\tThe Reservation instance was created: " + rev1);
		out.println("\t" + rev1.getRoom());
		
	}
	
	private static void testGetCheckInDate()
	{
		DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson", "david_ferguson1@google.ca");
		DawsonRoom room1 = new DawsonRoom(102, RoomType.NORMAL);
		DawsonReservation rev1 = new DawsonReservation(c1, room1, 2015,
				9, 24, 2015, 9, 29);
		
		out.println("\nTesting getCheckInDate method.");
		out.println("\tCase 1");
		
		out.println("\tThe Reservation instance was created: " + rev1);
		out.println("\t" + rev1.getCheckInDate());
	}
	
	private static void testGetCheckOutDate()
	{
		DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson", "david_ferguson1@google.ca");
		DawsonRoom room1 = new DawsonRoom(102, RoomType.NORMAL);
		DawsonReservation rev1 = new DawsonReservation(c1, room1, 2015,
				9, 24, 2015, 9, 29);
		
		out.println("\nTesting getCheckOut method.");
		out.println("\tCase 1");
		
		out.println("\tThe Reservation instance was created: " + rev1);
		out.println("\t" + rev1.getCheckOutDate());
	}
	
	private static void testGetNumberDays()
	{
		DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson", "david_ferguson1@google.ca");
		DawsonRoom room1 = new DawsonRoom(102, RoomType.NORMAL);
		DawsonReservation rev1 = new DawsonReservation(c1, room1, 2015,
				9, 24, 2015, 9, 29);
		
		out.println("\nTesting getCheckOut method.");
		out.println("\tCase 1");
		
		out.println("\tThe Reservation instance was created: " + rev1);
		out.println("\t" + rev1.getNumberDays());
	}
	
	private static void testOverlap()
	{
		DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson", "david_ferguson1@google.ca");
		DawsonRoom room1 = new DawsonRoom(102, RoomType.NORMAL);
		DawsonReservation rev1 = new DawsonReservation(c1, room1, 2015,
				9, 24, 2015, 9, 29);
		
		DawsonCustomer c2 = new DawsonCustomer("David", "Ferguson", "david_ferguson1@google.ca");
		DawsonRoom room2 = new DawsonRoom(102, RoomType.NORMAL);
		DawsonReservation rev2 = new DawsonReservation(c2, room2, 2015,
				9, 26, 2015, 9, 28);
		
		DawsonCustomer c3 = new DawsonCustomer("David", "Ferguson", "david_ferguson1@google.ca");
		DawsonRoom room3 = new DawsonRoom(103, RoomType.NORMAL);
		DawsonReservation rev3 = new DawsonReservation(c3, room3, 2015,
				9, 26, 2015, 9, 30);
		
		out.println("\nTesting Overlap method.");
		out.println("\tCase 1 - Invalid - Check in date of Reservation 2 while Reservation 1 is still in same room");
		out.println("\tReservation 1 date: " + rev1.getCheckInDate() + " Room Number: " + rev1.getRoom());
		out.println("\tReservation 2 " + rev2.getCheckInDate() + " Room Number: " + rev2.getRoom());
		out.println("\t" + rev1.overlap(rev2));
		
		out.println();

		out.println("\tCase 2 - Valid Reservation - Different Rooms");
		out.println("\tReservation 1 " + rev1.getCheckInDate() + " Room Number: " + rev1.getRoom());
		out.println("\tReservation 2 " + rev3.getCheckInDate() + " Room Number: " + rev3.getRoom());
		out.println("\t" + rev1.overlap(rev3));

	}
	
private static void testCompareTo() {
		
		out.println("\nTesting compareTo method.");
		
		DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson", "david_ferguson1@google.ca");
		DawsonRoom room1 = new DawsonRoom(102, RoomType.NORMAL);
		DawsonReservation rev1 = new DawsonReservation(c1, room1, 2015,
				9, 24, 2015, 9, 29);

		DawsonCustomer c2 = new DawsonCustomer("David", "Ferguson", "david_ferguson1@google.ca");
		DawsonRoom room2 = new DawsonRoom(102, RoomType.NORMAL);
		DawsonReservation rev2 = new DawsonReservation(c2, room2, 2015,
				9, 24, 2015, 9, 29);

		DawsonReservation rev3 = null;
		
		DawsonCustomer c4 = new DawsonCustomer("David", "Ferguson", "david_ferguson1@google.ca");
		DawsonRoom room4 = new DawsonRoom(102, RoomType.NORMAL);
		DawsonReservation rev4 = new DawsonReservation(c4, room4, 2015,
				9, 23, 2015, 9, 29);
		
		int comparison = rev1.compareTo(rev2);
		
		out.println("\tCase 1 - Both are the same");
		out.println("\tThe rev1 instance was created: " + rev1);
		out.println("\tThe rev2 instance was created: " + rev2);
		
		if(comparison == 0)
			out.println("\t==== SUCCESS ==== Value is: " + comparison);
		else
			out.println("\t==== FAILED TEST ==== Error! Value is supposed" +
					" to be 0: " + comparison);
		
		out.println();
		
		out.println("\tCase 2 - rev2 is null");
		rev2 = null;
		out.println("\tThe rev1 instance was created: " + rev1);
		out.println("\tThe rev3 instance was created: " + rev3);
		comparison = rev1.compareTo(rev3);
		
		if(comparison < 0)
			out.println("\t==== SUCCESS ==== Value is: " + comparison);
		else
			out.println("\t==== FAILED TEST ==== Error! Value is supposed" +
					" to be negative: " + comparison);
		
		out.println();
		
		out.println("\tCase 3 - Same Customer, different reservations - rev4 is earlier");
		out.println("\tThe rev1 instance was created: " + rev1);
		out.println("\tThe rev4 instance was created: " + rev4);
		comparison = rev1.compareTo(rev4);
		
		if(comparison > 0)
			out.println("\t==== SUCCESS ==== Value is: " + comparison);
		else
			out.println("\t==== FAILED TEST ==== Error! rev1 value is supposed"
					+ " to be larger: " + comparison);
	}

private static void testEquals() 
{
	out.println("\nTesting equals method.");
	
	DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson", "david_ferguson1@google.ca");
	DawsonRoom room1 = new DawsonRoom(102, RoomType.NORMAL);
	DawsonReservation rev1 = new DawsonReservation(c1, room1, 2015,
			9, 24, 2015, 9, 29);

	DawsonCustomer c2 = new DawsonCustomer("David", "Ferguson", "david_ferguson1@google.ca");
	DawsonRoom room2 = new DawsonRoom(102, RoomType.NORMAL);
	DawsonReservation rev2 = new DawsonReservation(c2, room2, 2015,
			9, 24, 2015, 9, 29);
	
	DawsonReservation rev3 = null;
	
	out.println("\tCase 1 - Both are the same");
	out.println("\tThe rev1 instance was created: " + rev1);
	out.println("\tThe rev2 instance was created: " + rev2);
	boolean equality = rev1.equals(rev2);
	
	if(equality && rev1.hashCode() == rev2.hashCode())
		out.println("\t==== SUCCESS ==== Equality is: " + equality);
	else
		out.println("\t==== FAILED TEST ==== Error! Equality is supposed"
				+ " to be true: " + equality);
	
	out.println();
	
	out.println("\tCase 2 - Both reference the same object");
	c2 = c1;
	out.println("\tThe rev1 instance was created: " + rev1);
	out.println("\tThe rev2 instance was created: " + rev2);
	equality = c1.equals(c2);
	
	if(equality && rev1.hashCode() == rev2.hashCode())
		out.println("\t==== SUCCESS ==== Equality is: " + equality);
	else
		out.println("\t==== FAILED TEST ==== Error! Equality is supposed"
				+ " to be true: " + equality);
	
	out.println();
	
	out.println("\tCase 3 - One object refences null ");

	out.println("\tThe rev1 instance was created: " + rev1);
	out.println("\tThe rev3 instance was created: " + rev3);
	equality = rev1.equals(rev3);
	
	if(!equality)
		out.println("\t==== SUCCESS ==== Equality is: " + equality);
	else
		out.println("\t==== FAILED TEST ==== Error! Equality is supposed"
				+ " to be true: " + equality);
}

private static void testToString()
{
	out.println("\nTesting toString method.");
	
	DawsonCustomer c1 = new DawsonCustomer("David", "Ferguson", "david_ferguson1@google.ca");
	DawsonRoom room1 = new DawsonRoom(102, RoomType.NORMAL);
	DawsonReservation rev1 = new DawsonReservation(c1, room1, 2015,
			9, 24, 2015, 9, 29);
	
	out.println("\tThe rev1 instance was created: " + rev1);
	if(rev1.toString().equals
			("david_ferguson1@google.ca*2015*9*24*2015*9*29*102"))
		out.println("\t==== SUCCESS ==== String is: " + rev1.toString());
	else
		out.println("\t==== FAILED TEST ==== Error! String " +
				"is supposed to be the same.");
	
	
}


}
