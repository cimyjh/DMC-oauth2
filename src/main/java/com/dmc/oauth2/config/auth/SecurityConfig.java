package com.dmc.oauth2.config.auth;

import com.dmc.oauth2.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.csrf().disable()

                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/","/event/**","/scss/**", "/vendor/**", "/css/**", "/img/**", "/js/**", "/h2-console/**", "/profile", "/lib/**").permitAll()
//                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .antMatchers("/new/**").authenticated()
                    .anyRequest().authenticated()
                .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
    }
}