package com.kot.frameworkot.dal.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import com.kot.frameworkot.dal.entity.user.UserEntity;
import com.kot.frameworkot.dal.entity.user.UserPrincipal;

@Component
public class ApplicationOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oath2User = super.loadUser(userRequest);
        return buildPrincipal(oath2User, userRequest.getAccessToken().getTokenValue());
    }

    public UserPrincipal buildPrincipal(OAuth2User oAuth2User, String accessToken) {
        UserEntity user = userDetailsService.findUser(oAuth2User, accessToken);

        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }

}
