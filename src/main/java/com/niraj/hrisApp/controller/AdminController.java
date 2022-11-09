/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.controller;

import com.niraj.hrisApp.entity.employee.Employee;
import com.niraj.hrisApp.entity.employee.Leave;
import com.niraj.hrisApp.entity.employee.LeaveType;
import com.niraj.hrisApp.service.EmployeeService;
import com.niraj.hrisApp.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell
 */
@Controller
public class AdminController {
    @Autowired
    LeaveService ls;
    
    @Autowired
    EmployeeService es;
    
    
    //make sure only admin can access this.
    @GetMapping("/admin/registerleave")
    public ModelAndView registerLeave(){
        ModelAndView mav = new ModelAndView("admin-registerleave");
        mav.addObject("newLeaveType", new LeaveType());
        return mav;
    }
    
    //make sure only admin can access this.
    @GetMapping("/admin/leaverequests")
    public ModelAndView showLeaveRequests(Authentication auth){
        ModelAndView mav = new ModelAndView("dashboard-leaverequests");
        
        //System.out.println("Emp id: "+empl.getEmpId()+", Emp name: "+empl.getName()+". This is from leavecontroller.");
        mav.addObject("leaveRequestList", ls.findAllLeaves());
        return mav;
        
        
    }
    
    //make sure only admin can access this.
    @GetMapping("/admin/approve/{leaveId}")
    ModelAndView approveLeave(@PathVariable("leaveId") long leaveId, Authentication auth){
        Leave leave = ls.findLeaveByLeaveId(leaveId);
        leave.setApproved(true);
        ls.requestLeave(leave);
        ModelAndView mav = new ModelAndView("dashboard-leaverequests");
        Employee empl = es.findemployeeByName(auth.getName());
        mav.addObject("leaveRequestList", ls.findLeaveRequest(empl));
        
        return mav;
    }
}
