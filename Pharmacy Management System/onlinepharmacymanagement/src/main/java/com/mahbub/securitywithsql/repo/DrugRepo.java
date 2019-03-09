package com.mahbub.securitywithsql.repo;


import com.mahbub.securitywithsql.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrugRepo extends JpaRepository<Drug, Long> {
    Drug findByDrugName(String drugName);
    Drug findByDrugCode(String dc);

}
