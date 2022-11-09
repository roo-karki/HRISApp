/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.niraj.hrisApp.entity.employee.LeaveType;

/**
 *
 * @author Dell
 */
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
    
}
