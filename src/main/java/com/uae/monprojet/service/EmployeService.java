package com.uae.monprojet.service;

import com.uae.monprojet.model.Employe;
import com.uae.monprojet.repository.EmployeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeService {
   final EmployeRepository employeRepository;
    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    public Boolean deleteEmploye(Long id) {
       employeRepository.deleteById(id);
       return !employeRepository.existsById(id);
    }
}
