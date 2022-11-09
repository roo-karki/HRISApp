/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.entity.employee;

import lombok.*;

/**
 *
 * @author Dell
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class EducationVO {
    Education education;
    boolean addAnotherEducation;
}
