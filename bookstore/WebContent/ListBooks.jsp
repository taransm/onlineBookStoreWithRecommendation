<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.List"%>
<%@page import="bookstore.data.Book"%>
<%@page import="java.text.*"%>

<%
    List<Book> bookList = (List<Book>) request.getAttribute("BookList");

	NumberFormat pformatter = new DecimalFormat("#0.00");
    %>
    <div id="s-lg-content-34208524" class="  clearfix">
        <div style="background-color:#d9dbdc;  padding:1px;">
        </div>
        <div id="s-lg-content-34207352" class="clearfix">
            <table class="table table-condensed">
            <tbody>
                <tr style="background-color:#d9dbdc;">
                    <td class="ck_border" style="text-align:center; width: 5%;">
                        <strong>ID</strong>
                    </td>
                    <td class="ck_border" style="text-align:left; width: 30%;">
                        <strong>Title</strong>
                    </td>
                    <td class="ck_border" style="text-align:left; width: 12%;">
                        <strong>Author</strong>
                    </td>
                    <td class="ck_border" style="text-align:right; width: 7%;">
                        <strong>Price</strong>
                    </td>
                    <td class="ck_border" style="text-align:left; width: 25%;">
                        <strong>Genre</strong>
                    </td>
                    <td class="ck_border" style="text-align:center; width: 7%;">
                        <strong>Rating</strong>
                    </td>
                    <td class="ck_border" style="text-align:center; width: 6%;">
                        <strong>Reviews</strong>
                    </td>
                    <td class="ck_border" style="text-align:center; width: 10%;">
                        <strong>Actions</strong>
                    </td>
                </tr>
                <%

                    if (bookList!=null && !bookList.isEmpty()) {
                    	bookCount = bookList.size();
                        for (Book book : bookList) {
                        %>

                <tr >
                    <td class="ck_border" style="text-align:center; width: 5%;">
                        <%=book.getBookId()%>
                    </td>
                    <td class="ck_border" style="text-align:left; width: 30%;">
                        <%=book.getTitle()%>
                    </td>
                    <td class="ck_border" style="text-align:left; width: 12%;">
                        <%=book.getAuthor()%>
                    </td>
                    <td class="ck_border" style="text-align:right; width: 7%;">
                        <%=pformatter.format(book.getPrice())%>
                    </td>
                    <td class="ck_border" style="text-align:left; width: 25%;"><%=book.getGenreDesc()%></td>
                    <td class="ck_border" style="text-align:center; width: 7%;"><%=book.getRatings() %> / 5.0</td>
                    <td class="ck_border" style="text-align:center; width: 6%;"><%=book.getReviews()%></td>
                    <td class="ck_border" style="text-align:center; width: 10%;">
                    	
                    	<% if (isAdmin || isCustomer ) { %>
                        <a class="btn btn-info" style="padding: 0px 4px;" href="<%=request.getContextPath()%>/viewBook?bookId=<%=book.getBookId()%>" title="View Information">V</a>
						<% } %>
						
                    	<% if (isAdmin) { %>
                        <a class="btn btn-info" style="padding: 0px 4px;" href="<%=request.getContextPath()%>/updateBook?lastAction=list&bookId=<%=book.getBookId()%>" title="Edit Information">E</a>
						<% } %>
                    	<% if (isAdmin) { %>
                        <a class="btn btn-info" style="padding: 0px 4px;" href="<%=request.getContextPath()%>/deleteBook?bookId=<%=book.getBookId()%>" title="Delete Book">D</a>
						<% } %>
                    </td>
                </tr>
                        <%
                        }
                    } else {
                        %>
                <tr>
                    <td class="ck_border" style="text-align:center; width: 100%;" colspan="7">
                        No Books Found
                    </td>
                </tr>
                <%  } %>
                    
               	<% if (false) { %>
                <tr>
                    <td class="ck_border" style="text-align:right; width: 100%;" colspan="7">
                        <a class="btn btn-info" href="<%=request.getContextPath()%>/newBook" title="Add Book">Add</a>
                        &nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                <%  } %>
            </tbody>
            </table>
       </div>
    </div>

