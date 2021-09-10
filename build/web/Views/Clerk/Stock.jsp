

<%@ include file = "Clerk_Header.jsp" %>



<h2 class="text-center">Stock List</h2>


<table border= "1" class="table table-striped  table-bordered table-responsive" id="datatable">
    <thead>
        <tr class="thead-light">
            <th>SN</th>
            <th>Product Name</th>
            <th>Image</th>
            <th><span>&#x20A6;</span> Cost Price</th>
            <th><span>&#x20A6;</span>  Selling Price</th>
            <th>Logger</th>
      
            <th>Category</th>
            <th>Quantity</th>
       

        </tr>
    </thead>
<%--<%@page import="javax.xml.bind.DatatypeConverter"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.*"%>
<%@page import="java.io.*"%>--%>
    <tbody>

        <c:forEach items="${list}" var="product" varStatus="loop">
            <tr>  <td>${loop.index+1}</td>
                <td>${product.name}</td>
                <td>
                    <a href= "${pageContext.request.contextPath}/DisplayImage?&img=${product.picURL}" target="_blank" >
                    <img src="${pageContext.request.contextPath}/DisplayImage?&img=${product.picURL}" class="img-thumbnail " width="150px" height="150px"></img></td> 

                </a>   
                <td>${product.cost_price}</td>
                <td>${product.selling_price}</td>
                <td>${product.loggerName}</td>
         
                <td>${product.category}</td>
                <td>${product.quantity}</td>
               

            </tr>
        </c:forEach>  
    </tbody> 


</table>
<button class="btn btn-primary pull-right" onclick="window.location.href = 'ClerkController?action=SELL'">Make Transaction</button>
<button class="btn btn-primary pull-left " onclick="window.location.href = 'ClerkController?action=ADD'">Upload Products</button>
<div>
    <p> ${message} </p>
</div>


<%@ include file = "../../Footer.jsp" %>   
