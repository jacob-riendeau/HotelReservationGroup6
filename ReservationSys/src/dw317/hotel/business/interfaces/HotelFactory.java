package dw317.hotel.business.interfaces;

import java.io.Serializable;

import dw317.lib.creditcard.CreditCard;

/**
 * 
 * @author Danny Manzano
 * @version Phase I 
 */
public interface HotelFactory extends Serializable {

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @return Customer obj
	 */
	Customer getCustomerInstance(String firstName, String lastName, String email);
	
	/**
	 * 
	 * @param cardtype
	 * @param number
	 * @return CreditCard obj
	 */
	CreditCard getCard(String cardtype, String number);
	
	/**
	 * 
	 * @param roomNumber
	 * @param roomtype
	 * @return Room obj
	 */
	Room getRoomInstance(int roomNumber, String roomtype);
	
	/**
	 * 
	 * @param aCustomer
	 * @param aRoom
	 * @param inYear
	 * @param inMonth
	 * @param inDay
	 * @param outYear
	 * @param outMonth
	 * @param outDay
	 * @return Reservation obj
	 */
	Reservation getReservationInstance(Customer aCustomer, Room aRoom, int inYear, int inMonth, int inDay, int outYear, int outMonth, int outDay);
	
	/**
	 * 
	 * @param toCopy
	 * @return Reservation obj
	 */
	Reservation getReservationInstance(Reservation toCopy);
}

