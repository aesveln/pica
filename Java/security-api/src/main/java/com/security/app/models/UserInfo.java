/**
 * 
 */
package com.security.app.models;

/**
 * @author javier
 *
 */
public class UserInfo {
	private String userName;
	private String firstName;
	private String lastName;
	private String customerCategory;
	
	public UserInfo() {}
	
	public UserInfo(String userName, String firstName, String lastName, String customerCategory) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerCategory = customerCategory;
	}

	public String getUserName() 
	{
		return userName;
	}
	
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getCustomerCategory() 
	{
		return customerCategory;
	}
	
	public void setCustomerCategor(String customerCategory) 
	{
		this.customerCategory = customerCategory;
	}
}
