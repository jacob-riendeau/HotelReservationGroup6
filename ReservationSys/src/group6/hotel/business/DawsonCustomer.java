/**
 * 
 */
package group6.hotel.business;

import java.io.Serializable;
import java.util.Optional;
import dw317.hotel.business.interfaces.*;
import dw317.lib.Email;
import dw317.lib.Name;
import dw317.lib.creditcard.CreditCard;



/**
 * @author Kevin
 * @version Phase I
 *
 */
public class DawsonCustomer implements Customer, Serializable
{
	private static final long serialVersionUID = 42031768871L;
	private Name name;
	private Email email;
	private CreditCard credCard = null;
	
	public DawsonCustomer (String firstName, String lastName, String email)
	{
		name = new Name(firstName, lastName);
		this.email = new Email(email);
	}
	
	/**
	 * Returns a the name of the customer. 
	 * 
	 *
	 * @return 	The name of the customer.
	 *
	 *			 
	 */
	
	public Name getName()
	{
		return new Name(name.getFirstName(), name.getLastName());
	}
	
	/**
	 * Returns a the email of the customer. 
	 * 
	 *
	 * @return 	The email of the customer.
	 *
	 *			 
	 */
	
	public Email getEmail()
	{
		return this.email;
	}

	
	/**
	 * Returns a deep copy of the credit card. 
	 * 
	 *
	 * @return 	A deep copy of the credit card.
	 *
	 *			 
	 */
	
	public Optional<CreditCard> getCreditCard()
	{
		return Optional.ofNullable(credCard);
	}
	
	/**
	 * 
	 * Sets the credit card, if present
	 *			 
	 */
	
	
	public void setCreditCard(Optional <CreditCard> card)
	{
		
			if(card == null)
				this.credCard = null;
			else
				this.credCard = card.orElse(null); //Shouldn't go to default
			
	}
	
	@Override
	public final int hashCode()
	{

			int prime = 37;
			int result = 1;
			
			result = prime * result + name.getFirstName().toUpperCase().hashCode();
			result += name.getLastName().toUpperCase().hashCode();
			
			return result;

	}
	
	@Override
	public final boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(! (obj instanceof DawsonCustomer))
			return false;
	
		DawsonCustomer aCustomer = (DawsonCustomer)obj;
	
		return email.equals(aCustomer.email);

	}
	
	@Override
	public String toString()
	{
		String card;
		 
		 if(credCard == null)
			 card = "*";
		 
		 else
			 card = credCard.getType() + "*" +
					 credCard.getNumber();
		 
		 return email + "*" + name.getFirstName() + "*" + 
		 	name.getLastName() + "*" + card;
	}

	@Override
	public int compareTo(Customer o) 
	{
		if(o == null)
			return -1;
		
		return email.compareTo(o.getEmail());
	}
	
	//this part is not needed since the name class is already validating the inputs
	
	/*
	 * Validates the name of the patient.
	 * 
	 * @param name A patient's full name.
	 * @param nameField One of the fields of the full name.
	 * @return A validated name.
	 * @throws IllegalArgumentException For invalid name values.
	 */
	/*private String validateName(String name, String nameField)
	{	
		if(name == null)
			throw new IllegalArgumentException("Name Error - " + nameField
					+ " cannot be null. Invalid value = " + name);
		
		name = name.trim();
		
		if(name.length() < 2)
			throw new IllegalArgumentException("Name Error - " + 
					nameField + " must have at least 2 characters. " +
					"Invalid value = " + name);
		
		for(int i = 0; i < name.length(); i ++)
		{		
			if(!(Character.isLetter(name.charAt(i)) || name.charAt(i) == '-' 
					|| name.charAt(i) == '\'' || name.charAt(i) == ' '))
				throw new IllegalArgumentException("Name Error - " + name +
						" must contain letters. Invalid value = " + name);
		}
		
		return name;		
	}*/
}
