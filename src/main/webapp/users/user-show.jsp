<!-- Topbar -->
<%@ include file="/header.jsp" %>
<!-- End of Topbar -->

<!-- Begin Page Content -->
<div class="container-fluid">
    <div class="row">

        <div class="container-fluid">
            <a href="/user/list" class="btn btn-secondary mb-3">
                <i class="fas fa-arrow-left"></i> Back
            </a>

            <div class="card shadow mb-4">
                <div class="card-header bg-light border-bottom">
                    <h6 class="m-0 font-weight-bold text-primary">USERS LIST</h6>
                </div>
                <div class="card-body">
                    <c:choose>
                        <c:when test="${not empty user}">
                            <div class="table-responsive">
                                <table class="table table-bordered mb-0">
                                    <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Email</th>
                                        <th>Username</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>${user.id}</td>
                                        <td>${user.email}</td>
                                        <td>${user.username}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="alert alert-danger">
                                User was not found!
                            </div>
                        </c:otherwise>
                    </c:choose>
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
