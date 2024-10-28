package tp2.ex1;

public class Main {
    public static void main(String[] args) {
        Adherent adherent = new Adherent("ELHABTI","Fatiha","elhabtiftiha07@gmail.com",
                "0604862820",22,1);

        Auteur aut = new Auteur("ELHABTI","Siham","siham@gmail.com","0704452320",30,1);
        Livre livre = new Livre(1234,aut);

        System.out.println("Les informations de l'adherent : ");
        adherent.afficher();

        System.out.println("Les informations du livre :");
        livre.afficher();
    }
}
