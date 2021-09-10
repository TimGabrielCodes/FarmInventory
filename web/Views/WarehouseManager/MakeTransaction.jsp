<%@page import="com.farminventory.util.DBConnectionUtil"%>
<%@page import="com.farminventory.entity.Product"%>
<%@page import="com.farminventory.dao.ProductDAOImpl"%>
<%@page import="com.farminventory.dao.ProductDAO"%>
<%@page import="java.sql.*"%>
<%!
    String selectedProductName = null;
    int id = 0;

%>
<%@include file="../../Header.jsp" %>
<div class="info">
    <body>

        <h2>Log Transaction</h2>
          <button class="btn btn-neutral">Scan Barcode</button>
        <br/><br/>
        ${message}
        
        <form  method="GET" name="entryForm" action="ValidateTransaction">


            <div class="row">
                <div class="col">   <select class=" form-control"  name="product_name"  placeholder="Select Product" required>
                        <option value="${product_id}" selected="selected" >- Select Product-</option>
                        <%                            try {
                                String query = "select * from product order by name";
                                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                                Connection conn =  DBConnectionUtil.openConnection();
                                Statement stm = conn.createStatement();
                                ResultSet rs = stm.executeQuery(query);

                                while (rs.next()) {
                                    selectedProductName = rs.getString("name");
                                    id = rs.getInt("product_id");
                        %>
                        <option class="form-control" value="<%=selectedProductName%>"><%=selectedProductName%></option>
                        <%
                                }

                            } catch (Exception ex) {
                                ex.printStackTrace();
                                out.println("Error" + ex.getMessage());
                            }
                        %>
                    </select></div>
                <div class="col">
                    <input class="form-control" type="number" name="quantity" placeholder="quantity" min="1" step="1" required="true"/>  

                </div>
            </div>
            </br> 

            <div class="row">
                <div class="col">
                    <select name="delivery"  class="form-control" required="true">
                        <option value="Pick-up" selected="selected" >Pick Up</option>
                        <option value='Abia'>Abia</option>
                        <option value='Adamawa'>Adamawa</option>
                        <option value='AkwaIbom'>AkwaIbom</option>
                        <option value='Anambra'>Anambra</option>
                        <option value='Bauchi'>Bauchi</option>
                        <option value='Bayelsa'>Bayelsa</option>
                        <option value='Benue'>Benue</option>
                        <option value='Borno'>Borno</option>
                        <option value='Cross River'>Cross River</option>
                        <option value='Delta'>Delta</option>
                        <option value='Ebonyi'>Ebonyi</option>
                        <option value='Edo'>Edo</option>
                        <option value='Ekiti'>Ekiti</option>
                        <option value='Enugu'>Enugu</option>
                        <option value='FCT'>FCT</option>
                        <option value='Gombe'>Gombe</option>
                        <option value='Imo'>Imo</option>
                        <option value='Jigawa'>Jigawa</option>
                        <option value='Kaduna'>Kaduna</option>
                        <option value='Kano'>Kano</option>
                        <option value='Katsina'>Katsina</option>
                        <option value='Kebbi'>Kebbi</option>
                        <option value='Kogi'>Kogi</option>
                        <option value='Kwara'>Kwara</option>
                        <option value='Lagos'>Lagos</option>
                        <option value='Nasarawa'>Nasarawa</option>
                        <option value='Niger'>Niger</option>
                        <option value='Ogun'>Ogun</option>
                        <option value='Ondo'>Ondo</option>
                        <option value='Osun'>Osun</option>
                        <option value='Oyo'>Oyo</option>
                        <option value='Plateau'>Plateau</option>
                        <option value='Rivers'>Rivers</option>
                        <option value='Sokoto'>Sokoto</option>
                        <option value='Taraba'>Taraba</option>
                        <option value='Yobe'>Yobe</option>
                        <option value='Zamfara'>Zamafara</option>
                    </select>
                </div>
                <div class="col">
                    <input class="form-control" type="text" name="client" placeholder="Enter Client's Name" required="true"/>

                </div>
            </div>
            </br>

            <input type="radio" id="POS" name="method" value="POS" required="true">
            <label for="POS">POS</label>

            <input type="radio" id="CASH" name="method" value="CASH" checked>
            <label for="CASH">CASH</label>  






