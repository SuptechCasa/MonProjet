package com.uae.monprojet.service;

import com.uae.monprojet.model.Departement;
import com.uae.monprojet.repository.DepartementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {
    final DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    public Departement addDepartement(Departement departement) {
        System.out.println(departement.getNom());
        return departementRepository.save(departement);
    }
}
