<!-- Topbar -->
<%@ include file="/header.jsp" %>
<!-- End of Topbar -->

<!-- Begin Page Content -->
<div class="container-fluid">
    <div class="row">

        <div class="container-fluid">
            <div class="row">
                <!-- Users -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-warning shadow h-100 py-2">
                        <div class="card-body">
                            <div class="d-flex justify-content-between align-items-center mb-2">
                                <div class="text-md font-weight-bold text-warning text-uppercase">
                                    EXISTING USERS
                                </div>
                                <a href="/user/add" class="btn btn-sm btn-success">
                                    <i class="fas fa-plus"></i> Add User
                                </a>
                            </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">
                                ${usersNumber}
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="card shadow mb-4">
                <div class="card-header bg-light border-bottom">
                    <h6 class="m-0 font-weight-bold text-primary">USERS LIST</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered mb-0">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Email</th>
                                <th>Username</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.email}</td>
                                    <td>${user.username}</td>
                                    <td>

                                        <a href="/user/edit?id=${user.id}" class="btn btn-sm btn-primary">Edit</a>
                                        <form action="/user/delete" method="post" style="display:inline;">
                                            <input type="hidden" name="id" value="${user.id}"/>
                                            <button type="submit" class="btn btn-sm btn-danger"
                                                    onclick="return confirm('Are you sure?');">
                                                Delete
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</div>
<%@ include file="/footer.jsp" %>
</div>
</div>
<!-- /.container-fluid -->

<!-- End of Main Content -->

</body>
<!-- End of Page Wrapper -->

</html>
