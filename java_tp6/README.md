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
