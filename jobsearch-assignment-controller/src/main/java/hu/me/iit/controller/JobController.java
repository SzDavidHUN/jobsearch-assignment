package hu.me.iit.controller;

import hu.me.iit.model.JobCategory;
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

    @GetMapping("/jobs/all")
    public Collection<JobListing> getJobListings() {
        return jobService.getJobListings();
    }

    @GetMapping("/jobs/bytitle/{title}")
    public Collection<JobListing> getJobsByTitle(
            @PathVariable String title
    ) {
        return jobService.getJobsByTitle(title);
    }

    @GetMapping("/jobs/bycompany/{company}")
    public Collection<JobListing> getJobsByCompany(
            @PathVariable String company
    ) {
        return jobService.getJobsByCompany(company);
    }

    @GetMapping("/jobs/bycategory/{category}")
    public Collection<JobListing> getJobsByCategory(
            @PathVariable("category") JobCategory category
    ) {
        return jobService.getJobsByCategory(category);
    }
}
