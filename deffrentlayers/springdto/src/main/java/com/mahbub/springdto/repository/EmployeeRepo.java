package com.mahbub.springdto.repository;


import com.mahbub.springdto.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employe, Long> {
    Employe findByEmail(String email);
    long countAllByEmail(String email);
}
