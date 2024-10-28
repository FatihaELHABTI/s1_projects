package tp2.ex3;

class LigneCommande {
    private int quantite;
    private Commande commande;
    private Ordinateur ordinateur;

    public LigneCommande(int quantite, Commande commande, Ordinateur ordinateur) {
        this.quantite = quantite;
        this.commande = commande;
        this.ordinateur = ordinateur;
    }

    @Override
    public String toString() {
        return "LigneCommande{" +
                "quantite=" + quantite +
                ", ordinateur=" + ordinateur +
                '}';
    }
}
