/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.user.Role;

/**
 *
 * @author Dell
 */
public interface RoleService {
    public Role saveRole(Role r);
    public Role findRole(long roleId);
    public Role findByName(String roleName);
}
