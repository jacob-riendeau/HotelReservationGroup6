/**
 * 
 */
package dw317.hotel.business;

/**
 * @author Danny Manzano
 * @version Phase I
 *
 */
public enum RoomType {
	NORMAL, SUITE, PENTHOUSE;
	
	/**
	 * It returns a string representation of the RoomType in lower cases
	 * @return this.name().toLowerCase()
	 */
	public String toString(){
		return this.name().toLowerCase();
	}
}
