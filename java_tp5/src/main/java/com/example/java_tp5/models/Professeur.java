package com.example.java_tp5.models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Professeur {
    private int idProf;
    private String nom;
    private String prenom;
    private String cin;
    private String adresse;
    private String telephone;
    private String email;
    private Date dateRecrutement;
    private Departement departement;

    public Professeur(String dupont, String jean, String s, String s1, String s2, String s3, Date date, Departement departement1) {
    }
}
