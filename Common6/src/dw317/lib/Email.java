/**
 * 
 */
package dw317.lib;

import java.io.Serializable;
//Git hub test 2
/**
 * @author Danny Manzano
 * @version Phase 1
 *
 */
public class Email implements Serializable, Comparable<Email> {
	private static final long serialVersionUID = 42031768871L;
	private final String address; // reading only

	/**
	 * Constructor assigns the value address to the instance variable this.address 
	 * while calling on validationEmail() method before the assignment
	 * @param address
	 */
	public Email(String address) {
		this.address = validateEmail(address);
	}

	/**
	 * 
	 * Return the instance of address
	 * @return this.address
	 */
	public String getAddress() {
		return this.address;
	}

	
	/**
	 * The method uses substring and indexOf to locate the @ symbol
	 * and returns the UserId part
	 * @return userId
	 */
	public String getUserId() {
		int positionAt = this.address.indexOf("@");
		String userId = this.address.substring(0, positionAt);
		return userId;
	}

	/**
	 * The method uses substring and indexOf to locate the @ symbol
	 * and returns the host part
	 * @return host
	 */
	public String getHost() {
		int positionAt = this.address.indexOf("@");
		String host = this.address.substring(positionAt + 1);
		return host;
	}

	/**
	 * Check for equality of the instance of the object being 'address'
	 */
	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() == obj.getClass()) {
			Email objCopy = (Email) obj;
			if (this.address.equals(objCopy.address))
				return true;
		}

		return false;
	}

	/**
	 * Modifying the hash code
	 */
	@Override
	public final int hashCode() {
		return this.address.hashCode() * 2;
	}

	/**
	 * @return this.address
	 */
	@Override
	public String toString() {
		return this.address;
	}

	/**
	 * Checks first equality then compares the hosts, if the hosts are equals then 
	 * it compares the userIds
	 */
	@Override
	public int compareTo(Email other) {
		if (this.address.equals(other.address))
			return 0;
		String host = this.getHost().toLowerCase();
		String otherHost = other.getHost().toLowerCase();
		String userId = this.getUserId();
		String otherUserId = other.getUserId();

		if (host.compareTo(otherHost) != 0) {
			if (host.compareTo(otherHost) > 0)
				return 1;
			else
				return -1;
		} 
		else {
			// if it goes to this point, no need for validation of the userId's
			// equality since both email's string are not equal
			if (userId.compareTo(otherUserId) > 0)
				return 1;
			else
				return -1;
		}

	}

	/**
	 * Validates the email string according to specific constraints and returns the string if 
	 * it respects these constraints or else would throw an IllegalArgumentException
	 * 
	 * @param email
	 * @return email
	 * @throws IllegalArgumentException
	 */
	private static String validateEmail(String email) throws IllegalArgumentException {
		
		if(email == null)
			throw new IllegalArgumentException("The email is null");
		
		//can't call for the getHost and getUserId method since at this point the constructor is done executing
		int positionOfAtSymbol = email.indexOf("@");
		String userId = email.substring(0, positionOfAtSymbol);
		String host = email.substring(positionOfAtSymbol + 1);

		if (userId.length() >= 1 && userId.length() <= 32) {
			for (int i = 0; i < userId.length(); i++) {
				// to help readability
				char ch = userId.charAt(i);
				if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') || ch == '-' || ch == '_'
						|| ch == '.'))
					throw new IllegalArgumentException("The userId doesn't respect the constraints of an email. " + ch
							+ ": is not a valid character");
			}
			if (userId.indexOf("..") > 0 || userId.indexOf(".") == userId.length() - 1 || userId.indexOf(".") == 0)
				throw new IllegalArgumentException(
						"The userId doesn't respect the constraints of an email. The dot is not used properly");
		}
		// Rules to follow for the userId:
		// Length between 1 & 32
		// characters accepted: upper&lower case letters, digits, hyphen,
		// underscore & dot
		// no dot at the end or two together

		if (host.length() >= 1 && host.length() <= 32) {
			for (int i = 0; i < host.length(); i++) {
				char ch = host.charAt(i);
				if (!((ch >= 'a' && ch <= 'z' )|| (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') || ch == '-' || ch == '.'))
					throw new IllegalArgumentException("The host doesn't respect the constraints of an email. " + ch
							+ ": is not a valid character");
			}
			if (host.indexOf("-") == 0 || host.indexOf("-") == host.length() - 1)
				throw new IllegalArgumentException("The host doesn't respect the constraints of an email. The hyphen is not used properly");

		}
		// Rules to follow for the host:
		// At least 1 segment
		// dots should separate segments
		// Segment: length 1 to 32 char:
		// characters accepted: upper&lower case letters, digits, hyphen as long
		// it is not the first or last character
		return email;
	}
}
