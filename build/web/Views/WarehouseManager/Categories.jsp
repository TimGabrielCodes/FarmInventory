
<%@ include file = "../../Header.jsp" %>
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
                            <th>Category</th>
                            <th>Created By</th>
                            <th>Action</th>
                            

                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${list}" var="category" varStatus="loop">
                            <tr>  <td>${loop.index+1}</td>
                                <td ><input class="form-control" type="text" name="name" value="${category.name}" readonly/></td>
                               
                                <td><input class="form-control" type="text" name="loggedBy"value="${category.createdBy}" readonly/></td>
                                
                                <td>
                                    <a class="form-control row-md-2" href="${pageContext.request.contextPath}/CategoryController?action=EDIT&id=${category.id}">Edit</a>
                                    
                                    <a class="form-control row-md-2" href="${pageContext.request.contextPath}/CategoryController?action=DELETE&id=${category.id}">Delete</a>
                                    
                                </td>

                            </tr>
                        </c:forEach>  
                    </tbody> 


                </table>
                <button class="btn btn-primary" onclick="window.location.href = 'Dashboard'">Home</button>
                <button class="btn btn-primary" onclick="window.location.href = 'CategoryController?action=NEW'">Add Category</button>
                <div>
                    <p> ${message} </p>
                </div>

        <%@include file="../../Footer.jsp" %>