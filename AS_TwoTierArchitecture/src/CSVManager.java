import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author dariush
 *
 */
public class CSVManager implements IDataManager {
	
	
	private String file = 			"/Users/dariush/studentNamesCSV.csv";
	private String delimiter = 		";";
	private String line = "";

	// Constructor 1
	public CSVManager() {
	}

	// Constructor 2
	public CSVManager(String delimiter, String file) {
		this.delimiter = delimiter;
		this.file = file;
	}
	
	// Begin Methods

	public List<User> getAllUsers() {

		List<User> users = new ArrayList<User>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			while ((line = br.readLine()) != null) {
					
				String[] user = line.split(delimiter);
				
				users.add(new User(user[1], user[0]));

			}
			
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	public void printAll(List<User> students) {
		for (User s : students) {
			System.out.println(s.getFirstName());
		}
	}
	

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(int personID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

}
