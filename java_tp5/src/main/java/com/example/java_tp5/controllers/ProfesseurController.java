package com.example.java_tp5.controllers;

import com.example.java_tp5.dao.IMetier;
import com.example.java_tp5.dao.MetierImpl;
import com.example.java_tp5.models.Professeur;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class ProfesseurController implements Initializable {

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnRechercher;

    @FXML
    private Button btnSupprimer;

    @FXML
    private TableColumn<Object, Void> colAction;

    @FXML
    private TableColumn<Professeur, String> colAdresse;

    @FXML
    private TableColumn<Professeur, String> colCin;

    @FXML
    private TableColumn<Professeur, Date> colDate;

    @FXML
    private TableColumn<Professeur, String> colEmail;

    @FXML
    private TableColumn<Professeur, Integer> colId;

    @FXML
    private TableColumn<Professeur, String> colNom;

    @FXML
    private TableColumn<Professeur, String > colPrenom;

    @FXML
    private TableColumn<Professeur, String> colTel;

    @FXML
    private DatePicker dpDate;

    @FXML
    private TextField tfAdresse;

    @FXML
    private TextField tfCin;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfNom;

    @FXML
    private TextField tfPrenom;

    @FXML
    private TextField tfRechercher;

    @FXML
    private TextField tfTelephone;

    @FXML
    private TableView<Professeur> tvProf;

    IMetier metier = new MetierImpl();

    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnAjouter) {
            insertProf();

        }else if(event.getSource() == btnModifier) {
            updateProf();

        }else if(event.getSource() == btnSupprimer){
            deleteProf();
        }

    }
    @FXML
    void handleMouseAction(MouseEvent event) {

        Professeur selectedProf = tvProf.getSelectionModel().getSelectedItem();
        if (selectedProf != null) {
            // Remplir les champs avec les données du professeur sélectionné
            tfId.setText(String.valueOf(selectedProf.getIdProf()));
            tfNom.setText(selectedProf.getNom());
            tfPrenom.setText(selectedProf.getPrenom());
            tfCin.setText(selectedProf.getCin());
            tfAdresse.setText(selectedProf.getAdresse());
            tfTelephone.setText(selectedProf.getTelephone());
            tfEmail.setText(selectedProf.getEmail());

            // Convertir la date de type java.util.Date en java.time.LocalDate
            if (selectedProf.getDateRecrutement() != null) {
                dpDate.setValue(new java.sql.Date(selectedProf.getDateRecrutement().getTime()).toLocalDate());
            } else {
                dpDate.setValue(null); // Réinitialiser si la date est null
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showProfesseurs();
    }

    public void showProfesseurs(){
        ObservableList<Professeur> profs =  metier.listerProfesseurs();

        colId.setCellValueFactory(new PropertyValueFactory<Professeur,Integer>("idProf"));
        colNom.setCellValueFactory(new PropertyValueFactory<Professeur,String>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<Professeur,String>("prenom"));
        colCin.setCellValueFactory(new PropertyValueFactory<Professeur,String>("cin"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<Professeur,String>("adresse"));
        colTel.setCellValueFactory(new PropertyValueFactory<Professeur,String>("telephone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Professeur,String>("email"));
        colDate.setCellFactory(column -> {
            return new TableCell<Professeur, Date>() {
                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(new SimpleDateFormat("dd/MM/yyyy").format(item));
                    }
                }
            };
        });

        colAction.setCellFactory(param -> new TableCell<>() {
            private final Button actionButton = new Button("Assigner");

            @Override
            protected void updateItem(Void unused, boolean empty) {
                super.updateItem(unused, empty);

                if (empty) {
                    setGraphic(null); // Cellule vide
                } else {
                    setGraphic(actionButton); // Affiche le bouton
                }
            }
        });
        tvProf.setItems(profs);
    }

    private void insertProf(){
        Professeur prof = new Professeur();
        prof.setIdProf(Integer.parseInt(tfId.getText()));
        prof.setNom(tfNom.getText());
        prof.setPrenom(tfPrenom.getText());
        prof.setCin(tfCin.getText());
        prof.setAdresse(tfAdresse.getText());
        prof.setTelephone(tfTelephone.getText());
        prof.setEmail(tfEmail.getText());
        LocalDate dateRecrutement = dpDate.getValue();
        LocalDate localDate = dpDate.getValue();
        if (localDate != null) {
            // Conversion de LocalDate à java.util.Date
            java.util.Date date = java.sql.Date.valueOf(localDate);
            prof.setDateRecrutement(date);
        } else {
            // Gérer le cas où la date n'est pas sélectionnée
            prof.setDateRecrutement(null);
        }
        metier.ajouterProfesseur(prof);
        showProfesseurs();
        clearFields();// Actualisation de la table

    }

    private void updateProf(){

        Professeur prof = new Professeur();
        prof.setIdProf(Integer.parseInt(tfId.getText()));
        prof.setNom(tfNom.getText());
        prof.setPrenom(tfPrenom.getText());
        prof.setCin(tfCin.getText());
        prof.setAdresse(tfAdresse.getText());
        prof.setTelephone(tfTelephone.getText());
        prof.setEmail(tfEmail.getText());
        LocalDate dateRecrutement = dpDate.getValue();
        LocalDate localDate = dpDate.getValue();
        if (localDate != null) {
            // Conversion de LocalDate à java.util.Date
            java.util.Date date = java.sql.Date.valueOf(localDate);
            prof.setDateRecrutement(date);
        } else {
            // Gérer le cas où la date n'est pas sélectionnée
            prof.setDateRecrutement(null);
        }
        metier.modifierProfesseur(prof);
        showProfesseurs();
        clearFields();// Actualisation de la table

    }
    private void deleteProf(){
        int id = Integer.parseInt(tfId.getText());
        metier.supprimerProfesseur(id);
        showProfesseurs();
        clearFields();// Actualisation de la table
    }

    private void clearFields() {
        tfId.clear();
        tfNom.clear();
        tfPrenom.clear();
        tfCin.clear();
        tfAdresse.clear();
        tfTelephone.clear();
        tfEmail.clear();
        dpDate.setValue(null); // Réinitialiser le DatePicker
    }
}
