package hu.me.iit.service;

import hu.me.iit.model.ApplicantProfile;

import java.util.Collection;

public interface ApplicantService {
    Collection<ApplicantProfile> getAllApplicant();

    Collection<ApplicantProfile> getApplicantByBorn(int born);

    Collection<ApplicantProfile> getApplicantByBornOrAfter(int born);

    Collection<ApplicantProfile> getApplicantByBornOrBefore(int born);

    Collection<ApplicantProfile> getApplicantByBornBetween(int born1, int born2);

    Collection<ApplicantProfile> getApplicantByEkkr(int ekkrLevel);

    Collection<ApplicantProfile> getApplicantByEkkrOrHigher(int ekkrLevel);

    Collection<ApplicantProfile> getApplicantByEkkrOrLover(int ekkrLevel);

    Collection<ApplicantProfile> getApplicantByEkkrBetween(int ekkrLevel1, int ekkrLevel2);

    Collection<ApplicantProfile> getApplicantByName(String name);

    Collection<ApplicantProfile> getApplicantByCity(String city);
}