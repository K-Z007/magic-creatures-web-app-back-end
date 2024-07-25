package org.kevzgtech.magiccreatureswebapp.model;


import jakarta.persistence.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
@Scope("prototype")
@Entity
public class MagicCreature
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String description;
    private String strength;
    private String weakness;
    private List<String> elementTypes;
    //private String imagePath; // This is the new field for storing the image path

    @Lob
    private byte[] image; // This is the new field for storing the image data

    // getters and setters for image
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "Creature{" +
                ", name='" + name + '\'' +
                ", desc='" + description + '\'' +
                ", strength='" + strength + '\'' +
                ", weakness='" + weakness + '\'' +
                ", elementTypes=" + elementTypes +
                '}';
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getStrength()
    {
        return strength;
    }

    public void setStrength(String strength)
    {
        this.strength = strength;
    }

    public String getWeakness()
    {
        return weakness;
    }

    public void setWeakness(String weakness)
    {
        this.weakness = weakness;
    }

    public List<String> getElementTypes()
    {
        return elementTypes;
    }

    public void setElementTypes(List<String> elementTypes)
    {
        this.elementTypes = elementTypes;
    }

    public void saveImageViaPath(String imagePath) throws IOException
    {
        // Convert the image at the given path into a byte array
        Path path = Paths.get(imagePath);
        byte[] imageBytes = Files.readAllBytes(path);

        setImage(imageBytes);
    }


//    public String getImagePath()
//    {
//        return imagePath;
//    }
//
//    public void setImagePath(String imagePath)
//    {
//        this.imagePath = imagePath;
//    }

    public void updateDetails(MagicCreature newMagicCreature)
    {
        setName(newMagicCreature.getName());
        setDescription(newMagicCreature.getDescription());
        setStrength(newMagicCreature.getStrength());
        setWeakness(newMagicCreature.getWeakness());
        setElementTypes(newMagicCreature.getElementTypes());
    }
}
