
/**
 * This class is focused on creating posts on the microblog app. Figure out how
 * to make a post object, like I did for User. Amanda Michel 12/24/2016
 */
public class Post {

	// instance variables
	private String postUser;
	private int postOrder;
	private String postContent;
	User author = null;

	public Post() {

	}

	public Post(User author) {
		this.author = author;
	}

	public void setPostUser(String postUser) {
		this.postUser = postUser;
	}

	public String getPostUser() {
		return postUser;
	}

	public void setPostOrder(int postOrder) {
		this.postOrder = postOrder;
	}

	public int getPostOrder() {
		return postOrder;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostContent() {
		return postContent;
	}

	public String toString() {
		return "Post #" + (this.postOrder + 1) + ": " + this.postContent + "\n" + ", by: " + author.getUserName()
				+ " email address:  " + author.getEmailAddress() + " avatar address: " + author.getAvatarAddress()
				+ "\n";
	}

}
