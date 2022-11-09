/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.controller;

import com.niraj.hrisApp.entity.employee.Attendance;
import com.niraj.hrisApp.entity.employee.Employee;
import com.niraj.hrisApp.service.AttendanceService;
import com.niraj.hrisApp.service.EmployeeService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell
 */
@Controller
public class AttendanceController {
    Employee emp = new Employee();
    @Autowired
    AttendanceService as;

    @Autowired
    EmployeeService emps;

    @GetMapping("/employee/clockIn")
    public ModelAndView clockIn(Authentication auth) {
        //emp = emps.findemployeeByName(auth.getName());
        Attendance atten = new Attendance();
        atten.setEmp(emp);
        ModelAndView mav = new ModelAndView("dashboard");

        if (as.clockIn(atten)) {

            mav.addObject("message", "[*] Clocked in successfully!");
            mav.addObject("isClockedIn", as.isClockedIn(emp));
            return mav;
        }

        mav.addObject("message", "/!\\ Clocked in failed!");
        mav.addObject("isClockedIn", as.isClockedIn(emp));
        return mav;
    }

    @GetMapping("/employee/clockOut")
    public ModelAndView clockOut(Authentication auth) {
        ModelAndView mav = new ModelAndView("dashboard");
        //emp = emps.findemployeeByName(auth.getName());
        mav.addObject("isClockedIn", as.isClockedIn(emp));
        Attendance att = as.findByEmployeeForToday(emp);
        if (as.clockOut(att)) {
            mav.addObject("message", "[*] Clocked Out successfully!");
        } else {
            mav.addObject("message", "/!\\ Clocked Out failed!");
        }
        return mav;
    }

    @GetMapping("/employee/listattendance")
    public ModelAndView listAttendance(Authentication auth) {
        ModelAndView mav = new ModelAndView("dashboard-listattendance");
        
        mav.addObject("listAttendance", as.findAttendenceOfEmpForMonth(emp.getEmpId(), LocalDate.now().getMonth().toString()));
        return mav;
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard(Authentication auth) {
        ModelAndView mav = new ModelAndView("dashboard");
        emp = emps.findemployeeByName(auth.getName());
        mav.addObject("isClockedIn", as.isClockedIn(emp));
        return mav;
    }
}
