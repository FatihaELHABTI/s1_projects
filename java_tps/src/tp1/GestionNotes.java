package tp1;

import java.util.Arrays;
import java.util.Scanner;

public class GestionNotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Saisie du nombre d'étudiants
        System.out.print("Entrez le nombre d'étudiants : ");
        int nombreEtudiants = scanner.nextInt();

        // Création du tableau de notes
        double[] notes = new double[nombreEtudiants];

        // Saisie des notes
        System.out.println("Entrez les notes des étudiants :");
        for (int i = 0; i < nombreEtudiants; i++) {
            System.out.print("Note de l'étudiant " + (i + 1) + " : ");
            notes[i] = scanner.nextDouble();
        }

        // Trier le tableau des notes
        Arrays.sort(notes);

        // Afficher la liste des notes triées
        System.out.println("\nListe des notes triées :");
        for (double note : notes) {
            System.out.print(note + " ");
        }
        System.out.println();

        // Calcul et affichage de la note moyenne
        double somme = 0;
        for (double note : notes) {
            somme += note;
        }
        double moyenne = somme / nombreEtudiants;
        System.out.printf("La note moyenne est : %.2f\n", moyenne);

        // Affichage de la note maximale et minimale
        double noteMax = notes[nombreEtudiants - 1];
        double noteMin = notes[0];
        System.out.println("La note maximale est : " + noteMax);
        System.out.println("La note minimale est : " + noteMin);

        // Recherche du nombre d'étudiants ayant une note spécifique
        System.out.print("Entrez une note pour connaître le nombre d'étudiants ayant cette note : ");
        double noteRecherchee = scanner.nextDouble();

        int nombreEtudiantsAvecNote = 0;
        for (double note : notes) {
            if (note == noteRecherchee) {
                nombreEtudiantsAvecNote++;
            }
        }

        System.out.println("Nombre d'étudiants ayant la note " + noteRecherchee + " : " + nombreEtudiantsAvecNote);

        // Fermeture du scanner
        scanner.close();
    }
}
