/**
 * 
 */
package group6.hotel.business;

import dw317.hotel.business.interfaces.Room;
import java.io.Serializable;
import dw317.hotel.business.*;

/**
 * A DawsonRoom object that implements Room and 
 * creates a Room record.
 * 
 * @author Kevin Bui
 * @version Phase I
 * @since 1.8
 */

public class DawsonRoom implements Room, Serializable {
	
	private static final long serialVersionUID = 42031768871L;
	private int roomNumber;
	private RoomType roomType;
	
	public DawsonRoom(int roomNumber, RoomType roomType)
	{
		if (validateRoomNumber(roomNumber))
			this.roomNumber = roomNumber;
		else
			throw new IllegalArgumentException("Room Number Error " +
					"invalid. Invalid value = " + roomNumber);
			
		this.roomType = roomType;
	}
	
	public RoomType getRoomType()
	{
		return this.roomType;
	}
	
	public int getRoomNumber() 
	{
		return this.roomNumber;
	}
	
	public int getFloor()
	{
		String roomNumString = roomNumber + "";
		roomNumString = roomNumString.substring(0,1);
		int floorNum = Integer.parseInt(roomNumString);
		
		return floorNum;
	}
	
	public int getNumber()
	{
		String roomNumString = roomNumber + "";
		roomNumString = roomNumString.substring(1,3);
		int roomNum = Integer.parseInt(roomNumString);
		
		return roomNum;
	}
	
	@Override
	public final int hashCode()
	{
		int prime = 37;
		int result = 1;
		
		result = prime * result + Integer.valueOf(roomNumber).hashCode();
		
		return result;
	}
	
	@Override
	public final boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(! (obj instanceof DawsonRoom))
			return false;
	
		DawsonRoom aRoom = (DawsonRoom)obj;
	
		return roomNumber == aRoom.roomNumber;
	}
	
	@Override
	public String toString()
	{
		String room;
		 
		 if(roomType == null)
			 room = "*";
		 
		 else
			 room = roomNumber + "*" +
					 roomType;
		 
		 return room;
	}

	@Override
	public int compareTo(Room o) 
	{
		if(o == null)
			return -1;
		
		return Integer.valueOf(roomNumber).compareTo(Integer.valueOf(o.getRoomNumber()));
	}
	
	private boolean validateRoomNumber(int roomNumber)
	{
		
		boolean validDigit = false;
		boolean validFirstDigit = false;
		boolean validSecondDigit = false;
		boolean validThirdDigit = false;
		
		if (roomNumber == 0)
			return false;
		
		String roomNumString = roomNumber + "";
		String roomNumStringFirstDigit = roomNumString.substring(0,1);
		int roomNumFirstDigit = Integer.parseInt(roomNumStringFirstDigit);
		
		if (roomNumFirstDigit > 0 && roomNumFirstDigit < 9)
			validFirstDigit = true;

		
		String roomNumStringSecondDigit = roomNumString.substring(1,2);
		int roomNumSecondDigit = Integer.parseInt(roomNumStringSecondDigit);
		
		if (roomNumSecondDigit == 0)
			validSecondDigit = true;

		String roomNumStringThirdDigit = roomNumString.substring(2,3);
		int roomNumThirdDigit = Integer.parseInt(roomNumStringThirdDigit);

		if (roomNumThirdDigit > 0 && roomNumThirdDigit < 9)
			validThirdDigit = true;

		
		if (validFirstDigit == true && validSecondDigit == true && 
				validThirdDigit == true)
			validDigit = true;
		
		return validDigit;
		
		
	}

}