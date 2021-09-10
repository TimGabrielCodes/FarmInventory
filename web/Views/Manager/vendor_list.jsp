
<%@ include file = "Manager_Header.jsp" %>
            <!--Body Starts Here-->
            <div class="info">
                <body>

                    
                    <div class="info">
                        
                        <h2 class="text-center">Farm Inventory Vendors List</h2>
                        
                        <div class="container">
                            <table border= "1" class="table table-striped table-bordered" id="datatable">
                                <thead>
                                    <tr class="thead-dark">
                                        <th>Vendor ID</th>
                                        <th>Vendor Name</th>
                                        <th>Action</th>
                                        
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach items="${list}" var="vendor">
                                        <tr>  <td>${vendor.vendor_id}</td>
                                            <td>${vendor.vendor_name}</td>
                                            
                                            <td>
                                                <a href="${pageContext.request.contextPath}/VendorController?action=EDIT&id=${vendor.vendor_id}">Edit</a>
                                                |
                                                <a href="${pageContext.request.contextPath}/VendorController?action=DELETE&id=${vendor.vendor_id}">Delete</a>
                                            </td>

                                        </tr>
                                    </c:forEach>  
                                </tbody> 


                            </table>
                            <button class="btn btn-primary" onclick="window.location.href = 'VendorController?action=ADD'">Create Vendor</button>
                            <div>
                                <p> ${message} </p>
                            </div>

    <%@ include file = "../../Footer.jsp" %>   