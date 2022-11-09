/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.LeaveType;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public interface LeaveTypeService {
    public LeaveType findLeaveQuotaByLeaveId(long leaveId);
    public LeaveType saveLeaveQuota(LeaveType leaveQuota);
    public ArrayList<LeaveType> findAll();
}
