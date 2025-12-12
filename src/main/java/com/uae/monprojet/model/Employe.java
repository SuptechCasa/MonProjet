package com.uae.monprojet.model;

import com.uae.monprojet.dto.EmployeDTO;
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

    public EmployeDTO toDTO(){
        return new EmployeDTO(this.id,this.nom,this.age,this.photo,this.departement.toDTO());
    }
}
