
package org.kevzgtech.magiccreatureswebapp.ui.controller;

import org.kevzgtech.magiccreatureswebapp.model.MagicCreature;
import org.kevzgtech.magiccreatureswebapp.service.implementation.MagicCreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;


@RestController()
@RequestMapping("/magic_creatures")
//@CrossOrigin("http://localhost:3000")
public class MagicCreatureController
{
    @Autowired
    private MagicCreatureService magicCreatureService;


    @GetMapping()
    public List<MagicCreature> getAllMagicCreatures()
    {
        List<MagicCreature> magicCreatures = magicCreatureService.getAllMagicCreatures();

        return magicCreatures;
    }

    @GetMapping("/{id}")
    public MagicCreature getMagicCreature(@PathVariable("id") int id)
    {
        MagicCreature returnMagicCreature = magicCreatureService.getCreature(id);

        return returnMagicCreature;
    }

//    @PostMapping()
//    public MagicCreature createMagicCreature(@RequestBody MagicCreature magicCreature)
//    {
//
//        MagicCreature returnMagicCreature = magicCreatureService.addMagicCreature(magicCreature);
//
//        return returnMagicCreature;
//    }

    @PostMapping(consumes = "multipart/form-data")
    public MagicCreature createMagicCreature(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("strength") String strength,
            @RequestParam("weakness") String weakness,
            @RequestParam("elementTypes") List<String> elementTypes,
            @RequestPart("image") MultipartFile image
    )
    {
        try {
            // Convert the request parameters to a MagicCreature object
            MagicCreature magicCreature = new MagicCreature();
            magicCreature.setName(name);
            magicCreature.setDescription(description);
            magicCreature.setStrength(strength);
            magicCreature.setWeakness(weakness);
            magicCreature.setElementTypes(elementTypes);
            magicCreature.setImage(image.getBytes()); // Assuming MagicCreature has a field for the image as byte array

            MagicCreature returnMagicCreature = magicCreatureService.addMagicCreature(magicCreature);

            return magicCreature;
        }
        catch (IOException e) {
            throw new RuntimeException("There is an issue");
            }
    }


    @PutMapping("/{id}")
    public MagicCreature updateMagicCreature(@PathVariable("id") int id,
                                       @RequestBody MagicCreature magicCreature)
    {
        MagicCreature returnMagicCreature = magicCreatureService.update(id, magicCreature);

        return returnMagicCreature;
    }

    @DeleteMapping("/{id}")
    public void deleteMagicCreature(@PathVariable int id)
    {
        System.out.println("postId in Controller --->> " + id);
        magicCreatureService.delete(id);
    }

    @GetMapping("/load")
    public void loadInitialData()
    {
        try
        {
            magicCreatureService.loadInitalData();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/search/{keyword}")
    public List<MagicCreature> searchByKeywords(@PathVariable("keyword") String keyword)
    {
        List<MagicCreature> creatures = magicCreatureService.searchByKeywords(keyword);

        return creatures;
    }


}
