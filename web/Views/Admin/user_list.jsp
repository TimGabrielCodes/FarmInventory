
<%@ include file = "Admin_Header.jsp" %>
<!--Body Starts Here-->
<div class="info">
    <body>


        <div class="info">

            <h2 class="text-center">Farm Inventory User List</h2>

            <div class="container">
                <table border= "1" class="table table-striped table-bordered" id="datatable">
                    <thead>
                        <tr class="thead-dark">
                            <th>User ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th>Actions</th>

                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${list}" var="user">
                            <tr>  <td>${user.user_id}</td>
                                <td>${user.first_name}</td>
                                <td>${user.last_name}</td>
                                <td>${user.email}</td>
                                <td>${user.role}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/UserController?action=EDIT&id=${user.user_id}">Edit</a>
                                    |
                                    <a href="${pageContext.request.contextPath}/UserController?action=DELETE&id=${user.user_id}">Delete</a>
                                </td>

                            </tr>
                        </c:forEach>  
                    </tbody> 


                </table>
                </br></br>
                <div class="row">
                <button class="btn btn-primary form-control" onclick="window.location.href = 'UserController?action=ADD'">Create User</button>
                </div>
                <div>
                    <p> ${message} </p>
                </div>

                <%@ include file = "../../Footer.jsp" %>   