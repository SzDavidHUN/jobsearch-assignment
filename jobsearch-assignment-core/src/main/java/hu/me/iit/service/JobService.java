package hu.me.iit.service;

import hu.me.iit.model.JobCategory;
import hu.me.iit.model.JobListing;

import java.util.Collection;

public interface JobService {
    Collection<JobListing> getJobListings();

    Collection<JobListing> getJobsByCategory(JobCategory category);

    Collection<JobListing> getJobsByTitle(String title);

    Collection<JobListing> getJobsByCompany(String company);
}
