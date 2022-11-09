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
@Table(name="family")
public class Family {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long famId;
    
    String father;
    String mother;
    
    @Column(nullable=true)
    String spouse;
    
    @Column(nullable=true)
    @OneToMany(targetEntity = Children.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
            @JoinColumn(name="famId_fk", referencedColumnName="famId")
    List<Children> children;
  
}
