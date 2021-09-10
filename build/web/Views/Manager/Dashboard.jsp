<%-- 
    Document   : Dashboard
    Created on : Apr 25, 2020, 11:54:32 PM
    Author     : Zinwota Timothy @BrainStack
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Manager_Header.jsp"%>

<!-- Card stats -->
<div class="row">
    <div class="col-xl-3 col-md-6">
        <div class="card card-stats">
            <!-- Card body -->
            <div class="card-body">
                <div class="row">
                    <div class="col">
                        <h5 class="card-title text-uppercase text-muted mb-0">Products</h5>
                        <span class="h2 font-weight-bold mb-0">${stockCount}</span>
                    </div>
                    <div class="col-auto">
                        <div class="icon icon-shape bg-gradient-red text-white rounded-circle shadow">
                            <i class="ni ni-cart"></i>
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
                        <h5 class="card-title text-uppercase text-muted mb-0">VAT </h5>
                        <span class="h2 font-weight-bold mb-0">%${config.VAT}</span>
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
                        <h5 class="card-title text-uppercase text-muted mb-0">POS Charge</h5>
                        <span class="h2 font-weight-bold mb-0">&#8358;${config.POS}</span>
                    </div>
                    <div class="col-auto">
                        <div class="icon icon-shape bg-gradient-green text-white rounded-circle shadow">
                            <i class="ni ni-credit-card"></i>
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


                    <h2 class="h2 text-center "> Transactions</h2>
<table border= "1" class="table table-striped table-dark table-bordered" id="datatable">
  
    <thead>
        <tr class="thead-dark">
           
            <th>Ref No.</th>
            <th>Product</th>
            <th>Logger</th>
            <th>Client</th>
            <th>Date & Time</th>
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
