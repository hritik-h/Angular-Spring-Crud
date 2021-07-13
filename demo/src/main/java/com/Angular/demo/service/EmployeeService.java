package com.Angular.demo.service;

import com.Angular.demo.exceptions.UserNotFoundException;
import com.Angular.demo.model.Employee;
import com.Angular.demo.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private  final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return  employeeRepo.save(employee);
    }

    public List<Employee> findAllEmp(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        System.out.println("_---------------------------__________UPDATE______________----------------------------");
        System.out.println(employee);
        return employeeRepo.save(employee);
    }
    public Employee findById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User by id" + id + "was not found"));
    }
    public void deleteEmployee(Long id){
        System.out.println("_---------------------------__________DELETE______________----------------------------");
        employeeRepo.deleteById(id);
    }
}
