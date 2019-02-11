package com.mahbub.webmvccroud.repository;

import com.mahbub.webmvccroud.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRipo extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
