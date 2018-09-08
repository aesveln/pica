/**
 * 
 */
package com.security.app.controllers;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.security.app.models.UserInfo;
import com.security.app.models.UserRegisterRequest;
import com.security.app.models.UserRequest;
import com.security.app.services.UserService;

/**
 * @author javier
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value =  "/api/Security/Register")
	public List<UserInfo> RegisterUser(@RequestBody UserRegisterRequest userRegisterRequest) {
	
		return userService.getUserInfo();
	
	}
	
	@RequestMapping(method = RequestMethod.POST, value =  "/api/Security/Login")
	public Response ValidateUser(@RequestBody UserRequest userRequest) {
		
		return userService.getUserInfoById(userRequest);
	
	}
	
}
