/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.repository;

import com.niraj.hrisApp.entity.employee.Employee;
import com.niraj.hrisApp.entity.employee.Leave;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Dell
 */
public interface LeaveRepository extends JpaRepository<Leave,Long> {
    
    @Query(value="SELECT * FROM allleaves WHERE (emp_fk = :empId);", nativeQuery = true)
    public ArrayList<Leave> findLeaveRequest(@Param("empId") Long empId);
    
    @Query(value="SELECT * FROM allleaves WHERE (`emp_fk` = '?' && `approved` = '1');", nativeQuery = true)
    public ArrayList<Leave> findApprovedLeaves(long empId);
    
    @Query(value="SELECT * FROM allleaves WHERE (`emp_fk` = '?' && `approved` = '0');", nativeQuery = true)
    public ArrayList<Leave> findNotApprovedLeaves(long empId);
    
    
    
    
}
