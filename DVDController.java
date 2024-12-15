package com.delflix.controller;

import com.delflix.model.DVD;
import com.delflix.service.DVDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dvds")
public class DVDController {

    @Autowired
    private DVDService dvdService;

    @PostMapping
    public DVD createDVD(@RequestParam String title, @RequestParam String genre, @RequestParam int year,
                         @RequestParam String directorName, @RequestParam String directorSurname) {
        return dvdService.createDVD(title, genre, year, directorName, directorSurname);
    }

    @GetMapping
    public List<DVD> searchDVDs(@RequestParam(required = false) String title, @RequestParam(required = false) String genre,
                                 @RequestParam(required = false) String directorName) {
        return dvdService.searchDVDs(title, genre, directorName);
    }

    @PostMapping("/{id}/rent")
    public String rentDVD(@PathVariable Long id) {
        return dvdService.rentDVD(id);
    }

    @PostMapping("/{id}/return")
    public String returnDVD(@PathVariable Long id) {
        return dvdService.returnDVD(id);
    }
}
