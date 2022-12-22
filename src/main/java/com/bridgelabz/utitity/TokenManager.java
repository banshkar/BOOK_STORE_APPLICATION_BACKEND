package com.bridgelabz.utitity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.bridgelabz.dto.Login;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class TokenManager  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String jwtSecret="qwertyuioplkjhgfdsazxcvbnm";
	
	public String generateToken(Login login) {
		Map<String, Object>claim =new HashMap<>();
		String token = Jwts.builder().setClaims(claim).setSubject(login.getEmail())
				.signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
		return token;
	}
   public String getEmailDecode(String token) {
	   final Claims claim =Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	    return claim.getSubject();
   }
}
