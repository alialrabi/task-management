package com.task.security.jwt;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.task.security.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {
	private final long TOKEN_VALIDITY_IN_MILLISECONDS = 1000 *    86400; // 24 hours --> 1 day
	private final long TOKEN_VALIDITY_IN_MILLISECONDS_FOR_REMEMBER_ME =
			1000 * 2592000; // 720 hours --> 30 days
	
	private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	public String generateToken(UserDetailsImpl userDetails, boolean rememberMe) {
		String authorities = userDetails.getAuthorities().stream()
				.map(authority -> authority.getAuthority())
				.collect(Collectors.joining(","));
		
		Date expirationDate;
		if (rememberMe) {
			expirationDate = new Date(System.currentTimeMillis() + this.TOKEN_VALIDITY_IN_MILLISECONDS_FOR_REMEMBER_ME);
		} else {
			expirationDate = new Date(System.currentTimeMillis() + this.TOKEN_VALIDITY_IN_MILLISECONDS);
		};
		
        return Jwts.builder()
        		.claim("auth", authorities)
        		.setSubject(userDetails.getEmail())
        		.setIssuedAt(new Date(System.currentTimeMillis()))
        		.setExpiration(expirationDate)
        		.signWith(key).compact();
	}
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build().parseClaimsJws(token).getBody();
	}
	
	public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	public Date getExpirationDateFromToken(String token) {
		return getClaimsFromToken( token, Claims::getExpiration);
	}
	
	public Boolean isTokenExpired(String token) {
		Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	public String getEmailFromToken(String token) {		
		return getClaimsFromToken(token, Claims::getSubject);
	}
	
	public Boolean validateToken(String token, UserDetailsImpl userDetails) {
		String email = getEmailFromToken(token);
	    return (email.equals(userDetails.getEmail()) && !isTokenExpired(token));
	}
}
