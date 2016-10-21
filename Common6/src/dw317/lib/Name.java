/**
 * Object Name containing Name data
 */
package dw317.lib;

import java.io.Serializable;

/**
 * @author Danny Manzano
 * @version Phase I 
 *
 */
public class Name implements Serializable, Comparable<Name> {
	private String firstName;
	private String lastName;
	private static final long serialVersionUID = 42031768871L;

	/**
	 * No parameter Constructor Instantiate object to empty String
	 */
	public Name() {
		this.firstName = "";
		this.lastName = "";
	}

	/**
	 * Instantiate private variables to corresponding parameters. 
	 * 
	 * @param first
	 * @param last
	 */
	public Name(String first, String last) {
		this.firstName = validateConstraints("firstName", first);
		this.lastName = validateConstraints("lastName", last);
	}

	/**
	 * Looks through the string and validates the constraints: -minimum of 2
	 * characters -accepts only letters, apostrophe, hyphen and space
	 * 
	 * @param fieldName
	 * @param fieldValue
	 * @return fieldValue
	 */
	private String validateConstraints(String fieldName, String fieldValue) {
		String fieldLowerValue = validateExistence(fieldName, fieldValue).toLowerCase().trim();
		if (!(fieldLowerValue.length() >= 2))
			throw new IllegalArgumentException(
					"Name Error - " + fieldName + " does not respect constraints value = " + fieldValue);
		for (int i = 0; i < fieldLowerValue.length(); i++) {
			if (!((fieldLowerValue.charAt(i) >= 'a' && fieldLowerValue.charAt(i) <= 'z')
					|| fieldLowerValue.charAt(i) == '\'' || fieldLowerValue.charAt(i) == '-'
					|| fieldLowerValue.charAt(i) == ' '))
				throw new IllegalArgumentException(
						"Name Error - " + fieldName + " does not respect constraints value = " + fieldValue);
		}

		return fieldValue;
	}

	/**
	 * Validates the String is not null
	 * 
	 * @param fieldName
	 * @param fieldValue
	 * @return trimmedString
	 */
	private String validateExistence(String fieldName, String fieldValue) {
		if (fieldValue == null)
			throw new IllegalArgumentException(
					"Name Error - " + fieldName + " must exist. Invalid value = " + fieldValue);

		String trimmedString = fieldValue.trim();
		if (trimmedString.isEmpty())
			throw new IllegalArgumentException(
					"Name Error - " + fieldName + " must exist. Invalid value = " + fieldValue);
		return trimmedString;
	}

	/**
	 * Returns the first name
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Returns the last name
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = validateConstraints("firstName", firstName);
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = validateConstraints("lastName", lastName);
	}

	/**
	 * Returns a String format of the full name
	 * 
	 * @return (this.firstName + " " + this.lastName)
	 */
	public String getFullName() {
		return (this.firstName + " " + this.lastName);
	}

	/**
	 * Override toString method
	 * 
	 * @return (this.firstName + "*" + this.lastName)
	 */
	@Override
	public String toString() {
		return (this.firstName + "*" + this.lastName);
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj)
				return true;
		if(obj == null)
			return false;
		
		if(this.getClass() == obj.getClass()){
			Name otherName = (Name) obj;
			if(this.firstName == otherName.firstName && this.lastName == otherName.lastName)
				return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode(){
		return (this.lastName.hashCode() + this.firstName.hashCode()) * 13;
	}
	
	@Override
	public int compareTo(Name name){
		if(this.equals(name))
			return 0;
		
		if(this.lastName.compareToIgnoreCase(name.lastName) != 0)
			return this.lastName.compareToIgnoreCase(name.lastName);
		else
			return this.firstName.compareToIgnoreCase(name.firstName);
			
	}
}
