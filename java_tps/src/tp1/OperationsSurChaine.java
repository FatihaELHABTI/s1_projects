package tp1;
import java.util.Scanner;

public class OperationsSurChaine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String chaine = "";  // Variable pour stocker la chaîne de caractères
        int choix;

        do {
            // Affichage du menu
            System.out.println("\nMenu :");
            System.out.println("1. Saisir une chaîne de caractères");
            System.out.println("2. Afficher la chaîne");
            System.out.println("3. Inverser la chaîne");
            System.out.println("4. Nombre de mots dans la chaîne");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la fin de ligne après nextInt()

            switch (choix) {
                case 1:
                    // Saisir la chaîne de caractères
                    System.out.print("Entrez la chaîne de caractères : ");
                    chaine = scanner.nextLine();
                    System.out.println("Frappez une touche pour revenir au menu...");
                    scanner.nextLine();
                    break;

                case 2:
                    // Afficher la chaîne saisie
                    System.out.println("La chaîne saisie est : " + chaine);
                    System.out.println("Frappez une touche pour revenir au menu...");
                    scanner.nextLine();
                    break;

                case 3:
                    // Inverser la chaîne
                    String chaineInversee = new StringBuilder(chaine).reverse().toString();
                    System.out.println("La chaîne inversée est : " + chaineInversee);
                    System.out.println("Frappez une touche pour revenir au menu...");
                    scanner.nextLine();
                    break;

                case 4:
                    // Compter le nombre de mots en utilisant un espace simple comme séparateur
                    String[] mots = chaine.trim().split(" ");
                    int nombreMots = 0;

                    // Compter les éléments non vides dans le tableau de mots
                    for (String mot : mots) {
                        if (!mot.isEmpty()) {
                            nombreMots++;
                        }
                    }

                    System.out.println("Nombre de mots dans la chaîne : " + nombreMots);
                    System.out.println("Frappez une touche pour revenir au menu...");
                    scanner.nextLine();
                    break;

                case 5:
                    // Quitter
                    System.out.println("Programme terminé.");
                    break;

                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        } while (choix != 5);

        scanner.close();
    }
}
