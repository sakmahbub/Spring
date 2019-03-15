package com.sofiqul54.repo;

import com.sofiqul54.entity.Role;
import com.sofiqul54.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUserNameOrEmail(String userName, String email);
    User findByUserName(String username);
    Optional<User> findByEmail(String email);
    List<User> findAllByRoles(Set<Role> roles);
    boolean existsByEmail(String email);
    User findByConfirmationToken(String token);
}
