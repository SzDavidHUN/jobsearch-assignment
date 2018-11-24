package hu.me.iit.service;

import hu.me.iit.dao.ApplicantsRepository;
import hu.me.iit.model.ApplicantProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Service
public class ApplicantServiceImplementation implements ApplicantService {

    @Autowired
    private ApplicantsRepository applicantsRepository;

    @PostConstruct
    private void init() {
        applicantsRepository.save(new ApplicantProfile("Kovács Józsefné Kis Marika", "Csajágaröcsöge", 1, 1948));
        applicantsRepository.save(new ApplicantProfile("Nagy Géza", "Pilisborzasztó", 4, 1980));
        applicantsRepository.save(new ApplicantProfile("Pintér Csaba", "Bivalybasznád", 6, 1995));
        applicantsRepository.save(new ApplicantProfile("Farkas Szilárd", "Bokoraljapusztaszéle", 6, 1970));
    }

    @Override
    public Collection<ApplicantProfile> getAllApplicant() {
        return applicantsRepository.findAll();
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByName(String name) {
        return applicantsRepository.findByName(name);
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByCity(String city) {
        return applicantsRepository.findByCity(city);
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByBorn(int born) {
        return applicantsRepository.findByBorn(born);
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByBornOrAfter(int born) {
        return applicantsRepository.findByBornGreaterThanEqual(born);
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByBornOrBefore(int born) {
        return applicantsRepository.findByBornLessThanEqual(born);
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByBornBetween(int born1, int born2) {
        if (born1 < born2) {
            int tmp = born1;
            born1 = born2;
            born2 = tmp;
        }
        return applicantsRepository.findByBornLessThanEqualAndBornGreaterThanEqual(born1, born2);
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByEkkr(int ekkrLevel) {
        return applicantsRepository.findByEkkr(ekkrLevel);
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByEkkrOrHigher(int ekkrLevel) {
        return applicantsRepository.findByEkkrGreaterThanEqual(ekkrLevel);
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByEkkrOrLower(int ekkrLevel) {
        return applicantsRepository.findByEkkrLessThanEqual(ekkrLevel);
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByEkkrBetween(int ekkrLevel1, int ekkrLevel2) {
        if (ekkrLevel1 < ekkrLevel2) {
            int tmp;
            tmp = ekkrLevel1;
            ekkrLevel1 = ekkrLevel2;
            ekkrLevel2 = tmp;
        }
        return applicantsRepository.findByEkkrLessThanEqualAndEkkrGreaterThanEqual(ekkrLevel1, ekkrLevel2);
    }
}
