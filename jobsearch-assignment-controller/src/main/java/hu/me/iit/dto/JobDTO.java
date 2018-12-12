package hu.me.iit.dto;

import hu.me.iit.exception.DtoConversionException;
import hu.me.iit.model.JobCategory;
import hu.me.iit.model.JobListing;

import java.util.Objects;

public class JobDTO {

    private String title;
    private String description;
    private String company;
    private String category;

    public JobDTO() {
    }

    public JobDTO(String title, String description, String company, String category) {
        this.title = title;
        this.description = description;
        this.company = company;
        this.category = category;
    }

    public static JobDTO modelToDto(JobListing jobListing) {
        return new JobDTO(
                jobListing.getTitle(),
                jobListing.getDescription(),
                jobListing.getCompany(),
                jobListing.getCategory().name()
        );
    }

    public static JobListing dtoToModel(JobDTO jobDTO) {
        JobCategory category = null;
        for (JobCategory jobCategory : JobCategory.values()) {
            if (jobCategory.name().equalsIgnoreCase(jobDTO.getCategory()))
                category = jobCategory;
        }
        if (category == null)
            throw new DtoConversionException("Invalid job category: " + jobDTO.getCategory());

        return new JobListing(
                jobDTO.getTitle(),
                jobDTO.getDescription(),
                jobDTO.getCompany(),
                category
        );
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobDTO jobDTO = (JobDTO) o;
        return Objects.equals(title, jobDTO.title) &&
                Objects.equals(description, jobDTO.description) &&
                Objects.equals(company, jobDTO.company) &&
                Objects.equals(category, jobDTO.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, company, category);
    }

    @Override
    public String toString() {
        return "JobDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", company='" + company + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
