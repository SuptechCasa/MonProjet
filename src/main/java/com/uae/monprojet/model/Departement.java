package com.uae.monprojet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uae.monprojet.dto.DepartementDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String nom;
    @OneToMany(mappedBy = "departement",cascade = CascadeType.ALL)
    List<Employe> employes;

    public DepartementDTO toDTO(){
        return new DepartementDTO(this.id,this.nom);
    }
}
