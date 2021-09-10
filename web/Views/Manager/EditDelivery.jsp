<%@include file="Manager_Header.jsp" %>
       
      
 
             <body>
              
           
             <div class="info">
                    <div class="container">
                        <h1> Locations </h1>  
                     <div class="container">
                            <div class="row">
                                <div class="col-md-4">
                                    <form method="POST"  action="${pageContext.request.contextPath}/DeliveryController">
<div 
    <select id="state">
        
    </select>
                                        <div class="form-group">
                                           
                                              <select name="state" value="${location.state}"  class="form-control">
                
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
                                            </br></br>
                                        <div class="form-group">
                                            <input type="number" name="charge" placeholder="Charge" value="${location.charge}" class="form-control"><br>  
                                        </div>
                                        <div class="form-group">
                                            <input type="hidden" value="${location.location_id}" name="id">
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

            