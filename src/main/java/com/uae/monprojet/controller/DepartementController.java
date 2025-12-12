package com.uae.monprojet.controller;

import com.uae.monprojet.model.Departement;
import com.uae.monprojet.repository.DepartementRepository;
import com.uae.monprojet.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rh")
public class DepartementController {
    final DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }
    @GetMapping("departements")
    List<Departement> findAll() {
        return departementService.getAllDepartements();
    }
    @PostMapping("departements")
    Departement addDepartement(@RequestBody Departement departement) {
        return departementService.addDepartement(departement);
    }
}
