package org.kevzgtech.magiccreatureswebapp.service.implementation;


import org.kevzgtech.magiccreatureswebapp.model.MagicCreature;
import org.kevzgtech.magiccreatureswebapp.repo.MagicCreatureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Service
public class MagicCreatureService
{
    @Autowired
    private MagicCreatureRepo magicCreatureRepo;


    public MagicCreature addMagicCreature(MagicCreature magicCreature)
    {
        return magicCreatureRepo.save(magicCreature);
    }

    public List<MagicCreature> getAllMagicCreatures()
    {
        return magicCreatureRepo.findAll();
    }

    public MagicCreature getCreature(int id)
    {
        return magicCreatureRepo.findById(id).orElse(null);
    }

    public MagicCreature update(int id, MagicCreature magicCreature)
    {
        MagicCreature magicCreatureFound = getCreature(id);

        if (magicCreatureFound == null)
            return null;

        magicCreatureFound.updateDetails(magicCreature);

        System.out.println("found id -->> " + id);
        return magicCreatureRepo.save(magicCreatureFound);
    }

    public void delete(int id)
    {
        magicCreatureRepo.deleteById(id);
    }

    @Transactional
    public List<MagicCreature> searchByKeywords(String keyword)
    {
        String keywordLower = keyword.toLowerCase();

//        return magicCreatureRepo.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keywordLower,
//                keywordLower);

        return magicCreatureRepo.findByNameContainingIgnoreCase(keywordLower);
    }

    public void loadInitalData() throws IOException
    {
        try
        {
            List<MagicCreature> magicCreatures = new ArrayList<>();
            Path currPath = Paths.get(".");
            Path absolutePath = currPath.toAbsolutePath();
            String projectDir = absolutePath.toString();
            String imageSaveDirectory = projectDir + "/src/main/resources/static/images/";

//        System.out.println(path);

            for (int i = 0; i < 3; i++)
            {
                magicCreatures.add(new MagicCreature());
            }

            magicCreatures.get(0).setName("Aetherwings");
            magicCreatures.get(0).setDescription(
                    "Ethereal bird-like creatures with wings that shimmer with celestial energy. They have the ability to manipulate gravitational forces.");
            magicCreatures.get(0).setStrength("Ability to manipulate gravitational forces");
            magicCreatures.get(0).setWeakness("Limited to zones");
            magicCreatures.get(0).setElementTypes(
                    List.of("Wind", "Light"));
            magicCreatures.get(0).saveImageViaPath(Paths.get(imageSaveDirectory + magicCreatures.get(0).getName()).toString()+".jfif");
//        magicCreatures.get(0).setImagePath(
//                Paths.get(imageSaveDirectory + magicCreatures.get(0).getName()).toString()+".jfif");


            magicCreatures.get(1).setName("Glimmerhide");
            magicCreatures.get(1).setDescription(
                    "Stealthy beasts covered in a reflective hide that can blend into their surroundings. " +
                            "Their special ability is to become invisible in direct light, " +
                            "making them nearly undetectable.");
            magicCreatures.get(1).setStrength("Ability to become invisible in direct light");
            magicCreatures.get(1).setWeakness("Low Defence");
            magicCreatures.get(1).setElementTypes(
                    List.of("Dark", "Earth"));
            magicCreatures.get(1).saveImageViaPath(Paths.get(imageSaveDirectory + magicCreatures.get(1).getName()).toString()+".jfif");
//        magicCreatures.get(1).setImagePath(
//                Paths.get(imageSaveDirectory + magicCreatures.get(1).getName()).toString()+".jfif");

            magicCreatures.get(2).setName("Frostwhisker");
            magicCreatures.get(2).setDescription(
                    "Feline creatures with fur as white as snow and eyes that glow blue. " +
                            "They can exhale a breath of freezing mist that can encase enemies in ice.");
            magicCreatures.get(2).setStrength("Ability to exhale a breath of freezing mist");
            magicCreatures.get(2).setWeakness("Fear of fire");
            magicCreatures.get(2).setElementTypes(
                    List.of("Water"));
            magicCreatures.get(2).saveImageViaPath(Paths.get(imageSaveDirectory + magicCreatures.get(2).getName()).toString()+".jfif");
//        magicCreatures.get(2).setImagePath(
//                Paths.get(imageSaveDirectory + magicCreatures.get(2).getName()).toString()+".jfif");

            magicCreatureRepo.saveAll(magicCreatures);
        }
        catch (IOException e) {

        }

    }



}

