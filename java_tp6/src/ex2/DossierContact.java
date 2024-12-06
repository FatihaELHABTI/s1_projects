package ex2;
import java.io.*;
import java.util.*;

public class DossierContact {
    private Map<String, String> contacts;
    private final String dossier;

    // Constructeur : Initialise le dossier et charge les données existantes
    public DossierContact(String cheminDossier) {
        this.dossier = cheminDossier;
        this.contacts = new HashMap<>();
        chargerContacts();
    }

    // Charger les contacts depuis les fichiers
    private void chargerContacts() {
        File dossierFichiers = new File(dossier);

        if (!dossierFichiers.exists()) {
            dossierFichiers.mkdirs(); // Créer le dossier s'il n'existe pas
        }

        File[] fichiers = dossierFichiers.listFiles();
        if (fichiers != null) {
            for (File fichier : fichiers) {
                if (fichier.isFile() && fichier.getName().toLowerCase().endsWith(".txt")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
                        String numero = reader.readLine();
                        // Enregistrer le nom du fichier sans l'extension
                        String nomSansExtension = fichier.getName().replaceFirst("[.][^.]+$", "");
                        contacts.put(nomSansExtension, numero);
                    } catch (IOException e) {
                        System.err.println("Erreur lors de la lecture du fichier : " + fichier.getName());
                    }
                }
            }
        }
    }

    // Sauvegarder les contacts dans des fichiers
    public void sauvegarderContacts() {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            String nom = entry.getKey();
            String numero = entry.getValue();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(dossier, nom + ".txt")))) {
                writer.write(numero);
            } catch (IOException e) {
                System.err.println("Erreur lors de l'écriture du fichier : " + nom);
            }
        }
    }

    // Ajouter un contact
    public void ajouterContact(String nom, String numero) {
        if (contacts.containsKey(nom)) {
            System.out.println("Le contact existe déjà !");
        } else {
            contacts.put(nom, numero);
            System.out.println("Contact ajouté avec succès !");
        }
    }

    // Supprimer un contact
    public void supprimerContact(String nom) {
        if (contacts.remove(nom) != null) {
            File fichier = new File(dossier, nom + ".txt");
            if (fichier.delete()) {
                System.out.println("Contact supprimé avec succès !");
            } else {
                System.out.println("Le contact a été supprimé de la liste mais le fichier n'a pas pu être supprimé.");
            }
        } else {
            System.out.println("Contact introuvable !");
        }
    }

    // Rechercher un numéro par nom
    public String rechercherContact(String nom) {
        return contacts.getOrDefault(nom, null);
    }

    // Modifier un numéro de téléphone
    public void modifierNumero(String nom, String nouveauNumero) {
        if (contacts.containsKey(nom)) {
            contacts.put(nom, nouveauNumero);
            System.out.println("Numéro modifié avec succès !");
        } else {
            System.out.println("Contact introuvable !");
        }
    }
}
