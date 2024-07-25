package org.kevzgtech.magiccreatureswebapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Entity
public class JobPost
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;


    @Override
    public String toString()
    {
        return "JobPost{" +

                ", postProfile='" + postProfile + '\'' +
                ", postDesc='" + postDesc + '\'' +
                ", reqExperience=" + reqExperience +
                ", postTechStack=" + postTechStack +
                '}';
    }

    public int getPostId()
    {
        return postId;
    }

    public void setPostId(int postId)
    {
        this.postId = postId;
    }

    public String getPostProfile()
    {
        return postProfile;
    }

    public void setPostProfile(String postProfile)
    {
        this.postProfile = postProfile;
    }

    public String getPostDesc()
    {
        return postDesc;
    }

    public void setPostDesc(String postDesc)
    {
        this.postDesc = postDesc;
    }

    public int getReqExperience()
    {
        return reqExperience;
    }

    public void setReqExperience(int reqExperience)
    {
        this.reqExperience = reqExperience;
    }

    public List<String> getPostTechStack()
    {
        return postTechStack;
    }

    public void setPostTechStack(List<String> postTechStack)
    {
        this.postTechStack = postTechStack;
    }

    public void updateDetails(JobPost newJobPost)
    {
        setPostProfile(newJobPost.getPostProfile());
        setPostDesc(newJobPost.getPostDesc());
        setReqExperience(newJobPost.getReqExperience());
        setPostTechStack(newJobPost.getPostTechStack());
    }
}
