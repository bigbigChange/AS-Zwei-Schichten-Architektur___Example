

public class UserMainClass {
	public static void main(String[] args) {
		new GUI(new DBManager());
		
		/*
		 * DBManager dbm = new DBManager(); List<User> users = new ArrayList<User>();
		 * users = dbm.getAllUsers();
		 * 
		 * for(User u : users) { System.out.println( u.getUserID()+ ", " +
		 * u.getFirstName() + ", " + u.getLastName()); }
		 */
		
	}
}
