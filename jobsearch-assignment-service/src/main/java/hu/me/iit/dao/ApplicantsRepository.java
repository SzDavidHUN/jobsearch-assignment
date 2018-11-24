package hu.me.iit.dao;

import hu.me.iit.model.ApplicantProfile;

import java.util.Collection;
import java.util.UUID;

public interface ApplicantsRepository extends CreatReadRepository<ApplicantProfile, UUID> {

    Collection<ApplicantProfile> findByName(String name);

    Collection<ApplicantProfile> findByCity(String city);

    Collection<ApplicantProfile> findByBorn(int born);

    Collection<ApplicantProfile> findByBornLessThanEqualAndBornGreaterThanEqual(int lower, int higher);

    Collection<ApplicantProfile> findByBornGreaterThanEqual(int born);

    Collection<ApplicantProfile> findByBornLessThanEqual(int born);

    Collection<ApplicantProfile> findByEkkr(int ekkr);

    Collection<ApplicantProfile> findByEkkrLessThanEqualAndEkkrGreaterThanEqual(int lower, int higher);

    Collection<ApplicantProfile> findByEkkrGreaterThanEqual(int ekkr);

    Collection<ApplicantProfile> findByEkkrLessThanEqual(int ekkr);
}
