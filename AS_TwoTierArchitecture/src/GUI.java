import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtUserId;
	private JTextArea textArea;

	private IDataManager datenhaltung;

	// Constructor 1
	public GUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		TextField textField_1 = new TextField();
		textField_1.setBounds(146, 35, -102, 22);
		contentPane.add(textField_1);

		txtFirstName = new JTextField();
		txtFirstName.setText("first name");
		txtFirstName.setBounds(50, 31, 130, 26);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);

		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnAddUser();
			}
		});
		btnAddUser.setBounds(305, 31, 117, 29);
		contentPane.add(btnAddUser);

		txtLastName = new JTextField();
		txtLastName.setText("last name");
		txtLastName.setBounds(40, 74, 130, 26);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);

		textArea = new JTextArea();
		textArea.setBounds(51, 164, 167, 85);
		contentPane.add(textArea);

		JButton btnNewButton_1 = new JButton("Get User");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnGetUser();
			}
		});
		btnNewButton_1.setBounds(264, 196, 117, 29);
		contentPane.add(btnNewButton_1);

		txtUserId = new JTextField();
		txtUserId.setText("user id");
		txtUserId.setBounds(251, 146, 130, 26);
		contentPane.add(txtUserId);
		txtUserId.setColumns(10);
		setVisible(true);
	}

	// Constructor 2
	public GUI(DBManager db) {
		this();
		this.datenhaltung = db; // set DBManager object to Interface
	}

	private void btnAddUser() {
		String fName = txtFirstName.getText();
		String lName = txtLastName.getText();
		User user = new User();
		user.setFirstName(fName);
		user.setLastName(lName);
		datenhaltung.addUser(user);
	}

	private void btnGetUser() {
		int userID = Integer.parseInt(txtUserId.getText());
		User user = datenhaltung.getUser(userID);

		textArea.append(Integer.toString(user.getUserID()));
		textArea.append(user.getFirstName());
		textArea.append(user.getLastName());

	}
}
