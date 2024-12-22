package ex1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientNombreMagique {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 1234;

        try (Socket socket = new Socket(HOST, PORT)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.println(in.readLine()); // Message de bienvenue

            boolean trouvé = false;
            while (!trouvé) {
                System.out.print("Votre proposition : ");
                String proposition = scanner.nextLine();
                out.println(proposition);

                String response = in.readLine();
                System.out.println("Serveur : " + response);

                if (response.contains("Félicitations")) {
                    trouvé = true;
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur du client : " + e.getMessage());
        }
    }
}
