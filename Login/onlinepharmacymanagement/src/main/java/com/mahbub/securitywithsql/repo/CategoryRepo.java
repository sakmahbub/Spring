package com.mahbub.securitywithsql.repo;


import com.mahbub.securitywithsql.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByCategoryName(String categoryName);
}
