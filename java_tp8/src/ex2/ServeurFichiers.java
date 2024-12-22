package ex2;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServeurFichiers {
    private static final int PORT = 1234;
    private static final String REP_FICHIERS = "fichiers"; // Répertoire contenant les fichiers à partager

    public static void main(String[] args) {
        // Pool de threads pour gérer plusieurs clients
        ExecutorService pool = Executors.newFixedThreadPool(5); // Limité à 5 clients simultanés

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Serveur de fichiers démarré sur le port " + PORT);

            File dossier = new File(REP_FICHIERS);
            if (!dossier.exists()) {
                dossier.mkdir();
                System.out.println("Dossier de fichiers créé : " + REP_FICHIERS);
            }

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouvelle connexion : " + clientSocket.getInetAddress());
                pool.execute(new ClientHandler(clientSocket, REP_FICHIERS));
            }
        } catch (IOException e) {
            System.err.println("Erreur du serveur : " + e.getMessage());
        } finally {
            pool.shutdown();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private String repFichiers;

    public ClientHandler(Socket socket, String repFichiers) {
        this.socket = socket;
        this.repFichiers = repFichiers;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             DataOutputStream fileOut = new DataOutputStream(socket.getOutputStream())) {

            out.println("Bienvenue sur le serveur de fichiers. Entrez le nom du fichier que vous souhaitez :");

            String nomFichier = in.readLine();
            File fichier = new File(repFichiers, nomFichier);

            if (fichier.exists() && fichier.isFile()) {
                out.println("Fichier trouvé. Envoi en cours...");

                try (FileInputStream fis = new FileInputStream(fichier)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        fileOut.write(buffer, 0, bytesRead);
                    }
                    fileOut.flush();
                }
                out.println("Fichier envoyé avec succès !");
            } else {
                out.println("Erreur : Fichier non trouvé !");
            }
        } catch (IOException e) {
            System.err.println("Erreur avec le client : " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Impossible de fermer la connexion : " + e.getMessage());
            }
            System.out.println("Connexion fermée avec le client.");
        }
    }
}
