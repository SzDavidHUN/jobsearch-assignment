package hu.me.iit.dao;

import hu.me.iit.model.JobListing;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface JobsCrudRepository extends CrudRepository<JobListing, UUID>, JobsRepository {
}
