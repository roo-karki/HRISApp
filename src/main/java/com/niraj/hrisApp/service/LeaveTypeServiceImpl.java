/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.LeaveType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.niraj.hrisApp.repository.LeaveTypeRepository;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {
    @Autowired
    LeaveTypeRepository lqr;
    
    @Override
    public LeaveType findLeaveQuotaByLeaveId(long leaveId) {
        return lqr.getById(leaveId);
    }

    @Override
    public LeaveType saveLeaveQuota(LeaveType leaveQuota) {
        return lqr.save(leaveQuota);
    }

    @Override
    public ArrayList<LeaveType> findAll() {
        return (ArrayList<LeaveType>) lqr.findAll();
    }
    
}
