<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link rel="stylesheet" type="text/css" href='<c:url value="/theme/vendor/fontawesome-free/css/all.min.css"/>'/>
    <link rel="stylesheet"
          href='<c:url value="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"/>'/>

    <!-- Custom styles for this template-->
    <link rel="stylesheet" href='<c:url value="/theme/css/sb-admin-2.css"/>'/>


</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <li class="nav-item active">
            <a class="nav-link" href="list.jsp">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Users CRUD</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <%@ include file="/header.jsp" %>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-header bg-light border-bottom">
                        <h1 class="h5 text-gray-800 my-2">Edit user</h1>
                    </div>
                    <div class="card-body p-4">
                        <form class="user" method="post">

                            <input type="hidden" name="id" value="${user.id}"/>
                            <div class="form-group">
                                <label for="email">Email address</label>
                                <input type="email" class="form-control"
                                       id="email" name="email"
                                       value="${user.email}" required>
                            </div>
                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" class="form-control"
                                       id="username" name="username"
                                       value="${user.username}" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control"
                                       id="password" name="password"
                                       placeholder="Nowe hasło">
                            </div>
                            <div>
                                <button type="submit" class="btn btn-primary btn-block">
                                    Zapisz zmiany
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- End of Main Content -->

        </div>
        <%@ include file="/footer.jsp" %>
    </div>
</div>
</body>
<!-- End of Page Wrapper -->
