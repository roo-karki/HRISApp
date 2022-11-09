/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.hrisApp.controller;

import com.niraj.hrisApp.entity.employee.Address;
import com.niraj.hrisApp.entity.employee.AddressVO;
import com.niraj.hrisApp.entity.employee.Children;
import com.niraj.hrisApp.entity.employee.ChildrenVO;
import com.niraj.hrisApp.entity.employee.Contact;
import com.niraj.hrisApp.entity.employee.Education;
import com.niraj.hrisApp.entity.employee.EducationVO;
import com.niraj.hrisApp.entity.employee.Employee;
import com.niraj.hrisApp.entity.employee.Family;
import com.niraj.hrisApp.entity.employee.Health;
import com.niraj.hrisApp.entity.employee.Leave;
import com.niraj.hrisApp.entity.employee.LeaveType;
import com.niraj.hrisApp.entity.employee.OfficeDetails;
import com.niraj.hrisApp.entity.employee.Team;
import com.niraj.hrisApp.entity.user.Role;
import com.niraj.hrisApp.entity.user.User;
import com.niraj.hrisApp.service.EmployeeService;
import com.niraj.hrisApp.service.LeaveService;
import com.niraj.hrisApp.service.LeaveTypeService;
import com.niraj.hrisApp.service.RoleService;
import com.niraj.hrisApp.service.UserService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService es;
    
    @Autowired
    LeaveTypeService lts;
    
    @Autowired
    LeaveService ls;
    
    @Autowired
    RoleService rs;
    
    @Autowired
    UserService us;
    
    Employee emp;
    
    
    ArrayList<Children> childs = new ArrayList<>();
    
    ArrayList<Education> eduList = new ArrayList<>();
    
    
    //make sure both admin and user can access this.
    @GetMapping("/employee/list")
    public ModelAndView showAllEmployee(){
        
        ModelAndView mav = new ModelAndView("dashboard-listemployees");
        mav.addObject("empList", es.findAll());
        return mav;
    }
    
    
    //make sure only admin can access this.
    @GetMapping("/employee/add")
    public ModelAndView shownewEmployeePage(){
        
        ModelAndView mav = new ModelAndView("dashboard-addnewemployee");
        mav.addObject("newEmployee", new Employee());
        return mav;
    }
    
    //Step 1: process the details yu got on page  of the new employee thing.
    @PostMapping("/employee/processNewEmployee")
    public ModelAndView processNewEmployee(@ModelAttribute("newEmployee") Employee employee){
        emp = employee;
        System.out.println(emp);
        ModelAndView mav = new ModelAndView("dashboard-newcontact");
        mav.addObject("empContact", new Contact());
        return mav;
    }
    
    //Step 2: process the contact details yu got on page  of the new employee thing.
    @PostMapping("/employee/processNewContact")
    public ModelAndView processNewContact(@ModelAttribute("empContact") Contact contact){
        emp.setContactDetails(contact);
        System.out.println(emp.getContactDetails());
        ModelAndView mav = new ModelAndView("dashboard-newaddress");
        mav.addObject("newAddress", new AddressVO());
        return mav;
    }
    
    
    //Step3: process the newAddress VO.
    @PostMapping("/employee/processNewAddress")
    public ModelAndView processNewAddress(@ModelAttribute("newAddress") AddressVO address) {
        emp.setPermAddress(address.getPermaAddress());
        emp.setTempAddress(address.getTempAddress());
        ModelAndView mav = new ModelAndView("dashboard-neweducation");
        mav.addObject("newEducation", new EducationVO());
        return mav;
    }
    
    //Step4: iterate until there is the checkbox checked.
    @PostMapping("/employee/processNewEducation")
    public ModelAndView processNewEducation(@ModelAttribute("newEducation") EducationVO edu) {
        eduList.add(edu.getEducation());
        if(edu.isAddAnotherEducation()){
            ModelAndView mav = new ModelAndView("dashboard-neweducation");
            mav.addObject("newEducation", new EducationVO());
            return mav;
        }
        
        emp.setEducation(eduList);
        
        System.out.println("Education list: \n\n" +emp.getEducation().toString());
        
        ModelAndView mav = new ModelAndView("dashboard-newfamily");
        mav.addObject("newFamily", new Family());
        return mav;
    }
    
    @PostMapping("/employee/processNewFamily")
    public ModelAndView processNewFamily(@ModelAttribute("newFamily") Family fam) {
        emp.setFamily(fam);
        ModelAndView mav = new ModelAndView("dashboard-newchildren");
        mav.addObject("newChild", new ChildrenVO());
        return mav;
    }
    
    @PostMapping("/employee/processNewChild")
    public ModelAndView processNewChild(@ModelAttribute("newChild") ChildrenVO child){
        childs.add(child.getChild());
        if(child.isNextChild()){
            ModelAndView mav = new ModelAndView("dashboard-newchildren");
            mav.addObject("newChild", new ChildrenVO());
            return mav;
        }
        ModelAndView mav = new ModelAndView("dashboard-newhealth");
        mav.addObject("newHealth", new Health());
        return mav;
    }
    
    
    @PostMapping("/employee/processNewHealth")
    public ModelAndView processNewHealth(@ModelAttribute("newHealth") Health health) {
        emp.setHealth(health);
        ModelAndView mav = new ModelAndView("dashboard-newofficedetails");
        mav.addObject("newOfficeDetails", new OfficeDetails());
        return mav;
    }

    @PostMapping("/employee/processNewOfficeDetails")
    public ModelAndView processNewOfficeDetails(@ModelAttribute("newOfficeDetails") OfficeDetails officeDetails){
        emp.setOd(officeDetails);
        ModelAndView mav = new ModelAndView("dashboard-newteam");
        mav.addObject("newTeam", new Team());
        return mav;
    }
    
