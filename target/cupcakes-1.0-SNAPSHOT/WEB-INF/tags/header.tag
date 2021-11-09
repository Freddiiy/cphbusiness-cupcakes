<%--
  Created by IntelliJ IDEA.
  User: Frederik
  Date: 08/11/2021
  Time: 13.40
  To change this template use File | Settings | File Templates.
--%>
<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="icon" type="image/png" href=${pageContext.request.contextPath}"/img/favicon.png" />
    <script defer src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.js"></script>
    <title>Cupcakes</title>
</head>
<body>
<div id="container-hero">
    <img class="w-100 h-auto" src=${pageContext.request.contextPath}"/img/banner.png" alt="cupcake banner" />
</div>

<header class="p-lg-3 p-0 mb-3 border-bottom bg-light sticky-top">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start py-lg-0 py-md-3" id="logo">
            <ul class="nav col-lg-auto me-lg-auto justify-content-center mb-md-2 mb-0">
                <li>
                    <a class="nav-link px-2 text-secondary" href="${pageContext.request.contextPath}/">Hjem</a>
                </li>
                <li>
                    <a class="nav-link px-2 text-secondary" href="${pageContext.request.contextPath}/orders">Ordrer</a>
                </li>
                <li>
                    <a class="nav-link px-2 text-secondary">Kunder</a>
                </li>
            </ul>
            <div class="text-end">
                <ul class="nav col-lg-auto me-lg-auto justify-content-center mb-md-0 mb-0 pt-md-0 pt-2">
                    <li>
                        <a class="nav-link px-2 text-secondary">kontakt@cupcake</a>
                    </li>
                    <li>
                        <a class="nav-link px-2 text-secondary" href="">
                            <img class="img-fluid" src="${pageContext.request.contextPath}/img/shopping-cart.png" alt="Shopping cart"/>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>

<div id="body">
    <jsp:doBody />
</div>


</body>
</html>