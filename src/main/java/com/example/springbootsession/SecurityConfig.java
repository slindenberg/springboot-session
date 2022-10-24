package com.example.springbootsession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests ->
                        requests.antMatchers("/VAADIN/**", "/invalid", "/h2/**", "/webjars/**").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin().and()
                .headers().frameOptions().sameOrigin().and()
                .csrf().disable()
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                        .invalidSessionUrl("/invalid")
                );
        return http.build();
    }

//    @Bean
//    public CookieSerializer cookieSerializer() {
//        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
//        serializer.setCookieName("SESSIONID");
//        serializer.setCookiePath("/");
//        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
//        return serializer;
//    }

    @Bean
    public HttpSessionListener httpSessionListener() {
        return new HttpSessionListener() {
            @Override
            public void sessionCreated(final HttpSessionEvent hse) {
                log.warn("Session created: {}, {}", hse.getSession().getId(), hse.getSession().getServletContext().getServletContextName());
            }

            @Override
            public void sessionDestroyed(final HttpSessionEvent hse) {
                log.warn("Session destroyed: {}, {}", hse.getSession().getId(), hse.getSession().getServletContext().getServletContextName());
            }
        };
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("admin")
//                        .password("admin")
//                        .roles("ADMIN")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
