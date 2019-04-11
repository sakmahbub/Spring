package com.mahbub.webmvc.repository;

import com.mahbub.webmvc.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepo extends JpaRepository<Sales, Long> {
}
