package org.kevzgtech.magiccreatureswebapp.ui.controller;

import org.kevzgtech.magiccreatureswebapp.model.JobPost;
import org.kevzgtech.magiccreatureswebapp.service.implementation.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

//@Controller # in RESTfull API use @RequestMapping to return the object body (not using @Controller as Controller default to return a 'view' obj)
//@RequestMapping({"/","/job"})
//@CrossOrigin(origins = "http://localhost:3000")
@RestController()
@RequestMapping("/jobPosts")
public class JobController
{
    @Autowired
    private JobService jobService;

    @GetMapping()
    public List<JobPost> getAllJobPosts()
    {
        List<JobPost> jobPosts = jobService.getAllJobPosts();

        return jobPosts;
    }

    @GetMapping("/{postId}")
    public JobPost getJobPost(@PathVariable("postId") int postId)
    {
        JobPost jobPost = jobService.getJobPost(postId);

        return jobPost;
    }

    @PostMapping()
    public JobPost createJobPost(@RequestBody JobPost jobPost)
    {

        JobPost returnJobPost = jobService.addJobPost(jobPost);

        return returnJobPost;
    }


    @PutMapping("/{postId}")
    public JobPost updateJobPost(@PathVariable("postId") int postId,
                                 @RequestBody JobPost jobPost)
    {
        JobPost returnJobPost = jobService.updateJobPost(postId, jobPost);

        return returnJobPost;
    }


    @DeleteMapping("/{postId}")
    public void deleteJobPost(@PathVariable int postId)
    {
        System.out.println("postId in Controller --->> " + postId);
        jobService.deletePost(postId);
    }

    @GetMapping("/load")
    public void loadInitialData()
    {
        jobService.loadInitalData();
    }


    @GetMapping("/search/{keyword}")
    public List<JobPost> searchByKeywords(@PathVariable("keyword") String keyword)
    {
        List<JobPost> jobPosts = jobService.searchByKeywords(keyword);

        return jobPosts;
    }


}
