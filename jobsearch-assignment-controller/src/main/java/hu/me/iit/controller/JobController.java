package hu.me.iit.controller;

import hu.me.iit.dto.JobDTO;
import hu.me.iit.model.JobCategory;
import hu.me.iit.model.JobListing;
import hu.me.iit.service.JobService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/jobs/all")
    public List<JobDTO> getJobListings() {
        return jobService.getJobListings().stream()
                .map((JobListing jobListing) -> modelMapper.map(jobListing, JobDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/jobs/bytitle/{title}")
    public List<JobDTO> getJobsByTitle(
            @PathVariable String title
    ) {
        return jobService.getJobsByTitle(title).stream()
                .map((JobListing jobListing) -> modelMapper.map(jobListing, JobDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/jobs/bycompany/{company}")
    public List<JobDTO> getJobsByCompany(
            @PathVariable String company
    ) {
        return jobService.getJobsByCompany(company).stream()
                .map((JobListing jobListing) -> modelMapper.map(jobListing, JobDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/jobs/bycategory/{category}")
    public List<JobDTO> getJobsByCategory(
            @PathVariable("category") JobCategory category
    ) {
        return jobService.getJobsByCategory(category).stream()
                .map((JobListing jobListing) -> modelMapper.map(jobListing, JobDTO.class))
                .collect(Collectors.toList());
    }

}
