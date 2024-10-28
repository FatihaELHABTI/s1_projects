package tp2.ex3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Ordinateur {
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombreEnStock;
    private Categorie categorie;

    public Ordinateur(String nom, String marque, double prix, String description, int nombreEnStock, Categorie categorie) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombreEnStock = nombreEnStock;
        this.categorie = categorie;
    }

    public double calculerPrixPourQuantite(int quantite) {
        return prix * quantite;
    }

    @Override
    public String toString() {
        return "Ordinateur{" +
                "nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nombreEnStock=" + nombreEnStock +
                '}';
    }

    public double getPrix() {
        return prix;
    }
}









