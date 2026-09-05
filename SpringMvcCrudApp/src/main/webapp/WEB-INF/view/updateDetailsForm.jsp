<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Product</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css' />">

    <style>
        :root{
            --navy:#0b1f3a;
            --navy-2:#132c52;
            --orange:#f47b20;
            --bg:#eef2f6;
            --card:#ffffff;
            --border:#d8e0ea;
            --muted:#6c7a89;
        }
        body{background:var(--bg); color:#1f2a37;}
        .page-wrap{min-height:100vh; display:flex; align-items:center;}
        .app-card{border:1px solid var(--border); border-radius:12px; background:var(--card);}
        .app-header{background:var(--navy); color:#fff; border-radius:12px 12px 0 0; border-bottom:1px solid rgba(255,255,255,.08);}
        .app-title{font-weight:800; margin:0;}
        .app-sub{color:rgba(255,255,255,.78); margin:0; font-size:13px;}
        .form-label{font-weight:700; color:#253043; margin-bottom:6px;}
        .form-control{border-radius:8px; border:1px solid var(--border); padding:.7rem .85rem;}
        .form-control:focus{box-shadow:none; border-color:var(--orange);}
        .btn{border-radius:8px; padding:.65rem 1rem;}
        .btn-orange{background:var(--orange); border-color:var(--orange); color:#111;}
        .btn-orange:hover{filter:brightness(.95); color:#111;}
        .btn-outline-navy{border-color:var(--navy); color:var(--navy); background:#fff;}
        .btn-outline-navy:hover{background:var(--navy); color:#fff;}
        .error{color:#dc3545; font-size:13px;}
        .error-space{min-height:18px;}
    </style>
</head>
<body>

<div class="page-wrap py-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-lg-7 col-xl-6">

                <div class="app-card shadow-sm">
                    <div class="app-header p-4">
                        <h3 class="app-title">Update Product</h3>
                        <p class="app-sub">Edit product information and save changes</p>
                    </div>

                    <div class="p-4">
                        <form:form action="processUpdateProductForm" modelAttribute="productModel" method="post">

                            <form:hidden path="id"/>
                            <form:hidden path="productDetails.id"/>
                            <form:hidden path="productDetails.name"/>

                            <div class="mb-3">
                                <label class="form-label">Id</label>
                                <form:input type="text" cssClass="form-control" path="id" readonly="true"/>
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Product Name</label>
                                <form:input type="text" cssClass="form-control" path="name" placeholder="Enter product name"/>
                                <div class="error-space">
                                    <form:errors path="name" cssClass="error"/>
                                </div>
                            </div>

                            <div class="row g-3">
                                <div class="col-md-6">
                                    <label class="form-label">Expiration Date</label>
                                    <form:input type="date" cssClass="form-control" path="productDetails.expirationDate" placeholder="dd/mm/yyyy"/>
                                    <div class="error-space">
                                        <form:errors path="productDetails.expirationDate" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <label class="form-label">Manufacturer</label>
                                    <form:input type="text" cssClass="form-control" path="productDetails.manufacturer" placeholder="Manufacturer"/>
                                    <div class="error-space">
                                        <form:errors path="productDetails.manufacturer" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <label class="form-label">Price</label>
                                    <form:input type="text" cssClass="form-control" path="productDetails.price" placeholder="Price"/>
                                    <div class="error-space">
                                        <form:errors path="productDetails.price" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <label class="form-label">Availability</label>
                                    <form:input type="text" cssClass="form-control" path="productDetails.available" placeholder="0 or 1"/>
                                    <div class="error-space">
                                        <form:errors path="productDetails.available" cssClass="error"/>
                                    </div>
                                </div>
                            </div>

                            <div class="d-flex flex-column flex-sm-row gap-2 mt-4">
                                <input type="submit" class="btn btn-orange flex-fill" value="Update"/>
                                <a class="btn btn-outline-navy flex-fill" href="<c:url value='/list'/>">Back</a>
                            </div>

                        </form:form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>