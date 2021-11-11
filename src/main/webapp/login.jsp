<%--
  Created by IntelliJ IDEA.
  User: Frederik
  Date: 10/11/2021
  Time: 13.47
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:head>
    <jsp:body>
        <div class="d-flex align-items-center min-vh-100 bg-light nopadding">
            <div class="container-fluid nopadding">
                <div class="row nopadding">
                    <div class="col-0 col-md-4 col-lg-6 col-xl-8 bg-img d-none d-md-block nopadding">
                    </div>
                    <div class="col-12 col-md-8 col-lg-6 col-xl-4 align-items-center my-auto">
                        <div class="p-5">

                            <form action="${pageContext.request.contextPath}/register" method="post" id="login-form" class="needs-validation">
                                <h3 class="pb-3">Log ind på Olskers Cupckes.</h3>
                                <div class="form-floating mb-3">
                                    <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" required>
                                    <label for="floatingInput">Email adresse</label>
                                    <div class="invalid-feedback">Venligst angiv en gyldig email.</div>
                                </div>
                                <div class="form-floating mb-3">
                                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password" required>
                                    <label for="floatingPassword">Gentag kodeord</label>
                                    <div class="invalid-feedback">Venligst angiv et gyldigt kodeord</div>
                                </div>
                                <button class="w-100 btn btn-lg btn-cupcakes-secondary" type="submit" id="sendButton">Log ind</button>
                                <hr class="my-4">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script defer src="js/loginValidation.js"></script>
    </jsp:body>
</t:head>
