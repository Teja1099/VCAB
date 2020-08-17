<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

	<%@page import="java.sql.*"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/bootstrap-social.css">
    <link rel="stylesheet" href="css/style.css">
  
    <title>Destinations</title>
</head>

<body>
    <nav class="navbar bg-primary navbar-dark navbar-expand-sm fixed-top">
                <span class="navbar-text">
                		<!-- id="login_link" -->
                    <a href="booking.html"><i class="fa fa-sign-out ml-5"></i><input type="submit" class="btn btn-primary p-0"  value="back"/></a>
                </span>

    </nav>
    <header class="jumbotron">
        <div class="container">
            <div class="row row-header">
                <div class="col-12 col-sm-6 align-self-center">
                	<div class="row justify-content-center">
                    	<h1>VCAB SERVICE APP</h1>
                    </div>
                    <div class="row justify-content-center">
                    	<h1> MADE EASY</h1>
                    </div>
                    <div class="row justify-content-center">
                    	<h3>Start booking your ride in no time!! </h3>
                    </div>
                </div>
                <div class="col-12 col-sm align-self-center">
                    <div class="row justify-content-center">
                        <div class="col-12 col-sm-6 align-self-center">
                            <img src="images/logo.jpg" class="img-fluid">
                        </div>

                    </div>
                </div>
            </div>
         </div>
    </header>

    <div class="container">
        <div class="row row-content">
            <div class="col-12 col-sm-9">
                <h2>Choose Appropriate Destination</h2>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>Available Places</th>
                                <th>Cost Per KM</th>

                            </tr>
                        </thead>

                        <tbody>
                        <%
							
                    		try {
                    			Class.forName("com.mysql.jdbc.Driver");                   			
                    			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/vcab","root","1234");
                    			PreparedStatement st=  con.prepareStatement("select dest,hike from destination");
                    			
                    			ResultSet rs= st.executeQuery();
                    			  while(rs.next())
                    			  {

                        %>                        
                            <tr>
                                <td><%=rs.getString(1)%></td>
                                <td><%=rs.getString(2)%></td>

                        <%


				      			  }
				      		}
				      		catch(Exception e) {
				      			e.printStackTrace();
				      		}
                        %>    


                            </tr>                        
                        </tbody>
                    </table>
                </div>
            </div>
             <div class="col-12 col-sm-3">
            </div>
       </div> 
    </div>

	<footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-4 offset-1 col-sm-2">
                    <h5>Links</h5>
                    <ul class="list-unstyled">
                        <li><a href="./index.html">Home</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="./booking.html">Booking</a></li>
                        <li><a href="./contactus.html">Contact</a></li>
                    </ul>
                </div>
                <div class="col-7 col-sm-5">
                    <h5>Our Address</h5>
                    <address>
                        A-320, Gitam Boys Hostel<br>
                        Rudraram, Patancheru<br>
                        Telangana<br>
                        <i class="fa fa-phone fa-lg"></i>: +91 8332029083<br>
                        <i class="fa fa-fax fa-lg"></i>: +112 5756 1221<br>
                        <i class="fa fa-envelope fa-lg"></i>: <a href="mailto:221710301044@gitam.in">Vcab@gmail.com</a>
                    </address>
                </div>
                <div class="col-12 col-sm-4 align-self-center">
                    <div class="text-center">
                        <a class="btn btn-social-icon btn-google" href="http://google.com/+"><i
                                class="fa fa-google-plus fa-lg"></i></a>
                        <a class="btn btn-social-icon btn-facebook" href="http://www.facebook.com/profile.php?id="><i
                                class="fa fa-facebook fa-lg"></i></a>
                        <a class="btn btn-social-icon btn-linkedin" href="http://www.linkedin.com/in/"><i
                                class="fa fa-linkedin fa-lg"></i></a>
                        <a class="btn btn-social-icon btn-twitter" href="http://twitter.com/"><i
                                class="fa fa-twitter fa-lg"></i></a>
                        <a class="btn btn-social-icon btn-google" href="http://youtube.com/"><i
                                class="fa fa-youtube fa-lg"></i></a>
                        <a class="btn btn-social-icon" href="mailto:"><i class="fa fa-envelope fa-lg"></i></a>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-auto">
                    <p>© Copyright 2020 Vcab | Design By Pulluri Saiteja</p>
                </div>
            </div>
        </div>
    </footer>
    <!-- jQuery first, then popper.js, then Bootstrap JS. -->
    <!-- build:js js/main.js -->
    <script src="js/jquery.js"></script>
    <script src="node_modules/popper.js/dist/umd/popper.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/scripts.js"></script>
    <!-- endbuild -->


</body>

</html>