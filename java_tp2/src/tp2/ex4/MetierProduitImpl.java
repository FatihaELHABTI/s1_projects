package tp2.ex4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MetierProduitImpl implements IMetierProduit {
    private List<Produit> produits;

    public MetierProduitImpl() {
        this.produits = new ArrayList<>();
    }

    @Override
    public Produit addProduit(Produit produit) {
        if (!produits.contains(produit)) {
            produits.add(produit);
            return produit;
        }
        return null;
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public List<Produit> findByName(String motCle) {
        List<Produit> listResult = new ArrayList<>();
        for (Produit p : produits) {
            if (p.getNom().contains(motCle)) {
                listResult.add(p);
            }
        }
        return listResult;
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : produits) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        Iterator<Produit> iterator = produits.iterator();
        while (iterator.hasNext()) {
            Produit p = iterator.next();
            if (p.getId() == id) {
                iterator.remove(); // Suppression via l'itérateur
                break; // Sortir après la suppression
            }
        }
    }
}
