package org.kevzgtech.magiccreatureswebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//A dedicated place to store all beans for Authentication;
@Configuration
public class AuthenticationConfigs
{
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();  // here didn't set the strength of the encoder, default is 10;
    }



}
