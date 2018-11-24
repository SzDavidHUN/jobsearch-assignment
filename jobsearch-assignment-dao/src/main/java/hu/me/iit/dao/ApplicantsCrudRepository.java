package hu.me.iit.dao;

import hu.me.iit.model.ApplicantProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicantsCrudRepository extends CrudRepository<ApplicantProfile, UUID>, ApplicantsRepository {

}
