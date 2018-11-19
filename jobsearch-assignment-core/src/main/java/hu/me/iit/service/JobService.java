package hu.me.iit.service;

import hu.me.iit.model.JobListing;

import java.util.Collection;

public interface JobService {
    Collection<JobListing> getJobListings();

    Collection<JobListing> getJobsByCategory(String category);
}
