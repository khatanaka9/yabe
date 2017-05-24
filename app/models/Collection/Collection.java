package models.Collection;

import java.util.*;

import models.*;
import models.repo.*;

public class Collection {

	public Collection olderPosts() {
		final List<Post> olderPosts = YabeRepo.findOlderPosts();
		return this;
	}

}
