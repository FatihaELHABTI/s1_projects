# Practical Activity: Java File Handling, Generics, and Serialization

## Overview

This project focuses on practical exercises aimed at exploring **Java Generics**, **File Handling**, and **Serialization**. The exercises will guide you through concepts such as file management, managing collections of objects, and performing basic CRUD operations with serialized data. Below is a summary of the exercises covered in this repository.

---

## Exercise 1: Simulating the `ls` Command

### Description

In this exercise, we simulate the behavior of the Unix `ls` command, which lists files and directories. The program recursively explores the contents of a specified directory and prints out information about the files and directories, including:
- Type (`<DIR>` for directories, `<FILE>` for files).
- Permissions (`'r'` for read, `'w'` for write, `'h'` for hidden files).

### Code Snippet for Listing Files Recursively

```java
public void listFilesRecursive(File directory) {
    File[] files = directory.listFiles();
    if (files != null) {
        for (File file : files) {
            String type = file.isDirectory() ? "<DIR>" : "<FILE>";
            String permissions = (file.canRead() ? "r" : "-") +
                                 (file.canWrite() ? "w" : "-") +
                                 (file.isHidden() ? "h" : "-");
            System.out.println(file.getAbsolutePath() + " " + type + " " + permissions);
            if (file.isDirectory()) {
                listFilesRecursive(file);
            }
        }
    }
}
```
## Exercise 2: Managing a Phone Directory

### Description

In this exercise, we create a phone directory where each contact is stored in a separate text file. The user can perform several operations:
- **Search** for a contact by name.
- **Add** new contacts.
- **Delete** contacts.
- **Modify** a contact's phone number.
- **Save** and **load** data from files.

Each contact is stored in its own file, named after the contact's name (e.g., `FatihaElhabti.txt`), and contains the phone number. When the program starts, it will load the data from these files, and when any changes are made, it will save them back to the files.

### Code Snippet to Add a Contact

```java
public void addContact(String name, String number) {
    try {
        File contactFile = new File(DIRECTORY_PATH + name + ".txt");
        if (!contactFile.exists()) {
            contactFile.createNewFile();
        }
        FileWriter writer = new FileWriter(contactFile);
        writer.write(number);
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```
### Code Snippet to Search for a Contact
```java
public String searchContact(String name) {
    File contactFile = new File(DIRECTORY_PATH + name + ".txt");
    if (contactFile.exists()) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(contactFile));
            return reader.readLine(); // Return the phone number from the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return "Contact not found.";
}
```
### Code Snippet to Modify a Contact's Phone Number
```java
public void modifyContact(String name, String newNumber) {
    File contactFile = new File(DIRECTORY_PATH + name + ".txt");
    if (contactFile.exists()) {
        try {
            FileWriter writer = new FileWriter(contactFile);
            writer.write(newNumber);
            writer.close();
            System.out.println("Contact " + name + " modified successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("Contact not found.");
    }
}
```
### Code Snippet to Load All Contacts on Startup
```java
public void loadContacts() {
    File directory = new File(DIRECTORY_PATH);
    File[] files = directory.listFiles();
    if (files != null) {
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String contactName = file.getName().replace(".txt", "");
                    String phoneNumber = reader.readLine();
                    contacts.put(contactName, phoneNumber);
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```
## Exercise 3: Managing Products and Clients with Serialization

### Description

In this exercise, we focus on managing a collection of **Product** and **Client** objects by using **serialization**. The goal is to demonstrate how to store and retrieve objects from files while maintaining data persistence. The objects are saved to files in serialized format, and the program performs CRUD (Create, Read, Update, Delete) operations for both products and clients. The program also allows for storing these entities in separate files and loading them when the program starts.

The main components of this exercise include:
- **Product** class with attributes like name, brand, price, description, and stock quantity.
- **Client** class with attributes such as name, surname, address, phone number, and email.
- **Serialization** of objects to store data in files and deserialization to read data back into the program.
- **CRUD operations** for both products and clients, which include adding, deleting, finding, and saving these entities.

### Code Snippet for the `Product` Class

```java
import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String brand;
    private double price;
    private String description;
    private int stock;

    public Product(String name, String brand, double price, String description, int stock) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    // Getters and Setters
}
```
### Code Snippet for the IMetier Interface
```java
import java.util.List;

public interface IMetier<T> {
    T add(T o);
    List<T> getAll();
    T findByNom(String name);
    void delete(String name);
    void saveAll();
}
```
### Code Snippet for MetierProduitImpl Class (Product Management)
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Product> {
    private List<Product> products;
    private String fileName;

    public MetierProduitImpl(String fileName) {
        this.fileName = fileName;
        this.products = loadProducts();
    }

    @Override
    public Product add(Product product) {
        products.add(product);
        saveAll();
        return product;
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product findByNom(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(String name) {
        products.removeIf(product -> product.getName().equalsIgnoreCase(name));
        saveAll();
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Product> loadProducts() {
        List<Product> loadedProducts = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            loadedProducts = (List<Product>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadedProducts;
    }
}
```

