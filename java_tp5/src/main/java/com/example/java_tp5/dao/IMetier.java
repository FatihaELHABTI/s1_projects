package com.example.java_tp5.dao;

import com.example.java_tp5.models.Departement;
import com.example.java_tp5.models.Professeur;

import java.util.List;

public interface IMetier {
    void ajouterProfesseur(Professeur professeur);
    void modifierProfesseur(Professeur professeur);
    void supprimerProfesseur(int idProf);
    List<Professeur> listerProfesseurs();
    List<Professeur> chercherProfesseursParMotCle(String motCle);
    void affecterProfesseurADepartement(int idProf, int idDepart);

    void ajouterDepartement(Departement departement);
    void modifierDepartement(Departement departement);
    void supprimerDepartement(int idDepart);
    List<Departement> listerDepartements();
    List<Professeur> listerProfesseursParDepartement(int idDepart);
}

