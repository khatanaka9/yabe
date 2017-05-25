package models.post;

import java.util.*;

import javax.persistence.*;

import models.comment.*;
import models.user.*;
import play.db.jpa.*;

@Entity
public class Post extends Model {

	private final String title;
	private final Date postedAt;

	@Lob
	private final String content;

	@ManyToOne
	private final User author;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	public List<Comment> comments;

	public Post(final User author, final String title, final String content) {
		this.author = author;
		this.title = title;
		this.content = content;
		this.postedAt = new Date();
		this.comments = new ArrayList<Comment>();

	}

	public Post addComment(final String author, final String content) {
		final Comment newComment = new Comment(this, author, content).save();
		this.comments.add(newComment);
		this.save();

		return this;
	}

	public Post previous() {
		return Post.find("postedAt < ? order by postedAt desc", postedAt)
				.first();
	}

	public Post next() {
		return Post.find("postedAt > ? order by postedAt asc", postedAt)
				.first();
	}

	/**
	 * titleを取得します。
	 * @return title
	 */
	public String getTitle() {
	    return title;
	}

	/**
	 * postedAtを取得します。
	 * @return postedAt
	 */
	public Date getPostedAt() {
	    return postedAt;
	}

	/**
	 * contentを取得します。
	 * @return content
	 */
	public String getContent() {
	    return content;
	}

	/**
	 * authorを取得します。
	 * @return author
	 */
	public User getAuthor() {
	    return author;
	}

}
