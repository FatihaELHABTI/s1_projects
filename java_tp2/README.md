# Java Exercises: Inheritance, Overriding, Polymorphism, Abstract Classes, and Interfaces

## Introduction
This project consists of Java applications that demonstrate concepts such as inheritance, method overriding, polymorphism, abstract classes, and interfaces. Each exercise targets specific functionalities relevant to managing various systems.

## Exercises

### Exercise 1: Library Management System
- **Objective**: Create an application to manage books and library members.
- **Classes**:
  - **Person**: Contains attributes like `nom`, `prenom`, `email`, `tel`, and `age`.
  - **Adherent**: Inherits from `Person`, adds `numAdherent`, and overrides the `afficher()` method.
  - **Auteur**: Inherits from `Person`, adds `numAuteur`, and overrides the `afficher()` method.
  - **Livre**: Contains `ISBN` and an `Auteur`. Implements the `afficher()` method.
- **Main Application**:
  - Instantiate an `Adherent`.
  - Instantiate a `Livre` written by an `Auteur`.
  - Display information for both the `Adherent` and the `Livre`.

### Exercise 2: Employee Salary Management System
- **Objective**: Create an application to manage the salaries of engineers and managers.
- **Classes**:
  - **Employe**: Abstract class with attributes `nom`, `prenom`, `email`, `telephone`, and `salaire`. Includes the abstract method `calculerSalaire()`.
  - **Ingénieur**: Inherits from `Employe`, adds the attribute `specialité`, and implements `calculerSalaire()` with a 15% increase.
  - **Manager**: Inherits from `Employe`, adds the attribute `service`, and implements `calculerSalaire()` with a 20% increase.
- **Main Application**:
  - Instantiate an `Ingénieur`.
  - Instantiate a `Manager`.
  - Display information for both the `Ingénieur` and the `Manager`.

### Exercise 3: Computer Order Management System
- **Objective**: Create an application to manage computer orders for a company.
- **Classes**:
  - **Ordinateur**: Contains attributes `nom`, `marque`, `prix`, `description`, and `nombreEnStock`. Includes a method to calculate price based on quantity.
  - **Catégorie**: Manages a list of `Ordinateur` and methods to add, remove, and search computers by price.
  - **Commande**: Contains attributes for the order reference, client details, order date, and status.
  - **LigneCommande**: Contains quantity, command details, and ordered computer.
  - **Client**: Contains attributes for client details and methods to add/remove orders.
- **Main Application**:
  - Instantiate a list of three `Ordinateur`.
  - Instantiate a `Catégorie`.
  - Instantiate a `Client`.
  - Instantiate a `Commande` for the `Client`.
  - Instantiate three `LigneCommande` for the created order.
  - Display all order information.

### Exercise 4: Product Management System
- **Objective**: Manage a collection of products using lists and interfaces.
- **Classes**:
  - **Produit**: Contains attributes `id`, `nom`, `marque`, `prix`, `description`, and `nombreEnStock`.
  - **IMetierProduit**: Interface with methods for product management: `add`, `getAll`, `findByNom`, `findById`, and `delete`.
  - **MetierProduitImpl**: Implements `IMetierProduit`, managing a list of products.
- **Main Application**:
  - Presents a menu for user interactions:
    1. Display product list.
    2. Search products by keyword.
    3. Add a new product.
    4. Retrieve product by ID.
    5. Delete product by ID.
    6. Exit the program.

## Requirements
- Java Development Kit (JDK) version 8 or above.

## Usage
Each exercise can be run independently in a Java IDE or via command line:
```bash
javac tp2/exercise1/*.java
java tp2.exercise1.Application
