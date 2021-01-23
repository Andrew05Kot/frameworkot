package com.kot.frameworkot.api.service.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import com.kot.frameworkot.dal.entity.user.UserEntity;
import com.kot.frameworkot.dal.security.jwt.JwtService;
import com.kot.frameworkot.dal.service.user.UserService;
import com.nimbusds.jwt.JWTClaimsSet;

@Service
public class AuthenticationAPIService {

    @Value("${frameworkot.oauth2.expirationMillis}")
    private String expirationMillis;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    public String authenticate(String token) {
        JWTClaimsSet claims = jwtService.parseToken(token);
        UserEntity user = userService.getUserBySocialId(claims.getSubject());
        if (user == null) {
            throw new BadCredentialsException("Bad credentials. User not found.");
        }
        return jwtService.createToken(claims.getAudience().toString(), claims.getSubject(), Long.parseLong(expirationMillis));
    }

}
