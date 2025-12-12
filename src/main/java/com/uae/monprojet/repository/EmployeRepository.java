package com.uae.monprojet.repository;

import com.uae.monprojet.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long>{
    List<Employe> findByNom(String nom);
    List<Employe> findByNomAndAgeBetween(String nom,Integer minAge,Integer maxAge);
}
