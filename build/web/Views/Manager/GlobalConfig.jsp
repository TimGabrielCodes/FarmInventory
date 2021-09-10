<%@include  file="Manager_Header.jsp" %>




<div class="row"> 
    <div class="col">
        <a class="btn btn-secondary btn-lg  " href="${pageContext.request.contextPath}/DeliveryController">Delivery Costs</a>

    </div>
    <div class="col">
        <a class="btn btn-secondary btn-lg "    href="${pageContext.request.contextPath}/GlobalConfig?action=EDITPOS">VAT & POS Charges</a>
    </div>

</div>
</tr> 
<h3>${message}</h3>
</table> 
<%@include file="../../Footer.jsp" %>
