package tp1;

import java.util.Scanner;

public class CompterLettres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialisation du tableau de comptage des occurrences
        int[] nb_occurrences = new int[26];

        // Demande de saisie de la chaîne de caractères
        System.out.print("Entrez une ligne de texte (max. 100 caractères) : ");
        String ch = scanner.nextLine().toUpperCase();  // Convertir en majuscules pour ne pas différencier majuscules/minuscules

        // Parcourir chaque caractère de la chaîne
        for (int i = 0; i < ch.length(); i++) {
            char caractere = ch.charAt(i);

            // Vérifier si le caractère est une lettre (A à Z)
            if (caractere >= 'A' && caractere <= 'Z') {
                // Incrémenter le compteur pour la lettre correspondante
                nb_occurrences[caractere - 'A']++;
            }
        }

        // Affichage des lettres avec au moins une occurrence
        System.out.println("\nLa chaîne \"" + ch + "\" contient :");
        for (int i = 0; i < nb_occurrences.length; i++) {
            if (nb_occurrences[i] > 0) {
                char lettre = (char) (i + 'A');
                System.out.println(nb_occurrences[i] + " fois la lettre '" + lettre + "'");
            }
        }

        // Fermeture du scanner
        scanner.close();
    }
}

