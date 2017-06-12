<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <c:url value="/css/main.css" var="jstlCss"/>
    <link href="${jstlCss}" rel="stylesheet"/>

</head>
<body>

<div class="container">

    <div class="starter-template">
        <h1>Events information for London</h1>
    </div>
    <div>
        <table>
            <tr>
                <th colspan=2>Title</th>
                <th colspan=4>Description</th>
                <th colspan=2>Start Time</th>
                <th colspan=2>Weather Conditions</th>
            </tr>
            <c:forEach var="event" items="${eventResult.events}">
                <tr>
                    <td colspan=2>${event.title}</td>
                    <td colspan=4>${event.description}</td>
                    <td colspan=2>${event.startTime}</td>
                    <td colspan=2>20C - Sunny</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<!-- /.container -->

<script type="text/javascript"
        src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
