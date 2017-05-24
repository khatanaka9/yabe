package models;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class User extends Model {

	private final String email;
	private final String password;
	private final String fullname;
	private boolean isAdmin;

	private User(final String email, final String password,
			final String fullname) {
		this.email = email;
		this.password = password;
		this.fullname = fullname;
	}

	public static User connect(final String email, final String password) {
		return find("byEmailAndPassword", email, password).first();
	}

}
