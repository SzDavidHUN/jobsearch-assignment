package hu.me.iit.service;

import hu.me.iit.model.JobListing;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

@Service
public class JobServiceImplementation implements JobService {

    private Collection<JobListing> jobListings;

    @PostConstruct
    private void init() {
        jobListings = new ArrayList<>();
        jobListings.add(new JobListing(
                "Web fejlesztő",
                "Web fejlesztésére felelős akárki",
                "Pók Kft",
                "IT"
        ));
        jobListings.add(new JobListing(
                "Embed fejlesztő",
                "Beágyazott rendszerek fejletésévelhez keresünk munkatársat",
                "Ágyazó Kft",
                "IT"
        ));
        jobListings.add(new JobListing(
                "Síküveg restaurátor asszisztens",
                "ö8243jinh4mihbn4reöhb",
                "Avandzsá Bt",
                "Takarítás"
        ));
        jobListings.add(new JobListing(
                "Takarító néni",
                "Igényes informatikai vállalat keres kedves takarító nénit nappali munkarenddel",
                "Clean-Office Kft",
                "Takarítás"
        ));

    }

    public Collection<JobListing> getJobListings() {
        return jobListings;
    }

    @Override
    public Collection<JobListing> getJobsByCategory(String category) {
        Collection<JobListing> result = new LinkedList<>();
        for (JobListing jobListing : jobListings) {
            if (jobListing.getCategory().equals(category))
                result.add(jobListing);
        }
        return result;
    }

    @Override
    public Collection<JobListing> getJobsByTitle(String title) {
        Collection<JobListing> result = new LinkedList<>();
        for (JobListing jobListing : jobListings) {
            if (jobListing.getTitle().equals(title))
                result.add(jobListing);
        }
        return result;
    }

    @Override
    public Collection<JobListing> getJobsByCompany(String company) {
        Collection<JobListing> result = new LinkedList<>();
        for (JobListing jobListing : jobListings) {
            if (jobListing.getCompany().equals(company))
                result.add(jobListing);
        }
        return result;
    }
}
