/**
 * 
 */
package com.security.app.services;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.security.app.models.UserInfo;
import com.security.app.models.UserRequest;

/**
 * @author javier
 *
 */
@javax.ws.rs.Path("auth")
@Service
public class UserService {
	
	private List<UserInfo> userArray =  Arrays.asList(
			new UserInfo("JonDoe@dominio.com","Jon", "Doe", "Gold"),
			new UserInfo("JonDoe1@dominio.com","Jon1", "Doe1", "Gold"),
			new UserInfo("JonDoe2@dominio.com","Jon2", "Doe2", "Gold")
		);
	
	
	public List<UserInfo> getUserInfo(){
		return userArray;
	}
	
	public Response getUserInfoById(UserRequest userRequest) {
		
		boolean status = userArray.stream().filter(t -> t.getUserName().equals(userRequest.getUserName())).count() > 0;
		//UserInfo info = userArray.stream().filter(t -> t.getUserName().equals(userRequest.getUserName())).findFirst().get();
				
		return com.security.app.infraestructure.JwtApplication.JwtToken(status, "Hola");
	}
}
