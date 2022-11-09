/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Education;

/**
 *
 * @author Dell
 */
public interface EducationService {
    public Education findEducationbyEduId(long eduId);
    public Education saveEducation(Education education);
    
}
