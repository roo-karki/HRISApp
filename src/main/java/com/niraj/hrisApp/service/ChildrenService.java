/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Children;

/**
 *
 * @author Dell
 */
public interface ChildrenService {
    public Children findChildrenByChildId(long childId);
    public Children saveFamily(Children child);
}
