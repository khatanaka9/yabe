package models.post.collection;

import java.util.*;

import models.post.*;
import models.post.repo.*;

public class PostCollection {

	// TODO hatanaka フィールドでlist<post>をもって管理する

	public PostCollection olderPosts() {
		final List<Post> olderPosts = PostRepo.findOlderPosts();
		return this;
	}

}
