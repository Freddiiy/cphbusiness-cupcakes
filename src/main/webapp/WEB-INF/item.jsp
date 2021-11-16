<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 15/11/2021
  Time: 22.30
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:head>
    <t:navbar>
        <jsp:body>
            <br><br><br><br><br>
            <p>Name: ${requestScope.name}</p>
            <p>Desc: ${requestScope.desc}</p>
            <p>Image: ${requestScope.imageURL}</p>
        </jsp:body>
    </t:navbar>
</t:head>