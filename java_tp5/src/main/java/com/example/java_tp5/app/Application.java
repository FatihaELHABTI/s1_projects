package com.example.java_tp5.app;

import com.example.java_tp5.dao.*;
import com.example.java_tp5.models.*;

import java.util.Date;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        IMetier metier = new MetierImpl();

        // Test: Ajouter un département
        Departement departement1 = new Departement();
        departement1.setNom("Informatique");
        metier.ajouterDepartement(departement1);
        System.out.println("Département ajouté : " + departement1.getNom());

        // Test: Ajouter un autre département
        Departement departement2 = new Departement();
        departement2.setNom("Mathématiques");
        metier.ajouterDepartement(departement2);
        System.out.println("Département ajouté : " + departement2.getNom());

        // Test: Lister les départements
        List<Departement> departements = metier.listerDepartements();
        System.out.println("\nListe des départements :");
        for (Departement dep : departements) {
            System.out.println(dep.getIdDepart() + " - " + dep.getNom());
        }

        // Test: Ajouter un professeur
        Professeur professeur1 = new Professeur();
        professeur1.setNom("Dupont");
        professeur1.setPrenom("Jean");
        professeur1.setCin("AB123456");
        professeur1.setAdresse("123 Rue des Lilas");
        professeur1.setTelephone("0123456789");
        professeur1.setEmail("jean.dupont@example.com");
        professeur1.setDateRecrutement(new Date());
        metier.ajouterProfesseur(professeur1);
        System.out.println("\nProfesseur ajouté : " + professeur1.getNom() + " " + professeur1.getPrenom());

        // Test: Ajouter un autre professeur
        Professeur professeur2 = new Professeur();
        professeur2.setNom("Martin");
        professeur2.setPrenom("Claire");
        professeur2.setCin("CD789012");
        professeur2.setAdresse("456 Avenue des Fleurs");
        professeur2.setTelephone("0987654321");
        professeur2.setEmail("claire.martin@example.com");
        professeur2.setDateRecrutement(new Date());
        metier.ajouterProfesseur(professeur2);
        System.out.println("Professeur ajouté : " + professeur2.getNom() + " " + professeur2.getPrenom());

        // Test: Lister les professeurs
        List<Professeur> professeurs = metier.listerProfesseurs();
        System.out.println("\nListe des professeurs :");
        for (Professeur prof : professeurs) {
            System.out.println(prof.getIdProf() + " - " + prof.getNom() + " " + prof.getPrenom());
        }

        // Test: Affecter un professeur à un département
        if (!departements.isEmpty() && !professeurs.isEmpty()) {
            int idProf = professeurs.get(0).getIdProf();
            int idDepart = departements.get(0).getIdDepart();
            metier.affecterProfesseurADepartement(idProf, idDepart);
            System.out.println("\nProfesseur " + professeurs.get(0).getNom() + " affecté au département " + departements.get(0).getNom());
        }

        // Test: Afficher les professeurs par département
        if (!departements.isEmpty()) {
            System.out.println("\nListe des professeurs du département " + departements.get(0).getNom() + " :");
            List<Professeur> profsParDepartement = metier.listerProfesseursParDepartement(departements.get(0).getIdDepart());
            for (Professeur prof : profsParDepartement) {
                System.out.println(prof.getIdProf() + " - " + prof.getNom() + " " + prof.getPrenom());
            }
        }

        // Test: Modifier un professeur
        if (!professeurs.isEmpty()) {
            Professeur profToUpdate = professeurs.get(0);
            profToUpdate.setNom("UpdatedName");
            profToUpdate.setAdresse("789 Boulevard du Renouveau");
            metier.modifierProfesseur(profToUpdate);
            System.out.println("\nProfesseur modifié : " + profToUpdate.getNom());
        }

        // Test: Supprimer un professeur
        if (!professeurs.isEmpty()) {
            int idProfToDelete = professeurs.get(1).getIdProf();
            metier.supprimerProfesseur(idProfToDelete);
            System.out.println("\nProfesseur supprimé avec ID : " + idProfToDelete);
        }

        // Test: Supprimer un département
        if (!departements.isEmpty()) {
            int idDepartToDelete = departements.get(1).getIdDepart();
            metier.supprimerDepartement(idDepartToDelete);
            System.out.println("\nDépartement supprimé avec ID : " + idDepartToDelete);
        }

        // Test: Chercher des professeurs par mot-clé
        String keyword = "Jean";
        List<Professeur> searchResults = metier.chercherProfesseursParMotCle(keyword);
        System.out.println("\nRésultats de la recherche pour le mot-clé \"" + keyword + "\" :");
        for (Professeur prof : searchResults) {
            System.out.println(prof.getIdProf() + " - " + prof.getNom() + " " + prof.getPrenom());
        }
    }
}
