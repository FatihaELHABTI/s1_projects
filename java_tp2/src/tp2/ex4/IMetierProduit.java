package tp2.ex4;

import java.util.List;

public interface IMetierProduit {

    Produit addProduit(Produit produit);

    List<Produit> getAll();

    List<Produit> findByName(String motCle);

    Produit findById(long id);

    void delete(long id);
}
