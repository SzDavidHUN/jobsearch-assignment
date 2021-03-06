package hu.me.iit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class ApplicantProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String city;
    private int ekkr; //http://dev.wiki.szie.hu/wiki/europai-es-magyar-kepesitesi-keretrendszerek-neptunban
    private int born;

    public ApplicantProfile(String name, String city, int ekkr, int born) {
        this.name = name;
        this.city = city;
        this.ekkr = ekkr;
        this.born = born;
    }

    private ApplicantProfile() {
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

    public int getEkkr() {
        return ekkr;
    }

    public void setEkkr(int ekkr) {
        this.ekkr = ekkr;
    }

    public int getBorn() {
        return born;
    }

    public void setBorn(int born) {
        this.born = born;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicantProfile that = (ApplicantProfile) o;
        return born == that.born &&
                Objects.equals(name, that.name) &&
                Objects.equals(city, that.city) &&
                Objects.equals(ekkr, that.ekkr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, ekkr, born);
    }

    @Override
    public String toString() {
        return "ApplicantProfile{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", ekkr='" + ekkr + '\'' +
                ", born=" + born +
                '}';
    }
}
