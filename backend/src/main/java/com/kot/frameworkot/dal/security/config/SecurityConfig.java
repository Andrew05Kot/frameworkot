package com.kot.frameworkot.dal.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.kot.frameworkot.api.controller.authentication.AuthenticationController;
import com.kot.frameworkot.api.controller.user.UserController;
import com.kot.frameworkot.dal.security.jwt.*;
import com.kot.frameworkot.dal.security.service.ApplicationOAuth2UserService;
import com.kot.frameworkot.dal.security.service.CustomUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuth2AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private OAuth2AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

    @Autowired
    private ApplicationOAuth2UserService oAuth2UserService;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder())
                .and().authenticationProvider(jwtAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().cors()
                .and().csrf().disable()
                .oauth2Login()
                .authorizationEndpoint()
                .authorizationRequestRepository(httpCookieOAuth2AuthorizationRequestRepository)
                .and()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .userInfoEndpoint()
                .userService(oAuth2UserService);

        http.authorizeRequests()
                .antMatchers("/login", AuthenticationController.BASE_URL)
                .permitAll()
                .antMatchers(HttpMethod.GET,
                        UserController.BASE_URL,
                        UserController.BASE_URL + "/{id}")
                .permitAll()
                .antMatchers("/v2/api-docs/**",
                        "/swagger-ui.html",
                        "/swagger-resources/**",
                        "/webjars/**")
                .permitAll()
                .antMatchers("/v1/**").authenticated();

        http.addFilterBefore(new JwtTokenAuthenticationFilter(authenticationManagerBean()),
                UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}