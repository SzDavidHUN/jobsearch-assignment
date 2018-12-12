package hu.me.iit.dto;

import hu.me.iit.exception.DtoConversionException;
import hu.me.iit.model.ApplicantProfile;

import java.util.Objects;

public class ApplicantDTO {
    private String name;
    private String city;
    private String ekkr;
    private String born;

    public ApplicantDTO(String name, String city, String ekkr, String born) {
        this.setName(name);
        this.setCity(city);
        this.setEkkr(ekkr);
        this.setBorn(born);
    }

    public static ApplicantDTO modelToDto(ApplicantProfile applicantProfile) {
        return new ApplicantDTO(
                applicantProfile.getName(),
                applicantProfile.getCity(),
                Integer.toString(applicantProfile.getEkkr()),
                Integer.toString(applicantProfile.getBorn())
        );
    }

    public static ApplicantProfile dtoToModel(ApplicantDTO applicantDto) throws DtoConversionException {
        int born = Integer.parseInt(applicantDto.getBorn());
        int ekkr = Integer.parseInt(applicantDto.getEkkr());
        if (applicantDto.getEkkr().isEmpty())
            throw new DtoConversionException("EKKR field is empty");
        if (applicantDto.getBorn().isEmpty())
            throw new DtoConversionException("Born field is empty");
        if (applicantDto.getName().isEmpty())
            throw new DtoConversionException("Name field is empty");
        if (applicantDto.getCity().isEmpty())
            throw new DtoConversionException("City field is empty");
        if (born < 1990 || born > 2018)
            throw new DtoConversionException("Incorrect birth year");
        if (ekkr < 0 || Integer.parseInt(applicantDto.getEkkr()) > 5)
            throw new DtoConversionException("invalid Ekkr level");
        return new ApplicantProfile(
                applicantDto.getName(),
                applicantDto.getCity(),
                ekkr,
                born
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEkkr() {
        return ekkr;
    }

    public void setEkkr(String ekkr) {
        this.ekkr = ekkr;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicantDTO that = (ApplicantDTO) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(city, that.city) &&
                Objects.equals(ekkr, that.ekkr) &&
                Objects.equals(born, that.born);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, ekkr, born);
    }

    @Override
    public String toString() {
        return "ApplicantDTO{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", ekkr='" + ekkr + '\'' +
                ", born='" + born + '\'' +
                '}';
    }
}
