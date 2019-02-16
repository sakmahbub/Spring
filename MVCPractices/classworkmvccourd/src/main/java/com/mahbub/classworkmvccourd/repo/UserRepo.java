package com.mahbub.classworkmvccourd.repo;


import com.mahbub.classworkmvccourd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
