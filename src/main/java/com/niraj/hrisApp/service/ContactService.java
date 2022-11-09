/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Contact;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface ContactService {
    public Contact findContactByConId(long conId);
    public List<Contact> findAllComtacts();
    public Contact saveContact(Contact contact);
    
    
}
