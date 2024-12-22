package ex2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientFichiers {
    private static final String HOST = "localhost";
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             DataInputStream fileIn = new DataInputStream(socket.getInputStream())) {

            Scanner scanner = new Scanner(System.in);

            System.out.println(in.readLine()); // Message de bienvenue

            System.out.print("Entrez le nom du fichier à télécharger : ");
            String nomFichier = scanner.nextLine();
            out.println(nomFichier);

            String reponse = in.readLine();
            System.out.println("Serveur : " + reponse);

            if (reponse.contains("Envoi en cours")) {
                File fichierRecu = new File("reçu_" + nomFichier);
                try (FileOutputStream fos = new FileOutputStream(fichierRecu)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = fileIn.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                        if (bytesRead < buffer.length) {
                            break;
                        }
                    }
                    System.out.println("Fichier téléchargé : " + fichierRecu.getAbsolutePath());
                }
            } else {
                System.out.println("Le fichier demandé est introuvable.");
            }
        } catch (IOException e) {
            System.err.println("Erreur client : " + e.getMessage());
        }
    }
}
