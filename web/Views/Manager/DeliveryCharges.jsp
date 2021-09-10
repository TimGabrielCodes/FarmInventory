
<%@ include file = "Manager_Header.jsp" %>
<!--Body Starts Here-->
<div class="info">
    <body>


        <div class="info">
      
          <h2 class="text-center">Delivery Charges</h2>

            <div class="container">
                <table border= "1" class="table table-striped table-bordered" id="datatable">
                    <thead>
                        <tr class="thead-dark">
                            
                            <th>S/N</th>
                            <th>State</th>
                            <th>Charge</th>
                            <th>Action</th>
                            

                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${list}" var="location" varStatus="loop">
                            <tr>  <td>${loop.index+1}</td>
                                <td ><input class="form-control" type="text" name="state" value="${location.state}" readonly/></td>
                              
                                <td><input class="form-control" type="number" name="charge"value="${location.charge}" readonly/></td>
                                
                                <td>
                                    <a class="form-control row-md-2" href="${pageContext.request.contextPath}/DeliveryController?action=EDIT&id=${location.location_id}">Edit</a>
                                    
                                    <a class="form-control row-md-2" href="${pageContext.request.contextPath}/DeliveryController?action=DELETE&id=${location.location_id}">Delete</a>
                                    
                                </td>

                            </tr>
                        </c:forEach>  
                    </tbody> 


                </table>
                <button class="btn btn-primary" onclick="window.location.href = 'Dashboard'">Home</button>
                <button class="btn btn-primary" onclick="window.location.href = 'DeliveryController?action=NEW'">Add Delivery Location</button>
                <div>
                    <p> ${message} </p>
                </div>

        <%@include file="../../Footer.jsp" %>