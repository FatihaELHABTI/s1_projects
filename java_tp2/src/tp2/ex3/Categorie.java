package tp2.ex3;

import java.util.ArrayList;
import java.util.List;

class Categorie {
    private String nom;
    private String description;
    private List<Ordinateur> ordinateurs;

    public Categorie(String nom, String description) {
        this.nom = nom;
        this.description = description;
        this.ordinateurs = new ArrayList<>();
    }

    public void ajouterOrdinateur(Ordinateur ordinateur) {
        if (!ordinateurs.contains(ordinateur)) {
            ordinateurs.add(ordinateur);
        }
    }

    public void supprimerOrdinateur(Ordinateur ordinateur) {
        if (ordinateurs.contains(ordinateur)){
            ordinateurs.remove(ordinateur);

        }
    }

    public List<Ordinateur> rechercherParPrix(double prix) {
        List<Ordinateur> resultat = new ArrayList<>();
        for (Ordinateur ord : ordinateurs) {
            if (ord.getPrix() == prix) {
                resultat.add(ord);
            }
        }
        return resultat;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", ordinateurs=" + ordinateurs +
                '}';
    }
}

