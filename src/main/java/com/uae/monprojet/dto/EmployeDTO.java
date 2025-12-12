package com.uae.monprojet.dto;

import com.uae.monprojet.model.Departement;
import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Setter
@Getter
public class EmployeDTO {
    Long id;
    String nom;
    int age;
    String photo;
    DepartementDTO departement;

}
