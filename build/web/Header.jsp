<%-- 
    Document   : Header
    Created on : Apr 19, 2020, 10:19:26 PM
    Author     : Zinwota Timothy @BrainStack
--%>
<%@page import="com.farminventory.dao.UserDAOImpl"%>
<%@page import="com.farminventory.dao.UserDAO"%>
<%! String email;
UserDAO userDAO = new UserDAOImpl();

    public String getEmail() {
        return email;
    }

    public String getUserName(){
            String fName= userDAO.getLogger(email).getFullName();
return fName;
}
    public String getRole(){
            String role= userDAO.getLogger(email).getRole();
return role;
}%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="Brainstack Farm Inventory">
  <meta name="author" content="Brainstack Technologies">
  <title><%out.print("Farm Inventory || " + request.getAttribute("title"));%></title>
  <!-- Favicon -->
  <link rel="icon" href="assets/img/brand/blue.png" type="image/png">
  <!-- Fonts -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
  <!-- Icons -->
  <link rel="stylesheet" href="assets/vendor/nucleo/css/nucleo.css" type="text/css">
  <link rel="stylesheet" href="assets/vendor/@fortawesome/fontawesome-free/css/all.min.css" type="text/css">
  <!-- Page plugins -->
  <!-- Argon CSS -->
  <link rel="stylesheet" href="assets/css/argon.css?v=1.2.0" type="text/css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.css"/>
        <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
        <script src="https://cdnjs.com/libraries/Chart.js"></script> 
         <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
         <%
             email = (String) session.getAttribute("email");
            if (email == null) {
                response.sendRedirect("index.jsp");
            }
        %>
</head>
<body>
  <!-- Sidenav -->
  <nav class="sidenav navbar navbar-vertical  fixed-left  navbar-expand-xs navbar-light bg-white" id="sidenav-main">
    <div class="scrollbar-inner">
      <!-- Brand -->
      <div class="sidenav-header  align-items-center">
        <a class="navbar-brand" href="javascript:void(0)">
        <!--img width="100%" height="300%" src="assets/img/brand/blue.png" class="navbar-brand-img" alt="..."-->
        <h1>Farm Inventory</h1>
        </a>
      </div>
      <div class="navbar-inner">
        <!-- Collapse -->
        <div class="collapse navbar-collapse" id="sidenav-collapse-main">
          <!-- Nav items -->
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link active" href="${pageContext.request.contextPath}/Dashboard">
                <i class="ni ni-tv-2 text-primary"></i>
                <span class="nav-link-text">Dashboard</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link " href="${pageContext.request.contextPath}/AnalyticsController">
                <i class="ni ni-chart-bar-32 text-orange"></i>
                <span class="nav-link-text">Analytics</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/StockController">
                <i class="ni ni-shop text-orange"></i>
                <span class="nav-link-text">Stock</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/TransactionController?action=CREATE">
                <i class="ni ni-pin-3 text-primary"></i>
                <span class="nav-link-text">Make Transaction</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/TransactionController?action=LIST">
                <i class="ni ni-single-02 text-yellow"></i>
                <span class="nav-link-text">View Transactions</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/StockController?action=RESTOCK">
                <i class="ni ni-shop text-yellow"></i>
                <span class="nav-link-text">Restock</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/CategoryController?action=LIST">
                <i class="ni ni-cart text-success"></i>
                <span class="nav-link-text">Product Categories</span>
              </a>
            </li>
         
          </ul>
          <!-- Divider -->
          <hr class="my-3">
          <!-- Heading -->
         
          </ul>
        </div>
      </div>
    </div>
  </nav>
  <!-- Main content -->
  <div class="main-content" id="panel"  >
    <!-- Topnav -->
    <nav class="navbar navbar-top navbar-expand navbar-dark bg-primary border-bottom">
      <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <!-- Search form -->
       
          <!-- Navbar links -->
          <ul class="navbar-nav align-items-center  ml-md-auto ">
            <li class="nav-item d-xl-none">
              <!-- Sidenav toggler -->
              <div class="pr-3 sidenav-toggler sidenav-toggler-dark" data-action="sidenav-pin" data-target="#sidenav-main">
                <div class="sidenav-toggler-inner">
                  <i class="sidenav-toggler-line"></i>
                  <i class="sidenav-toggler-line"></i>
                  <i class="sidenav-toggler-line"></i>
                </div>
              </div>
            </li>
            <li class="nav-item d-sm-none">
              <a class="nav-link" href="#" data-action="search-show" data-target="#navbar-search-main">
                <i class="ni ni-zoom-split-in"></i>
              </a>
            </li>
           
         
          </ul>
          <ul class="navbar-nav align-items-center  ml-auto ml-md-0 ">
            <li class="nav-item dropdown">
              <a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <div class="media align-items-center">
                  <span class="avatar avatar-sm rounded-circle">
                    <img alt="Image placeholder" src="assets/img/default.png">
                  </span>
                  <div class="media-body  ml-2  d-none d-lg-block">
                    <span class="mb-0 text-sm  font-weight-bold"><%out.print(getUserName());%></span>
                  </div>
                </div>
              </a>
              <div class="dropdown-menu  dropdown-menu-right ">
                <div class="dropdown-header noti-title">
                  <h6 class="text-overflow m-0"><%out.print(getRole());%></h6>
                               <div class="dropdown-divider"></div>
                <a href="${pageContext.request.contextPath}/Logout.jsp" class="dropdown-item">
                  <i class="ni ni-user-run"></i>
                  <span>Logout</span>
                </a>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>
                  <div style="padding: 10px">
