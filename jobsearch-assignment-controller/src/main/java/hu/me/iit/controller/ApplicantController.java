package hu.me.iit.controller;

import hu.me.iit.dto.ApplicantDTO;
import hu.me.iit.model.ApplicantProfile;
import hu.me.iit.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

@RestController
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;

    @GetMapping("/applicants/all")
    public Collection<ApplicantProfile> listApplicants() {
        return applicantService.getAllApplicant();
    }

    @GetMapping("/applicants/byname/{name}")
    public Collection<ApplicantDTO> getApplicantProfilesByName(
            @PathVariable String name
    ) {
        return applicantService.getApplicantByName(name).stream().map(ApplicantDTO::modelToDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @GetMapping("/applicants/bycity/{city}")
    public Collection<ApplicantDTO> getApplicantProfilesByCity(
            @PathVariable String city
    ) {
        return applicantService.getApplicantByCity(city).stream().map(ApplicantDTO::modelToDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @GetMapping("/applicants/byborn/{born}")
    public Collection<ApplicantDTO> getApplicantprofilesByBorn(
            @PathVariable int born
    ) {
        return applicantService.getApplicantByBorn(born).stream().map(ApplicantDTO::modelToDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @GetMapping("/applicants/byborn")
    public ResponseEntity<Collection<ApplicantDTO>> getApplicantProfilesByBornDetailed(
            @RequestParam(required = false) Integer before,
            @RequestParam(required = false) Integer after
    ) {
        if (before != null && after != null)
            return ResponseEntity.ok(applicantService.getApplicantByBornBetween(before, after).stream().map(ApplicantDTO::modelToDto).collect(Collectors.toCollection(LinkedList::new)));
        if (before != null)
            return ResponseEntity.ok(applicantService.getApplicantByBornOrBefore(before).stream().map(ApplicantDTO::modelToDto).collect(Collectors.toCollection(LinkedList::new)));
        if (after != null)
            return ResponseEntity.ok(applicantService.getApplicantByBornOrAfter(after).stream().map(ApplicantDTO::modelToDto).collect(Collectors.toCollection(LinkedList::new)));
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/applicants/byekkr/{ekkr}")
    public Collection<ApplicantDTO> getApplicantProfilesByEkkr(
            @PathVariable int ekkr
    ) {
        return applicantService.getApplicantByEkkr(ekkr).stream().map(ApplicantDTO::modelToDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @GetMapping("/applicants/byekkr")
    public ResponseEntity<Collection<ApplicantDTO>> getApplicantProfilesByEkkr(
            @RequestParam(required = false) Integer lowerLimit,
            @RequestParam(required = false) Integer higherLimit
    ) {
        if (lowerLimit != null && higherLimit != null)
            return ResponseEntity.ok(applicantService.getApplicantByEkkrBetween(lowerLimit, higherLimit).stream().map(ApplicantDTO::modelToDto).collect(Collectors.toCollection(LinkedList::new)));
        if (lowerLimit != null)
            return ResponseEntity.ok(applicantService.getApplicantByEkkrOrHigher(lowerLimit).stream().map(ApplicantDTO::modelToDto).collect(Collectors.toCollection(LinkedList::new)));
        if (higherLimit != null) {
            return ResponseEntity.ok(applicantService.getApplicantByEkkrOrLower(higherLimit).stream().map(ApplicantDTO::modelToDto).collect(Collectors.toCollection(LinkedList::new)));
        }
        return ResponseEntity.badRequest().body(null);
    }
}
