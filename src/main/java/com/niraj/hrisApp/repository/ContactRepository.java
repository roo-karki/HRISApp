/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.repository;

import com.niraj.hrisApp.entity.employee.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dell
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {
    
}
