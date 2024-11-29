package com.example.java_tp5.dao;

import com.example.java_tp5.models.Departement;
import com.example.java_tp5.models.Professeur;

import java.util.List;

public interface IMetier {
    // Professeur
    void ajouterProfesseur(Professeur prof);
    void modifierProfesseur(Professeur prof);
    void supprimerProfesseur(int idProf);
    Professeur chercherProfesseurParId(int idProf);
    List<Professeur> chercherProfesseursParMotCle(String motCle);
    List<Professeur> listerProfesseurs();

    // Departement
    void ajouterDepartement(Departement depart);
    void modifierDepartement(Departement depart);
    void supprimerDepartement(int idDepart);
    List<Departement> listerDepartements();
    List<Professeur> listerProfesseursParDepartement(int idDepart);
    void affecterProfesseurADepartement(int idProf, int idDepart);
}

