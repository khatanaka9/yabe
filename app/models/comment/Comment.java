package models.comment;

import java.util.*;

import javax.persistence.*;

import models.post.*;
import play.db.jpa.*;

@Entity
public class Comment extends Model {

	// TODO hatanaka privateに修正（ゲッター必要）
	public String author;
	public Date postedAt;

	@Lob
	public String content;

	@ManyToOne
	public Post post;

	public Comment(final Post post, final String author, final String content) {
		this.post = post;
		this.author = author;
		this.content = content;
		this.postedAt = new Date();
	}

}
