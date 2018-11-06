/**
 *
 */
package co.com.toures.b2c.users.conf;

import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;

import co.com.toures.b2c.users.dto.admcyo.CustomerDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author javier
 *
 */
public class JwtApplication {

    public static String JwtToken(boolean status, String obj, CustomerDTO customerDTO)
    {
        if(status)
        {
            String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9eyJpc3MiOiJhdXRoMCJ9AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEpzWfOkEE";

            long times = System.currentTimeMillis();

            @SuppressWarnings("deprecation")
            String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, token)
                    .setSubject(customerDTO.getFirstName() +" "+ customerDTO.getLastName())
                    .claim("email", customerDTO.getEmail())
                    .claim("category", customerDTO.getCategory())
                    .claim("firstName", customerDTO.getFirstName())
                    .claim("lastName", customerDTO.getLastName())
                    .claim("documnetNumber", customerDTO.getDocumentNumber())
                    .claim("phoneNumber", customerDTO.getPhoneNumber())
                    .claim("idCustomer", customerDTO.getIdCustomer())
                    .claim("category", customerDTO.getCategory())
                    .setIssuedAt(new Date(times))
                    .setExpiration(new Date(times+900000))
                    .compact();

            JsonObject json = Json.createObjectBuilder()
                    .add("JWT", jwt).build();

            return jwt;
            //userArray.stream().filter(t -> t.getUserName().equals(userRequest.getUserName())).findFirst().get();
        }

        return "";

    }

}
