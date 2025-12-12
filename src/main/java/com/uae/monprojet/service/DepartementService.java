package com.uae.monprojet.service;

import com.uae.monprojet.dto.DepartementDTO;
import com.uae.monprojet.model.Departement;
import com.uae.monprojet.repository.DepartementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartementService {
    final DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public List<DepartementDTO> getAllDepartements() {
        return departementRepository.findAll().stream().map(Departement::toDTO).toList() ;
    }

    public Departement addDepartement(Departement departement) {
        return departementRepository.save(departement);
    }
    public Departement updateDepartement(Departement departement) {
        return departementRepository.save(departement);
    }
    public Departement getDepartementById(UUID idDep) {
        return departementRepository.getReferenceById(idDep);
    }
}
