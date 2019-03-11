package com.mahbub.securitywithsql.repo;




import com.mahbub.securitywithsql.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepo extends JpaRepository<Sales, Long> {
    Sales findByDrug_DrugName(String drugName);


}
