package ex3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {
    private List<Produit> produits;
    private final String fichier;

    public MetierProduitImpl(String fichier) {
        this.fichier = fichier;
        this.produits = new ArrayList<>();
        charger();
    }

    @Override
    public Produit add(Produit produit) {
        produits.add(produit);
        return produit;
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public Produit findByNom(String nom) {
        return produits.stream()
                .filter(p -> p.getNom().equalsIgnoreCase(nom))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(String nom) {
        produits.removeIf(p -> p.getNom().equalsIgnoreCase(nom));
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(produits);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void charger() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            produits = (List<Produit>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            produits = new ArrayList<>();
        }
    }
}

