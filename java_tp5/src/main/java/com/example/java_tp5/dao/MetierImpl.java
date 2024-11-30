package com.example.java_tp5.dao;

import com.example.java_tp5.config.SingletonConnexionDB;
import com.example.java_tp5.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements IMetier {
    private Connection connection = SingletonConnexionDB.getConnection();

    // Add a professor
    @Override
    public void ajouterProfesseur(Professeur professeur) {
        try {
            String sql = "INSERT INTO professeur (nom, prenom, cin, adresse, telephone, email, date_recrutement, id_depart) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, professeur.getNom());
            ps.setString(2, professeur.getPrenom());
            ps.setString(3, professeur.getCin());
            ps.setString(4, professeur.getAdresse());
            ps.setString(5, professeur.getTelephone());
            ps.setString(6, professeur.getEmail());
            ps.setDate(7, new java.sql.Date(professeur.getDateRecrutement().getTime()));
            if (professeur.getDepartement() != null) {
                ps.setInt(8, professeur.getDepartement().getIdDepart());
            } else {
                ps.setObject(8, null);  // Passez null pour le département
            }ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update professor
    @Override
    public void modifierProfesseur(Professeur professeur) {
        try {
            String sql = "UPDATE professeur SET nom = ?, prenom = ?, cin = ?, adresse = ?, telephone = ?, email = ?, date_recrutement = ?, id_depart = ? WHERE id_prof = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, professeur.getNom());
            ps.setString(2, professeur.getPrenom());
            ps.setString(3, professeur.getCin());
            ps.setString(4, professeur.getAdresse());
            ps.setString(5, professeur.getTelephone());
            ps.setString(6, professeur.getEmail());
            ps.setDate(7, new java.sql.Date(professeur.getDateRecrutement().getTime()));
            ps.setObject(8, professeur.getDepartement() != null ? professeur.getDepartement().getIdDepart() : null);
            ps.setInt(9, professeur.getIdProf());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete professor
    @Override
    public void supprimerProfesseur(int idProf) {
        try {
            String sql = "DELETE FROM professeur WHERE id_prof = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idProf);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // List all professors
    @Override
    public List<Professeur> listerProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM professeur";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
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

    // Search professors by keyword
    @Override
    public List<Professeur> chercherProfesseursParMotCle(String motCle) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM professeur WHERE nom LIKE ? OR prenom LIKE ? OR email LIKE ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + motCle + "%");
            ps.setString(2, "%" + motCle + "%");
            ps.setString(3, "%" + motCle + "%");
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

    // Assign a professor to a department
    @Override
    public void affecterProfesseurADepartement(int idProf, int idDepart) {
        try {
            String sql = "UPDATE professeur SET id_depart = ? WHERE id_prof = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idDepart);
            ps.setInt(2, idProf);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add a department
    @Override
    public void ajouterDepartement(Departement departement) {
        try {
            String sql = "INSERT INTO departement (nom) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, departement.getNom());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update a department
    @Override
    public void modifierDepartement(Departement departement) {
        try {
            String sql = "UPDATE departement SET nom = ? WHERE id_depart = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, departement.getNom());
            ps.setInt(2, departement.getIdDepart());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a department
    @Override
    public void supprimerDepartement(int idDepart) {
        try {
            String sql = "DELETE FROM departement WHERE id_depart = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idDepart);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // List all departments
    @Override
    public List<Departement> listerDepartements() {
        List<Departement> departements = new ArrayList<>();
        try {
            String sql = "SELECT * FROM departement";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Departement dep = new Departement();
                dep.setIdDepart(rs.getInt("id_depart"));
                dep.setNom(rs.getString("nom"));
                departements.add(dep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }

    // List professors by department
    @Override
    public List<Professeur> listerProfesseursParDepartement(int idDepart) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM professeur WHERE id_depart = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
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
}

