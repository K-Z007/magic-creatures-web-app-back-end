package org.kevzgtech.magiccreatureswebapp.service.implementation;

import org.kevzgtech.magiccreatureswebapp.model.JobPost;
import org.kevzgtech.magiccreatureswebapp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService
{
    @Autowired
    private JobRepo jobRepo;


    public JobPost addJobPost(JobPost jobPost)
    {
        return jobRepo.save(jobPost);
    }

    public List<JobPost> getAllJobPosts()
    {
        return jobRepo.findAll();
    }

    public JobPost getJobPost(int postId)
    {
        return jobRepo.findById(postId).orElse(null);
    }

    public JobPost updateJobPost(int postId, JobPost jobPost)
    {
        JobPost jobPostFound = getJobPost(postId);

        if (jobPostFound == null)
            return null;

        jobPostFound.updateDetails(jobPost);

        System.out.println("found id -->> " + postId);
        return jobRepo.save(jobPostFound);
    }

    public void deletePost(int postId)
    {
        jobRepo.deleteById(postId);
    }

    public List<JobPost> searchByKeywords(String keyword)
    {
       String keywordLower = keyword.toLowerCase();

        return jobRepo.findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(keywordLower,
                keywordLower);
    }

    public void loadInitalData()
    {
        List<JobPost> jobPosts = new ArrayList<>();

        for (int i = 0; i < 3; i++)
        {
            jobPosts.add(new JobPost());
        }

        jobPosts.get(0).setPostId(1);
        jobPosts.get(0).setPostProfile(
                "Java Developer"
        );
        jobPosts.get(0).setPostDesc(
                "Must have good experience in core Java and advanced Java");
        jobPosts.get(0).setReqExperience(2);
        jobPosts.get(0).setPostTechStack(
                List.of("Java", "Spring Boot", "Hibernate"));

        jobPosts.get(1).setPostId(2);
        jobPosts.get(1).setPostProfile(
                "Frontend Developer"
        );
        jobPosts.get(1).setPostDesc(
                "Experience in building responsive web applications using React");
        jobPosts.get(1).setReqExperience(3);
        jobPosts.get(1).setPostTechStack(
                List.of("HTML", "CSS", "JavaScript", "React"));

        jobPosts.get(2).setPostId(3);
        jobPosts.get(2).setPostProfile(
                "Data Analyst"
        );
        jobPosts.get(2).setPostDesc(
                "Strong background in machine learning and data analysis");
        jobPosts.get(2).setReqExperience(4);
        jobPosts.get(2).setPostTechStack(
                List.of("Python", "Pandas"));

        jobRepo.saveAll(jobPosts);
    }


}
