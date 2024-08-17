package io.chechi.taxi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "9ecd4bea8391a8162abaa26d1f06f760b9388a323562672c600bb954aa4a857d";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T>T extractClaim(String token, Function<Claims, T> claimsResolver) {

        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {

        return Jwts
                .parser()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private SecretKey getSigningKey() {

        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //======================================================================================

    public String generateToken (UserDetails userDetails) {

        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24 * 10))
                .signWith(getSigningKey())
                .compact();
    }

    public boolean isTokenValid (String token, UserDetails userDetails) {

        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {

        return extractClaim(token, Claims::getExpiration);
    }
}
