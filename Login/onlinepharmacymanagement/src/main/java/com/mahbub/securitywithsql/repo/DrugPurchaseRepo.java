package com.mahbub.securitywithsql.repo;



import com.mahbub.securitywithsql.entity.DrugPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugPurchaseRepo extends JpaRepository<DrugPurchase, Long> {
    DrugPurchase findByDrug_DrugName(String drugName);


}
