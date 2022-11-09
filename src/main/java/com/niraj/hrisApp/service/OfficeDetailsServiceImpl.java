/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.OfficeDetails;
import com.niraj.hrisApp.repository.OfficeDetailsRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class OfficeDetailsServiceImpl implements OfficeDetailsService{
    @Autowired
    OfficeDetailsRepository odr;
    @Override
    public OfficeDetails findOfficeDetailsByOffId(long offId) {
//        Optional<OfficeDetails> opt;
//        opt = odr.findById(offId);
//        if(opt.isPresent()){
//            return opt.get();
//        }
//        return null;

        return odr.getById(offId);
    }

    @Override
    public OfficeDetails saveOfficeDetails(OfficeDetails od) {
        return odr.save(od);
    }
    
}
