package tpstreams.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManipulationDeMots {
    public static void main(String[] args) {
        List<String> mots = Arrays.asList("java", "stream", "exemple", "code", "hello", "world");

        // 1. Filtrer les mots qui contiennent la lettre "a"
        List<String> contientA = mots.stream()
                .filter(mot -> mot.contains("a"))
                .collect(Collectors.toList());
        System.out.println("Mots contenant 'a' : " + contientA);

        // 2. Filtrer les mots qui ont une longueur supérieure à 3 et inverser chaque mot
        List<String> longueurSup3Inverses = mots.stream()
                .filter(mot -> mot.length() > 3)
                .map(mot -> new StringBuilder(mot).reverse().toString())
                .collect(Collectors.toList());
        System.out.println("Mots de longueur > 3, inversés : " + longueurSup3Inverses);



        // 4. Transformer chaque chaîne en majuscules
        List<String> enMajuscules = mots.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Mots en majuscules : " + enMajuscules);

        // 5. Convertir chaque chaîne en sa longueur
        List<Integer> longueurs = mots.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Longueur de chaque mot : " + longueurs);



        // 7. Transformer chaque mot en "Nom - Index"
        List<String> motsAvecIndex = mots.stream()
                .map(mot -> mot + " - " + mots.indexOf(mot))
                .collect(Collectors.toList());
        System.out.println("Mots avec index : " + motsAvecIndex);
    }
}

/* // 3. Filtrer les mots qui contiennent la lettre "e" et les transformer en liste de caractères
        List<Character> lettresContenantE = mots.stream()
                .filter(mot -> mot.contains("e"))
                .flatMap(mot -> mot.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Caractères des mots contenant 'e' : " + lettresContenantE);

        // 6. Transformer chaque chaîne en une liste de caractères, puis aplatir en une liste unique de caractères
        List<Character> listeDeCaracteres = mots.stream()
                .flatMap(mot -> mot.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Tous les caractères aplatis : " + listeDeCaracteres);
 */