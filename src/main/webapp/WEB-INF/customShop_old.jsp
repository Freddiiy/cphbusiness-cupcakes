<%--
  Created by IntelliJ IDEA.
  User: Frederik
  Date: 15/11/2021
  Time: 23.10
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--
    æ = &#230; &aelig;
    Æ = &#198; &AElig;
    ø = &#248;
    Ø = &#216;
    å = &#229;
    Å = &#197;
-->


<t:head>
    <jsp:body>
        <div class="bg-light rounded-3 text-center container py-4 mb-3 container-xl" id="welcome">
            <h1 class="display-3">Velkommen ombord</h1>
            <p class="h4">Øens bedst customCupcake. Vælg og bestil her:</p>
            <form action="${pageContext.request.contextPath}/addToCart" method="POST" accept-charset="UTF-8">
                <div class="container align-items-center p-4">
                    <div class="row d-flex">
                        <div class="col-sm col-md">
                            <select class="form-select flex-column" name="bottom" id="choose-menu" required>
                                <option value="" selected="true" disabled="disabled">Vælg bund</option>
                                <option value="Chocolate">Chocolate</option>
                                <option value="Blueberry">Blueberry</option>
                                <option value="Raspberry">Raspberry</option>
                                <option value="Crispy">Crispy</option>
                                <option value="Strawberry">Strawberry</option>
                                <option value="Rum & raisin">Rum & raisin</option>
                                <option value="Orange">Orange</option>
                                <option value="Lemon">Lemon</option>
                                <option value="Blue cheese">Blue cheese</option>
                            </select>
                        </div>

                        <div class="col-sm col-md">
                            <select class="form-select flex-column" name="topping" id="choose-menu" required>
                                <option value="" selected="true" disabled="disabled">Vælg topping</option>
                                <option value="Chocolate">Chocolate</option>
                                <option value="Vanilla">Vanilla</option>
                                <option value="Nutmeg">Nutmeg</option>
                                <option value="Pistachio">Pistachio</option>
                                <option value="Wallnut">Wallnut</option>
                            </select>
                        </div>

                        <div class="col-sm col-md">
                            <input class="form-control text-center me-3" type="number" name="amount" value="1" min="1">
                        </div>
                        <div class="flex-column col-lg col-md-4 col-sm-0 col-12 my-lg-0 my-md-0 px-md-0 mt-sm-5 mt-5">
                            <button class="btn btn-primary rounded-3 px-sm-5 px-5" type="submit">Bestil</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <c:if test="${param.addedToCart==1}">
            <div role="alert" aria-live="assertive" aria-atomic="true" class="toast" data-bs-autohide="false">
                <div class="toast-header">
                    <img src="${pageContext.request.contextPath}/resources/img/favicon.png" class="rounded me-2" alt="...">
                    <strong class="me-auto">Tilføjet til kurv</strong>
                    <small>now</small>
                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
                <div class="toast-body">
                    Tekst :)
                </div>
            </div>
        </c:if>
    </jsp:body>
</t:head>