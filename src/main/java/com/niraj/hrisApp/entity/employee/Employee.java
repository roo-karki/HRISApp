/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.entity.employee;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Dell
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long empId;
    
    String name;
    char gender;
    String nationality;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="perma_address_fk")
    Address permAddress;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="temp_address_fk")
    Address tempAddress;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="contact_fk")
    Contact contactDetails;
    
    @OneToMany(targetEntity = Education.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
            @JoinColumn(name="empId_fk", referencedColumnName="empId")
    List<Education> education;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="family_fk")
    Family family;
    
    @ManyToMany(cascade = {CascadeType.PERSIST,
                           CascadeType.DETACH, 
                           CascadeType.REFRESH}, 
                fetch = FetchType.LAZY)
         @JoinTable(name = "empteams",
                 joinColumns = @JoinColumn(name="empId"),
                 inverseJoinColumns = @JoinColumn(name="tid")
                 )   
    Set<Team> empteams;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="health_fk")
    Health health;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
            @JoinColumn(name="od_fk")
    OfficeDetails od;
    
}
