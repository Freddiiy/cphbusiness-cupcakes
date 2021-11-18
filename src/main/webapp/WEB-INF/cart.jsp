<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:head>
    <t:navbar>
        <jsp:body>
            <c:choose>
                <c:when test="${sessionScope.orderList != null}">
                    <div class="container" style="margin-top: 80px">
                        <div class="bg-light rounded-3 p-5 mb-3">
                            <h1>Indkøbsvogn</h1>

                            <c:forEach var="item" items="${sessionScope.orderList}">
                                <div class="py-5 mb-5 bg-light border rounded shadow mx-3">
                                    <form method="post" action="${pageContext.request.contextPath}/removeFromCart">
                                        <div class="row text-start px-5">
                                            <h3 class="col-6">Bund: ${item.getCartItems().getBottom()}</h3>
                                            <h3 class="col-6">${item.getCartItems().getBottomPrice()} kr.</h3>
                                            <hr class="mb-5">

                                            <h3 class="col-6">Topping ${item.getCartItems().getTopping()}</h3>
                                            <h3 class="col-6">${item.getCartItems().getToppingPrice()} kr.</h3> <br>
                                            <hr class="mb-5">
                                            <h3 class="col-6">Antal: ${item.getCartItems().getAmount()}</h3>
                                            <h3 class="col-6">i alt: ${item.getCartItems().getTotalPrice()} kr.</h3>
                                        </div>
                                        <hr>
                                        <input type="hidden" name="cartId" value="${item.getId()}">
                                        <input class="btn btn-cupcakes-secondary float-end me-3" type="submit"
                                               value="Fjern fra kurv">
                                    </form>
                                </div>
                            </c:forEach>
                            <c:if test="${sessionScope.orderList != null}">
                                <div class="bg-light">
                                    <form method="post" action="${pageContext.request.contextPath}/addOrder">
                                        <c:forEach var="order" items="${sessionScope.orderList}">
                                            <input type="hidden" name="order" value="">
                                        </c:forEach>
                                        <input class="btn btn-cupcakes-secondary float-end me-3" style="padding-left: 5rem; padding-right: 5rem;" type="submit" value="Køb">
                                    </form>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="container" style="margin-top: 80px">
                        <h1>Din indkøbskurv er tom.</h1>
                    </div>
                </c:otherwise>
            </c:choose>
        </jsp:body>
    </t:navbar>
    <t:footer />
</t:head>
