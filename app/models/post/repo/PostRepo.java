package models.post.repo;

import java.util.*;

import models.post.*;

public class PostRepo {

	// findFrontPost

	public static Post findFrontPost() {
		return Post.find("order by postedAt desc").first();
	}

	public static Post showFindby(final Long id) {
		return Post.findById(id);
	}

	public static Post postComment(final Long postId) {
		return Post.findById(postId);
	}

	public static Post previousFind(final Date postedAt) {
		return Post.find("postedAt < ? order by postedAt desc", postedAt)
				.first();
	}

	public static Post nextFind(final Date postedAt) {
		return Post.find("postedAt > ? order by postedAt asc", postedAt)
				.first();
	}
}
