package com.mahbub.springdto.service;

import com.mahbub.springdto.entity.Employe;

import java.util.List;

public interface EmployeeService {

    void saveOrUpdate(Employe employe);

    void deleteById(Long id);

    Employe findByID(Long id);
    Employe findByEmailAddress(String email);

    List<Employe> getAll();

}
