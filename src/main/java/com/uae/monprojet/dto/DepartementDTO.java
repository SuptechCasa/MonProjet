package com.uae.monprojet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@NoArgsConstructor @AllArgsConstructor @Getter
@Setter
public class DepartementDTO {
    UUID id;
    String nom;
}
