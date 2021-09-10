<%@ include file = "Manager_Header.jsp" %>
<!--Body Starts Here-->
<div class="info">
              
           
             <div class="info">
                    <div class="container">
                        <h1> Add New Vendor </h1>  
                     <div class="container">
                            <div class="row">
                                <div class="col-md-4">
                                    <form method="POST"  action="${pageContext.request.contextPath}/VendorController">
<div 
                                        <div class="form-group">
                                            <input type ="text" name="vendor_name" value="${vendor.vendor_name}" placeholder="Vendor Name" class="form-control"><br>
                                        </div>
                                       
                                        <div class="form-group">
                                          Created By  <input type ="text" name="created_by" value="<%out.print(email);%>" placeholder="<%out.print(email);%>" readonly="enabled" class="form-control"><br> 
                                        </div>
                                        
                                            <input type="hidden" value="${vendor.vendor_id}" name="vendor_id">
                                        </div>
                                        <div class="form-group">
                                            <button class="btn btn-primary" type="submit"> Save Vendor </button>    
                                        </div>
                                        <div class="form-group">

                                    </form>
                                </div>
                            </div>
                        </div>

    <%@ include file = "../../Footer.jsp" %>   

            