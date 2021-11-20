<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:head>
    <t:navbar>
        <jsp:body>
            <c:choose>
                <c:when test="${requestScope.orderList != null}">
                    <div class="container" style="margin-top: 80px">
                        <div class="bg-light rounded-3 p-4 p-md-5 mb-3">
                            <h1 class="ps-4">Mine ordre</h1>

                            <c:forEach var="item" items="${requestScope.orderList}">
                                <div class="px-0 py-5 mb-5 bg-light border rounded shadow mx-0">
                                    <div class="row text-start px-5">

                                        <h4 class="col-12 col-lg-6 text-truncate">Bund: ${item.getOrderItems().getBottom()}</h4>
                                        <h4 class="col-12 col-lg-6 text-truncate">${item.getOrderItems().getBottomPrice()} kr.</h4>
                                        <hr class="mb-3 mb-md-5">

                                        <h4 class="col-12 col-lg-6 text-truncate">Topping: ${item.getOrderItems().getTopping()}</>
                                        <h4 class="col-12 col-lg-6 text-truncate">${item.getOrderItems().getToppingPrice()} kr.</h4> <br>
                                        <hr class="mb-3 mb-md-5">

                                        <h4 class="col-12 col-lg-6 text-truncate">Antal: ${item.getOrderItems().getAmount()}</h4>
                                        <h4 class="col-12 col-lg-6 text-truncate">i alt: ${item.getOrderItems().getTotalPrice()} kr.</h4>
                                        <hr class="mb-1 mb-md-1">
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="container" style="margin-top: 80px">
                        <h1>Du har ingen ordre.</h1>
                    </div>
                </c:otherwise>
            </c:choose>
        </jsp:body>
    </t:navbar>
    <t:footer/>
</t:head>
