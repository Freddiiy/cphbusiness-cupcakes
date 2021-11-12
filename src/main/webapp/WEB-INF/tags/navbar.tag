<%--
  Created by IntelliJ IDEA.
  User: Frederik
  Date: 08/11/2021
  Time: 13.40
  To change this template use File | Settings | File Templates.
--%>
<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:head>
    <jsp:body>
        <body>
        <header>
            <nav class="sticky-top navbar navbar-expand-lg navbar-dark bg-dark bg-opacity-75 px-3 align-content-lg-center">
                <div class="container">
                    <div class="d-block">
                        <a class="navbar-brand" href="#">
                            <img class="img-fluid rounded-3" style="height: 2em; width: auto;"
                                 src="${pageContext.request.contextPath}/resources/img/logo.png">
                            Olskers Cupcakes
                        </a>
                    </div>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false"
                            aria-label="navbarNavDropdown">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <ul class="navbar-nav justify-content-start">
                            <li class="nav-item">
                                <a class="nav-link" href="#about">Om mig</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#prices">Priser</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#contact">Kontakt</a>
                            </li>
                        </ul>
                    </div>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <ul class="navbar-nav justify-content-end">
                            <li class="nav-item me-2">
                                <button class="btn btn-outline-light" href="/login" value="Log ind">Log Ind</button>
                            </li>
                            <li class="nav-item me-2">
                                <button class="btn btn-outline-light" href="/register" value="Registrer">Registrer</button>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>

        <div id="body">
            <jsp:doBody/>
        </div>
        </body>
    </jsp:body>
</t:head>
