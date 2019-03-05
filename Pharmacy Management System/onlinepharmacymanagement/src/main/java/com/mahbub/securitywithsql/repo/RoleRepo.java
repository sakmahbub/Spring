package com.mahbub.securitywithsql.repo;

import com.mahbub.securitywithsql.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByRolename(String roleName);
}
