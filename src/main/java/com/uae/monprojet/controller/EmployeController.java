package com.uae.monprojet.controller;

import com.uae.monprojet.dto.EmployeDTO;
import com.uae.monprojet.model.Employe;
import com.uae.monprojet.service.EmployeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("rh")
public class EmployeController {
    final EmployeService employeService;
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping("employes")
    List<EmployeDTO> getAllEmployees() {
        return employeService.getAllEmployes();
    }

    @GetMapping("employes/{id}")
    Employe getEmployeById(@PathVariable("id") Long id) {
        return employeService.getEmployeById(id);
    }

    @PostMapping("employes")
    public ResponseEntity<Employe> addEmploye(
            @RequestPart("employe") String employejson,
            @RequestPart("photo") MultipartFile photo
    ) throws IOException {
        String path="src/main/resources/static/photos/"+photo.getOriginalFilename();
        photo.transferTo(Path.of(path));
        ObjectMapper mapper = new ObjectMapper();
        Employe employe= mapper.readValue(employejson,Employe.class);
        employe.setPhoto("http://localhost:8080/photos/"+photo.getOriginalFilename());
        return ResponseEntity.ok(employeService.addEmploye(employe));

    }

    @DeleteMapping("employes/{id}")
    public ResponseEntity<Boolean> deleteEmploye(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeService.deleteEmploye(id));
    }
}
