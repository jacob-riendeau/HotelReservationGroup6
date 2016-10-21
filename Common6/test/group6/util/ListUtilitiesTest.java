/**
 * 
 */
package group6.util;

import dw317.lib.Name;

/**
 * @author elfla
 *
 */
public class ListUtilitiesTest extends ListUtilities{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arrS = {"a", "d", "g", "h", "t", "p"};
		sort(arrS);
		for(String arr : arrS)
			System.out.println(arr);
		
		Name[] arrN = new Name[4];
		arrN[0] = new Name("Danny", "Manzano");
		arrN[1] = new Name("Jaya", "Nilketkndpf");
		arrN[2] = new Name("Jacob", "Reindeau");
		arrN[3] = new Name("Alex", "Yin");
		
		sort(arrN);
		
		for(Name arr: arrN)
			System.out.println(arr);

	}

}
