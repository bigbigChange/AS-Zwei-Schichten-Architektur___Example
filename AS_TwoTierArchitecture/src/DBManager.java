import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dariush
 * 
 * Databank		:: 	customersTest
 * table		::	customers
 * 3 columns	:: 	| customerID | firstName | lastName |
 * user			:: 	dariush
 * password		::	user123!
 * 
 *
 */
public class DBManager implements IDataManager {

	static final String DB_URL = "jdbc:mysql://localhost:3306/customersTest";
	static final String USER = "dariush";
	static final String PASS = "user123!";

	
	private PreparedStatement prepStat = null;
	private Connection conn = null;
	
	// Constructor
	public DBManager () {
		  initDB();		
	}
	
	
	// Begin private methods
	private void initDB() {
	    try {
	      if (conn == null){
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        System.out.println("Connecting to DB ...");
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        System.out.println("Connection to DB successful");
	      }
	    } catch(Exception e) {
	      System.out.println(e.toString());
	    }
	}
	

	private void closeDB(){
	    System.out.println("Closing connection to DB ...");
	    try{
	      if (conn != null){
	        prepStat.close();
	        conn.close();
	        prepStat = null;
	        conn = null;
	      }
	    } catch (Exception e){
	      System.out.println(e.toString());
	    }
	    System.out.println("DB connection is closed.");
	  } 
	// End private methods
	
	
	// Begin methods implemented from Interface
	public void addUser(User user) {
		String fName = user.getFirstName();
		String lName = user.getLastName();
		
	    String sql = "insert into customers (firstName, lastName)" + "values ( ?, ? )";
	    try{
	      prepStat = conn.prepareStatement(sql);
	      prepStat.setString(1, fName);
	      prepStat.setString(2, lName);
	      prepStat.execute();
	    } catch (Exception e) {
	      System.out.println(e.toString());
	    } finally {
	      closeDB();
	    }
	  }

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			prepStat = conn.prepareStatement("select * from customers");
			ResultSet rs = prepStat.executeQuery();  
			
			while(rs.next()){
				
				User u = new User();
				u.setUserID(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				
				users.add(u);  
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		    closeDB();
		}
		return users;
	}
	
	public User getUser(int userID) {
		
		User user = new User();
		
		String sql = "SELECT customerID, firstName, lastName FROM customers WHERE customerID = ?";
	
		try {
			PreparedStatement prepStat = conn.prepareStatement(sql);
			prepStat.setInt(1, userID);
			
			ResultSet rs = prepStat.executeQuery();
			rs.next();
			
			user.setUserID(rs.getInt(1));
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
			
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		    closeDB();
		}
		
		return user;
	}
	
	public void removeUser(int personID) {
		// TODO Auto-generated method stub

	}

	public void modifyUser(User person) {
		// TODO Auto-generated method stub

	}

}
