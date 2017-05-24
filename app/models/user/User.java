package models.user;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class User extends Model {

	public String email;
	public String password;
	public String fullname;
	public boolean isAdmin;

	public User(final String email, final String password, final String fullname) {
		this.email = email;
		this.password = password;
		this.fullname = fullname;
	}

	public static User connect(final String email, final String password) {
		return find("byEmailAndPassword", email, password).first();
	}

}
