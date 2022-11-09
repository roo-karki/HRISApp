<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<ul class="nav navbar-right top-nav">
                    <li>
                        <script>function display_ct6() {
                            var x = new Date()
                            var ampm = x.getHours( ) >= 12 ? ' PM' : ' AM';
                            hours = x.getHours( ) % 12;
                            hours = hours ? hours : 12;
                            var x1=x.getMonth() + 1+ "/" + x.getDate() + "/" + x.getFullYear(); 
                            x1 = x1 + " - " +  hours + ":" +  x.getMinutes() + ":" +  x.getSeconds() + ":" + ampm;
                            document.getElementById('ct6').innerHTML = x1;
                            display_c6();
                             }
                             function display_c6(){
                            var refresh=1000; // Refresh rate in milli seconds
                            mytime=setTimeout('display_ct6()',refresh)
                            }
                            display_c6()
                        </script>
                        <span id='ct6' style="background-color: #222222; color: #fff; margin-right: 412px; font-size: x-large"></span>
                        
                        
                    
                    </li>
                    
                    <li><a href="#" data-placement="bottom" data-toggle="tooltip" data-original-title="Search"><i class="fa fas fa-search"></i>
                        </a></li>
                    <li><a href="#" data-placement="bottom" data-toggle="tooltip" data-original-title="Status"><i class="fa fa-bar-chart-o"></i>
                        </a>
                    </li>            
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${pageContext["request"].userPrincipal.principal.username}<b class="fa fa-angle-down"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="editprofile"><i class="fa fa-fw fa-user"></i> Edit Profile</a></li>
                            <li><a href="changepassword"><i class="fa fa-fw fa-cog"></i> Change Password</a></li>
                            <li class="divider"></li>
                            <li><sec:authentication property="principal.authorities"/></li>
                            <li><a href="\logout"><i class="fa fa-fw fa-power-off"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
