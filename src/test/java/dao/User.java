package dao;

import javax.persistence.Column;

import org.hibernate.annotations.SqlFragmentAlias;

/**
 * @author di
 */
public class User {
	private Integer userId;
	private String userName;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
