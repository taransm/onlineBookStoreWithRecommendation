<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // TODO
%>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/vendor.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/site.css">
        <title>Students Book Store</title>
    </head>
    <body>
        <div class="container">
            <!-- Header -->
            <div class="logo">
                <h1 class="margin-top">Students Book Store</h1>
            </div>

            <div class="row">
                <div class="col-md-offset-4 col-md-4 ">
                    <hr>
                    <form action="<%=request.getContextPath()%>/signup" id="Signupform" method="post" class="form-horizontal" novalidate="">
                        <div class="form-group has-feedback">
                            <label class="control-label sr-only">Username</label>
                            <input class="form-control input-lg" data-parsley-errors-container="#username_error" id="username" name="j_username" data-parsley-error-message="Username is required" type="text" required="" placeholder="Username" value="" autofocus="">
                        </div>
                        <div class="form-group has-feedback">
                            <label class="control-label sr-only">Password</label>
                            <input class="form-control input-lg" data-parsley-errors-container="#password_error" id="password" name="j_password" data-parsley-error-message="Password is required" type="password" required="" placeholder="Password">
                        </div>
                        <div class="form-group no-margin"></div>
                        <div class="form-group">
                            <button class="btn btn-info btn-block btn-lg" type="submit" name="_eventId_proceed">Signup</button>
                        </div>
                    </form>
                    <hr>
                </div>
            </div>
            <div class="row">
                <div class="col-md-offset-3 col-md-6 text-center">
                </div>
            </div>
        </div>
    </body>
</html>