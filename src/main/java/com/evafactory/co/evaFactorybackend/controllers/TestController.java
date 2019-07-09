package com.evafactory.co.evaFactorybackend.controllers;


import com.evafactory.co.evaFactorybackend.Repos.EtudiantRepository;
import com.evafactory.co.evaFactorybackend.Repos.FormationRepository;
import com.evafactory.co.evaFactorybackend.modules.Etudiant;
import com.evafactory.co.evaFactorybackend.modules.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestController {

    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private FormationRepository formationRepository;

    //etudiants

    @RequestMapping(value = "/etudiants", method = RequestMethod.GET, produces = "application/json")
    public List<Etudiant> firstPage() {
        return (List<Etudiant>)etudiantRepository.findAll();
    }
    @RequestMapping(value = "/etudiants/delete/{id}", method = RequestMethod.GET)
    public Etudiant delete(@PathVariable("id") long id) {
        Etudiant deletedEtudiant = etudiantRepository.findById((int)id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        etudiantRepository.delete(deletedEtudiant);
        return deletedEtudiant;
    }
    @PostMapping
    public Etudiant create(@RequestBody Etudiant etudiant) {
        etudiantRepository.save(etudiant);
        return etudiant;
    }

    //formations

    @RequestMapping(value = "/formations", method = RequestMethod.GET, produces = "application/json")
    public List<Formation> formations() {
        return (List<Formation>)formationRepository.findAll();
    }
    @RequestMapping(value = "/formations/delete/{id}", method = RequestMethod.GET)
    public Formation deleteformation(@PathVariable("id") long id) {
        Formation deletedEtudiant = formationRepository.findById((int)id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        formationRepository.delete(deletedEtudiant);
        return deletedEtudiant;
    }

    @PostMapping(path = "/formations/add")
    public Formation createformation(@RequestBody Formation formation) {
        formationRepository.save(formation);
        return formation;
    }

}
