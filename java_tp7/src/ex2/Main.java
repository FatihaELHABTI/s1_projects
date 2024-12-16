package ex2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] tableau = new int[100];
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = i + 1;
        }


        int nombreThreads = 4;
        int tailleBloc = tableau.length / nombreThreads;


        List<Thread> threads = new ArrayList<>();
        List<Sommeur> sommeurs = new ArrayList<>();


        for (int i = 0; i < nombreThreads; i++) {
            int debut = i * tailleBloc;
            int fin = (i == nombreThreads - 1) ? tableau.length : debut + tailleBloc;
            Sommeur sommeur = new Sommeur(tableau, debut, fin);
            Thread thread = new Thread(sommeur);
            sommeurs.add(sommeur);
            threads.add(thread);
            thread.start(); // Démarrer le thread
        }

        // Attendre que tous les threads terminent
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Calculer la somme totale
        int sommeTotale = 0;
        for (Sommeur sommeur : sommeurs) {
            sommeTotale += sommeur.getSomme();
        }

        // Afficher la somme totale
        System.out.println("La somme totale du tableau est : " + sommeTotale);
    }
}

