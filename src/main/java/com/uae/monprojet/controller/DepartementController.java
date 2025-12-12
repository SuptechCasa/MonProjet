package com.uae.monprojet.controller;

import com.uae.monprojet.dto.DepartementDTO;
import com.uae.monprojet.dto.EmployeDTO;
import com.uae.monprojet.model.Departement;
import com.uae.monprojet.model.Employe;
import com.uae.monprojet.repository.DepartementRepository;
import com.uae.monprojet.service.DepartementService;
import com.uae.monprojet.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("rh")
public class DepartementController {
    final DepartementService departementService;
    private final EmployeService employeService;

    public DepartementController(DepartementService departementService, EmployeService employeService) {
        this.departementService = departementService;
        this.employeService = employeService;
    }
    @GetMapping("departements")
    List<DepartementDTO> findAll() {
        return departementService.getAllDepartements();
    }
    @PostMapping("departements")
    Departement addDepartement(@RequestBody Departement departement) {
        return departementService.addDepartement(departement);
    }
    @PostMapping("departements/{idDep}/employes")
    ResponseEntity<EmployeDTO> addEmploye(
            @PathVariable UUID idDep,
            @RequestPart("employe") String employejson,
            @RequestPart("photo") MultipartFile photo
    ) throws IOException {
        String path="src/main/resources/static/photos/"+photo.getOriginalFilename();
        photo.transferTo(Path.of(path));
        ObjectMapper mapper = new ObjectMapper();
        Employe employe= mapper.readValue(employejson,Employe.class);
        employe.setPhoto("http://localhost:8080/photos/"+photo.getOriginalFilename());
        Departement departement=departementService.getDepartementById(idDep);
        employe.setDepartement(departement);
        Employe emp=employeService.addEmploye(employe);
        return ResponseEntity.ok(emp.toDTO());
    }

}
