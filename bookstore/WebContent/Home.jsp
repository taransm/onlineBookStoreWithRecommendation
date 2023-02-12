<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/slick.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/slick-theme.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/lg-public.min.css">
        <title>Students Book Store</title>
    </head>
    <body>
    	<%
    	int bookCount = 0;
    	%>
        <%@include file="./include/Header.jsp" %>

        <%@include file="./SearchBook.jsp" %>
        
        <%@include file="./ListBooks.jsp" %>
        
    </body>
</html>