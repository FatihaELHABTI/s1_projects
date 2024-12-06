package ex2;

import java.util.Scanner;

public class AnnuaireTelephonique {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DossierContact dossierContact = new DossierContact("C:\\contacts"); // Remplacez par le chemin réel

        boolean quitter = false;
        while (!quitter) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Rechercher un numéro de téléphone");
            System.out.println("2. Ajouter un nouveau contact");
            System.out.println("3. Supprimer un contact");
            System.out.println("4. Changer le numéro de téléphone d’un contact");
            System.out.println("5. Quitter ce programme");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la fin de ligne

            switch (choix) {
                case 1 -> {
                    System.out.print("Entrez le nom du contact : ");
                    String nom = scanner.nextLine();
                    String numero = dossierContact.rechercherContact(nom);
                    if (numero != null) {
                        System.out.println("Numéro de " + nom + " : " + numero);
                    } else {
                        System.out.println("Contact introuvable !");
                    }
                }
                case 2 -> {
                    System.out.print("Entrez le nom du nouveau contact : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez le numéro de téléphone : ");
                    String numero = scanner.nextLine();
                    dossierContact.ajouterContact(nom, numero);
                }
                case 3 -> {
                    System.out.print("Entrez le nom du contact à supprimer : ");
                    String nom = scanner.nextLine();
                    dossierContact.supprimerContact(nom);
                }
                case 4 -> {
                    System.out.print("Entrez le nom du contact : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez le nouveau numéro de téléphone : ");
                    String nouveauNumero = scanner.nextLine();
                    dossierContact.modifierNumero(nom, nouveauNumero);
                }
                case 5 -> {
                    quitter = true;
                    dossierContact.sauvegarderContacts();
                    System.out.println("Données sauvegardées. Au revoir !");
                }
                default -> System.out.println("Option invalide !");
            }
        }

        scanner.close();
    }
}
