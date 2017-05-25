package models.comment;

import java.util.*;

import javax.persistence.*;

import models.post.*;
import play.db.jpa.*;

@Entity
public class Comment extends Model {

	private final String author;
	private final Date postedAt;

	@Lob
	private final String content;

	@ManyToOne
	private final Post post;

	public Comment(final Post post, final String author, final String content) {
		this.post = post;
		this.author = author;
		this.content = content;
		this.postedAt = new Date();
	}

	/**
	 * authorを取得します。
	 * 
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * postedAtを取得します。
	 * 
	 * @return postedAt
	 */
	public Date getPostedAt() {
		return postedAt;
	}

	/**
	 * contentを取得します。
	 * 
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * postを取得します。
	 * 
	 * @return post
	 */
	public Post getPost() {
		return post;
	}

}
