<%@include file="Admin_Header.jsp" %>








        <div class="info">

            <h1> Add New User </h1>  

            <form method="POST"  action="${pageContext.request.contextPath}/UserController">

                <div class="row">
                    <div class="col">
                        <input type ="text" name="first_name" value="${user.first_name}" placeholder="First Name" class="form-control" required="true"><br>
                    </div>
                    <div class="col">
                        <input type ="text"  name="last_name" value="${user.last_name}" placeholder="Last Name" class="form-control" required="true"><br>   
                    </div>
                </div>
                <div class="row"> 
                    <div class="col">
                        <input type ="email" name="email" value="${user.email}" placeholder="Email" class="form-control" required="true"><br>
                    </div>
                    <div class="col">                        
                        <select id="role" name="role" value="${user.role}" placeholder="Select Role" class="form-control" required="true">
                            <option value="" disabled selected> Select Role</option>
                            <option value="Administrator" name="role" placeholder="${user.role}">Administrator</option>
                            <option value="Manager" name="role" placeholder="${user.role}">Manager</option>
                            <option value="Warehouse Manager" name="role" placeholder="${user.role}">Warehouse Manager</option>                
                            <option value="Clerk" name="role" placeholder="${user.role}">Clerk</option>                
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <input type ="text" name="username" value="${user.username}" placeholder="username" class="form-control" required="true"/>
                    </div>
                </div>
                </br>
             
                  
                <input type="password"  class="form-control" name="pass1" placeholder="Enter Password"  required="true"/>
                </br>   
                <input type="password" class="form-control" name="pass2" placeholder="Enter Password" required="true"/>
              
       
        </br>

        <div class="row">
            <div class="col">
                <input type="hidden" value="${user.user_id}" name="user_id"/>
            </div>
        </div>
        </br>

        <div class="form-group">
            <button class="btn btn-primary" type="submit"> Save Employee </button>    
        </div>


        </form>
    </div>



<%@ include file = "../../Footer.jsp" %>   


