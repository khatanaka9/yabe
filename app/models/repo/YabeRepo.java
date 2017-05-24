package models.repo;

import java.util.*;

import models.*;

public class YabeRepo {

	// findFrontPost

	// public static Post findFrontPost() {
	// return Post.find("order by postedAt desc").first();
	// }

	// olderPosts
	public static List<Post> findOlderPosts() {
		return Post.find("order by postedAt desc").from(1).fetch(10);

	}

}
