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

    @GetMapping("/applicants/byborn")
    public ResponseEntity<Collection<ApplicantProfile>> getApplicantProfilesByBornDetailed(
            @RequestParam(required = false) Integer before,
            @RequestParam(required = false) Integer after
    ) {
        if(before != null && after != null)
            return ResponseEntity.ok(applicantService.getApplicantByBornBetween(before, after));
        if(before != null)
            return ResponseEntity.ok(applicantService.getApplicantByBornOrBefore(before));
        if(after != null)
            return ResponseEntity.ok(applicantService.getApplicantByBornOrAfter(after));
        return ResponseEntity.badRequest().body(null);
    }
}
