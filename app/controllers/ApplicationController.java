package controllers;

import java.util.*;

import models.post.*;
import models.post.collection.*;
import models.post.repo.*;
import play.*;
import play.data.validation.*;
import play.mvc.*;

public class ApplicationController extends Controller {

	@Before
	static void addDefaults() {
		renderArgs.put("blogTitle",
				Play.configuration.getProperty("blog.title"));
		renderArgs.put("blogBaseline",
				Play.configuration.getProperty("blog.baseline"));
	}

	public static void index() {
		final Post frontPost = PostRepo.findFrontPost();
		final List<Post> olderPosts = PostCollection.olderPosts();
		render(frontPost, olderPosts);
	}

	public static void show(final Long id) {
		final Post post = PostRepo.showFindby(id);
		render(post);
	}

	public static void postComment(final Long postId,
			@Required final String author, @Required final String content) {
		final Post post = PostRepo.postComment(postId);

		if (validation.hasErrors()) {
			render("ApplicationController/show.html", post);
		}
		post.addComment(author, content);
		flash.success("Thanks for posting %s", author);
		show(postId);
	}
}