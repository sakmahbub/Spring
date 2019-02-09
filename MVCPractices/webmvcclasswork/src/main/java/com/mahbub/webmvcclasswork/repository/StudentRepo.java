package com.mahbub.webmvcclasswork.repository;

import com.mahbub.webmvcclasswork.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}
