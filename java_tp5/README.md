# JavaFX CRUD Application

This JavaFX application allows users to manage professors and departments with basic CRUD operations (Create, Read, Update, Delete). The application integrates JavaFX for the graphical interface and JDBC for database connectivity.

## Overview

The application provides a simple interface for managing professors and departments in an educational institution. You can perform operations like adding, updating, deleting, and listing professors and departments. Additionally, there is a search feature that allows you to find professors by their name or email. The data is stored and retrieved using a relational database, ensuring persistence across application sessions.

### Features
- **Professor Management**: Add, update, delete, and list professors. Professors are associated with departments.
- **Department Management**: Add, update, delete, and list departments.
- **Search Functionality**: Search professors by keyword (name, surname, or email).
- **Data Persistence**: Data is stored and retrieved using a relational database (MySQL, SQLite, etc.).
## Screenshotes
![image_alt](https://github.com/FatihaELHABTI/s1_projects/blob/main/java_tp5/src/main/resources/imgs/screen1.PNG)
![image_alt](https://github.com/FatihaELHABTI/s1_projects/blob/main/java_tp5/src/main/resources/imgs/screen2.PNG)
### Technologies Used
- **JavaFX**: Provides the user interface for interaction.
- **JDBC**: Handles database operations.
- **Lombok**: Reduces boilerplate code by automatically generating getters, setters, constructors, and other common methods.
- **Singleton Design Pattern**: Used for managing the database connection.

## Project Structure

### 1. **DAO Layer (Data Access Object)**

The DAO (Data Access Object) layer handles all database operations such as adding, updating, deleting, and retrieving data.

#### Key Methods in `MetierImpl` (DAO Implementation):

- **`ajouterProfesseur(Professeur professeur)`**: Inserts a new professor into the `professeur` table.
    ```java
    public void ajouterProfesseur(Professeur professeur) {
        String query = "INSERT INTO professeur (nom, prenom, email, etc.) VALUES (?, ?, ?)";
        // Execute the insert query
    }
    ```
  
- **`modifierProfesseur(Professeur professeur)`**: Updates an existing professor's details.
  
- **`supprimerProfesseur(int idProf)`**: Deletes a professor by their ID.
  
- **`listerProfesseurs()`**: Retrieves all professors and returns them as an `ObservableList`.
  
- **`chercherProfesseursParMotCle(String motCle)`**: Searches professors by name, surname, or email.
  
- **`affecterProfesseurADepartement(int idProf, int idDepart)`**: Assigns a professor to a department.

- **`ajouterDepartement(Departement departement)`**: Adds a new department.
  
- **`modifierDepartement(Departement departement)`**: Updates a department's details.
  
- **`supprimerDepartement(int idDepart)`**: Deletes a department by its ID.
  
- **`listerDepartements()`**: Retrieves all departments as an `ObservableList`.
  
- **`listerProfesseursParDepartement(int idDepart)`**: Retrieves professors by their department.

### 2. **Controller Layer**

The controller layer manages user interactions and events in the UI, handling button clicks, list updates, and other actions.

#### Key Methods in the Controller Classes:

- **`insertProf()`** (in `ProfesseurController`):
    - Triggered when the user clicks the "Ajouter" button.
    - Collects input from the user and adds a new professor.
    ```java
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
    ```

- **`updateProfesseur()`** (in `ProfesseurController`):
    - Triggered when the user selects a professor to update.
    - Updates the professor's details in the database.
    

- **`deleteProfesseur()`** (in `ProfesseurController`):
    - Triggered when the user clicks the "Delete" button to delete a selected professor.

- **`searchProfesseurs()`** (in `ProfesseurController`):
    - Triggered when the user enters a search term.
    - Displays professors matching the search term.

- **`insertDepartement()`** (in `DepartementController`):
    - Triggered when the user clicks the "Ajouter" button.
    - Adds a new department to the database.
    
- **`updateDepartement()`** (in `DepartementController`):
    - Triggered when the user selects a department to update.
    - Updates the department's details.

- **`deleteDepartement()`** (in `DepartementController`):
    - Triggered when the user clicks the "Delete" button to delete a selected department.
   
#### Event Handling and UI Updates:
- The controller methods are linked to UI elements such as buttons, text fields, and list views.
- These methods process user input, update the database via DAO calls, and refresh the UI accordingly.

## Conclusion

This application serves as a basic CRUD system for managing professors and departments, demonstrating the use of JavaFX for the user interface and JDBC for data persistence. The DAO and controller layers follow clean architecture principles, separating concerns and making it easier to maintain and extend the application.
