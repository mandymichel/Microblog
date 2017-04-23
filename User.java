import java.util.ArrayList;
import java.util.List;

/**
 * Improvement ideas: Different sub forums, make it so you can update user
 * information, GUI
 * 
 * @version (3/19/17)
 */
public class User {
	private String avatarAddress;
	private String userName;
	private String firstName;
	private String lastName;
	private String emailAddress;
	public List<String> usersString = new ArrayList<>();

	/**
	 * This method instantiates the variables needed for users to input their
	 * info in the microblog.
	 * 
	 * @param firstname
	 *            is the first name of the user
	 * @param lastname
	 *            is the last name of the user
	 * @param username
	 *            is the chosen username of the user
	 * @param email
	 *            is the email address of the user
	 * @param avatar
	 *            is the chosen avatar web address of the user
	 * 
	 */
	public User() {

	}

	public User(String firstname, String lastname, String username, String email, String avatar) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.userName = username;
		this.emailAddress = email;
		this.avatarAddress = avatar;
	}

	public String toString() {
		return this.userName + " " + this.firstName + " " + this.lastName + " " + this.emailAddress + " "
				+ this.avatarAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getAvatarAddress() {
		return this.avatarAddress;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setAvatarAddress(String avatarAddress) {
		this.avatarAddress = avatarAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}