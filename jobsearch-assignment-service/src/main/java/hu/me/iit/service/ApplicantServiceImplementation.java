package hu.me.iit.service;

import hu.me.iit.model.ApplicantProfile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.LinkedList;

@Component
public class ApplicantServiceImplementation implements ApplicantService {
    private Collection<ApplicantProfile> applicantProfiles;

    @PostConstruct
    private void init(){
        applicantProfiles = new LinkedList<>();
        applicantProfiles.add(new ApplicantProfile("Kovács Józsefné Kis Marika", "Csajágaröcsöge", 1, 1948));
        applicantProfiles.add(new ApplicantProfile("Nagy Géza", "Pilisborzasztó", 4, 1980));
        applicantProfiles.add(new ApplicantProfile("Pintér Csaba", "Bivalybasznád", 6, 1995));
        applicantProfiles.add(new ApplicantProfile("Farkas Szilárd", "Bokoraljapusztaszéle", 6, 1970));
    }

    //http://dev.wiki.szie.hu/wiki/europai-es-magyar-kepesitesi-keretrendszerek-neptunban

    @Override
    public Collection<ApplicantProfile> getAllApplicant() {
        return applicantProfiles;
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByBorn(int born) {
        Collection<ApplicantProfile> result = new LinkedList<>();
        for(ApplicantProfile applicantProfile : applicantProfiles){
            if(applicantProfile.getBorn() == born)
                result.add(applicantProfile);
        }
        return result;
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByBornOrAfter(int born) {
        Collection<ApplicantProfile> result = new LinkedList<>();
        for(ApplicantProfile applicantProfile : applicantProfiles){
            if(applicantProfile.getBorn() >= born)
                result.add(applicantProfile);
        }
        return result;
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByBornOrBefore(int born) {
        Collection<ApplicantProfile> result = new LinkedList<>();
        for(ApplicantProfile applicantProfile : applicantProfiles){
            if(applicantProfile.getBorn() <= born)
                result.add(applicantProfile);
        }
        return result;
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByBornBetween(int born1, int born2) {
        if(born1 > born2){
            int tmp;
            tmp = born1;
            born1 = born2;
            born2 = tmp;
        }
        Collection<ApplicantProfile> result = new LinkedList<>();
        for(ApplicantProfile applicantProfile : applicantProfiles){
            if(applicantProfile.getBorn() >= born1 && applicantProfile.getBorn() <= born2)
                result.add(applicantProfile);
        }
        return result;
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByEkkr(int ekkrLevel) {
        Collection<ApplicantProfile> result = new LinkedList<>();
        for(ApplicantProfile applicantProfile : applicantProfiles){
            if(applicantProfile.getEkkr() == ekkrLevel)
                result.add(applicantProfile);
        }
        return result;

    }

    @Override
    public Collection<ApplicantProfile> getApplicantByEkkrOrHigher(int ekkrLevel) {
        Collection<ApplicantProfile> result = new LinkedList<>();
        for(ApplicantProfile applicantProfile : applicantProfiles){
            if(applicantProfile.getEkkr() >= ekkrLevel)
                result.add(applicantProfile);
        }
        return result;

    }

    @Override
    public Collection<ApplicantProfile> getApplicantByEkkrOrLover(int ekkrLevel) {
        Collection<ApplicantProfile> result = new LinkedList<>();
        for(ApplicantProfile applicantProfile : applicantProfiles){
            if(applicantProfile.getEkkr() <= ekkrLevel)
                result.add(applicantProfile);
        }
        return result;

    }

    @Override
    public Collection<ApplicantProfile> getApplicantByEkkrBetween(int ekkrLevel1, int ekkrLevel2) {
        if(ekkrLevel1 > ekkrLevel2){
            int tmp;
            tmp = ekkrLevel1;
            ekkrLevel1 = ekkrLevel2;
            ekkrLevel2 = tmp;
        }
        Collection<ApplicantProfile> result = new LinkedList<>();
        for(ApplicantProfile applicantProfile : applicantProfiles){
            if(applicantProfile.getBorn() >= ekkrLevel1 && applicantProfile.getBorn() == ekkrLevel2)
                result.add(applicantProfile);
        }
        return result;

    }

    @Override
    public Collection<ApplicantProfile> getApplicantByName(String name) {
        Collection<ApplicantProfile> result = new LinkedList<>();
        for(ApplicantProfile applicantProfile : applicantProfiles){
            if(applicantProfile.getName().equals(name))
                result.add(applicantProfile);
        }
        return result;
    }

    @Override
    public Collection<ApplicantProfile> getApplicantByCity(String city) {
        Collection<ApplicantProfile> result = new LinkedList<>();
        for(ApplicantProfile applicantProfile : applicantProfiles){
            if(applicantProfile.getCity().equals(city))
                result.add(applicantProfile);
        }
        return result;
    }
}
