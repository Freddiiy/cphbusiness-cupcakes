<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:navbar>

    <jsp:body>
        <div class="landing-header">

            <div class="video-overlay"></div>

            <div class="container h-100">
                <div class="d-flex h-100 text-center align-items-center">
                    <div class="landing-container text-white w-100">
                        <h1 class="display-3 text-shadow">Olsker Cupcakes</h1>
                        <p class="lead mb-0 text-shadow">Cupcakes til dine lår</p>
                    </div>
                </div>
            </div>
            <video class="landing-video" playsinline autoplay muted loop>
                <source src="resources/vid/hero.mp4" type="video/mp4">
            </video>
        </div>

        <!-- Cards container-->
        <div class="container py-3 py-md-5">
            <div class="row row-cols-1 row-cols-sm-1 row-cols-md-1 row-cols-lg-2 g-4">

                <!-- Cards -->
                <div class="col">
                    <div class="card mb-3">
                        <div class="row g-0">
                            <div class="col-12 col-md-12 col-lg-5 p-0 pt-lg overflow-hidden">
                                <img class="card-img-container" src="${pageContext.request.contextPath}/resources/img/cardImg/card-img.png" alt="...">
                            </div>
                            <div class="rounded-3 col-12 col-md-12 col-lg-7 my-3 my-md-3">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card mb-3">
                        <div class="row g-0">
                            <div class="col-12 col-md-12 col-lg-5 p-0 pt-lg overflow-hidden">
                                <img class="card-img-container" src="${pageContext.request.contextPath}/resources/img/cardImg/card-img-2.png" alt="...">
                            </div>
                            <div class="rounded-3 col-12 col-md-12 col-lg-7 my-3 my-md-3">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                        <img src="${pageContext.request.contextPath}/resources/img/cardImg/card-img.png"
                             class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                        <img src="https://media.istockphoto.com/photos/photo-of-female-hand-holding-cupcake-on-the-wonderful-red-background-picture-id677634654?k=20&m=677634654&s=170667a&w=0&h=VUsc-QKBx_5g4nQgyi4yURu7g0qDxjbQN3JpH2W9maA="
                             class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                        <img src="https://media.istockphoto.com/photos/photo-of-female-hand-holding-cupcake-on-the-wonderful-red-background-picture-id677634654?k=20&m=677634654&s=170667a&w=0&h=VUsc-QKBx_5g4nQgyi4yURu7g0qDxjbQN3JpH2W9maA="
                             class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:navbar>
