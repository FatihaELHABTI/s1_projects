package com.example.java_tp5.app;

import com.example.java_tp5.dao.IMetier;
import com.example.java_tp5.dao.MetierImpl;
import com.example.java_tp5.models.Departement;
import com.example.java_tp5.models.Professeur;

import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Création d'une instance de MetierImpl
        IMetier metier = new MetierImpl();

        // 1. Ajouter un département
        Departement departement1 = new Departement("Informatique");
        metier.ajouterDepartement(departement1);
        System.out.println("Département ajouté: " + departement1.getNom());

        // 2. Ajouter un professeur
        Professeur professeur1 = new Professeur("Dupont", "Jean", "123456", "1 rue Exemple", "0123456789", "jean.dupont@example.com", new Date(), departement1);
        metier.ajouterProfesseur(professeur1);
        System.out.println("Professeur ajouté: " + professeur1.getNom() + " " + professeur1.getPrenom());

        // 3. Lister tous les professeurs
        System.out.println("\nListe des professeurs:");
        List<Professeur> professeurs = metier.listerProfesseurs();
        for (Professeur prof : professeurs) {
            System.out.println(prof.getNom() + " " + prof.getPrenom());
        }

        // 4. Lister tous les départements
        System.out.println("\nListe des départements:");
        List<Departement> departements = metier.listerDepartements();
        for (Departement dep : departements) {
            System.out.println(dep.getNom());
        }

        // 5. Modifier un professeur
        professeur1.setNom("DupontModifié");
        metier.modifierProfesseur(professeur1);
        System.out.println("\nProfesseur modifié: " + professeur1.getNom() + " " + professeur1.getPrenom());

        // 6. Rechercher un professeur par mot clé
        System.out.println("\nRecherche de professeurs avec le mot clé 'Jean':");
        List<Professeur> resultatRecherche = metier.chercherProfesseursParMotCle("Jean");
        for (Professeur prof : resultatRecherche) {
            System.out.println(prof.getNom() + " " + prof.getPrenom());
        }

        // 7. Affecter un professeur à un autre département
        Departement departement2 = new Departement("Mathématiques");
        metier.ajouterDepartement(departement2);
        System.out.println("\nDépartement 'Mathématiques' ajouté");

        metier.affecterProfesseurADepartement(professeur1.getIdProf(), departement2.getIdDepart());
        System.out.println("Professeur " + professeur1.getNom() + " affecté au département " + departement2.getNom());

        // 8. Lister les professeurs d'un département
        System.out.println("\nListe des professeurs du département 'Mathématiques':");
        List<Professeur> professeursDepartement = metier.listerProfesseursParDepartement(departement2.getIdDepart());
        for (Professeur prof : professeursDepartement) {
            System.out.println(prof.getNom() + " " + prof.getPrenom());
        }

        // 9. Supprimer un professeur
        metier.supprimerProfesseur(professeur1.getIdProf());
        System.out.println("\nProfesseur supprimé: " + professeur1.getNom() + " " + professeur1.getPrenom());

        // 10. Supprimer un département
        metier.supprimerDepartement(departement2.getIdDepart());
        System.out.println("Département 'Mathématiques' supprimé");
    }
}
