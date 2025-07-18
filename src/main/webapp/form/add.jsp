<!-- Topbar -->
<%@ include file="/header.jsp" %>
<!-- End of Topbar -->

<!-- Begin Page Content -->
<div class="container-fluid">
    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-header bg-light border-bottom">
            <h1 class="h5 text-gray-800 my-2">Add user</h1>
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
                           placeholder="password">
                </div>
                <div>
                    <button type="submit" class="btn btn-primary btn-block">
                        Create
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
