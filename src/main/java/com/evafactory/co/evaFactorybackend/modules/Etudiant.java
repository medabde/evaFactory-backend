package com.evafactory.co.evaFactorybackend.modules;


import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String cin;
    private String nom;
    private String prenom;
    private String num;
    private String email;
    private String passwd;


    public int getId() {
        return id;
    }

    public String getCIN() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

}