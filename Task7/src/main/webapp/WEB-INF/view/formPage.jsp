<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>User Form</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
    <h2 class="text-center mb-4">User Form</h2>

    <div class="card p-4 shadow">

        <form:form action="processForm" modelAttribute="userdata" method="post">

            <div class="mb-3">
                <form:input path="userName" cssClass="form-control form-control-lg" placeholder="Username"/>
            </div>

            <div class="mb-3">
                <form:password path="passWord" cssClass="form-control form-control-lg" placeholder="Password"/>
            </div>

            <div class="mb-4">
                <form:select path="country" cssClass="form-select form-select-lg">
                    <form:option value="Egypt" label="Egypt" />
                    <form:option value="Brazil" label="Brazil" />
                    <form:option value="Saudia Arabia" label="KSA" />
                </form:select>
            </div>

            <h5>Preferred Programming Language</h5>
            <div class="mb-3">
                <label class="me-3">
                    <form:radiobutton path="programminglang" value="Java"/> Java
                </label>
                <label class="me-3">
                    <form:radiobutton path="programminglang" value="C#"/> C#
                </label>
                <label class="me-3">
                    <form:radiobutton path="programminglang" value="PHP"/> PHP
                </label>
                <label>
                    <form:radiobutton path="programminglang" value="Ruby"/> Ruby
                </label>
            </div>

            <h5>Preferred Operating System</h5>
            <div class="mb-4">
                Linux <form:checkbox path="os" value="Linux" />
                Mac OS <form:checkbox path="os" value="Mac OS" />
                MS Windows <form:checkbox path="os" value="MS Windows" />
            </div>

            <div class="d-grid">
                <button class="btn btn-danger btn-lg">Submit</button>
            </div>

        </form:form>

    </div>
</div>

</body>
</html>
