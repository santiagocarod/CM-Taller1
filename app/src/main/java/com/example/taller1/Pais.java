package com.example.taller1;

public class Pais {
    String capital;
    String name;
    String InternationalName;
    String initials;

    public Pais() {
    }

    public Pais(String capital, String name, String internationalName, String initials) {
        this.capital = capital;
        this.name = name;
        this.initials = initials;
        this.InternationalName = internationalName;
    }

    public String getCapital() {
        return capital;
    }

    public String getName() {
        return name;
    }

    public String getInternationalName() {
        return InternationalName;
    }

    public String getInitials() {
        return initials;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInternationalName(String internationalName) {
        this.InternationalName = internationalName;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @Override
    public String toString() {
        return name;
    }
}