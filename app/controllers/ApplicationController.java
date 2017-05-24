package controllers;

import java.util.*;

import models.post.*;
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
		// final Post frontPost = YabeRepo.findFrontPost();

		final Post frontPost = Post.find("order by postedAt desc").first();

		final List<Post> olderPosts = PostRepo.findOlderPosts();
		System.out.println(frontPost);
		render(frontPost, olderPosts);
	}

	public static void show(final Long id) {
		final Post post = Post.findById(id);
		render(post);
	}

	public static void postComment(final Long postId,
			@Required final String author, @Required final String content) {
		final Post post = Post.findById(postId);
		if (validation.hasErrors()) {
			render("ApplicationController/show.html", post);
		}
		post.addComment(author, content);
		flash.success("Thanks for posting %s", author);
		show(postId);
	}
}