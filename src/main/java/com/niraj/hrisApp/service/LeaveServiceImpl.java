/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Employee;
import com.niraj.hrisApp.entity.employee.Leave;
import com.niraj.hrisApp.repository.LeaveRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    LeaveRepository lr;
    
    @Override
    public Leave requestLeave(Leave leave) {
        return lr.save(leave);
    }

    @Override
    public ArrayList<Leave> findLeaveRequest(Employee emp) {
        return lr.findLeaveRequest(emp.getEmpId());   
    }

    @Override
    public ArrayList<Leave> findApprovedLeaves(Employee emp) {
        return lr.findApprovedLeaves(emp.getEmpId());
    }

    @Override
    public ArrayList<Leave> findNotApprovedLeaves(Employee emp) {
        return lr.findNotApprovedLeaves(emp.getEmpId());
    }

    @Override
    public ArrayList<Leave> findAllLeaves() {
        return (ArrayList<Leave>) lr.findAll();
    }

    @Override
    public Leave findLeaveByLeaveId(long leaveId) {
        return lr.getById(leaveId);
    }

    
    
}
