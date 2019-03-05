package com.mahbub.securitywithsql.repo;

import com.mahbub.securitywithsql.entity.Brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Long> {
    Brand findByBrandName(String brandName);
}
