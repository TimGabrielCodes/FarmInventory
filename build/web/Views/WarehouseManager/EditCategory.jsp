<%@include file="../../Header.jsp" %>



<body>


    <div class="info">
        <div class="container">
            <h1> Categories </h1>  
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <form method="POST"  action="${pageContext.request.contextPath}/CategoryController">
                            <div 


                                <div class="form-group">
                                    <input type="text" name="category" placeholder="Category Name" value="${category.name}" class="form-control"><br>  
                                </div>

                                <div class="form-group">
                                    <input type="text" name="loggedBy" placeholder="" value="<%out.print(getUserName());%>"  class="form-control" disabled="true"><br>  
                                </div>
                                <div class="form-group">
                                    <input type="hidden" value="${category.id}" name="id">
                                </div>
                                <div class="form-group">
                                    <button class="btn btn-primary" type="submit"> Save  </button>    
                                </div>
                                <div class="form-group">

                                    </form>
                                </div>
                            </div>
                    </div>

                    <%@ include file = "../../Footer.jsp" %>   

