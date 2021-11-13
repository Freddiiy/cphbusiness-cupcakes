<%--
  Created by IntelliJ IDEA.
  User: Frederik
  Date: 13/11/2021
  Time: 13.53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:navbar>
    <jsp:body>
        <table class="table table-striped table-borderless flex-column table-hover container">
            <thead class="table-active">
                <th class="col">Bottom</th>
                <th class="col">Pris</th>
            </thead>
            <c:forEach var="p" items="${}" varStatus="status">
                <tr>
                    <td></td>
                </tr>
            </c:forEach>
        </table>
    </jsp:body>
</t:navbar>