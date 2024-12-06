package ex1;

import java.io.File;

public class SimulerCommandeLs {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Demander à l'utilisateur d'entrer le chemin du répertoire
        System.out.print("Veuillez entrer le chemin complet du répertoire : ");
        String chemin = scanner.nextLine();

        // Créer une instance de fichier à partir du chemin
        File repertoire = new File(chemin);

        // Vérifier si le chemin est valide et est un répertoire
        if (repertoire.exists() && repertoire.isDirectory()) {
            // Appel à la méthode pour afficher les fichiers et répertoires
            listerFichiersEtRepertoires(repertoire, "");
        } else {
            System.out.println("Le chemin fourni n'est pas un répertoire valide.");
        }

        scanner.close();
    }

    private static void listerFichiersEtRepertoires(File repertoire, String prefix) {
        File[] fichiers = repertoire.listFiles(); // Liste des fichiers et répertoires

        if (fichiers != null) {
            for (File fichier : fichiers) {
                String type = fichier.isDirectory() ? "<DIR>" : "<FILE>";
                String droits = (fichier.canRead() ? "r" : "-") +
                        (fichier.canWrite() ? "w" : "-") +
                        (fichier.isHidden() ? "h" : "-");

                System.out.println(prefix + fichier.getAbsolutePath() + " " + type + " " + droits);

                // Si le fichier est un répertoire, exploration récursive
                if (fichier.isDirectory()) {
                    listerFichiersEtRepertoires(fichier, prefix + "  ");
                }
            }
        } else {
            System.out.println(prefix + "Impossible de lister le contenu du répertoire : " + repertoire.getAbsolutePath());
        }
    }
}
