<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:head>
    <t:navbar>
        <jsp:body>
            <div class="container"  style="margin-top: 80px">
                <table class="table table-striped table-borderless flex-column table-hover container" id="table">
                    <thead class="table-active">
                    <th class="col">Bottom</th>
                    <th class="col">Pris</th>
                    <th class="col">Topping</th>
                    <th class="col">Pris</th>
                    <th class="col">Antal</th>
                    <th class="col">Total</th>
                    </thead>
                    <c:forEach var="item" items="${requestScope.cartList}">
                        <tr>
                            <td>${item.getBottom()}</td>
                            <td>${item.getBottomPrice()} kr.</td>
                            <td>${item.getTopping()}</td>
                            <td>${item.getToppingPrice()} kr.</td>
                            <td>${item.getAmount()} stk.</td>
                            <td>${item.getTotalPrice()} kr.</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </jsp:body>
    </t:navbar>
</t:head>
