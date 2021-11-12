<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:navbar>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:body>
        <div class="mainContainer">
            <div class="heroVideo">
                <div class="headerText">
                    <h1>Velkommen til <span style="font-family: Architects Daughter">Olsker Cupcakes</span></h1>
                    <h3>Til alle dine søde ønsker</h3>
                    <div class="headerButtons">
                        <a href="shop"><button>Webshop</button></a> <a href="#info"><button>Info</button></a>
                    </div>
                </div>
                <video autoplay muted loop>
                    <source src="resources/vid/hero.mp4" type="video/mp4">
                </video>
            </div>
        </div>

        <div class="pageContent">


            <div class="cardContainer">
                <div class="cardText">
                    <h1>Olsker Cupcakes er mere end bare cupcakes</h1>
                    <p>Det er løftet om en ekstraordinær smagsoplevelse. Hos Olsker Cupcakes er kvalitet og indtryk vigtige fokuspunkter som adskiller os fra andre.</p>
                </div>
                <div class="cardImage">
                    <img src="https://lh3.googleusercontent.com/proxy/S4VPs81uy2jafUWgtWiyZrJq6puGo1aW4sp-MiWsN57cBWucnBGVjakuUGo1n48TYHpYKKO2sVsdzndNolCI0H1ZvEoVE8F8X0KvncsH-pVdacfhHSro35LqY-FdH1zAii7llhGr">
                </div>
            </div>

            <div class="cardContainer">
                <div class="cardText">
                    <h1>Bagt med kærlighed og højeste kvalitet</h1>
                    <p>Olsker Cupcakes garanterer den bedste kvalitets cupcakes med brug af eksotiske og høj-kvalitets ingredienser. Cupcakes er ikke bare en lækker snack, det er en kunstform.</p>
                </div>
                <div class="cardImage">
                    <img src="https://media.istockphoto.com/photos/tray-with-muffins-in-oven-picture-id1208245671?k=20&m=1208245671&s=612x612&w=0&h=EfubbkZ55oOBVdR6j0fNQnoN9Y2HdlFE7fsC2Gpylk0=">
                </div>
            </div>

            <div class="cardContainer">
                <div class="cardText">
                    <h1>Håndlavet fra bunden</h1>
                    <p>Alle Olsker Cupcakes er håndlavet for at sikre den bedste kvalitet.</p>
                </div>
                <div class="cardImage">
                    <img src="https://media.istockphoto.com/photos/photo-of-female-hand-holding-cupcake-on-the-wonderful-red-background-picture-id677634654?k=20&m=677634654&s=170667a&w=0&h=VUsc-QKBx_5g4nQgyi4yURu7g0qDxjbQN3JpH2W9maA=">
                </div>
            </div>

            <div class="cardContainer">
                <div class="cardText">
                    <h1>Om Olsker Cupcakes</h1>
                    <p>Olsker Cupcakes blev stiftet i 2019 med målet at lave cupcakes af den højeste kvalitet. Holdet bag Olsker Cupcakes har længe haft lidenskab til kunsten bag cupcakes og fører det ud i virkeligheden med over 30 forskellige varianter af cupcakes.</p>
                </div>
                <div class="cardImage">
                    <img src="https://www.oetker.dk/Recipe/Recipes/oetker.dk/dk-da/baking/image-thumb__101256__RecipeDetailsLightBox/cupcakes-med-regnbue-smoercreme.jpg">
                </div>
            </div>
        </div>
    </jsp:body>
</t:navbar>