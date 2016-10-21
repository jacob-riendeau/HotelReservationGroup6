/**
 * C
 */
package dw317.lib;

import java.util.Optional;

/**
 * @author elfla
 * 
 * 
 *
 */

public class AddressTest {

	public static void main(String[] args) {
		/*testTheThreeParameterConstructor();
		testGetCivicNumber();
		testSetCivicNumber();
		testNoParameterConstructor();
		testGetStreetName();
		testGetAddress();*/
		testFiveParameterConstructor();
	}
	
	

	/*private static void testTheThreeParameterConstructor() {
		System.out.println("\nTesting the three parameter constructor.");
		testTheThreeParameterConstructor(
			"Case 1 - Valid data (3040 Sherbrooke Westmount)", "3040",
				"Sherbrooke", "Westmount", true);
		
		testTheThreeParameterConstructor(
				"Case 2 - Invalid data – empty civicNumber ( Sherbrooke Westmount)","",
					"Sherbrooke","Westmount", false);
		
		testTheThreeParameterConstructor(
				"Case 3 - Invalid data – all spaces civicNumber ( Sherbrooke Westmount)","       ",
					"Sherbrooke","Westmount", false);
		
		testTheThreeParameterConstructor(
				"Case 4 - Invalid data – empty street name (3040  Westmount)","3040",
					"","Westmount", false);
		
		testTheThreeParameterConstructor(
				"Case 5 - Invalid data – all spaces street name ( 3040 Westmount)","3040",
					"     ","Westmount", false);
		
		testTheThreeParameterConstructor(
				"Case 6 - Invalid data – empty city ( 3040 Sherbrooke )","3040",
					"Sherbrooke","", false);

		testTheThreeParameterConstructor(
				"Case 7 - Invalid data – all spaces city ( 3040 Sherbrooke)","3040",
					"Sherbrooke","          ", false);
		
		testTheThreeParameterConstructor(
				"Case 8 - Invalid data – null civicNumber (null Sherbrooke Westmount)",
						null,"Sherbrooke","Westmount",false);
		
		testTheThreeParameterConstructor(
				"Case 9 - Invalid data – null street name (3040 null Westmount)",
						"3040",null,"Westmount",false);
		
		testTheThreeParameterConstructor(
				"Case 10 - Invalid data – null city (3040 Sherbrooke null)",
						"3040","Sherbrooke",null,false);

		
	}

	private static void testTheThreeParameterConstructor(String testCase,
			String civicNumber, String streetName, String city,
			boolean expectValid) {

		System.out.println("   " + testCase);

		try {
			Address theAddress = new Address(civicNumber, streetName, city, null, null);
			System.out.print("\tThe Address instance was created: " + theAddress);
			
			if (!expectValid)
				System.out.print("  Error! Expected Invalid. ==== FAILED TEST ====");
		}
		catch (IllegalArgumentException iae)	{
			System.out.print("\t"+ iae.getMessage());
			if (expectValid)
				System.out.print("  Error! Expected Valid. ==== FAILED TEST ====");
		}
		catch (Exception e) {
			System.out.print("\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() +  " "  + 				e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				System.out.print(" Expected Valid.");
		}

		System.out.println("\n");
}
	
	private static void testGetCivicNumber()
	{
		System.out.println("\nTesting the getCivicNumber method.");
		testGetCivicNumber("Case 1: 3040 without leading/trailing spaces",
				"3040","3040");
		testGetCivicNumber("Case 2: 3040 with leading/trailing spaces",
				"    3040    ","3040");
	}
	
	private static void testGetCivicNumber(String testCase, 
			String civicNumber, String expectedCivicNumber)
	{
		System.out.println("   " + testCase);
		Address theAddress = 
				new Address (civicNumber, "Sherbrooke","Westmount", null ,null);
		System.out.print("\tThe Address instance was created: " + theAddress);

		if (!theAddress.getCivicNumber().equals(expectedCivicNumber))
			System.out.print("  Error! Expected Invalid. ==== FAILED TEST ====");

		System.out.println("\n");
	}
	
	private static void testSetCivicNumber() {
		System.out.println("\nTesting the setCivicNumber method.");
		testSetCivicNumber("Case 1: Valid - 2086 without leading/trailing spaces",
				"2086","2086",true);
		testSetCivicNumber("Case 2: Invalid null civic number",
				null,"",false);
	}
	
	private static void testSetCivicNumber(String testCase, 
			String civicNumber, String expectedCivicNumber,boolean expectValid){
		System.out.println("   " + testCase);
		Address theAddress = 
				new Address ("3040", "Sherbrooke","Westmount", null, null);
		try {
			theAddress.setCivicNumber(civicNumber);
			System.out.print("\tThe Address instance was created: " + theAddress);
			
			if (!theAddress.getCivicNumber().equals(expectedCivicNumber))
				System.out.print("  Error! Expected Invalid. ==== FAILED TEST ====");
		}
		catch (IllegalArgumentException iae) {
			System.out.print("\t"+ iae.getMessage());
			if (expectValid)
				System.out.print("  Error! Expected Valid. ==== FAILED TEST ====");
		}
		catch (Exception e) {
			System.out.print("\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() + " " +
					e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				System.out.print(" Expected Valid.");
		}

		System.out.println("\n");
	}

	public static void testNoParameterConstructor(){
		Address adr = new Address();
		testNoParameterConstructor("Case 1 - No parameter constructor shouldn't have null instances", adr, true);
		
	}
	
	public static void testNoParameterConstructor(String testCase, Address address, boolean hasntNull){
		
		System.out.println("\t" + testCase);
		
		try{
			System.out.println(address.getCivicNumber().length());
			System.out.println(address.getStreetName().length());
			System.out.println(address.getCity().length());
		
		}
		catch(NullPointerException ne){
			System.out.println("\t" + ne.getMessage());
			if(hasntNull)
			System.out.println("ERROR Expected to not have null in no parameter constructor");
		}
	
	}
	
	public static void testGetStreetName(){
		testGetStreetName("Case 1 - Compare StreetName without trealing. 'sherbrooke' vs 'sherbrooke'" , "sherbrooke", "sherbrooke");
		testGetStreetName("Case 2 - Compare StreetName with trealing. '      sherbrooke      ' vs 'sherbrooke'" , "     sherbrooke     ", "sherbrooke");
		}
	
	private static void testGetStreetName(String testCase, 
			String streetName, String expectedStreetName)
	{
		System.out.println("   " + testCase);
		Address theAddress = 
				new Address ("3040", streetName,"Westmount", null, null);
		System.out.print("\tThe Address instance was created: " + theAddress);

		if (!theAddress.getStreetName().equals(expectedStreetName))
			System.out.print("  Error! Expected Invalid. ==== FAILED TEST ====");

		System.out.println("\n");
	}
	 /*And so on for all getter and setter methods*/
	
	
	/*public static void testGetAddress(){
		Address adr =  new Address("3040", "Sherbrooke", "Westmount", null, null);
		testGetAddress("Case - Instantiate an Address and test String of getAddress", adr);
	}
	
	private static void testGetAddress(String testCase, Address adr){
		System.out.println(testCase);
		
		System.out.println(adr.getAddress());
		
	}*/
	
	public static void testFiveParameterConstructor(){
		Optional<String> opProvince = Optional.ofNullable(null);
		Optional<String> opCode = Optional.ofNullable(null);
		
		testFiveParameterConstructor(
				"Case 1 - Invalid data – null province (3040 Sherbrooke Westmount)",
						"3040","Sherbrooke","Westmount",opProvince,opCode,true);
	}
	
	private static void testFiveParameterConstructor(String testCase, String civicNumber, String streetName, String city, Optional<String> province, Optional<String> code, boolean expectValid){
		System.out.println("   " + testCase);

		
			
			Address theAddress = new Address(civicNumber, streetName, city, province, code);
			System.out.print("\tThe Address instance was created: " + theAddress);
			
			if (!expectValid)
				System.out.print("  Error! Expected Invalid. ==== FAILED TEST ====");
		
		

		System.out.println("\n");
	}
	
	
}

