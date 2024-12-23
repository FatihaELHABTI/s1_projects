package tpcollections.ex3;

import java.util.HashSet;
import java.util.Set;

public class GestionGroupesEtudiants {
    public static void main(String[] args) {
        // 1. Créer deux HashSet pour les groupes A et B
        Set<String> groupeA = new HashSet<>();
        Set<String> groupeB = new HashSet<>();

        // 2. Ajouter des noms d'étudiants aux deux HashSet
        groupeA.add("Fatiha");
        groupeA.add("Malak");
        groupeA.add("Laila");
        groupeA.add("Yassine");

        groupeB.add("Fatiha");
        groupeB.add("Laila");
        groupeB.add("Saad");
        groupeB.add("Yahya");

        // Afficher les deux groupes
        System.out.println("Groupe A : " + groupeA);
        System.out.println("Groupe B : " + groupeB);

        // 3. Afficher l'intersection des deux HashSets
        Set<String> intersection = new HashSet<>(groupeA);
        intersection.retainAll(groupeB);
        System.out.println("Intersection des groupes A et B : " + intersection);
        /*
        //une autre maniere a faire :
        for (String element : groupeA) {
            if (groupeB.contains(element)) {
                intersection.add(element); // Ajouter les éléments communs à l'intersection
            }
        }*/

        // 4. Afficher l'union des deux HashSets
        Set<String> union = new HashSet<>(groupeA);
        union.addAll(groupeB);
        System.out.println("Union des groupes A et B : " + union);

        /*
        Set<String> union = new HashSet<>();
        // Ajouter tous les éléments de groupeA
        for (String element : groupeA) {
            union.add(element);
        }

        // Ajouter tous les éléments de groupeB (les doublons seront ignorés automatiquement)
        for (String element : groupeB) {
            union.add(element);
        }
        *
        * */
    }
}

