package com.tayani.app.model.authentication;

/**
 * @author Aditya Rajurkar
 * 
 * Purpose of this class is to store data about the user using the application
 * */

public class UserData {
	
	private String name;
	private String password;
	private UserRole role;
	
	/**
	 * The no argument constructor
	 * */
	private UserData(){
		
	}
	
	
	public UserData(String name, String password, UserRole role) {
		this.name = name;
		this.password = password;
		this.role = role;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the role
	 */
	public UserRole getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(UserRole role) {
		this.role = role;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("UserData [name=");
		builder.append(name);
		builder.append(", password=");
		builder.append(password);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}
	

}
