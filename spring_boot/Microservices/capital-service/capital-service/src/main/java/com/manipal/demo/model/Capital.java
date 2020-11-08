package com.manipal.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Capital {
    @Id
    private String countryCode;
    private String name;
    private String zipcode;
    private String language;
    private long population;
   // @Transient
    private String port;

    public Capital(){}

    public Capital(String countryCode, String name, String zipcode, String language, long population, String port) {
        this.countryCode = countryCode;
        this.name = name;
        this.zipcode = zipcode;
        this.language = language;
        this.population = population;
        this.port = port;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Capital{" +
                "countryCode='" + countryCode + '\'' +
                ", name='" + name + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", language='" + language + '\'' +
                ", population=" + population +
                ", port='" + port + '\'' +
                '}';
    }
}


