<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:head>
    <t:navbar>
        <jsp:body>
            <div class="container" style="margin-top: 80px">
                <c:forEach var="item" items="${requestScope.orderList}">
                    <form method="post" action="${pageContext.request.contextPath}/removeFromCart">
                        <h6>${item.getId()}</h6>
                        <h6>${item.getUserId()}</h6>
                        <h6>${item.getOrderItems().getBottom()}</h6>
                        <h6>${item.getOrderItems().getTopping()}</h6>
                        <h6>${item.getOrderItems().getAmount()}</h6>
                        <input type="hidden" name="cartId" value="${item.getId()}">
                        <input type="submit" value="Fjern fra kurv">
                    </form>
                </c:forEach>
            </div>
        </jsp:body>
    </t:navbar>
</t:head>