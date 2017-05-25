package models.post.repo;

import java.util.*;

import models.post.*;

public class PostRepo {

	public static Post findByPostedAtFirst() {
		return Post.find("order by postedAt desc").first();
	}

	public static List<Post> findByPostedAt() {
		return Post.find("order by postedAt desc").from(1).fetch(10);
	}

	public static Post findByPostedAtPrevious(final Date postedAt) {
		return Post.find("postedAt < ? order by postedAt desc", postedAt)
				.first();
	}

	public static Post findByPostedAtNext(final Date postedAt) {
		return Post.find("postedAt > ? order by postedAt asc", postedAt)
				.first();
	}
}
