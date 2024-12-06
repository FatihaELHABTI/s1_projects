package ex3;

import java.util.Scanner;

public class ApplicationClient {
    public static void main(String[] args) {
        MetierClientImpl metier = new MetierClientImpl("clients.dat");
        Scanner scanner = new Scanner(System.in);

        boolean quitter = false;
        while (!quitter) {
            System.out.println("\n--- Menu Clients ---");
            System.out.println("1. Afficher la liste des clients");
            System.out.println("2. Rechercher un client par nom");
            System.out.println("3. Ajouter un client");
            System.out.println("4. Supprimer un client par nom");
            System.out.println("5. Sauvegarder les clients");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            switch (choix) {
                case 1 -> {
                    // Afficher tous les clients
                    System.out.println("--- Liste des clients ---");
                    metier.getAll().forEach(System.out::println);
                }
                case 2 -> {
                    // Rechercher un client par nom
                    System.out.print("Entrez le nom du client : ");
                    String nom = scanner.nextLine();
                    Client client = metier.findByNom(nom);
                    System.out.println(client != null ? client : "Client introuvable.");
                }
                case 3 -> {
                    // Ajouter un nouveau client
                    System.out.print("Entrez le nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez le prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Entrez l'adresse : ");
                    String adresse = scanner.nextLine();
                    System.out.print("Entrez le numéro de téléphone : ");
                    String tel = scanner.nextLine();
                    System.out.print("Entrez l'email : ");
                    String email = scanner.nextLine();

                    metier.add(new Client(nom, prenom, adresse, tel, email));
                    System.out.println("Client ajouté avec succès.");
                }
                case 4 -> {
                    // Supprimer un client par nom
                    System.out.print("Entrez le nom du client à supprimer : ");
                    String nom = scanner.nextLine();
                    metier.delete(nom);
                    System.out.println("Suppression terminée.");
                }
                case 5 -> {
                    // Sauvegarder les clients dans le fichier
                    metier.saveAll();
                    System.out.println("Clients sauvegardés avec succès.");
                }
                case 6 -> {
                    // Quitter le programme
                    quitter = true;
                    System.out.println("Au revoir !");
                }
                default -> System.out.println("Option invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
    }
}

