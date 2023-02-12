<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="bookstore.data.Book"%>

<%

Map<String, String> params = (Map<String, String>) request.getAttribute("SearchParam");

String bookId = null;
String priceStart = null;
String priceEnd = null;
String bookTitle = null;
String bookAuthor = null;

if (params!=null) {
	bookId = params.get("BookId");
	priceStart = params.get("PriceStart");
	priceEnd = params.get("PriceEnd");
	bookTitle = params.get("BookTitle");
	bookAuthor = params.get("BookAuthor");
}

%>
    <div id="s-lg-content-34207352" class="clearfix">
        <form action="searchBook" id="searchForm" method="get" class="form-horizontal" novalidate="">
        <table class="table table-condensed">
        <tbody>
            <tr>
                <td class="ck_border" style="text-align:right; width: 3%;">
                    <strong>ID : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 4%;">
                    <input type="text" name="BookId" id="BookId" value="<%=bookId!=null?bookId:""%>" maxlength="11" size="8"/>
                </td>
                <td class="ck_border" style="text-align:right; width: 8%;">
                    <strong>Price : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 12%;">
                    <input type="text" name="PriceStart" id="PriceStart" value="<%=priceStart!=null?priceStart:""%>" size="4" maxlength="5"/>
                    &nbsp;&nbsp;
                    <input type="text" name="PriceEnd" id="PriceEnd" value="<%=priceEnd!=null?priceEnd:""%>" size="4" maxlength="5"/>
                </td>
                <td class="ck_border" style="text-align:right; width: 4%;">
                    <strong>Title : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 20%;">
                    <input type="text" name="BookTitle" id="BookTitle" value="<%=bookTitle!=null?bookTitle:""%>" size="35" maxlength="200"/>
                </td>
                <td class="ck_border" style="text-align:right; width: 5%;">
                    <strong>Author : </strong>
                </td>
                <td class="ck_border" style="text-align:left; width: 20%;">
                    <input type="text" name="BookAuthor" id="BookAuthor" value="<%=bookAuthor!=null?bookAuthor:""%>" size="30" maxlength="100"/>
                </td>
            </tr>
            <% if (true) { %>
            <tr>
                <td class="ck_border" style="text-align:right; width: 100%;" colspan="8">
                    <input type="hidden" name="param_action" value="search" />
	               	<% if (isAdmin) { %>
                        <a class="btn btn-info" href="<%=request.getContextPath()%>/newBook" title="Add Book">Add</a>
                        &nbsp;&nbsp;&nbsp;
                    <%  } %>
                    <button class="btn btn-info" type="submit" name="btnSearch">Search</button>
                    &nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            <% } %>
        </tbody>
        </table>
        </form>
    </div>

