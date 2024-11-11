package tpcollections.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionProduitsApp {

    public static void main(String[] args) {

        //creation de la liste des produits
        ArrayList<Produit> produits = new ArrayList<>();

        //creation des objets pour les ajouter dans la liste
        Produit produit1 = new Produit(1,"produit1",123);
        Produit produit2 = new Produit(2,"produit2",12);
        Produit produit3 = new Produit(3,"produit3",267);

        //ajouter les produits dans la liste
        produits.add(produit1);
        produits.add(produit2);
        produits.add(produit3);

        //suppresion de produit3
        produits.remove(2);

        //affichage des produits
        for(Produit p : produits){
            System.out.println(p.toString());
        }

        //Modifier un produit par indice
        Produit produit =produits.get(0);
        produit.setNom("produitModifie");

        //affichage des produits
        System.out.println("La liste des produits apres modification");
        for(Produit p : produits){
            System.out.println(p.toString());
        }

        //rechercher un produit par son nom
        Scanner input = new Scanner(System.in);
        String nom ;
        System.out.println("Veuillez tapper le nom du produit que vous voulez le rechercher : ");
        nom = input.nextLine();
        for(Produit p : produits){
            if(p.getNom().equals(nom)){
                System.out.println("Trouve : " + p.toString());
            }else{
                System.out.println("produit non existant dans la liste.");
            }
        }
    }
}
