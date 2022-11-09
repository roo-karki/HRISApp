/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Family;

/**
 *
 * @author Dell
 */
public interface FamilyService {
    public Family findFamilyByFamId(long famId);
    public Family saveFamily(Family fam);
}
