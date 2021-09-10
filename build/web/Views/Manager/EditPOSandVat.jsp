<%@include file="Manager_Header.jsp" %>



<body>


    <div class="info">
        <div class="container">
            <h1> Edit POS and VAT </h1>  
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                         <form method="POST"  action="${pageContext.request.contextPath}/GlobalConfig">
<div 
                                        <div class="form-group">
                                            <input type ="number" name="POS" value="${config.POS}"  class="form-control"><br>
                                        </div>
                                        <div class="form-group">
                                            <input type ="number"  name="VAT" value="${config.VAT}" step="0.01" class="form-control"><br>   
                                        </div>
                                        <div class="form-group">
                                          <div class="form-group">
                                            <input type ="text" name="restock_level" value="${config.restockLevel}" placeholder="Restock Level" class="form-control" ><br> 
                                        </div>                                               
                                       <div class="form-group">
                                            <input type ="text" name="lastModifiedBy" value="${config.lastModifiedBy}" placeholder="Last Modified" class="form-control" readonly><br> 
                                        </div>
                                        
                                     
                                      
                                        <div class="form-group">
                                         
                                            <button class="btn btn-primary" type="submit"> Update </button>    
                                        </div>
                                        <div class="form-group">

                                    </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%@ include file = "../../Footer.jsp" %>   

