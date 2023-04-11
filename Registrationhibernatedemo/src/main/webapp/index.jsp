<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registration form</title>


    <link rel="stylesheet"
     href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
     integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
     crossorigin="anonymous">
    </head>

    </head>
    <body>
     <div class="container">
     <div class="row text-center" style="color: tomato;">
      <h2>User Registration with JSP, Servlet and Hibernate</h2>
     </div>
     <hr>
      <div class="row col-md-10 col-md-offset-3">

       <div class="card card-body">

        <h2>User Register Form</h2>
        <div class="col-md-8 col-md-offset-3">

         <form action="RegistrationServlet" method="post">
           <div class="form-group">
                      <label for="uname">id</label> <input type="text"
                       class="form-control" id="uname" placeholder="id"
                       name="id" required>
                     </div>
          <div class="form-group">
           <label for="uname"> Name:</label> <input type="text"
            class="form-control" id="uname" placeholder=" Name"
            name="Name" required>
          </div>

          <div class="form-group">
           <label for="uname">Dept:</label> <input type="text"
            class="form-control" id="uname" placeholder="department"
            name="department" required>
          </div>

          <div class="form-group">
           <label for="uname">User email:</label> <input type="email"
            class="form-control" id="email" placeholder="email"
            name="email" required>
          </div>

          <div class="form-group">
           <label for="uname">Password:</label> <input type="password"
            class="form-control" id="password" placeholder="Password"
            name="password" required>
          </div>
          <div class="form-group">
                     <label for="uname">Salary:</label> <input type="text"
                      class="form-control" id="salary" placeholder="salary"
                      name="salary" required>
                    </div>

          <button type="submit" class="btn btn-primary">Submit</button>

         </form>
        </div>
       </div>
      </div>
     </div>
    </body>
    </html>
