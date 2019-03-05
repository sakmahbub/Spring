package com.mahbub.securitywithsql.repo;


import com.mahbub.securitywithsql.entity.Drugtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugtypeRepo extends JpaRepository<Drugtype, Long> {
    Drugtype findByTypeName(String typeName);
}
