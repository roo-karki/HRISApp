/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.repository;

import com.niraj.hrisApp.entity.employee.Employee;
import com.niraj.hrisApp.entity.employee.Team;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dell
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findByName(String name);
    public Set<Team> findAllTeamsByEmpId(long empId);
}
