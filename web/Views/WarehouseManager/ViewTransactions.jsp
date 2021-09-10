
<%@ include file = "../../Header.jsp" %>
<!--Body Starts Here-->
<div class="info">
    <body>


        <div class="info">

            <h2 class="text-center">Transactions</h2>

            <div class="container info">
                <table border= "1" class="table table-striped table-bordered" id="datatable">
                    <thead>
                        <tr class="thead-dark">
                            <th>SN</th>
                            <th>Ref No.</th>
                            <th>Product</th>
                            <th>Logger</th>
                            <th>Client</th>
                            <th>Time</th>
                            <th>Units Sold</th>
                            <th>Total Price</th>
                            
                            

                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${list}" var="transaction" varStatus="loop">
                            <tr>  <td>${loop.index+1}</td>
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
                <button class="btn btn-primary" onclick="window.location.href = 'StockController?action=ADD'">Upload Products</button>
                <div>
                    <p> ${message} </p>
                </div>

                <%@ include file = "../../Footer.jsp" %>   