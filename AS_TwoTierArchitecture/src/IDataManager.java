import java.util.List;

/**
 * @author dariush
 *
 */
public interface IDataManager {
	
	public void addUser(User user);
	
	public void removeUser(int personID);
	
	public void modifyUser(User user);
	
	public List<User> getAllUsers();

	public User getUser(int userID);

}
