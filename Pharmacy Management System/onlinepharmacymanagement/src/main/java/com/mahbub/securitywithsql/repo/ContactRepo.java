package com.mahbub.securitywithsql.repo;


import com.mahbub.securitywithsql.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {

}
