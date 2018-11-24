package hu.me.iit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    private String company;
    private String category;

    public JobListing(String title, String description, String company, String category) {
        this.title = title;
        this.description = description;
        this.company = company;
        this.category = category;
    }

    private JobListing() {
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
        JobListing that = (JobListing) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(company, that.company) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, company, category);
    }

    @Override
    public String toString() {
        return "JobListing{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", company='" + company + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
