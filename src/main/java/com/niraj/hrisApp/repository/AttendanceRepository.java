/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.repository;

import com.niraj.hrisApp.entity.employee.Attendance;
import com.niraj.hrisApp.entity.employee.Employee;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Dell
 */
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    //public Attendance findByEmployee(Long empId);
//    public List<Attendance> findAllByEmployee(Employee emp);
    public List<Attendance> findByEmp(Employee emp);
    
    //write custom query..
    @Query(value="SELECT * FROM attendance WHERE (emp_fk=:empId) && (monthname(date_in)=:month);", nativeQuery = true)
    public List<Attendance> findAttendenceOfEmpForMonth(@Param("empId") long empId, @Param("month") String month);
    
    @Query(value="SELECT * FROM attendance WHERE (emp_fk = :empId) && (date_in = :dateIn);", nativeQuery = true)
    public Attendance findByEmpForToday(@Param("empId") long empId, @Param("dateIn") LocalDate dateIn);
    
    
}
