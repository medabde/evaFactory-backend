package com.evafactory.co.evaFactorybackend.controllers;


import com.evafactory.co.evaFactorybackend.modules.Etudiant;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestController {

    @RequestMapping("/")
    public String sayHello(){
        return "hello :D";
    }


    private List<Etudiant> etudiants = createList();

    @RequestMapping(value = "/etudiants", method = RequestMethod.GET, produces = "application/json")
    public List<Etudiant> firstPage() {
        return etudiants;
    }

    @RequestMapping(value = "/etudiants/{id}", method = RequestMethod.DELETE)
    public Etudiant delete(@PathVariable("id") int id) {
        Etudiant deletedEmp = null;
        for (Etudiant emp : etudiants) {
            if (emp.getEmpId().equals(id)) {
                System.out.println("hello");
                etudiants.remove(emp);
                deletedEmp = emp;
                break;
            }
        }
        return deletedEmp;
    }

    @PostMapping
    public Etudiant create(@RequestBody Etudiant user) {
        etudiants.add(user);
        System.out.println(etudiants);
        return user;
    }

    private static List<Etudiant> createList() {
        List<Etudiant> tempEtudiant = new ArrayList<>();
        Etudiant emp1 = new Etudiant();
        emp1.setName("emp1");
        emp1.setDesignation("manager");
        emp1.setEmpId("1");
        emp1.setSalary(3000);

        Etudiant emp2 = new Etudiant();
        emp2.setName("emp2");
        emp2.setDesignation("developer");
        emp2.setEmpId("2");
        emp2.setSalary(3000);
        tempEtudiant.add(emp1);
        tempEtudiant.add(emp2);
        return tempEtudiant;
    }

}
