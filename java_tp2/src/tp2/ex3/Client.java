package tp2.ex3;

import java.util.ArrayList;
import java.util.List;

class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String ville;
    private String telephone;
    private List<Commande> commandes;

    public Client(String nom, String prenom, String adresse, String email, String ville, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.ville = ville;
        this.telephone = telephone;
        this.commandes = new ArrayList<>();
    }

    public void ajouterCommande(Commande commande) {
        if (!commandes.contains(commande)) {
            commandes.add(commande);
        }
    }

    public void supprimerCommande(Commande commande) {
        if (commandes.contains(commande)){
            commandes.remove(commande);

        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", ville='" + ville + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}

