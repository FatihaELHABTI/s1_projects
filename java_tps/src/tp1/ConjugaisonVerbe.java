package tp1;

import java.util.Scanner;

public class ConjugaisonVerbe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String verbe;

        do{
            // Demander à l'utilisateur d'entrer un verbe du premier groupe
            System.out.print("Entrez un verbe du premier groupe : ");
            verbe= scanner.nextLine().toLowerCase();
            if (!verbe.endsWith("er")){
                // Message d'erreur si le verbe n'est pas du premier groupe
                System.out.println("Le verbe doit se terminer par 'er' pour être conjugué.");
            }
        }while (!verbe.endsWith("er"));


            // Supprimer la terminaison "er" pour obtenir le radical
            String radical = verbe.substring(0, verbe.length() - 2);

            // Afficher la conjugaison au présent
            System.out.println("je " + radical + "e");
            System.out.println("tu " + radical + "es");
            System.out.println("il " + radical + "e");
            System.out.println("nous " + radical + "ons");
            System.out.println("vous " + radical + "ez");
            System.out.println("ils " + radical + "ent");

        // Fermer le scanner
        scanner.close();
    }
}

