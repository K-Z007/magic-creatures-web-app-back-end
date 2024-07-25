package org.kevzgtech.magiccreatureswebapp.security;

import org.kevzgtech.magiccreatureswebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer
{
    //allow cross origins defined in properties file;
    @Value("#{'${cors.allowed.origins}'.split(',')}")
    private String[] allowedOrigins;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /*Automatic Wiring: The AuthenticationProvider bean you defined is automatically
    wired into the default AuthenticationManager by Spring Security. This is why your authentication
    logic works even though you haven’t explicitly set an AuthenticationManager.*/
    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        //using DaoAuthenticationProvider to authenticate the UserDetails when loginin;
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);

        return authProvider;
    }


//        @Override
//        public void addCorsMappings(CorsRegistry registry) {
//
//            registry.addMapping("/**")
//                    .allowedOrigins(allowedOrigins);
//        }

    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins)
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http
//                .csrf(new Customizer<CsrfConfigurer<HttpSecurity>>()
//                {
//                    @Override
//                    public void customize(CsrfConfigurer<HttpSecurity> configurer)
//                    {
//                        configurer.disable();
//                    }
//                })  // they are the same:
                .csrf(configurer -> configurer.disable())  //disallow cross-site
                .authorizeHttpRequests(request   //make all reuqest to be authenticated before getting any response;
                        -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())  //this enabled means each login using HTTP "Basic" Authentication;
                .sessionManagement(session
                        -> session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS  //meaning not creating sessions;
                ));

        return http.build();
    }


    /*HTTP Basic Authentication is simple and stateless, but it’s not the most secure option because
    it involves sending the password with each request. Other authentication schemes like form login
    or JWT can provide more security features. Always consider your security requirements when choosing
    an authentication scheme.
    * */
}
