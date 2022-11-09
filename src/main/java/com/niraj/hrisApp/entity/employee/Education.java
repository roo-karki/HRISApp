/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.entity.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="education")
public class Education {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long eduId;
    
    String institution;
    String level;
    String board;
    String year;
    
    @Column(nullable=true)
    float percentage;
    
    @Column(nullable=true)
    float gpa;
    
}
