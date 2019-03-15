package com.sofiqul54.repo;

import com.sofiqul54.entity.Groupleader;
import com.sofiqul54.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupleaderRepo extends JpaRepository<Groupleader, Long> {
    Optional<Groupleader> findByLeaderNameOrEmail(String leaderName, String email);
    boolean existsByEmail(String email);
    Optional<Groupleader> findByLeaderName(String leaderNamed);

}
