package hu.me.iit.dao;

import hu.me.iit.model.JobCategory;
import hu.me.iit.model.JobListing;

import java.util.Collection;
import java.util.UUID;

public interface JobsRepository extends CreatReadRepository<JobListing, UUID> {
    Collection<JobListing> findByTitle(String title);

    Collection<JobListing> findByCategory(JobCategory category);

    Collection<JobListing> findByCompany(String company);
}
