package models;

import javax.persistence.*;

import org.joda.time.*;

import play.db.jpa.*;

@Entity
public class Comment extends Model {

	private final String author;
	private final DateTime postedAt;

	@Lob
	private final String content;

	@ManyToOne
	private final Post post;

	public Comment(final Post post, final String author, final String content) {
		this.post = post;
		this.author = author;
		this.content = content;
		this.postedAt = new DateTime();
	}

}
