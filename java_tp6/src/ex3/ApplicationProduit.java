package ex3;

import java.util.Scanner;

public class ApplicationProduit {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl("produits.dat");
        Scanner scanner = new Scanner(System.in);

        boolean quitter = false;
        while (!quitter) {
            System.out.println("\n--- Menu Produits ---");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par nom");
            System.out.println("3. Ajouter un produit");
            System.out.println("4. Supprimer un produit par nom");
            System.out.println("5. Sauvegarder les produits");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> metier.getAll().forEach(System.out::println);
                case 2 -> {
                    System.out.print("Entrez le nom du produit : ");
                    String nom = scanner.nextLine();
                    Produit produit = metier.findByNom(nom);
                    System.out.println(produit != null ? produit : "Produit introuvable.");
                }
                case 3 -> {
                    System.out.print("Entrez le nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Entrez la description : ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le stock : ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();
                    metier.add(new Produit(nom, marque, prix, description, stock));
                }
                case 4 -> {
                    System.out.print("Entrez le nom à supprimer : ");
                    String nom = scanner.nextLine();
                    metier.delete(nom);
                }
                case 5 -> metier.saveAll();
                case 6 -> quitter = true;
                default -> System.out.println("Option invalide.");
            }
        }

        scanner.close();
    }
}
