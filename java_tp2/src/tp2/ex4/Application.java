package tp2.ex4;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IMetierProduit metierProduit = new MetierProduitImpl(); // Instance de la classe qui implémente l'interface
        int choix;

        do {
            System.out.println("Menu :");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher des produits par mot clé");
            System.out.println("3. Ajouter un nouveau produit");
            System.out.println("4. Récupérer et afficher un produit par ID");
            System.out.println("5. Supprimer un produit par ID");
            System.out.println("6. Quitter le programme");
            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    List<Produit> produits = metierProduit.getAll();
                    System.out.println("Liste des produits :");
                    for (Produit produit : produits) {
                        System.out.println(produit);
                    }
                    break;

                case 2:
                    System.out.print("Entrez un mot clé pour la recherche : ");
                    String motCle = scanner.nextLine();
                    List<Produit> resultats = metierProduit.findByName(motCle);
                    System.out.println("Produits trouvés :");
                    for (Produit produit : resultats) {
                        System.out.println(produit);
                    }
                    break;

                case 3:
                    System.out.print("Entrez l'ID du produit : ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // Pour consommer la nouvelle ligne
                    System.out.print("Entrez le nom du produit : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Pour consommer la nouvelle ligne
                    System.out.print("Entrez la description : ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le nombre en stock : ");
                    int stock = scanner.nextInt();
                    scanner.nextLine(); // Pour consommer la nouvelle ligne

                    Produit nouveauProduit = new Produit(id, nom, marque, prix, description, stock);
                    metierProduit.addProduit(nouveauProduit);
                    System.out.println("Produit ajouté : " + nouveauProduit);
                    break;

                case 4:
                    System.out.print("Entrez l'ID du produit à récupérer : ");
                    long idARecuperer = scanner.nextLong();
                    Produit produitTrouve = metierProduit.findById(idARecuperer);
                    if (produitTrouve != null) {
                        System.out.println("Produit trouvé : " + produitTrouve);
                    } else {
                        System.out.println("Produit non trouvé.");
                    }
                    break;

                case 5:
                    System.out.print("Entrez l'ID du produit à supprimer : ");
                    long idASupprimer = scanner.nextLong();
                    metierProduit.delete(idASupprimer);
                    System.out.println("Produit supprimé.");
                    break;

                case 6:
                    System.out.println("Quitter le programme.");
                    break;

                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
                    break;
            }
        } while (choix != 6);

        scanner.close();
    }
}

