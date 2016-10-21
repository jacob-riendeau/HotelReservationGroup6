/**
 * Defines an Address type
 */
//Git hub test
package dw317.lib;

import java.util.Optional;

/**
 * @author Danny Manzano
 *
 */
public class Address {
	private String city = "";
	private String civicNumber = "";
	private String province = "";
	private String code = "";
	private String streetName = "";
	
	
	/**
	 * No Parameter Constructor
	 * @param none
	 */
	public Address() {

	}

	/**
	 * Assign values to the instances
	 * @param civicNumber
	 * @param streetName
	 * @param city
	 */
	public Address(String civicNumber, String streetName, String city, Optional<String> province, Optional<String> code) {

		this.civicNumber = validateExistence("civic number", civicNumber);
		this.streetName = validateExistence("street name", streetName);
		this.city = validateExistence("city", city);
		this.province = province.orElse("");
		this.code = code.orElse("");

	}
	
	/**
	 * Validate entries 
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
	 * Returns a String representation of the address.
	 * 
	 * @return address a formatted address.
	 */
	public String getAddress() {
		String address = civicNumber + " " + streetName + "\n" + city;
		address += (province.equals("") ? "" : (", " + province)) + (code.equals("") ? "" : ("\n" + code));

		return address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the civicNumber
	 */
	public String getCivicNumber() {
		return civicNumber;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = validateExistence("city" , city);
	}

	/**
	 * @param civicNumber
	 *            the civicNumber to set
	 */
	public void setCivicNumber(String civicNumber) {
		this.civicNumber = validateExistence("civicNumber", civicNumber);
	}

	/**
	 * @param province
	 *            the province to set
	 */
	public void setProvince(String province) {
		this.province = validateExistence("province", province);
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = validateExistence("code", code);
	}

	/**
	 * @param streetName
	 *            the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = validateExistence("streetName" , streetName);
	}

	/**
	 * Sets parameter to String representation
	 */
	@Override
	public String toString() {
		return (civicNumber + "*" + streetName + "*" + city + "*" + province + "*" + code);
	}

}
