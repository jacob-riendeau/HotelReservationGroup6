package dw317.hotel.business.interfaces;

import java.io.Serializable;

import java.util.Optional;

import dw317.lib.Name;
import dw317.lib.Email;
import dw317.lib.creditcard.CreditCard;

/**
 * 
 * @author Danny Manzano, Kevin
 * @version Phase I 
 */
public interface Customer extends Comparable<Customer>, Serializable{
	
	/**
	 * Returns a deep copy of the name. 
	 * 
	 *
	 * @return 	A deep copy of the name.
	 *
	 *			 
	 */
	Name getName();
	
	/**
	 * Returns a the email of the customer. 
	 * 
	 *
	 * @return 	The email of the customer.
	 *
	 *			 
	 */
	Email getEmail();
	
	/**
	 * Returns a deep copy of the credit card. 
	 * 
	 *
	 * @return 	A deep copy of the credit card.
	 *
	 *			 
	 */
	Optional<CreditCard> getCreditCard();
	
	/**
	 * 
	 * Sets the credit card, if present
	 *			 
	 */
	void setCreditCard(Optional<CreditCard> card);
}
