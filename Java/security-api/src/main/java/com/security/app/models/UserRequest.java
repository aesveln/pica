/**
 * 
 */
package com.security.app.models;

/**
 * @author javier
 *
 */
public class UserRequest {

	private String _userName;
	private String _password;
	
	public UserRequest() {}
	
	public UserRequest(String _userName, String _password) {
		super();
		this._userName = _userName;
		this._password = _password;
	}

	public String getUserName() 
	{
		return _userName;
	}
	
	public void setUserName(String userName) 
	{
		this._userName = userName;
	}
	
	public String getPassword() 
	{
		return _password;
	}
	
	public void setPassword(String password) 
	{
		this._password = password;
	}
}
