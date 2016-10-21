/**
 * 
 */
package dw317.lib;

/**
 * @author Danny Manzano
 *
 */
public class EmailTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		constructorTest("Case - instantiate the constructor and see if there is exception thrown with 'testemail@email.com' address", "testemail@email.com");
		toStringTest("Case - testing toString() should be returning 'testemail@email.com' ", "testemail@email.com");
		getUserIdTest("Case - testing getUserId() should be returning 'testemail'","testemail@email.com");
		getHostTest("Case - testing getHost() should be returning 'email.com' ","testemail@email.com");
		getAddressTest("Case - testing getAddress() should be returning 'testemail@email.com'", "testemail@email.com");
		equalsTest("Case1 - testing equals() method input 'testemail@email.com' & 'testemial@email.com'. Expected: to be true", "testemail@email.com", "testemail@email.com");
		equalsTest("Case2 - testing equals() method input 'testemail@email.com' & 'testemial2@email.com'. Expected: to be false", "testemail@email.com", "testemail2@email.com");
		compareToTest("Case1 - testing compareTo() method input 'testemail@email.com' & 'testemial@email.com'. Expected: to give 0", "david_ferguson1@google.ca", "david_ferguson11@google.ca");
		compareToTest("Case2 - testing compareTo() method input 'abc@email.com' & 'def@email.com'. Expected: to give -1", "abc@email.com", "def@email.com");
		compareToTest("Case3 - testing compareTo() method input 'def@email.com' & 'abc@email.com'. Expected: to give 1", "def@email.com", "abc@email.com");
		compareToTest("Case4 - testing compareTo() method input 'testemail@abc.com' & 'testemial@def.com'. Expected: to give -1", "testemail@abc.com", "testemail@def.com");
		compareToTest("Case5 - testing compareTo() method input 'testemail@def.com' & 'testemial@abc.com'. Expected: to give 1", "testemail@def.com", "testemail@abc.com");
		validateEmailTest("Case 1 - testing validateEmail() method in the constructor input 'testemail@email.com'. Expected: Validation successful ", "testemail@email.com");
		validateEmailTest("Case 2 - testing validateEmail() method in the constructor input 'test#mail@email.com'. Expected: Validation Failed ", "test#mail@email.com");
		validateEmailTest("Case 3 - testing validateEmail() method in the constructor input 'test..email@email.com'. Expected: Validation Failed ", "test..email@email.com");
		validateEmailTest("Case 4 - testing validateEmail() method in the constructor input 'testemail.@email.com'. Expected: Validation Failed ", "testemail.@email.com");
		validateEmailTest("Case 5 - testing validateEmail() method in the constructor input 'testemail@@mail.com'. Expected: Validation Failed ", "testemail@@mail.com");
		validateEmailTest("Case 6 - testing validateEmail() method in the constructor input 'testemail@email.com'. Expected: Validation Failed ", "testemail@-email.com");
		System.out.println("david_ferguson1".compareTo("david_ferguson11"));
		
	}
	
	private static void constructorTest(String caseTest, String address){
		System.out.println("\n constructorTest method");
		System.out.println(caseTest);
		try{
			Email testEmail = new Email(address);
			System.out.println("instantiation has been successfull");
		}
		catch(Exception e){
			System.out.println("Error there shouldn't be an exception");
		}
		
	}
	
	private static void toStringTest(String caseTest, String address){
		System.out.println("\n toStringTest method");
		System.out.println(caseTest);
		Email testEmail = new Email(address);
		System.out.println(testEmail.toString());
	}
	
	private static void getUserIdTest(String caseTest, String address){
		System.out.println("\n getUserIdTest method");
		System.out.println(caseTest);
		Email testEmail = new Email(address);
		System.out.println(testEmail.getUserId());
	}
	
	private static void getHostTest(String caseTest, String address){
		System.out.println("\n getHostTest method");
		System.out.println(caseTest);
		Email testEmail = new Email(address);
		System.out.println(testEmail.getHost());
	}
	
	private static void getAddressTest(String caseTest, String address){
		System.out.println("\n getAddressTest method");
		System.out.println(caseTest);
		Email testEmail = new Email(address);
		System.out.println(testEmail.getAddress());
	}
	
	private static void equalsTest(String caseTest, String email1, String email2){
		System.out.println("\n equalsTest method");
		System.out.println(caseTest);
		Email testEmail1 = new Email(email1);
		Email testEmail2 = new Email(email2);
		System.out.println("Result: " + testEmail1.equals(testEmail2));
	}
	
	private static void compareToTest(String caseTest, String email1, String email2){
		System.out.println("\n compareToTest method");
		System.out.println(caseTest);
		Email testEmail1 = new Email(email1);
		Email testEmail2 = new Email(email2);
		System.out.println("Result: " + testEmail1.compareTo(testEmail2));
	}
	
	private static void validateEmailTest(String caseTest, String address){
		System.out.println("\n validateEmail method");
		System.out.println(caseTest);
		try{
			Email testEmail = new Email(address);
			System.out.println("Result: Validation successful");
		}
		catch(IllegalArgumentException e){
			System.out.println("Result: Validation failed " + e.getMessage());
		}
	}
}
