package dw317.hotel.business.interfaces;

import java.io.Serializable;

import dw317.hotel.business.RoomType;

/**
 * 
 * @author Danny Manzano, kevin
 * @version Phase I
 *
 */
public interface Room extends Comparable<Room>, Serializable{
	
	/**
	 * Returns the room type. 
	 * 
	 * @return 	The room type requested.
	 *
	 * @throws  NonExistingRoomType The room type does not exists
	 *			 
	 */
	RoomType getRoomType();
	
	/**
	 * Returns the room with the specified room number. 
	 * 
	 *
	 * @return 	The room type requested.
	 *
	 * @throws  NonExistingRoomNumber The room type does not exists
	 *			 
	 */
	int getRoomNumber();
	
	/**
	 * Returns the floor of the room . 
	 * 
	 *
	 * @return 	The floor of the room requested.
	 *
	 * @throws  NonExistingFloor The floor does not exists
	 *			 
	 */
	int getFloor();
	
	/**
	 * Returns the room number. 
	 * 
	 *
	 * @return 	The room number
	 *
	 * @throws  NonExistingNumber The room number does not exists
	 *			 
	 */
	int getNumber();
}
