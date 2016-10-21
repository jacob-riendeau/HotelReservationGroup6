/**
 * 
 */
package dw317.hotel.business.interfaces;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Danny Manzano, kevin
 * @version Phase I
 * 
 */
public interface Reservation extends Comparable<Reservation>, Serializable{
	
	/**
	 * Gets the customer for the reservation.
	 * 
	 * @return The customer.
	 */
	Customer getCustomer();
	
	/**
	 * Gets the room for the reservation.
	 * 
	 * @return The room.
	 */
	Room getRoom();
	
	/**
	 * Gets the check in date of the reservation.
	 * 
	 * @return The check in date.
	 */
	LocalDate getCheckInDate();
	
	/**
	 * Gets the check out date of the reservation.
	 * 
	 * @return The check out date.
	 */
	LocalDate getCheckOutDate();
	
	/**
	 * Gets the number of days of the reservation.
	 * 
	 * @return The number of days.
	 */
	int getNumberDays();
	
	/**
	 * Checks if there is an overlap in reservation
	 * 
	 * @return A boolean value that determines if there is an
	 * 		   overlapping reservation.
	 */
	boolean overlap(Reservation other);
}
