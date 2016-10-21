/**
 * 
 */
package group6.hotel.business;

import dw317.hotel.business.interfaces.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author Kevin
 * @version Phase I
 *
 */
public class DawsonReservation implements Reservation, Serializable{
	
	private static final long serialVersionUID = 42031768871L;
	private final Customer customer;
	private final Room room;
	private LocalDate checkin;
	private LocalDate checkout;
	
	public DawsonReservation(Customer aCustomer, Room aRoom, int inYear,
			int inMonth, int inDay, int outYear, int outMonth, int outDay)
	{
		if (aCustomer == null)
			throw new IllegalArgumentException("There is no customer");
		
		this.customer = new DawsonCustomer(aCustomer.getName().getFirstName(), aCustomer.getName().getLastName(), 
				aCustomer.getEmail().toString());
		
		this.room = new DawsonRoom(aRoom.getRoomNumber(), aRoom.getRoomType());
		
			this.checkin = LocalDate.of(inYear, inMonth, inDay);
			this.checkout = LocalDate.of(outYear, outMonth, outDay);
			
			if(this.checkin.isAfter(this.checkout))
				throw new IllegalArgumentException("The out date is before the in date. It doesn't make sense");

			validateReservation();
			if (validateReservation() == false)
				throw new IllegalArgumentException("Check out date is before check in date");
	}
	
	public Customer getCustomer()
	{
		return new DawsonCustomer(customer.getName().getFirstName(), 
				customer.getName().getLastName(), customer.getEmail().toString());
	}
	
	public Room getRoom()
	{
		return this.room;
	}
	
	public LocalDate getCheckInDate()
	{
		return checkin;
	}
	
	public LocalDate getCheckOutDate()
	{
		return checkout;
	}
	
	public int getNumberDays()
	{
		int range = (int) ChronoUnit.DAYS.between(checkin, checkout);
		return range;
	}
	
	public boolean overlap(Reservation other)
	{

		boolean checkIfReservationValid = true;
		
		if (room.compareTo(other.getRoom()) == 0)
		{
		
		LocalDate test1in = checkin;
		LocalDate test1out = checkout;
		
		if (test1in.isAfter(test1out))
			throw new IllegalArgumentException("The checkout date is before "
					+ "the checkin date");
		
		LocalDate test2in = other.getCheckInDate();
		LocalDate test2out = other.getCheckOutDate();
		
		if (test2in.isAfter(test2out))
			throw new IllegalArgumentException("The checkout date is before "
					+ "the checkin date");
		
		if(test2in.isBefore(test1out) || test1in.isBefore(test2out))
			checkIfReservationValid = false;
		}
		
		
		return checkIfReservationValid;
	}

	@Override
	public int compareTo(Reservation o) 
	{
		if (o == null)
			return -1;
		
		if(room.compareTo(o.getRoom()) != 0)
			return room.compareTo(o.getRoom());


		if(this == o)
			return 0;
		
		if(this.checkin == null) {
			if(o.getCheckInDate() == null)
				return 0;
			else
				return -1;
		}
		if(o.getCheckInDate() == null)
			return 1;
		
		return checkin.compareTo(o.getCheckInDate());
				
		
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(! (obj instanceof DawsonReservation))
			return false;
	
		DawsonReservation rev = (DawsonReservation)obj;
	
		return customer.equals(rev.customer);

	}
	
	@Override
	public final int hashCode()
	{

			int prime = 37;
			int result = 1;
			
			result = prime * result + customer.getName().getFirstName().toUpperCase().hashCode();
			result += customer.getName().getLastName().toUpperCase().hashCode();
			
			return result;

	}
	
	@Override
	public String toString()
	{
		 
		 return customer.getEmail().toString() + "*" + checkin.getYear() + "*" + 
		 	checkin.getMonthValue() + "*" + checkin.getDayOfMonth() + "*" + 
				 checkout.getYear() + "*" + checkout.getMonthValue() + "*" +
		 	checkout.getDayOfMonth() + "*" + room.getRoomNumber();
	}
	
	private boolean validateReservation()
	{
		
		boolean valid = true;
		
		if(checkout.isBefore(checkin))
		{
			valid = false;
		}

		return valid;
	}
	

	

}
