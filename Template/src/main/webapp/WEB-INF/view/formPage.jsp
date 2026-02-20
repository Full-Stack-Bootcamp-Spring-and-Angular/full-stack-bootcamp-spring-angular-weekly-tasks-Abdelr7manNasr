<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Employee Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="card p-4 shadow">

        <h3 class="mb-4">Employee Registration Form</h3>

        <form:form action="processForm" modelAttribute="userModel" class="needs-validation">

            <div class="mb-3">
                <label class="form-label">Username</label>
                <form:input path="userName" class="form-control" placeholder="Enter Username"/>
                <form:errors path="userName" cssClass="text-danger"/>
            </div>

            <div class="mb-3">
                <label class="form-label">Email address</label>
                <form:input path="email" class="form-control" placeholder="example@gmail.com"/>
                <form:errors path="email" cssClass="text-danger"/>
            </div>

            <div class="mb-3">
                <label class="form-label">Password</label>
                <form:password path="password" class="form-control"/>
                <form:errors path="password" cssClass="text-danger"/>
            </div>

            <div class="mb-3">
                <label class="form-label">Confirm Password</label>
                <form:password path="confirmPassword" class="form-control"/>
                <form:errors path="confirmPassword" cssClass="text-danger"/>
            </div>

            <form:errors cssClass="text-danger mb-3"/>

            <button class="btn btn-primary">Submit</button>

        </form:form>

    </div>
</div>

</body>
</html>
