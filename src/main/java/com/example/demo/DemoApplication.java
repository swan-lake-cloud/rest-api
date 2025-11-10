package com.example.demo;

import com.example.employee.Employee;
import com.example.employee.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository employeeRepository) {
        return args -> {
            Set<Employee> set = new HashSet<>();
            Employee emp = new Employee("Alice", "Dev"); // id = null
            set.add(emp);

            System.out.println("Avant save - ID: " + emp.getId());
            System.out.println("HashCode avant save: " + emp.hashCode());

            employeeRepository.save(emp); // id devient généré (ex: 1)

            System.out.println("Après save - ID: " + emp.getId());
            System.out.println("HashCode après save: " + emp.hashCode());
            System.out.println("Set contient l'employé: " + set.contains(emp)); // true
        };
    }
}
