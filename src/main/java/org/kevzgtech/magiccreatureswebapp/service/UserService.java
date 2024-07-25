package org.kevzgtech.magiccreatureswebapp.service;

import org.kevzgtech.magiccreatureswebapp.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService
{

    void createUser(UserEntity user);
}
