<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

session.invalidate();
    
%>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/vendor.css">
        <link rel="stylesheet" type="text/css" href="css/site.css">
        <title>Students Book Store</title>
    </head>
    <body>
        <div class="container">
            <!-- Header -->
            <div class="logo">
                <h1 class="margin-top">Students Book Store</h1>
            </div>

            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <hr>
                    <h3>Log Out Request</h3>
                    <div>
                        <p>You have been successfully logged out.</p> 
                        <br>
                        <p>Please click <a href="<%=request.getContextPath()%>">here to log in</a> again.</p>
                    </div>
                    <hr style="margin-top: 2em">
            </div>
            </div>
            <div class="row">
                <div class="col-md-offset-3 col-md-6 text-center">
                </div>
            </div>
        </div>
    </body>
</html>