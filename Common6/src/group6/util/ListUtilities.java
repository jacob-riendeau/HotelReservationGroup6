/**
 * 
 */
package group6.util;

/**
 * @author Danny Manzano
 *
 */
public class ListUtilities {
	/*
	 * Sorts a list of objects in ascending natural order using 
	 * selection sort.
	 * 
	 *
	 * @param list 	A list of objects. Assumes that the
	 *             	list's capacity is equal to the list's size. 
	 * 
	* @throws  		IllegalArgumentException if the parameter is
	*			not full to capacity.
	*
	* @throws		NullPointerException if the list is null.
	 */
		 @SuppressWarnings({ "rawtypes", "unchecked" })
		 public static void sort(Comparable[] list)
					throws IllegalArgumentException, NullPointerException{
			/*if(list == null)
				throw new NullPointerException("The Comparable[] is null ");
			if(list[list.length -1] == null)
				throw new IllegalArgumentException("The Array list is not filled to capacity");*/
			
			int small;
			Comparable temp;
			for(int i=0; i < list.length; i++){
				small = i;
				for(int j=i+1; j < list.length; j++){
					if(list[j].compareTo(list[small]) < 0){
						small = j;
					}
				}	
				
				//swapping
				temp = list[small];
				list[small] = list[i];
				list[i] = temp;
					
				
			}
		 }

}
