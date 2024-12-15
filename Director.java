package com.delflix.model;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private String name;
    private String surname;
    private List<DVD> dvds;

    public Director(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.dvds = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<DVD> getDvds() {
        return dvds;
    }

    public void addDVD(DVD dvd) {
        this.dvds.add(dvd);
    }
}
