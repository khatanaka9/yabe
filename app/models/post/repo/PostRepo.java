package models.post.repo;

import java.util.*;

import models.post.*;

public class PostRepo {

	// findFrontPost

	// public static Post findFrontPost() {
	// return Post.find("order by postedAt desc").first();
	// }

	// olderPosts
	public static List<Post> findOlderPosts() {
		return Post.find("order by postedAt desc").from(1).fetch(10);

	}

}
