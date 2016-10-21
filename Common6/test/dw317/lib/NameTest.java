/**
 * 
 */
package dw317.lib;

/**
 * @author elfla
 *
 */
public class NameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*System.out.println("Testing the Name class");
		try {
			System.out.println("Case 1 - instantiate with valid first and last name");
			Name case1 = new Name("Danny", "Manzano");
			System.out.println("Case 1 - instantiated successfully");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Case 2 - instantiate without respecting length");
			Name case2 = new Name("a", "Manzano");
		} catch (IllegalArgumentException e) {
			System.out.println("Case 2 " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Case 2" + e.getMessage());
		}

		try {
			System.out.println("Case 3 - instantiate with illegal character");
			Name case3 = new Name("D#anny", "Manzano");
		} catch (IllegalArgumentException e) {
			System.out.println("Case 3 " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Case 3" + e.getMessage());
		}*/
		
		Name n1 = new Name("Danny","Manzano");
		Name n2 = new Name("Danny", "danzano");
		
		System.out.println(n1.compareTo(n2));
	}

}
