package org.kevzgtech.magiccreatureswebapp.repo;

import org.kevzgtech.magiccreatureswebapp.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>
{
    //To match the pattern of the findBy....
    UserEntity findByUsername(String username);
}
