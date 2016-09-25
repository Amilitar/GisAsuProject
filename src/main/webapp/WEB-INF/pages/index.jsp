<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="cp1251"%>
<%@ page language="java" contentType="text/html;charset=cp1251"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=cp1251"/>
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />

    <spring:url value="/resources/client/css/index.css"
                var="indexCss" />
    <link href="${indexCss}" rel="stylesheet" />

    <spring:url value="/resources/core/js/jquery-3.1.1.min.js"
                var="jqueryJs" />
    <spring:url value="/resources/core/js/bootstrap.min.js"
                var="bootstrapJs" />
    <script src="${jqueryJs}"></script>
    <script src="${bootstrapJs}"></script>

    <spring:url value="/resources/client/js/index.js"
                var="indexJs" />
    <script src="${jqueryJs}"></script>

</head>
<body>

<!-- YOUR CODE HERE -->
<div id="header">
    <jsp:include page="common/header.jsp" />
</div>

    <jsp:include page="common/header.jsp" />

<div id="footer">
    <jsp:include page="common/footer.jsp"/>
</div>
</body>
</html>
