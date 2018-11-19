package hu.me.iit.controller;

import hu.me.iit.model.JobListing;
import hu.me.iit.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping(value = "/jobs/all")
    public Collection<JobListing> getJobListings() {
        return jobService.getJobListings();
    }

    @GetMapping("/jobs/bycategory/{category}")
    public Collection<JobListing> getJobsByCategory(
            @PathVariable("category") String category
    ) {
        return jobService.getJobsByCategory(category);
    }
}
