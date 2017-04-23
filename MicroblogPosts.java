import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class MicroblogPosts {
	static Scanner keyboard = new Scanner(System.in);
	public static List<Post> posts = new ArrayList<>();

	public String getDate() {
		LocalDate localDate = new LocalDate();
		LocalTime localTime = new LocalTime();
		String postDateTime = localDate.toString() + " " + localTime;
		return postDateTime;
	}

	public String changePostContentToString(String postContent, User currentUser) {
		StringBuilder sb = new StringBuilder();
		sb.append(getDate());
		sb.append(" ");
		sb.append(currentUser.getUserName() + ": ");
		sb.append(postContent);
		sb.append("\n");
		String formattedPost = sb.toString();
		return formattedPost;
	}

	public Post createPost(User currentUser) {
		Post post = new Post(currentUser);
		out.println("Please type out your post here: ");
		String postContent = keyboard.nextLine();
		post.setPostContent(postContent);
		post.setPostOrder(posts.size());
		posts.add(post);// somehow add current user and properties here
		String formattedPost = changePostContentToString(postContent, currentUser);
		ReadWriteFiles.writeToFile(formattedPost, "userPosts.txt");
		return post;
	}
}
