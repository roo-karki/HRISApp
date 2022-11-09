/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Attendance;
import com.niraj.hrisApp.entity.employee.Employee;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface AttendanceService {
    public Attendance findByAttId(long attId);
    public List<Attendance> findByEmployee(Employee emp);
    public List<Attendance> findAll();
    public Attendance findByEmployeeForToday(Employee emp);
    public List<Attendance> findAllAttendanceForToday();
    public boolean clockIn(Attendance att);
    public boolean clockOut(Attendance att);
    public boolean isClockedIn(Employee emp);
    
    public List<Attendance> findAttendenceOfEmpForMonth(long empId, String month);
    
}
