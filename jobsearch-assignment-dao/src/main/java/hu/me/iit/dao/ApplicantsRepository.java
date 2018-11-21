package hu.me.iit.dao;

import hu.me.iit.model.ApplicantProfile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.LinkedList;

@Component
@Repository
public class ApplicantsRepository implements ObjectRepository<ApplicantProfile> {

    private Collection<ApplicantProfile> applicantProfiles;

    @PostConstruct
    private void init() {
        applicantProfiles = new LinkedList<>();
    }

    @Override
    public Collection<ApplicantProfile> getAll() {
        return applicantProfiles;
    }

    @Override
    public void save(ApplicantProfile applicantProfile) {
        applicantProfiles.add(applicantProfile);
    }

    @Override
    public void saveAll(Iterable<ApplicantProfile> iterable) {
        for (ApplicantProfile i : iterable)
            this.save(i);
    }
}
