/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.repository;

import com.niraj.hrisApp.entity.employee.Children;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dell
 */
public interface ChildrenRepository extends JpaRepository<Children, Long> {
    public List<Children> findByName(String name);
}
