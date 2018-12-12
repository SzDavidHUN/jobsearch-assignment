package hu.me.iit.controller;

import hu.me.iit.dto.JobDTO;
import hu.me.iit.model.JobCategory;
import hu.me.iit.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs/all")
    public Collection<JobDTO> getJobListings() {
        return jobService.getJobListings().stream()
                .map(JobDTO::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/jobs/bytitle/{title}")
    public Collection<JobDTO> getJobsByTitle(
            @PathVariable String title
    ) {
        return jobService.getJobsByTitle(title).stream()
                .map(JobDTO::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/jobs/bycompany/{company}")
    public Collection<JobDTO> getJobsByCompany(
            @PathVariable String company
    ) {
        return jobService.getJobsByCompany(company).stream()
                .map(JobDTO::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/jobs/bycategory/{category}")
    public Collection<JobDTO> getJobsByCategory(
            @PathVariable("category") JobCategory category
    ) {
        return jobService.getJobsByCategory(category).stream()
                .map(JobDTO::modelToDto)
                .collect(Collectors.toList());
    }

}
