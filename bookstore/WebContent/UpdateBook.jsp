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

String lastAction = (String) request.getAttribute("lastAction");
List<IdDescription> listGenre = (List<IdDescription>) request.getAttribute("Genres");
List<IdDescription> listCategory = (List<IdDescription>) request.getAttribute("Categories");
NumberFormat formatter = new DecimalFormat("0.0");
NumberFormat priceFormatter = new DecimalFormat("#0.00");
Book book = (Book) request.getAttribute("SelectedBook");

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

if (book!=null) {
	bookId = book.getBookId();
	bookTitle = book.getTitle();
	bookAuthor = book.getAuthor();
	bookEdition = book.getEdition();
	bookRating = book.getRatings();
	bookReview = book.getReviews();
	genreId = book.getGenreId();
	genreDesc = book.getGenreDesc();
	categoryId = book.getCategoryId();
	categoryDesc = book.getCategoryDesc();
	price = book.getPrice();
	synopsis = book.getSynopsis();
}

%>
    <div id="s-lg-content-34207352" class="clearfix">
        <form action="updateBook" id="BookForm" method="post" class="form-horizontal" novalidate="">
		<input type="hidden" id="BookId" name="BookId" value="<%=bookId!=null?bookId:""%>">
		<input type="hidden" id="lastAction" name="lastAction" value="<%=lastAction!=null?lastAction:""%>">
        <table class="table table-condensed" border="0">
        <tbody>
            <tr>
                <td class="ck_border" style="text-align:Left; width: 10%;">
                    <strong>Title : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 90%;" colspan="7">
                    <input type="text" name="BookTitle" id="BookTitle" value="<%=bookTitle!=null?bookTitle:""%>" maxlength="200" size="140">
                </td>
            </tr>
            <tr>
                <td class="ck_border" style="text-align:Left; width: 10%;">
                    <strong>Author : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 40%;" colspan="3">
                    <input type="text" name="BookAuthor" id="BookAuthor" value="<%=bookAuthor!=null?bookAuthor:""%>" maxlength="100" size="60">
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
                    <input type="text" name="BookEdition" id="BookEdition" value="<%=bookEdition!=null?bookEdition:""%>" maxlength="100" size="60">
                </td>
                <td class="ck_border" style="text-align:Left; width: 50%;" colspan="4" rowspan="5">
                    <textarea id="Synopsis" name="Synopsis" rows="8" cols="70"><%=synopsis!=null?synopsis:""%></textarea>
                </td>
            </tr>
			
            <tr>
                <td class="ck_border" style="text-align:Left; width: 10%;">
                    <strong>Price : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 40%;" colspan="3">
                    <input type="text" name="BookPrice" id="BookPrice" value="<%= priceFormatter.format(price)%>" maxlength="8" size="8">
                </td>
            </tr>
			
            <tr>
                <td class="ck_border" style="text-align:Left; width: 10%;">
                    <strong>Genre : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 40%;" colspan="3">
					<select id="BookGenre" name="BookGenre">
	                <%

                    if (listGenre!=null && !listGenre.isEmpty()) {

                        for (IdDescription genre : listGenre) {
                        	String genreValue = genre.getGenreId()+"|"+genre.getGenreDesc();
                        	String genreDescription = genre.getGenreDesc();
                        	boolean isSelected = (genre.getGenreId().intValue()==genreId.intValue());
                        %>
					
						<option value="<%=genreValue%>"   <%=isSelected?"selected":""%> ><%=genreDescription%></option>
                        <%
                        }
                    }
                        %>
					</select>
                </td>
            </tr>
			
            <tr>
                <td class="ck_border" style="text-align:Left; width: 10%;">
                    <strong>Category : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 40%;" colspan="3">
					<select id="BookCategory" name="BookCategory">
					<%
                    if (listCategory!=null && !listCategory.isEmpty()) {

                        for (IdDescription category : listCategory) {
                        	String categoryValue = category.getGenreId()+"|"+category.getGenreDesc();
                        	String categoryDescription = category.getGenreDesc();
                        	boolean isSelected = (category.getGenreId().intValue()==categoryId.intValue());
                        %>
						<option value="<%=categoryValue%>" <%=isSelected?"selected":""%>><%=categoryDescription%></option>
                        <%
                        }
                    }
                        %>
					</select>
                </td>
            </tr>
            <tr>
                <td class="ck_border" style="text-align:Left; width: 10%;">
                    <strong>Rating : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 15%;" >
					<select id="BookRating" name="BookRating">
						<%
                        for (double index=0.0d; index<=5.0; index+=0.1) {
                        	boolean isSelected = (formatter.format(index).equals(formatter.format(bookRating)));
                       	 %>
						<option value="<%=formatter.format(index)%>" <%=isSelected?"selected":""%>><%=formatter.format(index)%></option>
						<%
                        }
                       	 %>
					</select>
                </td>
                <td class="ck_border" style="text-align:right; width: 10%;">
                    <strong>Reviews : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 15%;" >
                    <input type="text" name="BookReview" id="BookReview" value="<%=bookReview!=null?bookReview:""%>" maxlength="5" size="5">
                </td>
            </tr>
            <tr>
                <td class="ck_border" style="text-align:left; width: 100%;" colspan="8">&nbsp;</td>
            </tr>
            <tr>
                <td class="ck_border" style="text-align:right; width: 100%;" colspan="8">
                    <a class="btn btn-info" href="<%=request.getContextPath()%>/searchBook" title="Home">Cancel</a>
                    &nbsp;&nbsp;&nbsp;
                    <button class="btn btn-info" type="submit" name="btnSave">Save</button>
                    &nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            <tr>
                <td class="ck_border" style="text-align:left; width: 100%;" colspan="8">&nbsp;</td>
            </tr>

        </tbody>
        </table>
        </form>
    </div>
        
    </body>
</html>