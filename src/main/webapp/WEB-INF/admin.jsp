<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:head>
    <t:navbar>
        <jsp:body>
            <c:choose>
                <c:when test="${requestScope.userList != null}">
                    <div class="container" style="margin-top: 80px">
                        <div class="bg-light rounded-3 p-0 p-md-5 mb-3">
                            <h1>Vores kunder</h1>

                            <c:forEach var="item" items="${requestScope.userList}">
                                <div class="px-0 py-5 mb-5 bg-light border rounded shadow mx-3">
                                    <div class="row text-start px-5">
                                        <h4 class="col-6">Email: ${item.getEmail()}</h4>
                                        <h4 class="col-6">ID: ${item.getId()}</h4>
                                        <hr class="mb-5">


                                        <h4 class="col-6">Rolle: ${item.getRole()}</h4>
                                        <h4 class="col-6">Balance: ${item.getBalance()} kr.</h4>
                                        <hr class="mb-3">

                                    </div>

                                    <div class="row justify-content-end m-0 p-0 p-md-0 m-md-0">
                                        <form class="col-2" method="get"
                                              action="${pageContext.request.contextPath}/admin/orders?userId=${item.getId()}">
                                            <input type="hidden" name="userId" value="${item.getId()}">
                                            <input class="btn btn-cupcakes-secondary" type="submit" value="Se ordre">
                                        </form>
                                        <div class="col-2">
                                            <button type="button" class="btn btn-cupcakes-secondary"
                                                    data-bs-toggle="modal"
                                                    data-bs-target="#modalVerify-${item.getId()}">
                                                Slet bruger
                                            </button>
                                        </div>
                                    </div>

                                    <!-- Modal -->
                                    <div class="modal fade" id="modalVerify-${item.getId()}" data-bs-keyboard="false"
                                         tabindex="-1" aria-labelledby="modal" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="modalVerifyTitle">Modal title</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                            aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <h4>Er du sikker på at du vil slette ${item.getEmail()}</h4>
                                                </div>
                                                <div class="modal-footer">
                                                    <form class="" method="post"
                                                          action="${pageContext.request.contextPath}/adminRemoveUser">
                                                        <input type="hidden" name="userId" value="${item.getId()}">
                                                        <input class="btn btn-cupcakes-secondary" type="submit"
                                                               value="Slet ${item.getEmail()}">
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="container" style="margin-top: 80px">
                        <h1>Der kunne ikke findes nogle kunder.</h1>
                    </div>
                </c:otherwise>
            </c:choose>
        </jsp:body>
    </t:navbar>
    <t:footer/>
</t:head>
