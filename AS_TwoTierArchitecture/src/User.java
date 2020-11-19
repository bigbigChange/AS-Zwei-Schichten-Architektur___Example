 
/**
 * @author dariush
 *
 */
public class User {
	
	private String firstName;
	private String lastName;
	private int		userID;
	
	
	// Constructor
	public User() {
		firstName 	= null;
		lastName 	= null;
	}
	
	// Begin getter and setter methods
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	
	public void setLastName(String lname) {
		this.lastName = lname;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public int getUserID() {
		return userID;
	}
	

}
