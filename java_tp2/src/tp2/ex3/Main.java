package tp2.ex3;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Categorie categorieLaptop = new Categorie("Laptop", "Ordinateurs portables");


        Ordinateur ordi1 = new Ordinateur("Dell XPS 13", "Dell", 1200.0,
                "Ultrabook performant", 10, categorieLaptop);
        Ordinateur ordi2 = new Ordinateur("MacBook Air", "Apple",
                1500.0, "Léger et puissant", 15, categorieLaptop);
        Ordinateur ordi3 = new Ordinateur("Lenovo ThinkPad", "Lenovo",
                900.0, "Professionnel et durable", 20, categorieLaptop);


        categorieLaptop.ajouterOrdinateur(ordi1);
        categorieLaptop.ajouterOrdinateur(ordi2);
        categorieLaptop.ajouterOrdinateur(ordi3);


        Client client = new Client("Dupont", "Jean", "123 Rue de Paris",
                "jean.dupont@example.com", "Paris", "0123456789");


        Commande commande = new Commande("CMD001", client, new Date(), "En cours");


        LigneCommande ligne1 = new LigneCommande(2, commande, ordi1);
        LigneCommande ligne2 = new LigneCommande(1, commande, ordi2);
        LigneCommande ligne3 = new LigneCommande(3, commande, ordi3);


        commande.ajouterLigneCommande(ligne1);
        commande.ajouterLigneCommande(ligne2);
        commande.ajouterLigneCommande(ligne3);


        System.out.println(commande);
    }
}