package com.evafactory.co.evaFactorybackend.controllers;


import com.evafactory.co.evaFactorybackend.Repos.EtudiantRepository;
import com.evafactory.co.evaFactorybackend.modules.Etudiant;
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


    private List<Etudiant> etudiants = createList();


    @RequestMapping("/")
    public String sayHello(){
        etudiantRepository.save(etudiants.get(0));
        return "hellooo "+etudiants.get(1).getId();
    }

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

    @RequestMapping(value = "/etudiants/edit", method = RequestMethod.GET)
    public Etudiant edit(@RequestBody Etudiant etudiant) {
        etudiantRepository.save(etudiant);
        return etudiant;
    }

//    @RequestMapping(value = "/etudiants/add", method = RequestMethod.GET)
//    public Etudiant add(@RequestBody Etudiant etudiant) {
//        etudiantRepository.save(etudiant);
//        return etudiant;
//    }
//

    @PostMapping
    public Etudiant create(@RequestBody Etudiant etudiant) {
        etudiantRepository.save(etudiant);
        return etudiant;
    }

    private static List<Etudiant> createList() {
        List<Etudiant> tempEtudiant = new ArrayList<>();
        Etudiant emp1 = new Etudiant();
        emp1.setNom("emp1");
        emp1.setPrenom("manager");
        emp1.setNum("065874");
        emp1.setCin("FA1058");

        Etudiant emp2 = new Etudiant();
        emp2.setNom("emp2");
        emp2.setPrenom("developer");
        emp2.setNum("06705485");
        emp2.setCin("FAfjasd");
        tempEtudiant.add(emp1);
        tempEtudiant.add(emp2);

        return tempEtudiant;
    }

}
