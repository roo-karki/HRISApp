/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Children;
import com.niraj.hrisApp.repository.ChildrenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class ChildrenServiceImpl implements ChildrenService{
    @Autowired
    ChildrenRepository cr;
    
    @Override
    public Children findChildrenByChildId(long childId) {
        return cr.getById(childId);
    }

    @Override
    public Children saveFamily(Children child) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
