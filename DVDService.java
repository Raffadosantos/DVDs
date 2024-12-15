package com.delflix.service;

import com.delflix.model.DVD;
import com.delflix.model.Director;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DVDService {

    private List<DVD> dvdList = new ArrayList<>();
    private List<Director> directorList = new ArrayList<>();


    public DVD createDVD(String title, String genre, int year, String directorName, String directorSurname) {
        Director director = findDirector(directorName, directorSurname);
        if (director == null) {
            director = new Director(directorName, directorSurname);
            directorList.add(director);
        }

        DVD dvd = new DVD(title, genre, year, director);
        dvdList.add(dvd);
        director.addDVD(dvd);

        return dvd;
    }

   
    public List<DVD> searchDVDs(String title, String genre, String directorName) {
        List<DVD> result = new ArrayList<>();
        for (DVD dvd : dvdList) {
            if ((title == null || dvd.getTitle().contains(title)) &&
                (genre == null || dvd.getGenre().contains(genre)) &&
                (directorName == null || dvd.getDirector().getName().contains(directorName))) {
                result.add(dvd);
            }
        }
        return result;
    }

  
    public String rentDVD(Long id) {
        DVD dvd = getDVDById(id);
        if (dvd != null && dvd.isAvailable()) {
            dvd.setAvailable(false);
            return "DVD alugado com sucesso!";
        }
        return "DVD não disponível!";
    }


    public String returnDVD(Long id) {
        DVD dvd = getDVDById(id);
        if (dvd != null && !dvd.isAvailable()) {
            dvd.setAvailable(true);
            return "DVD devolvido com sucesso!";
        }
        return "Este DVD não está alugado!";
    }

    
    private Director findDirector(String name, String surname) {
        for (Director director : directorList) {
            if (director.getName().equals(name) && director.getSurname().equals(surname)) {
                return director;
            }
        }
        return null;
    }

   
    private DVD getDVDById(Long id) {
        if (id < dvdList.size()) {
            return dvdList.get(id.intValue());
        }
        return null;
    }
}

