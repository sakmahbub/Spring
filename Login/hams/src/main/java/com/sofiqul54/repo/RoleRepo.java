package com.sofiqul54.repo;

import com.sofiqul54.entity.Role;
import com.sofiqul54.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String roleName);
    boolean existsRoleByRoleName(String roleName);
}
