package tpcollections.ex2;

import java.util.HashMap;

public class GestionNotesEtudiants {

    public static void main(String[] args) {
        // 1. Créer un HashMap pour stocker les notes des étudiants
        HashMap<String, Double> notes = new HashMap<>();

        // 2. Insérer des notes des étudiants
        notes.put("Fatiha", 15.5);
        notes.put("Siham", 12.0);
        notes.put("Aya", 18.0);
        notes.put("Najat", 14.5);
        afficherNotes(notes);

        // 3. Augmenter la note d'un étudiant
        String etudiant = "Fatiha";
        if (notes.containsKey(etudiant)) {
            notes.put(etudiant, notes.get(etudiant) + 1.5); // augmenter de 1.5 points
        }
        afficherNotes(notes);

        // 4. Supprimer la note d'un étudiant
        notes.remove("Najat");
        afficherNotes(notes);

        // 5. Afficher la taille du map
        System.out.println("Taille de la liste des notes : " + notes.size());

        // 6. Afficher la note moyenne, max et min
        afficherStatistiques(notes);

        // 7. Vérifier s'il y a une note égale à 20
        if (notes.containsValue(20.0)) {
            System.out.println("Il y a une note de 20.");
        } else {
            System.out.println("Il n'y a pas de note de 20.");
        }
    }

    // Méthode pour afficher les notes avec une boucle forEach et une expression lambda
    private static void afficherNotes(HashMap<String, Double> notes) {
        System.out.println("Liste des notes des étudiants :");
        notes.forEach((nom, note) -> System.out.println(nom + " : " + note));
    }

    // Méthode pour calculer et afficher la note moyenne, max et min
    private static void afficherStatistiques(HashMap<String, Double> notes) {
        if (notes.isEmpty()) {
            System.out.println("La liste des notes est vide.");
            return;
        }

        double somme = 0;
        double max = Double.MIN_VALUE;//on peut mettre la premiere valeur de hashmap
        double min = Double.MAX_VALUE;

        for (double note : notes.values()) {
            somme += note;
            if (note > max) max = note;
            if (note < min) min = note;
        }

        double moyenne = somme / notes.size();

        System.out.println("Note moyenne : " + moyenne);
        System.out.println("Note maximale : " + max);
        System.out.println("Note minimale : " + min);
    }

}
