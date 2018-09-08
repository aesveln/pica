/**
 * 
 */
package com.security.app.infraestructure;

import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author javier
 *
 */
public class JwtApplication {

	public static Response JwtToken(boolean status, String obj) 
	{
		if(status) 
		{
			String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9eyJpc3MiOiJhdXRoMCJ9AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEpzWfOkEE";

			long times = System.currentTimeMillis();
						
			@SuppressWarnings("deprecation")
			String jwt = Jwts.builder()
							 .signWith(SignatureAlgorithm.HS256, token)
							 .setSubject("Jon Doe")
							 .claim("email", "JonDoe@dominio.com")
							 .claim("category", "Gold")
							 .claim("firstName", "Jon")
							 .claim("lastName", "Doe")
							 .setIssuedAt(new Date(times))
							 .setExpiration(new Date(times+900000))
							 .compact();
			
			JsonObject json = Json.createObjectBuilder()
								  .add("JWT", jwt).build();
			
			return Response.status(Response.Status.CREATED).entity(json).build();
			 //userArray.stream().filter(t -> t.getUserName().equals(userRequest.getUserName())).findFirst().get();
		}
		
		return Response.status(Response.Status.UNAUTHORIZED).build();
		
	}
		
}
