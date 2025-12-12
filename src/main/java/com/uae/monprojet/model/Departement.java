package com.uae.monprojet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor @AllArgsConstructor @Setter @Getter
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String nom;
    List<Employe> employes;
}
