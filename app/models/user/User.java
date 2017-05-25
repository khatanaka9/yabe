package models.user;

import javax.persistence.*;

import jdk.nashorn.internal.objects.annotations.*;
import play.db.jpa.*;

@Entity
public class User extends Model {

	private final String email;
	private final String password;
	private final String fullname;
	private boolean isAdmin;

	public User(final String email, final String password, final String fullname) {
		this.email = email;
		this.password = password;
		this.fullname = fullname;
	}

	public static User connect(final String email, final String password) {
		return find("byEmailAndPassword", email, password).first();
	}

	/**
	 * emailを取得します。
	 * @return email
	 */
	public String getEmail() {
	    return email;
	}

	/**
	 * passwordを取得します。
	 * @return password
	 */
	public String getPassword() {
	    return password;
	}

	/**
	 * fullnameを取得します。
	 * @return fullname
	 */
	public String getFullname() {
	    return fullname;
	}

	/**
	 * isAdminを取得します。
	 * @return isAdmin
	 */
	public boolean isAdmin() {
	    return isAdmin;
	}

}
