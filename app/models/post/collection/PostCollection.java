package models.post.collection;

import java.util.*;

import models.base.*;
import models.post.*;

public class PostCollection extends
		AbstractCollection2<AbstractCollection2, Post> {

	// TODO hatanaka フィールドでlist<post>をもって管理する。作成途中

	public PostCollection(final List<Post> list) {
		super(list);

	}

	public static List<Post> olderPosts() {
		return Post.find("order by postedAt desc").from(1).fetch(10);
	}

}
