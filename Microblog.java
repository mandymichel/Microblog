import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Microblog {
	public static List<User> users = new ArrayList<>();
	static Scanner keyboard = new Scanner(System.in);

	public String changeUserListToString(List<User> users) {
		StringBuilder sb = new StringBuilder();
		for (User u : users) {
			sb.append(u.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * This is the method where the blog gets personal info from each user.
	 * 
	 * @return This returns one new user, complete with the 5 types of personal
	 *         information
	 */

	public User createUser() {
		out.println("Type in your first name.");
		String firstName = keyboard.next();
		out.println("Type in your last name.");
		String lastName = keyboard.next();
		out.println("Type in your desired user name.");
		String userName = keyboard.next();
		out.println("Type in your email address.");
		String emailAddress = keyboard.next();
		out.println("Type in your avatar address.");
		String avatarAddress = keyboard.next();
		return new User(firstName, lastName, userName, emailAddress, avatarAddress);
	}

	/**
	 * This method prints out a list of users.
	 * 
	 * @param iter
	 *            This is the iterator that goes through the array list, users,
	 *            item by item.
	 * @param users
	 *            This is a array list of users (different people who have a
	 *            compete set of personal information entered).
	 */

	public String printUsers() {
		String printedList = ReadWriteFiles.readFile("userInfo.txt");
		String eachline = null;
		Scanner inputScanner = new Scanner(printedList);
		String[] strArray = null;
		List<String> strList = new ArrayList<String>();
		while (inputScanner.hasNext()) {
			eachline = inputScanner.nextLine();
			strArray = eachline.split(" ");
			strList = Arrays.asList(strArray);
			String userName = strList.get(0);
			out.println(strList.get(0));
		}

		/*
		 * Iterator iter = users.iterator(); while (iter.hasNext()) { User user
		 * = (User) iter.next();
		 * 
		 * out.println(user);
		 */
		return printedList;
	}

	/**
	 * This method allows a user to select a user that she/he would like to use
	 * to author posts.
	 * 
	 * @return This method returns the currentUser, whichever user was selected.
	 */
	public User selectUserFromList() {
		String searchCriteria = null;
		User user = null;
		User currentUser = null;
		String eachline = null;
		String[] strArray = null;
		List<String> strList = new ArrayList<String>();
		String userList = printUsers();
		boolean found = false;
		Scanner inputScanner = new Scanner(userList);
		while (inputScanner.hasNext()) {
			eachline = inputScanner.nextLine();
			strArray = eachline.split(" ");
			strList = Arrays.asList(strArray);
			String userName = strList.get(0);
			String firstname = strList.get(1);
			String lastname = strList.get(2);
			String emailAddress = strList.get(3);
			String avatarAddress = strList.get(4);
			user = new User(firstname, lastname, userName, emailAddress, avatarAddress);
			users.add(user);
		}
		do {
			out.println("Which user would you like to use to author your posts? (Enter only their user name) ");
			searchCriteria = keyboard.next();// need to search file, not list
			for (int i = 0; i < users.size(); i++) {
				user = users.get(i);
				if (user.getUserName().equals(searchCriteria)) {
					found = true;
					currentUser = user;
					break;
				}
			}

		} while (!found);
		String userPosts = ReadWriteFiles.readFile("userPosts.txt");
		inputScanner = new Scanner(userPosts);
		while (inputScanner.hasNext()) {
			eachline = inputScanner.nextLine();
			if (eachline.contains((CharSequence) currentUser.getUserName())) {
				out.println(eachline);
			}
		}
		return currentUser;
	}

	public void postContent(User currentUser) {
		String printedList = ReadWriteFiles.readFile("userPosts.txt");
		String eachline = null;
		Scanner inputScanner = new Scanner(printedList);
		while (inputScanner.hasNext()) {
			eachline = inputScanner.nextLine();
			out.println(eachline);
		}
	}

	public void printMenu(User currentUser) {
		out.println("Main Menu");
		out.println("1. Create a new user");
		out.println("2. Become an existing user");
		out.println("3. Create a post as the current user");
		out.println("4. Print all posts");
		out.println("5. Print all users");
		out.println("9. exit");
		if (currentUser != null) {
			out.println("Please make another selection, " + currentUser.getUserName() + ": ");
		}
	}

	public void run() {
		User currentUser = null;
		Scanner keyboard = new Scanner(System.in);
		int menuchoice;
		String allUsers = null;
		do {
			printMenu(currentUser);
			menuchoice = keyboard.nextInt();
			switch (menuchoice) {
			case 1:
				User user = createUser();
				users.add(user);
				// allUsers = changeUserListToString(users);
				String userinfo = user.toString();
				ReadWriteFiles.writeToFile(userinfo, "userInfo.txt");
				break;
			case 2:
				currentUser = selectUserFromList();
				break;
			case 3:
				// create a post
				if (currentUser == null) {
					continue;
				}
				MicroblogPosts p = new MicroblogPosts();
				p.createPost(currentUser); // calls createPost method
				// with current user as
				// parameter
				break;
			case 4:
				// print all posts
				postContent(currentUser); // calls postContent method which
											// iterates over the posts and
											// prints them all
				break;
			case 5:
				// iterate over the users and print their names.
				printUsers();
				break;
			}
		} while (menuchoice != 9);
		out.println("Goodbye, " + currentUser.getUserName() + "!");
	}

	public static void main(String[] args) {
		Microblog m = new Microblog();
		m.run();
	}

}
