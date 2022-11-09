/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Attendance;
import com.niraj.hrisApp.entity.employee.Employee;
import com.niraj.hrisApp.repository.AttendanceRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceRepository ar;

    @Override
    public Attendance findByAttId(long attId) {
        return ar.getById(attId);
    }

    @Override
    public List<Attendance> findByEmployee(Employee emp) {
        return ar.findByEmp(emp);
    }

    @Override
    public List<Attendance> findAll() {
        return ar.findAll();
    }

    @Override
    public Attendance findByEmployeeForToday(Employee emp) {
        return ar.findByEmpForToday(emp.getEmpId(), LocalDate.now());
    }

    @Override
    public List<Attendance> findAllAttendanceForToday() {
        /*
        Write a custom query in repository where you select the data from attendance
         table checkignthe date only.
        
        */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean clockIn(Attendance att) {
        att.setClockIn(LocalTime.now());
        att.setDateIn(LocalDate.now());
        return ar.save(att) != null;
    }

    @Override
    public boolean clockOut(Attendance att) {
        Attendance attendance = ar.getById(att.getAttId());
        attendance.setClockOut(LocalTime.now());
        return ar.save(attendance) != null;
    }

    @Override
    public boolean isClockedIn(Employee emp) {
        return this.findByEmployeeForToday(emp) != null;
    }

    @Override
    public List<Attendance> findAttendenceOfEmpForMonth(long empId, String month) {
        return ar.findAttendenceOfEmpForMonth(empId, month);
    }
    
    
    
}
