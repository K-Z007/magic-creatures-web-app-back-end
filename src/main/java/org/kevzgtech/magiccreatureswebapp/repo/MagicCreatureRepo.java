package org.kevzgtech.magiccreatureswebapp.repo;

import org.kevzgtech.magiccreatureswebapp.model.MagicCreature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MagicCreatureRepo extends JpaRepository<MagicCreature, Integer>
{

//    List<MagicCreature> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name,
//                                                                                            String description);

    List<MagicCreature> findByNameContainingIgnoreCase(String name);
}