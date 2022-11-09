/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.user.Role;
import com.niraj.hrisApp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    RoleRepository rr;
    
    @Override
    public Role saveRole(Role r) {
        return rr.save(r);
    }

    @Override
    public Role findRole(long roleId) {
        return rr.getById(roleId);
    }

    @Override
    public Role findByName(String roleName) {
        return rr.findByName(roleName);
    }
    
}
