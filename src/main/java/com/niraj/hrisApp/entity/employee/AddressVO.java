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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddressVO {
    Address permaAddress;
    Address tempAddress;
}
