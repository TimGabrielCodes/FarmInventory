<%-- 
    Document   : Analytics
    Created on : Mar 31, 2020, 9:51:33 PM
    Author     : Zinwota Timothy @BrainStack
--%>
<%@page import="com.farminventory.entity.Transaction"%>
<%@page import="com.farminventory.dao.ProductDAOImpl"%>
<%@page import="com.farminventory.dao.ProductDAO"%>
<%@page import="com.farminventory.entity.Product"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%
    List<Product> products = new ArrayList();
    List<Transaction> countTrans = new ArrayList();
    List<Transaction> trackerList = new ArrayList();
    ProductDAO productDAO = new ProductDAOImpl();
    trackerList = productDAO.trackSales();
    products = productDAO.get();
    countTrans = productDAO.countTrans();

%>

<%@include file="Manager_Header.jsp" %>


<div class="row">
    <div class="col-sm-6">
        <canvas id="track"></canvas>         
    </div>
    <div class="col-sm-6">
            <td><canvas id="countTrans"></canvas></td>
       
    </div>
</div>
<div class="row">
    <div class="col-sm-12">
             <canvas id="StockChart"></canvas>
    </div>
</div>
   
  




<script>
    var ctx = document.getElementById('StockChart').getContext('2d');
    var chart = new Chart(ctx, {
// The type of chart we want to create
        type: 'bar',

// The data for our dataset
        data: {
            labels: [<%
for (int t = 0; t < products.size(); t++) {
if (t < 1) {
out.write("'" + products.get(t).getName() + "'");
} else {
out.write(", '" + products.get(t).getName() + "'");
}
            }%>],
            datasets: [{
                    label: 'Items In Stock',
                    backgroundColor: 'rgb(23,43,77)',
                    borderColor: 'rgb(23,43,77)',
                    data: [<%
for (int t = 0; t < products.size(); t++) {
if (t < 1) {
out.write("'" + products.get(t).getQuantity() + "'");
} else {
out.write(", '" + products.get(t).getQuantity() + "'");
}
                }%>]
                }]
        },

// Configuration options go here
        options: {}
    });
</script>

<script>
    var ctx = document.getElementById('countTrans').getContext('2d');
    var chart = new Chart(ctx, {
// The type of chart we want to create
        type: 'bar',

// The data for our dataset
        data: {
            labels: [<%
 for (int v = 0; v < countTrans.size(); v++) {
     if (v < 1) {
         out.write("'" + countTrans.get(v).getProductName() + "'");
     } else {
         out.write(", '" + countTrans.get(v).getProductName() + "'");
     }
            }%>],
            datasets: [{
                    label: 'Rate of Sales',
                    backgroundColor: '	rgb(23,43,77)',
                    borderColor: 'rgb(23,43,77)',
                    data: [<%
     for (int v = 0; v < countTrans.size(); v++) {
         if (v < 1) {
             out.write("'" + countTrans.get(v).getCount() + "'");
         } else {
             out.write(", '" + countTrans.get(v).getCount() + "'");
         }
                }%>]
                }]
        },

// Configuration options go here
        options: {
            beginAtZero: 'true'
        }
    });
</script>


<script>
    var ctx = document.getElementById('track').getContext('2d');
    var chart = new Chart(ctx, {
        // The type of chart we want to create
        type: 'line',
        // The data for our dataset
        data: {
            labels: [<%
           for (int u = 0; u < trackerList.size(); u++) {
               if (u < 1) {
                   out.write("'" + trackerList.get(u).getTime() + "'");
               } else {
                   out.write(", '" + trackerList.get(u).getTime() + "'");
               }
            }%>],
            datasets: [{
                    label: 'Sales over Time',

                    borderColor: '	rgb(23,43,77)',
                    data: [<%
               for (int u = 0; u < trackerList.size(); u++) {
                   if (u < 1) {
                       out.write("'" + trackerList.get(u).getTotalCharge() + "'");
                   } else {
                       out.write(", '" + trackerList.get(u).getTotalCharge() + "'");
                   }
                }%>]
                }]
        },

        // Configuration options go here
        options: {

        }
    });
</script> 



<%@include file="../../Footer.jsp" %>