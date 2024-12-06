package ex3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierClientImpl implements IMetier<Client> {
    private List<Client> clients;
    private final String fichier;

    public MetierClientImpl(String fichier) {
        this.fichier = fichier;
        this.clients = new ArrayList<>();
        charger();
    }

    @Override
    public Client add(Client client) {
        clients.add(client);
        return client;
    }

    @Override
    public List<Client> getAll() {
        return clients;
    }

    @Override
    public Client findByNom(String nom) {
        return clients.stream()
                .filter(c -> c.getNom().equalsIgnoreCase(nom))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(String nom) {
        clients.removeIf(c -> c.getNom().equalsIgnoreCase(nom));
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(clients);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void charger() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            clients = (List<Client>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            clients = new ArrayList<>();
        }
    }
}
