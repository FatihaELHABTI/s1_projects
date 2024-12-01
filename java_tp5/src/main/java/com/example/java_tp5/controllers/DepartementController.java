package com.example.java_tp5.controllers;

import com.example.java_tp5.dao.IMetier;
import com.example.java_tp5.dao.MetierImpl;
import com.example.java_tp5.models.Departement;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class DepartementController implements Initializable {

    @FXML
    private Button btnAjouterDep;

    @FXML
    private Button btnModifierDep;

    @FXML
    private Button btnSupprimerDep;

    @FXML
    private TableColumn<Departement, Integer> colIdDep;

    @FXML
    private TableColumn<Departement, String> colNomDep;
    @FXML
    private TableColumn<Object, Void> colActionDep;

    @FXML
    private TextField tfIdDep;

    @FXML
    private TextField tfNomDep;

    @FXML
    private TableView<Departement> tvDep;

    IMetier metier = new MetierImpl();

    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnAjouterDep) {
            insertDepartement();
        } else if(event.getSource() == btnModifierDep) {
            updateDepartement();
        } else if(event.getSource() == btnSupprimerDep){
            deleteDepartement();
        }
    }

    @FXML
    void handleMouseAction(MouseEvent event) {
        Departement selectedDep = tvDep.getSelectionModel().getSelectedItem();
        if (selectedDep != null) {
            tfIdDep.setText(String.valueOf(selectedDep.getIdDepart()));
            tfNomDep.setText(selectedDep.getNom());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showDepartements();
    }

    public void showDepartements() {
        ObservableList<Departement> departements = metier.listerDepartements();

        colIdDep.setCellValueFactory(new PropertyValueFactory<>("idDepart"));
        colNomDep.setCellValueFactory(new PropertyValueFactory<>("nom"));

        colActionDep.setCellFactory(param -> new TableCell<>() {
            private final Button actionButton = new Button("Lister Professeurs");

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
        tvDep.setItems(departements);
    }

    private void insertDepartement() {
        Departement departement = new Departement();
        departement.setIdDepart(Integer.parseInt(tfIdDep.getText()));
        departement.setNom(tfNomDep.getText());
        metier.ajouterDepartement(departement);
        showDepartements();
        clearFields(); // Réinitialiser les champs
    }

    private void updateDepartement() {
        Departement departement = new Departement();
        departement.setIdDepart(Integer.parseInt(tfIdDep.getText()));
        departement.setNom(tfNomDep.getText());
        metier.modifierDepartement(departement);
        showDepartements();
        clearFields(); // Réinitialiser les champs
    }

    private void deleteDepartement() {
        int idDepart = Integer.parseInt(tfIdDep.getText());
        metier.supprimerDepartement(idDepart);
        showDepartements();
        clearFields(); // Réinitialiser les champs
    }

    private void clearFields() {
        tfIdDep.clear();
        tfNomDep.clear();
    }
}