//    @PostMapping("/employee/processNewLeaveQuota")
//    public ModelAndView processNewLeaveQuota(@ModelAttribute("newLeaveQuota") LeaveType leave){
//        emp.setQuota(leave);
//        ModelAndView mav = new ModelAndView("dashboard-newteam");
//        mav.addObject("newTeam", new Team());
//        return mav;
//    }
    
    @PostMapping("/employee/processNewTeam")
    public ModelAndView processNewTeam(@ModelAttribute("newTeam") Team team){
        Set<Team> teams = new HashSet();
        teams.add(team);
        emp.setEmpteams(teams);
        
        es.addEmployee(emp); 
        User usr = new User();
        usr.setUsername(emp.getName());
        usr.setPassword("password");
        ArrayList<Role> roles = new ArrayList<>();
        Role r = rs.findByName("USER");
        roles.add(r);
        usr.setRole(roles);
        usr.setEnabled(true);
        us.addUser(usr);
        
        ModelAndView mav = new ModelAndView("dashboard-listemployees");
        mav.addObject("empList", es.findAll());
        return mav;
        
        
    }
    
    
    //make sure both admin and user can access this.
    @GetMapping("/employee/requestNewLeave")
    public ModelAndView serveRequestLeavePage(){
        ModelAndView mav = new ModelAndView("dashboard-requestleave");
        mav.addObject("newLeave", new Leave());
        mav.addObject("leaveTypes", lts.findAll());
        return mav;
    }
    
    //make sure both admin and user can access this.
    @PostMapping("/employee/processLeaveRequest")
    public ModelAndView processLeaveRequest(@ModelAttribute("newLeave") Leave leave, Authentication auth){
        //System.out.println("Auth.getName()= "+auth.getName());
        Employee empl = es.findemployeeByName(auth.getName());
        //System.out.println("Emp id: "+empl.getEmpId()+", Emp Name: "+empl.getName());
        leave.setEmployee(empl);
        leave.setApproved(false);
        if(ls.requestLeave(leave) != null){
            ModelAndView mav = new ModelAndView("dashboard-listemployees");
            mav.addObject("empList", es.findAll());
            return mav;
        }
        ModelAndView mav = new ModelAndView("dashboard-requestleave");
        mav.addObject("newLeave", new Leave());
        mav.addObject("leaveTypes", lts.findAll());
        
        return mav;
    }
    
    
}
