
<%@page import="com.farminventory.util.DBConnectionUtil"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@include file="../../Header.jsp" %>
<div class="info">
    <body>

        <form action = "${pageContext.request.contextPath}/StockController"  method="POST" enctype="multipart/form-data" >

            <div class = "form-group">
                <input type = "text" class = "form-control" name = "product_name" value="${product.name}" placeholder = "Enter Name" />
            </div>
                <div class="form-group">

                    <select class="form-control" name="dcategory" value="${product.category}" placeholder="Select Vendor">
                        <option value="${product.category}" placeholder="Select Vendor" selected disabled>Select Category</option>
                        <%
                            try {
                                String query = "select * from category order by category";
                                Connection conn = DBConnectionUtil.openConnection();
                                Statement stm = conn.createStatement();
                                ResultSet rs = stm.executeQuery(query);
                                while (rs.next()) {
                        %>
                        <option class="form-control" value="<%= rs.getString("category")%>"><%= rs.getString("category")%></option>
                        <%
                                }

                            } catch (Exception ex) {
                                ex.printStackTrace();
                                out.println("Error" + ex.getMessage());
                            }
                        %>
                    </select>
                </div>
            <div class = "form-group">
                <input type = "number" class = "form-control" name = "cost_price" value="${product.cost_price}" step="1" min="0" placeholder="Cost Price"/>
            </div>
            <div class="form-group">
                <input type = "number" class = "form-control" name = "selling_price" value="${product.selling_price}" min="0" placeholder = "Selling Price"/>
            </div>
            <div class="form-group">
                <input type = "number" class = "form-control" name = "quantity" value="${product.quantity}" step="1" min="1" placeholder = "quantity" />
            </div>
            <div class="form-group">
                <input type="file" name="file" />
                <div class="form-group">
                    <select class="form-control" name="vendor" value="${product.vendorName}" placeholder="Select Vendor">
                        <option value="${product.vendorName}" placeholder="Select Vendor" selected disabled>Select Vendor</option>
                        <%
                            try {
                                String query = "select * from vendor order by vendor_name";
                                Connection conn = DBConnectionUtil.openConnection();
                                Statement stm = conn.createStatement();
                                ResultSet rs = stm.executeQuery(query);
                                while (rs.next()) {
                        %>
                        <option class="form-control" value="<%= rs.getString("vendor_name")%>"><%= rs.getString("vendor_name")%></option>
                        <%
                                }

                            } catch (Exception ex) {
                                ex.printStackTrace();
                                out.println("Error" + ex.getMessage());
                            }
                        %>

                    </select>
                </div>
             

                <input type = "hidden" name ="product_id" value ="${product.product_id}"/>

                <button type = "submit" class = "btn btn-primary">Save</button>
        </form>
</div>

<a href = "${pageContext.request.contextPath}/StockController?action=LIST">Back to List</a>

</br></br>
<%@include file="../../Footer.jsp" %>
