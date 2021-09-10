<%-- 
    Document   : Dashboard
    Created on : Apr 25, 2020, 11:54:32 PM
    Author     : Zinwota Timothy @BrainStack
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../Header.jsp"%>

<!-- Card stats -->
<div class="row">
    <div class="col-xl-3 col-md-6">
        <div class="card card-stats">
            <!-- Card body -->
            <div class="card-body">
                <div class="row">
                    <div class="col">
                        <h5 class="card-title text-uppercase text-muted mb-0">Products</h5>
                        <span class="h4 font-weight-bold mb-0">${stockCount}</span>
                    </div>
                    <div class="col-auto">
                        <div class="icon icon-shape bg-gradient-red text-white rounded-circle shadow">
                            <i class="ni ni-active-40"></i>
                        </div>
                    </div>
                </div>
                <p class="mt-3 mb-0 text-sm">

                </p>
            </div>
        </div>
    </div>
    <div class="col-xl-3 col-md-6">
        <div class="card card-stats">
            <!-- Card body -->
            <div class="card-body">
                <div class="row">
                    <div class="col">
                        <h5 class="card-title text-uppercase text-muted mb-0">Transactions </h5>
                        <span class="h4 font-weight-bold mb-0">${transCount}</span>
                    </div>
                    <div class="col-auto">
                        <div class="icon icon-shape bg-gradient-orange text-white rounded-circle shadow">
                            <i class="ni ni-money-coins"></i>
                        </div>
                    </div>
                </div>
                <p class="mt-3 mb-0 text-sm">

                </p>
            </div>
        </div>
    </div>
    <div class="col-xl-3 col-md-6">
        <div class="card card-stats">
            <!-- Card body -->
            <div class="card-body">
                <div class="row">
                    <div class="col">
                        <h5 class="card-title text-uppercase text-muted mb-0">Vendors</h5>
                        <span class="h4 font-weight-bold mb-0">${vendorCount}</span>
                    </div>
                    <div class="col-auto">
                        <div class="icon icon-shape bg-gradient-green text-white rounded-circle shadow">
                            <i class="ni ni-shop"></i>
                        </div>
                    </div>
                </div>
                <p class="mt-3 mb-0 text-sm">

                </p>
            </div>
        </div>
    </div>
    <div class="col-xl-3 col-md-6">
        <div class="card card-stats">
            <!-- Card body -->
            <div class="card-body">
                <div class="row">
                    <div class="col">
                        <h5 class="card-title text-uppercase text-muted mb-0">Date</h5>
                        <span class="h4 font-weight-bold mb-0"><% Calendar date = Calendar.getInstance();
                        out.print(date.getTime().toString().substring(0, 11));
                        //As of JDK version 1.1, replaced by Calendar.get(Calendar.DAY_OF_MONTH).
                        %></span>
                    </div>
                    <div class="col-auto">
                        <div class="icon icon-shape bg-gradient-green text-white rounded-circle shadow">
                            <i class="ni ni-watch-time"></i>
                        </div>
                    </div>
                </div>
                <p class="mt-3 mb-0 text-sm">

                </p>
            </div>
        </div>
    </div>
  

</div>


                    <h2 class="h2 text-center "> Stock</h2>
                    <table border= "1" class="table table-striped table-dark table-bordered" id="datatable">
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

        <c:forEach items="${list2}" var="product" varStatus="loop">
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
               
            </tr>
        </c:forEach>  
    </tbody> 


</table>
                    <h2 class="h2 text-center "> Transactions</h2>
<table border= "1" class="table table-striped table-dark table-bordered" id="datatable">
  
    <thead>
        <tr class="thead-light">
           
            <th>Ref No.</th>
            <th>Product</th>
            <th>Logger</th>
            <th>Client</th>
            <th>Date </th>
            <th>Units Sold</th>
            <th><span>&#x20A6;</span>Total Price</th>



        </tr>
    </thead>

    <tbody>
        <c:forEach items="${list}" var="transaction" varStatus="loop">
            
                <td>${transaction.ref_number}</td>
                <td>${transaction.productName}</td>
                <td>${transaction.loggername}</img></td> 
                <td>${transaction.buyer}</td>
                <td>${transaction.time}</td>
                <td>${transaction.quantity}</td>
                <td>${transaction.totalCharge}</td>



            </tr>
        </c:forEach>  
    </tbody> 
</table>
</div>
<div>



<%@include file="../../Footer.jsp"%>