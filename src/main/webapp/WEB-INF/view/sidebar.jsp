<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.niraj.hrisApp.entity.employee.Employee" %>

<%@ page import = "org.springframework.security.core.GrantedAuthority"%>
<%@ page import = "org.springframework.security.core.authority.SimpleGrantedAuthority"%>
<%@ page import = "org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import = "org.springframework.security.core.context.SecurityContextHolder.*"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<style>
    /* Style the sidenav links and the dropdown button */
.sidenav a, .dropdown-btn {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 20px;
  color: #818181;
  display: block;
  border: none;
  background: none;
  width:100%;
  text-align: left;
  cursor: pointer;
  outline: none;
}

/* On mouse-over */
.sidenav a:hover, .dropdown-btn:hover {
  color: #f1f1f1;
}
/* Add an active class to the active dropdown button */
.active {
  background-color: green;
  color: white;
}
/* Dropdown container (hidden by default). Optional: add a lighter background color and some left padding to change the design of the dropdown content */
.dropdown-container {
  display: none;
  background-color: #262626;
  padding-left: 8px;
}

/* Optional: Style the caret down icon */
.fa-caret-down {
  float: right;
  padding-right: 8px;
}
</style>

<div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                       <li>
                            <a href="/employee/list"><i class="fa fas fa-user"></i> Employees </a>
                        </li>
                        <li>
                            <a href="/user/list"><i class="fa fas fa-users"></i> Users </a>
                        </li>
                        
                        <%
                            List<SimpleGrantedAuthority> author = (List<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
                            if(author.get(0).toString().equals("ADMIN")){%>
                                <li>
                                    <a href="/admin/registerleave"><i class="fa fas"></i> Register New LeaveType </a>
                            
                                </li>
                                <li>
                                    <a href="/admin/leaverequests"><i class="fa fas"></i> Show All Leave Requests </a>

                                </li>
                               <% }
                        %>
                        
                        
                        <li>
                            <a href="/employee/listattendance"><i class="fa fas fa-users"></i> Current Month Attendance </a>
                        </li>
                        <li>
                            <a href="/employee/requestNewLeave"><i class="fa fas"></i>Request for Leave</a>
                        </li>
                        
                        
                        
                       
                        
                    </ul>
                </div>
