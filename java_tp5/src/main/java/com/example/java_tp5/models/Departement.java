package com.example.java_tp5.models;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Departement {
    private int idDepart;
    private String nom;

    public Departement(String informatique) {
    }
}
