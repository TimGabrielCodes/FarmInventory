
<%@ include file = "../../Header.jsp" %>



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
            <th>Vendor</th>
            <th>Category</th>
            <th>Quantity</th>
            <th>Action</th>

        </tr>
    </thead>

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
                <td>${product.vendorName}</td>
                <td>${product.category}</td>
                <td>${product.quantity}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/StockController?action=EDIT&id=${product.product_id}">Edit</a>
                    |
                    <a href="${pageContext.request.contextPath}/StockController?action=DELETE&id=${product.product_id}">Delete</a>
                </td>

            </tr>
        </c:forEach>  
    </tbody> 


</table>
<button class="btn btn-primary" onclick="window.location.href = 'StockController?action=ADD'">Upload Products</button>
<div>
    <p> ${message} </p>
</div>


<%@ include file = "../../Footer.jsp" %>   
