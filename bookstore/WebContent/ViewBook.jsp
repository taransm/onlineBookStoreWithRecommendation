<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="bookstore.data.Book"%>
<%@page import="java.text.*"%>
<%@page import="bookstore.model.IdDescription"%>


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
        
        <%@include file="./include/Header.jsp" %>


<%

NumberFormat formatter = new DecimalFormat("0.0");
NumberFormat priceFormatter = new DecimalFormat("#0.00");
Book selectedBook = (Book) request.getAttribute("SelectedBook");
int bookCount = 0;

Integer bookId = null;
String bookTitle = null;
String bookAuthor = null;
String bookEdition = null;
Double bookRating = null;
Integer bookReview = null;
Integer genreId = null;
String genreDesc = null;
String synopsis = null;
Integer categoryId = null;
String categoryDesc = null;
Double price = null;

if (selectedBook!=null) {
	bookId = selectedBook.getBookId();
	bookTitle = selectedBook.getTitle();
	bookAuthor = selectedBook.getAuthor();
	bookEdition = selectedBook.getEdition();
	bookRating = selectedBook.getRatings();
	bookReview = selectedBook.getReviews();
	genreId = selectedBook.getGenreId();
	genreDesc = selectedBook.getGenreDesc();
	categoryId = selectedBook.getCategoryId();
	categoryDesc = selectedBook.getCategoryDesc();
	price = selectedBook.getPrice();
	synopsis = selectedBook.getSynopsis();
}

%>
    <div id="s-lg-content-34207352" class="clearfix">
        <table class="table table-condensed" border="0">
        <tbody>
            <tr>
                <td class="ck_border" style="text-align:Left; width: 10%;">
                    <strong>Title : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 90%;" colspan="7">
                    <input type="text" readonly name="BookTitle" id="BookTitle" value="<%=bookTitle!=null?bookTitle:""%>" maxlength="200" size="140">
                </td>
            </tr>
            <tr>
                <td class="ck_border" style="text-align:Left; width: 10%;">
                    <strong>Author : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 40%;" colspan="3">
                    <input type="text" readonly name="BookAuthor" id="BookAuthor" value="<%=bookAuthor!=null?bookAuthor:""%>" maxlength="100" size="60">
                </td>
                <td class="ck_border" style="text-align:Left; width: 50%;" colspan="4">
                    <strong>Synopsis : </strong>
                </td>
            </tr>
            <tr>
                <td class="ck_border" style="text-align:Left; width: 10%;">
                    <strong>Edition : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 40%;" colspan="3">
                    <input type="text" readonly name="BookEdition" id="BookEdition" value="<%=bookEdition!=null?bookEdition:""%>" maxlength="100" size="60">
                </td>
                <td class="ck_border" style="text-align:Left; width: 50%;" colspan="4" rowspan="5">
                    <textarea id="Synopsis" readonly name="Synopsis" rows="8" cols="70"><%=synopsis!=null?synopsis:""%></textarea>
                </td>
            </tr>
			
            <tr>
                <td class="ck_border" style="text-align:Left; width: 10%;">
                    <strong>Price : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 40%;" colspan="3">
                    <input type="text" readonly name="BookPrice" id="BookPrice" value="<%= priceFormatter.format(price)%>" maxlength="8" size="8">
                </td>
            </tr>
			
            <tr>
                <td class="ck_border" style="text-align:Left; width: 10%;">
                    <strong>Genre : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 40%;" colspan="3">
					<select id="BookGenre" disabled name="BookGenre">
						<option value="<%=genreId%>"><%=genreDesc%></option>
					</select>
                </td>
            </tr>
			
            <tr>
                <td class="ck_border" style="text-align:Left; width: 10%;">
                    <strong>Category : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 40%;" colspan="3">
					<select id="BookCategory" disabled ame="BookCategory">
						<option value="<%=categoryId%>"><%=categoryDesc%></option>
					</select>
                </td>
            </tr>
            <tr>
                <td class="ck_border" style="text-align:Left; width: 10%;">
                    <strong>Rating : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 15%;" >
					<select id="BookRating" disabled name="BookRating">
						<option value="<%=formatter.format(bookRating)%>" ><%=formatter.format(bookRating)%></option>
					</select>
                </td>
                <td class="ck_border" style="text-align:right; width: 10%;">
                    <strong>Reviews : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 15%;" >
                    <input type="text" readonly name="BookReview" id="BookReview" value="<%=bookReview!=null?bookReview:""%>" maxlength="5" size="5">
                </td>
            </tr>
            <tr>
                <td class="ck_border" style="text-align:left; width: 100%;" colspan="8">&nbsp;</td>
            </tr>
            <tr>
                <td class="ck_border" style="text-align:right; width: 100%;" colspan="8">
	               	<% if (isAdmin) { %>
                        <a class="btn btn-info" href="<%=request.getContextPath()%>/updateBook?lastAction=view&bookId=<%=bookId%>" title="Edit Information">Edit</a>
                        &nbsp;&nbsp;&nbsp;
                        <a class="btn btn-info" href="<%=request.getContextPath()%>/deleteBook?bookId=<%=bookId%>" title="Delete">Delete</a>
                        &nbsp;&nbsp;&nbsp;
                    <%  } %>
                    <a class="btn btn-info" href="<%=request.getContextPath()%>/searchBook" title="Home">Back</a>
                    &nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            <tr>
                <td class="ck_border" style="text-align:left; width: 100%;" colspan="8"><span  style="text-align:left; font-weight: bold; }">Recommended Books <span id="bookCount"></span></span></td>
            </tr>
            <tr>
                <td class="ck_border" style="text-align:left; width: 100%;" colspan="8">
				<%@include file="./ListBooks.jsp" %>
				</td>
            </tr>
			<script type="text/javascript">
			document.getElementById("bookCount").innerHTML = "(<%=bookCount%>)";
			</script>
        </tbody>
        </table>
    </div>
        
    </body>
</html>