</br> 
<button type="submit" class="btn  btn-neutral btn-block">Validate Product</button> <br/>
</form> 

<hr class="my-3">

</div>

<h2>Transaction Details</h2>
</hr>
<form action="ValidateTransaction" name="checkoutform" method="post">
    <div class="row">
        <div class="col">
            <label>Product Name</label>
            <input type="text" id="productName" class="form-control" value="${transaction.product.name}" name="productName" disabled="true"/>
        </div>
          <div class="col">
            <label>Quantity</label>
            <input name="quantity" id="quantity" class="form-control"  value="${transaction.quantity}" type="text" disabled="true"/>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <label>Category</label>
            <input name="category" id="category"  class="form-control" value="${transaction.product.category}" type="text" disabled="true"/>
        </div>
         <div class="col"> 
            <label>Unit Price</label>
              <div class="input-group">
                <div class="input-group-prepend">
                     <span class="input-group-text">&#x20A6;</span>
                </div>
            <input name="selectedName" id="selectedName" class="form-control" value="${transaction.product.selling_price}" type="text" disabled="true"/></br>
        </div>
        </div>
     
    </div>
    <div class="row">
        <div class="col">
            <label>Cost Price</label>
              <div class="input-group">
                <div class="input-group-prepend">
                     <span class="input-group-text">&#x20A6;</span>
                </div>
            <input name="costPrice" id="costPrice"  class="form-control" value="${transaction.costPrice}" type="text" disabled="true"/> </br>
              </div>
              </div>
        <div class="col">
            <label>VAT</label>
              <div class="input-group">
                <div class="input-group-prepend">
                     <span class="input-group-text">&#x20A6;</span>
                </div>
            <input name="VST" id="VAT"  class="form-control" value="${transaction.VAT}" type="text" disabled="true"/> </br>
        </div>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <label>Sub Charge</label>
              <div class="input-group">
                <div class="input-group-prepend">
                     <span class="input-group-text">&#x20A6;</span>
                </div>
            <input name="subCharge" id="subcharge"  class="form-control" value="${transaction.subcharge}" type="text" disabled="true"/> </br>
        </div>
        </div>
        <div class="col">
            <label>Delivery Price</label>
              <div class="input-group">
                <div class="input-group-prepend">
                     <span class="input-group-text">&#x20A6;</span>
                </div>
            <input name="deliverycost" id="subcharge"  class="form-control" value="${transaction.delivery.charge}" type="text" disabled="true"/> </br>
        
              </div></div></div>
    <div class="row">
        <div class="col">
            <label>Additional Costs</label>
            <div class="input-group">
                <div class="input-group-prepend">
                     <span class="input-group-text">&#x20A6;</span>
                </div>
                       <input name="additionalCost" id="additionalCost"  class="form-control" value="${transaction.POS_charge}" type="text" disabled="true"/> </br>
     
            </div>  
        </div>
        <div class="col">
            <label>Logger</label>
            <input name="Logger"  class="form-control"  value="<%out.print(getUserName());%>" type="text" disabled="true"/> </br>
        </div>
    </div>

    <div class="form-group">
        </br>
        <div class="input-group input-group-prepend">
            
                <span class="input-group-text"  style="color: #32325D">Grand Total: &#x20A6;</span>
       
            <input name="totalCharge" id="totalcharge" class="form-control"  value="${transaction.totalCharge}" type="text" disabled="true"/> </br>

        </div>
    </div>

    <button type="submit" class="btn btn-success btn-block btn-icon"  class="form-control"  >Confirm Transaction</button> <br/> 
</form>
<%@include file="../../Footer.jsp" %>
