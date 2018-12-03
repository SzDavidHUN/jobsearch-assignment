package hu.me.iit.service;

import hu.me.iit.dao.JobsRepository;
import hu.me.iit.model.JobCategory;
import hu.me.iit.model.JobListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Service
public class JobServiceImplementation implements JobService {

    @Autowired
    private JobsRepository jobsRepository;

    @PostConstruct
    private void init() {
        jobsRepository.save(new JobListing(
                "Web fejlesztő",
                "Web fejlesztésére felelős akárki",
                "Pók Kft",
                JobCategory.IT
        ));
        jobsRepository.save(new JobListing(
                "Embed fejlesztő",
                "Beágyazott rendszerek fejletésévelhez keresünk munkatársat",
                "Ágyazó Kft",
                JobCategory.IT
        ));
        jobsRepository.save(new JobListing(
                "Síküveg restaurátor asszisztens",
                "ö8243jinh4mihbn4reöhb",
                "Avandzsá Bt",
                JobCategory.CLEANING
        ));
        jobsRepository.save(new JobListing(
                "Takarító néni",
                "Igényes informatikai vállalat keres kedves takarító nénit nappali munkarenddel",
                "Clean-Office Kft",
                JobCategory.CLEANING
        ));

    }

    public Collection<JobListing> getJobListings() {
        return jobsRepository.findAll();
    }

    @Override
    public Collection<JobListing> getJobsByTitle(String title) {
        return jobsRepository.findByTitle(title);
    }

    @Override
    public Collection<JobListing> getJobsByCategory(JobCategory category) {
        return jobsRepository.findByCategory(category);
    }

    @Override
    public Collection<JobListing> getJobsByCompany(String company) {
        return jobsRepository.findByCompany(company);
    }
}
