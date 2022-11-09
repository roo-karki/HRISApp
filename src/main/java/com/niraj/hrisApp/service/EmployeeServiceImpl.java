/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Employee;
import com.niraj.hrisApp.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository er;
    
    @Override
    public Employee addEmployee(Employee emp) {
        return er.save(emp);
    }

    @Override
    public Employee findEmployeeByEmpId(long empId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee findemployeeByName(String name) {
        return er.findByName(name);
    }

    @Override
    public ArrayList<Employee> findAll() {
        return (ArrayList<Employee>)er.findAll();
    }

    @Override
    public Set<Employee> findTeamsByEmpId(long empId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
