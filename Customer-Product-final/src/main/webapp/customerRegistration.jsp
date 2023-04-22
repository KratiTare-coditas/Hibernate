<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <title>CRM</title>
</head>
<body>


<div class="container">
    <div class="card bg-light">
        <div class="card-body mx-auto"></div>

        <div align="center">
            <h1>Customer Registration</h1>
        </div>
        <form action="RegisterServlet" method="get">
            <div class="form-row">
                <div class="col">
                    <label for="inputEmail4">Name</label>
                    <input type="text" class="form-control" placeholder="First name" name="name">
                </div>


                <div class="form-group col-md-6">
                    <label for="inputEmail4">Email</label>
                    <input type="email" class="form-control" id="inputEmail4" placeholder="Email" name="email">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword4">Password</label>
                    <input type="password" class="form-control" id="inputPassword4" placeholder="Password" name="password">
                </div>
           </div>
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </div>
        </div>
    </form>
</div>
</div>


<!-- Optional JavaScript -->
</body>
</html>