package com.example.tienda.util;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	public static final String secretKey = "MysecretKey";

	public static String getJWToken(String correo, String roles) {
		List<GrantedAuthority> autoridadesAceptadas = AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
		
		String token = Jwts.builder().setId("JWT" + correo).setSubject(correo)
				.claim("authorities",
						autoridadesAceptadas.stream()
							.map(GrantedAuthority::getAuthority)
							.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
				.compact();
		System.out.println("entro a crear el token: "+token );

		return token;

	}
}

