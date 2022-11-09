/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Address;
import com.niraj.hrisApp.repository.AddressRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    AddressRepository ar;
    
    @Override
    public Address saveAddress(Address address) {
        return ar.save(address);
    }

    @Override
    public Address findAddressByAddId(long addId) {
        return ar.getById(addId);
    }

    @Override
    public List<Address> findAllByDistrict(String district) {
        return ar.findAllByDistrict(district);
    }
    
}
