/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Address;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface AddressService {
    public Address saveAddress(Address address);
    public Address findAddressByAddId(long addId);
    public List<Address> findAllByDistrict(String district);
}
