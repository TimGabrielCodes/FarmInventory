<%-- 
    Document   : Logout
    Created on : Mar 23, 2020, 12:45:54 AM
    Author     : Zinwota Timothy @BrainStack
--%>

<%
    session.invalidate();
    response.sendRedirect("index.jsp");
%>