package models.comment.repo;

import java.util.*;

import models.comment.*;
import models.post.*;

public class CommentRepo {

	public static List<Comment> findByComment(final Post post) {
		return Comment.find("post = ?", post).fetch();
	}
}
