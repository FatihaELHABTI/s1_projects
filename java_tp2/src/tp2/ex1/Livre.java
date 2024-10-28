package tp2.ex1;

public class Livre {

    private int isbn;
    private Auteur aut;

    public Livre(int isbn, Auteur aut) {
        this.isbn = isbn;
        this.aut = aut;
    }

    public void afficher(){
        System.out.println("ISBN : " + isbn);
        System.out.println("L'auteur du livre est : ");
        aut.afficher();
    }
}
