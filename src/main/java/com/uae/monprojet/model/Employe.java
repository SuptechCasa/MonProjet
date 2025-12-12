package com.uae.monprojet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
@DynamicUpdate
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    int age;
    String photo;
    @ManyToOne
    @JoinColumn(name = "departement_id")
    Departement departement;
}
