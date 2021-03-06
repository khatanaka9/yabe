//import java.util.*;
//
//import models.*;
//
//import org.junit.*;
//
//import play.test.*;
//
//public class BasicTest extends UnitTest {
//
//	@Before
//	public void setup() {
//		Fixtures.deleteDatabase();
//	}
//
//	@Test
//	public void createAndRetrieveUser() {
//		// Create a new user and save it
//		new User("bob@gmail.com", "secret", "Bob").save();
//
//		// Retrieve the user with e-mail address bob@gmail.com
//		final User bob = User.find("byEmail", "bob@gmail.com").first();
//
//		// Test
//		assertNotNull(bob);
//		assertEquals("Bob", bob.fullname);
//	}
//
//	@Test
//	public void tryConnectAsUser() {
//		// Create a new user and save it
//		new User("bob@gmail.com", "secret", "Bob").save();
//
//		// Test
//		assertNotNull(User.connect("bob@gmail.com", "secret"));
//		assertNull(User.connect("bob@gmail.com", "badpassword"));
//		assertNull(User.connect("tom@gmail.com", "secret"));
//	}
//
//	@Test
//	public void createPost() {
//		// Create a new user and save it
//		final User bob = new User("bob@gmail.com", "secret", "Bob").save();
//
//		// Create a new post
//		new Post(bob, "My first post", "Hello world").save();
//
//		// Test that the post has been created
//		final List<Post> bobPosts = Post.find("byAuthor", bob).fetch();
//
//		// Tests
//		assertEquals(1, bobPosts.size());
//		final Post firstPost = bobPosts.get(0);
//		assertNotNull(firstPost);
//		assertEquals(bob, firstPost.author);
//		assertEquals("My first post", firstPost.title);
//		assertEquals("Hello world", firstPost.content);
//		assertNotNull(firstPost.postedAt);
//
//	}
//
//	@Test
//	public void useTheCommentsRelation() {
//		// Create a new user and save it
//		final User bob = new User("bob@gmail.com", "secret", "Bob").save();
//
//		// Create a new post
//		Post bobPost = new Post(bob, "My first post", "Hello world").save();
//
//		// Post a first comment
//		bobPost.addComment("Jeff", "Nice Post");
//		bobPost.addComment("Tom", "I knew that!");
//
//		// Count things
//		assertEquals(1, User.count());
//		assertEquals(1, Post.count());
//		assertEquals(2, Comment.count());
//
//		// Retrieve Bob's post
//		bobPost = Post.find("byAuthor", bob).first();
//		assertNotNull(bobPost);
//
//		// Navigate to comments
//		assertEquals(2, bobPost.comments.size());
//		assertEquals("Jeff", bobPost.comments.get(0).author);
//
//		// Delete the post
//		bobPost.delete();
//
//		// Check that all comments have been deleted
//		assertEquals(1, User.count());
//		assertEquals(0, Post.count());
//		assertEquals(0, Comment.count());
//	}
//
//	@Test
//	public void postComments() {
//		// Create a new user and save it
//		final User bob = new User("bob@gmail.com", "secret", "Bob").save();
//
//		// Create a new post
//		final Post bobPost = new Post(bob, "My first post", "Hello world")
//				.save();
//
//		// Post a first comment
//		new Comment(bobPost, "Jeff", "Nice post").save();
//		new Comment(bobPost, "Tom", "I knew that!").save();
//
//		// Retrieve all comments
//		final List<Comment> bobPostComments = Comment.find("byPost", bobPost)
//				.fetch();
//
//		// Tests
//		assertEquals(2, bobPostComments.size());
//
//		final Comment firstComment = bobPostComments.get(0);
//		assertNotNull(firstComment);
//		assertEquals("Jeff", firstComment.author);
//		assertEquals("Nice post", firstComment.content);
//		assertNotNull(firstComment.postedAt);
//
//		final Comment secondComment = bobPostComments.get(1);
//		assertNotNull(secondComment);
//		assertEquals("Tom", secondComment.author);
//		assertEquals("I knew that!", secondComment.content);
//		assertNotNull(secondComment.postedAt);
//
//	}
//
// }
