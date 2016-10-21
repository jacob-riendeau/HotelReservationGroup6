/**
 * 
 */
package group6.hotel.business;

import static java.lang.System.out;

import dw317.hotel.business.RoomType;


/**
 * @author Kevin
 *
 */
public class DawsonRoomTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		testRoom();
		testCompareTo();
		testEquals();
		testToString();
		testGetRoomType();
		testGetRoomNumber();
		testGetFloor();

	}
	
	private static void testRoom()
	{
		out.println("Testing the two parameter constructor:");
		testRoom("Case 1 - Valid data (101 Normal)",
				101, RoomType.NORMAL, true);
		testRoom("Case 2 - Invalid data (909 Penthouse)",
				909, RoomType.PENTHOUSE, false);
		
		out.println("\n");
	}
	
	private static void testRoom(String testCase, int roomNumber, 
			RoomType roomType, boolean expectValid)
	{
		System.out.println(testCase);
	try 
	{
		DawsonRoom room = new DawsonRoom(roomNumber, roomType);
				
		out.print("A DawsonRoom instance was created: \n"
				+ room.toString() + "\n");		
		if (!expectValid)
			out.print("==== FAILED TEST ==== Expected Invalid!");
	}
	catch (IllegalArgumentException i) {
		out.print(i.getMessage() + "\n");
		if (expectValid)
			out.print("==== FAILED TEST ==== Expected Valid!");
	}
	catch (Exception e)
	{
			out.print("Unexpected Exception: " + e.getClass()
					+ " ==== FAILED TEST ====");
	}
}
	
	private static void testCompareTo()
	{
		out.println("Testing the compareTo method.");
		DawsonRoom room1 = new DawsonRoom(101, RoomType.NORMAL);
		
		out.println("Case 1 - Same room number and RoomType: ");		
		DawsonRoom room2 = new DawsonRoom(101, RoomType.NORMAL);
		out.println("Room 1 is made: " + room1);
		out.println("Room 2 is made: " + room2 + "");
		if(room1.compareTo(room2) != 0)
			out.print("Error! Values are not equal\n");
		else
			out.print("Values are equal\n");
	
		
		out.println("Case 2 - Different room number: ");		
		DawsonRoom room3 = new DawsonRoom(102, RoomType.NORMAL);
		out.println("Room 2 is made: " + room1);
		out.println("Room 3 is made: " + room3 + "");
		if(room1.compareTo(room3) == 0)
			out.print("Error! Values are supposed to be different.\n");
		else
			out.print("Values are different\n");
		
	}
	
	private static void testEquals()
	{
		out.println("\nTesting equals method.\n ");
		
		out.println("Case 1 - same rooms (101*normal "
				+ "101*normal");
		DawsonRoom room1 = new DawsonRoom(101, RoomType.NORMAL);
		DawsonRoom room2 = new DawsonRoom(101, RoomType.NORMAL);
		out.println("Room 1 was made: " + room1);
		out.println("Room 2 was made: " + room2 + "\n");
		if (room1.equals(room2) || room1.hashCode() == 
				room2.hashCode())
			out.print("Values are equal.");
		
		out.println();
		out.println();
		
		out.println("Case 2 - different rooms "
				+ "(101*normal 102*normal)");
		DawsonRoom room3 = new DawsonRoom(102, RoomType.NORMAL);
		out.println("Room 3 was made: " + room3 + "\n");
		if (!room1.equals(room3))
			out.print("The rooms are different.\n");
		

	}
	
	private static void testToString()
	{
		out.println("\nTesting the toString method.");
		DawsonRoom room = new DawsonRoom(101, RoomType.NORMAL);
		
		out.println("Case 1 - Room is made "
				+ room + "\n");

		if (!room.toString().equals("101*normal"))
			out.print("Error! Values are not equal.");

	}
	
	private static void testGetFloor()
	{
		out.println("Testing the getFloor method.\n");
		DawsonRoom room = new DawsonRoom(101, RoomType.NORMAL);
		
		out.println("Case 1 - Room is: 101*normal");				
		out.println("Room was created: " + room.getFloor());
		if (!(room.getFloor() == (room.getFloor())))
			out.print("Error! Values are not equal.");
		
		DawsonRoom room2 = new DawsonRoom(801, RoomType.PENTHOUSE);
		
		out.println("Case 2 - Room is: 801*penthouse");				
		out.println("Room was created: " + room2.getFloor());
		if (!(room2.getFloor() == (room2.getFloor())))
			out.print("Error! Values are not equal.");
	}
	
	private static void testGetRoomNumber()
	{
		out.println();
		out.println("Testing the getRoomNumber method.\n");
		DawsonRoom room = new DawsonRoom(101, RoomType.NORMAL);
		
		out.println("Case 1 - Room is: 101*normal");				
		out.println("Room was created: " + room.getRoomNumber());
		if (!(room.getRoomNumber() == (room.getRoomNumber())))
			out.print("Error! Values are not equal.");
		
		DawsonRoom room2 = new DawsonRoom(801, RoomType.PENTHOUSE);
		
		out.println("Case 2 - Room is: 801*penthouse");				
		out.println("Room was created: " + room2.getRoomNumber());
		if (!(room2.getRoomNumber() == (room2.getRoomNumber())))
			out.print("Error! Values are not equal.");
	}
	
	private static void testGetRoomType()
	{
		out.println();
		out.println("Testing the getRoomType method.\n");
		DawsonRoom room = new DawsonRoom(101, RoomType.NORMAL);
		
		out.println("Case 1 - Room is: 101*normal");				
		out.println("Room was created: " + room.getRoomType());
		if (!(room.getRoomType().equals(room.getRoomType())))
			out.print("Error! Values are not equal.");
		
		DawsonRoom room2 = new DawsonRoom(801, RoomType.PENTHOUSE);
		
		out.println("Case 2 - Room is: 801*penthouse");				
		out.println("Room was created: " + room2.getRoomType());
		if (!(room2.getRoomType().equals(room2.getRoomType())))
			out.print("Error! Values are not equal.");
	}
	
	

}
