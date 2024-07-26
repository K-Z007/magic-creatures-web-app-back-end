package org.kevzgtech.magiccreatureswebapp.service.implementation;

import org.kevzgtech.magiccreatureswebapp.model.UserEntity;
import org.kevzgtech.magiccreatureswebapp.repo.UserRepository;
import org.kevzgtech.magiccreatureswebapp.service.UserService;
import org.kevzgtech.magiccreatureswebapp.ui.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepo;

    @Override
    public void createUser(UserEntity user)
    {
//        System.out.println("DEBUG: UserServiceImpl " + user);
        userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserEntity userEntity = userRepo.findByUsername(username);


        System.out.println("userEntity " + userEntity);
        if(userEntity == null) {
            System.out.println("User -- 404");
            throw new UsernameNotFoundException("User 404");
        }

        System.out.println("userEntity " + userEntity);
        return new UserPrincipal(userEntity);
    }


}
