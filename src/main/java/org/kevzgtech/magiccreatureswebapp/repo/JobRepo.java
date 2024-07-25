package org.kevzgtech.magiccreatureswebapp.repo;

import org.kevzgtech.magiccreatureswebapp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer>
{

    List<JobPost> findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(String postProfile,
                                                                  String postDesc);

}

/*
*    private List<JobPost> jobPosts; // = new ArrayList<>();

    // constructor->injecting objects into ArrayList defined above.
    public JobRepo()
    {
        jobPosts = new ArrayList<>();
        // Java Developer Job Post
        jobPosts.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

        // Frontend Developer Job Post
        jobPosts.add(
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")));

        // Data Scientist Job Post
        jobPosts.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                List.of("Python", "Machine Learning", "Data Analysis")));

        // Network Engineer Job Post
        jobPosts.add(new JobPost(4, "Network Engineer",
                "Design and implement computer networks for efficient data communication", 5,
                List.of("Networking", "Cisco", "Routing", "Switching")));

        // Mobile App Developer Job Post
        jobPosts
                .add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                        3, List.of("iOS Development", "Android Development", "Mobile App")));

        // DevOps Engineer Job Post
        jobPosts.add(
                new JobPost(6, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",
                        4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes")));

        // UI/UX Designer Job Post
        jobPosts
                .add(new JobPost(7, "UI/UX Designer", "Create engaging user experiences and intuitive user interfaces",
                        2, List.of("User Experience", "User Interface Design", "Prototyping")));
    }


    public JobPost addJobPost(JobPost jobPost)
    {
        jobPosts.add(jobPost);

        return jobPost;
    }

    public List<JobPost> getAllJobPosts()
    {
        return jobPosts;
    }

    public JobPost getJobPost(int postId)
    {
        for (JobPost jobPost : jobPosts) {
            if (jobPost.getPostId() == postId){
                return jobPost;
            }
        }
        return null;
    }

    public JobPost updateJobPost(int postId, JobPost jobPost)
    {
        for (JobPost job : jobPosts) {
            if (job.getPostId() == postId){
                job.setPostDesc(jobPost.getPostDesc());
                job.setPostProfile(jobPost.getPostProfile());
                job.setReqExperience(jobPost.getReqExperience());
                job.setPostTechStack(jobPost.getPostTechStack());

                return job;
            }
        }
        return null;
    }

    public boolean deleteJobPost(int postId)
    {
        for (JobPost job : jobPosts) {
            if (job.getPostId() == postId){
                jobPosts.remove(job);
                return true;
            }
        }
        return false;
    }
* */
