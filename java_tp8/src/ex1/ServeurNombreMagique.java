package ex1;

import java.io.*;
import java.net.*;
import java.util.Random;

public class ServeurNombreMagique {
    public static void main(String[] args) {
        final int PORT = 1234;
        int nombreMagique = new Random().nextInt(101); // Nombre aléatoire entre 0 et 100
        System.out.println("Nombre magique (secret) : " + nombreMagique);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Serveur en attente de connexions sur le port " + PORT + "...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connexion établie avec : " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Bienvenue dans le jeu du Nombre Magique ! Devinez un nombre entre 0 et 100.");

            boolean trouvé = false;
            while (!trouvé) {
                String input = in.readLine();
                if (input == null) break;

                try {
                    int proposition = Integer.parseInt(input);
                    if (proposition == nombreMagique) {
                        out.println("Félicitations ! Vous avez trouvé le nombre magique.");
                        trouvé = true;
                    } else if (proposition < nombreMagique) {
                        out.println("Trop petit ! Essayez encore.");
                    } else {
                        out.println("Trop grand ! Essayez encore.");
                    }
                } catch (NumberFormatException e) {
                    out.println("Veuillez entrer un nombre valide.");
                }
            }

            System.out.println("Partie terminée. Fermeture de la connexion.");
        } catch (IOException e) {
            System.err.println("Erreur du serveur : " + e.getMessage());
        }
    }
}
