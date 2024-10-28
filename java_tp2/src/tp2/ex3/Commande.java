package tp2.ex3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Commande {
    private String reference;
    private Client client;
    private Date dateCommande;
    private String etatCommande;
    private List<LigneCommande> lignesCommande;

    public Commande(String reference, Client client, Date dateCommande, String etatCommande) {
        this.reference = reference;
        this.client = client;
        this.dateCommande = dateCommande;
        this.etatCommande = etatCommande;
        this.lignesCommande = new ArrayList<>();
    }

    public void ajouterLigneCommande(LigneCommande ligneCommande) {
        lignesCommande.add(ligneCommande);
    }

    @Override
    public String toString() {
        return "Commande{" +
                "reference='" + reference + '\'' +
                ", client=" + client +
                ", dateCommande=" + dateCommande +
                ", etatCommande='" + etatCommande + '\'' +
                ", lignesCommande=" + lignesCommande +
                '}';
    }
}