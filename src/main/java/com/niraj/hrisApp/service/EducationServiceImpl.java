/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Education;
import com.niraj.hrisApp.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    EducationRepository er;
    
    @Override
    public Education findEducationbyEduId(long eduId) {
        return er.getById(eduId);
    }

    @Override
    public Education saveEducation(Education education) {
        return er.save(education);
    }
    
}
