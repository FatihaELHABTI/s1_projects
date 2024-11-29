package com.example.java_tp5.dao;

import com.example.java_tp5.config.SingletonConnexionDB;
import com.example.java_tp5.models.Departement;
import com.example.java_tp5.models.Professeur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements IMetier {
    private Connection connection = SingletonConnexionDB.getConnexion();

    @Override
    public void ajouterProfesseur(Professeur prof) {
        try {
            String query = "INSERT INTO Professeur (nom, prenom, cin, adresse, telephone, email, date_recrutement, id_depart) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, prof.getNom());
            ps.setString(2, prof.getPrenom());
            ps.setString(3, prof.getCin());
            ps.setString(4, prof.getAdresse());
            ps.setString(5, prof.getTelephone());
            ps.setString(6, prof.getEmail());
            ps.setDate(7, new java.sql.Date(prof.getDateRecrutement().getTime()));
            ps.setObject(8, prof.getDepartement() != null ? prof.getDepartement().getIdDepart() : null);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Professeur> listerProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String query = "SELECT * FROM Professeur";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Professeur prof = new Professeur();
                prof.setIdProf(rs.getInt("id_prof"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setCin(rs.getString("cin"));
                prof.setAdresse(rs.getString("adresse"));
                prof.setTelephone(rs.getString("telephone"));
                prof.setEmail(rs.getString("email"));
                prof.setDateRecrutement(rs.getDate("date_recrutement"));
                professeurs.add(prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    @Override
    public void modifierProfesseur(Professeur prof) {
        try {
            String query = "UPDATE Professeur SET nom = ?, prenom = ?, cin = ?, adresse = ?, telephone = ?, email = ?, date_recrutement = ?, id_depart = ? WHERE id_prof = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, prof.getNom());
            ps.setString(2, prof.getPrenom());
            ps.setString(3, prof.getCin());
            ps.setString(4, prof.getAdresse());
            ps.setString(5, prof.getTelephone());
            ps.setString(6, prof.getEmail());
            ps.setDate(7, new java.sql.Date(prof.getDateRecrutement().getTime()));
            ps.setObject(8, prof.getDepartement() != null ? prof.getDepartement().getIdDepart() : null);
            ps.setInt(9, prof.getIdProf());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerProfesseur(int idProf) {
        try {
            String query = "DELETE FROM Professeur WHERE id_prof = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idProf);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Professeur chercherProfesseurParId(int idProf) {
        Professeur prof = null;
        try {
            String query = "SELECT * FROM Professeur WHERE id_prof = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idProf);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                prof = new Professeur();
                prof.setIdProf(rs.getInt("id_prof"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setCin(rs.getString("cin"));
                prof.setAdresse(rs.getString("adresse"));
                prof.setTelephone(rs.getString("telephone"));
                prof.setEmail(rs.getString("email"));
                prof.setDateRecrutement(rs.getDate("date_recrutement"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prof;
    }

    @Override
    public List<Professeur> chercherProfesseursParMotCle(String motCle) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String query = "SELECT * FROM Professeur WHERE nom LIKE ? OR prenom LIKE ? OR cin LIKE ? OR email LIKE ?";
            PreparedStatement ps = connection.prepareStatement(query);
            String pattern = "%" + motCle + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);
            ps.setString(3, pattern);
            ps.setString(4, pattern);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Professeur prof = new Professeur();
                prof.setIdProf(rs.getInt("id_prof"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setCin(rs.getString("cin"));
                prof.setAdresse(rs.getString("adresse"));
                prof.setTelephone(rs.getString("telephone"));
                prof.setEmail(rs.getString("email"));
                prof.setDateRecrutement(rs.getDate("date_recrutement"));
                professeurs.add(prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    @Override
    public void ajouterDepartement(Departement depart) {
        try {
            String query = "INSERT INTO Departement (nom) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, depart.getNom());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Departement> listerDepartements() {
        List<Departement> departements = new ArrayList<>();
        try {
            String query = "SELECT * FROM Departement";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Departement depart = new Departement();
                depart.setIdDepart(rs.getInt("id_depart"));
                depart.setNom(rs.getString("nom"));
                departements.add(depart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }

    @Override
    public void modifierDepartement(Departement depart) {
        try {
            String query = "UPDATE Departement SET nom = ? WHERE id_depart = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, depart.getNom());
            ps.setInt(2, depart.getIdDepart());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerDepartement(int idDepart) {
        try {
            String query = "DELETE FROM Departement WHERE id_depart = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idDepart);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Professeur> listerProfesseursParDepartement(int idDepart) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String query = "SELECT * FROM Professeur WHERE id_depart = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idDepart);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Professeur prof = new Professeur();
                prof.setIdProf(rs.getInt("id_prof"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setCin(rs.getString("cin"));
                prof.setAdresse(rs.getString("adresse"));
                prof.setTelephone(rs.getString("telephone"));
                prof.setEmail(rs.getString("email"));
                prof.setDateRecrutement(rs.getDate("date_recrutement"));
                professeurs.add(prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    @Override
    public void affecterProfesseurADepartement(int idProf, int idDepart) {
        try {
            String query = "UPDATE Professeur SET id_depart = ? WHERE id_prof = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idDepart);
            ps.setInt(2, idProf);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
