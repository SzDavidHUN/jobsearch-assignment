package hu.me.iit.controller;

import hu.me.iit.model.ApplicantProfile;
import hu.me.iit.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;

    @GetMapping("/applicants/all")
    public Collection<ApplicantProfile> listApplicants() {
        return applicantService.getAllApplicant();
    }

    @GetMapping("/applicants/bycity")
    public Collection<ApplicantProfile> getApplicantProfilesByName (
            @RequestParam String name
    ) {
        return applicantService.getApplicantByName(name);
    }

    @GetMapping("/applicants/bycity/{city}")
    public Collection<ApplicantProfile> getApplicantProfilesByCity (
            @PathVariable String city
    ) {
        return applicantService.getApplicantByCity(city);
    }

    @GetMapping("/applicants/byekkr/{ekkr}")
    public Collection<ApplicantProfile> getApplicantProfilesByEkkr(
            @PathVariable int ekkr
    ) {
        return applicantService.getApplicantByEkkr(ekkr);
    }

    @GetMapping("/applicants/byborn/{born}")
    public Collection<ApplicantProfile> getApplicantProfilesByBorn(
            @PathVariable int born
    ) {
        return applicantService.getApplicantByBorn(born);
    }
}
