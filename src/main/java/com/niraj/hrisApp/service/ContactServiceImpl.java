/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.service;

import com.niraj.hrisApp.entity.employee.Contact;
import com.niraj.hrisApp.repository.ContactRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository cr;

    @Override
    public Contact findContactByConId(long conId) {
        return cr.getById(conId);
    }

    @Override
    public List<Contact> findAllComtacts() {
        return cr.findAll();
    }

    @Override
    public Contact saveContact(Contact contact) {
        return cr.save(contact);
    }
}
