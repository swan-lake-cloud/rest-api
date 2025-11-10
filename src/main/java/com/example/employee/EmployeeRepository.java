package com.example.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);           // Recherche par nom
    List<Employee> findByPosition(String position);
    // Spring Data JPA génère automatiquement les méthodes save(), findById(), findAll(), etc.
}