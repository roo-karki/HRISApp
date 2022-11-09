/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Employee;
import com.niraj.hrisApp.entity.employee.Leave;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public interface LeaveService {
    public Leave requestLeave(Leave leave);
    public ArrayList<Leave> findLeaveRequest(Employee emp);
    public ArrayList<Leave> findApprovedLeaves(Employee emp);
    public ArrayList<Leave> findNotApprovedLeaves(Employee emp);
    public ArrayList<Leave> findAllLeaves();
    public Leave findLeaveByLeaveId(long leaveId);
    
}
