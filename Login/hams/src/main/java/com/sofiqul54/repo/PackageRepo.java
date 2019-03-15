package com.sofiqul54.repo;

import com.sofiqul54.entity.Ppackage;
import com.sofiqul54.entity.Role;
import com.sofiqul54.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PackageRepo extends JpaRepository<Ppackage, Long> {
    Optional<Ppackage> findByName(String name);
    boolean existsByName(String name);
}
