/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Employee;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Dell
 */
public interface EmployeeService {
    public Employee addEmployee(Employee emp);
    public Employee findEmployeeByEmpId(long empId);
    public Employee findemployeeByName(String name);
    public ArrayList<Employee> findAll();
    public Set<Employee> findTeamsByEmpId(long empId);
}
