package com.mahbub.springdto.serviceimplement;

import com.mahbub.springdto.entity.Employe;
import com.mahbub.springdto.repository.EmployeeRepo;
import com.mahbub.springdto.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplement implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void saveOrUpdate(Employe employe) {
    employeeRepo.save(employe);
    }

    @Override
    public void deleteById(Long id) {
    employeeRepo.deleteById(id);
    }

    @Override
    public Employe findByID(Long id) {
        return employeeRepo.getOne(id);
    }

    @Override
    public Employe findByEmailAddress(String email) {
        return null;
    }

    @Override
    public List<Employe> getAll() {
        return null;
    }
}
