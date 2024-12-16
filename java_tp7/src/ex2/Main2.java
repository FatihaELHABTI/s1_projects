package ex2;

public class Main2 {
    public static void main(String[] args) {
        // Initialisation du tableau
        int[] tableau = new int[100];
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = i + 1;
        }

        Sommeur sommeur1 = new Sommeur(tableau, 0, 25);
        Sommeur sommeur2 = new Sommeur(tableau, 25, 50);
        Sommeur sommeur3 = new Sommeur(tableau, 50, 75);
        Sommeur sommeur4 = new Sommeur(tableau, 75, 100);

        Thread t1 = new Thread(sommeur1);
        Thread t2 = new Thread(sommeur2);
        Thread t3 = new Thread(sommeur3);
        Thread t4 = new Thread(sommeur4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();


        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Calculer la somme totale
        int sommeTotale = sommeur1.getSomme() + sommeur2.getSomme() + sommeur3.getSomme() + sommeur4.getSomme();

        // Afficher la somme totale
        System.out.println("La somme totale du tableau est : " + sommeTotale);
    }
}

