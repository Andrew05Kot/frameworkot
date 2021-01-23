package com.kot.frameworkot.dal.security.jwt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.kot.frameworkot.dal.entity.user.UserPrincipal;
import com.kot.frameworkot.dal.security.service.CustomUserDetailsService;
import com.nimbusds.jwt.JWTClaimsSet;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication auth) {
        String token = (String) auth.getCredentials();

        JWTClaimsSet claims = jwtService.parseToken(token);

        UserPrincipal userPrincipal = userDetailsService.loadUserByUsername(claims.getSubject());

        if (userPrincipal == null) {
            throw new BadCredentialsException("Bad credentials. User not found");
        }

        return new JwtAuthenticationToken(userPrincipal, token, userPrincipal.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
