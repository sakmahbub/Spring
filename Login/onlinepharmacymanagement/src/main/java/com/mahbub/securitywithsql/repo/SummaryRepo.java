package com.mahbub.securitywithsql.repo;

import com.mahbub.securitywithsql.entity.Drug;
import com.mahbub.securitywithsql.entity.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SummaryRepo extends JpaRepository<Summary, Long> {
    Summary findByDrugName(String drugName);


}
