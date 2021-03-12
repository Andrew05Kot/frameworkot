package com.kot.frameworkot.dal.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import com.kot.frameworkot.dal.entity.user.UserEntity;
import com.kot.frameworkot.dal.entity.user.UserPrincipal;
import com.kot.frameworkot.dal.repository.user.UserRepository;
import com.kot.frameworkot.dal.security.FacebookAuthorizationHandler;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private static final String ID = "id";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FacebookAuthorizationHandler facebookAuthorizationHandler;

    @Override
    public UserPrincipal loadUserByUsername(String socialId) {
        UserEntity user = userRepository.findBySocialId(socialId).orElseThrow(() ->
                new UsernameNotFoundException("User with " + socialId + " social id"));
        return UserPrincipal.create(user);
    }

    public UserEntity findOrCreateUser(OAuth2User oAuth2User, String accessToken) {
        return userRepository.findBySocialId(oAuth2User.getAttribute(ID))
                .orElseGet(() -> facebookAuthorizationHandler.createUser(oAuth2User.getAttributes(), accessToken));
    }
}