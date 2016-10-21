/**
 * 
 */
package dw317.lib;

import java.util.Optional;

/**
 * @author elfla
 *	
 */
public class Person {
	private Name name;
	private Address address;
	
	
	/**
	 * Instantiates the private variables and give Address object default values
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName){
		this.name = new Name(firstName, lastName);
		this.address = new Address();
	}
	
	/**
	 * Instantiates the private variables and does a deep copy of Address
	 * @param firstName
	 * @param lastName
	 * @param address
	 */
	public Person(String firstName, String lastName, Address address){
		this.name = new Name(validateExistence("firstName",firstName), validateExistence("lastName",lastName));
		if(address.getCivicNumber().isEmpty()){
			this.address = new Address();
		}
		else{
			this.address = new Address(validateExistence("civicNumber",address.getCivicNumber()), validateExistence("streetName", address.getStreetName()), validateExistence("city", address.getCity()), Optional.ofNullable(address.getProvince()), Optional.ofNullable(address.getProvince()));
		}
	}
	
	/**
	 * Validates the String is not null
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 */
	private String validateExistence(String fieldName, String fieldValue) {
		if (fieldValue == null)
			throw new IllegalArgumentException(
					"Address Error - " + fieldName + " must exist. Invalid value = " + fieldValue);

		String trimmedString = fieldValue.trim();
		if (trimmedString.isEmpty())
			throw new IllegalArgumentException(
					"Address Error - " + fieldName + " must exist. Invalid value = " + fieldValue);
		return trimmedString;
	}
	
	/**
	 * Returns deep copy of Address 
	 * @return copy: Address
	 */
	public Address getAddress(){
		
		if(this.address.getCivicNumber().isEmpty()){
			Address empty = new Address();
			return empty;
		}
		
		Address copy = new Address(this.address.getCivicNumber(), this.address.getStreetName(), this.address.getCity(), Optional.ofNullable(this.address.getProvince()), Optional.ofNullable(this.address.getCode()));
		copy.setCode(copy.getCode());
		copy.setProvince(copy.getProvince());
		
		return copy;
			
	}
	
	/**
	 * Returns deep copy of Name
	 * @return copy: Name
	 */
	public Name getName(){
		Name copy = new Name(this.name.getFirstName(), this.name.getLastName());
		return copy;
	}
	
	
	/**
	 * Sets the Name
	 * @param firstName
	 * @param lastName
	 */
	public void setName(String firstName, String lastName){
		this.name = new Name(validateExistence("firstName",firstName), validateExistence("lastName",lastName));
	}
	
	/**
	 * Sets the Address
	 * @param address
	 */
	public void setAddress(Address address){
		this.address = new Address(validateExistence("civicNumber",address.getCivicNumber()), validateExistence("streetName", address.getStreetName()), validateExistence("city", address.getCity()), null, null);
	}
	
	/**
	 * String representation of the object
	 */
	
	@Override
	public String toString() {
	             
	    return name.toString() + "*" + 
	(address == null ? ""  : 
	       address.toString());                      
	}

}
