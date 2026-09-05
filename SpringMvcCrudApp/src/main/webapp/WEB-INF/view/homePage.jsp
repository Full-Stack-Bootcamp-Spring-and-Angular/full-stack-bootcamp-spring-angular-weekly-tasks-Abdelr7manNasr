<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products Data</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>">

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
        .app-card{border:1px solid var(--border); border-radius:12px; background:var(--card);}
        .app-header{background:var(--navy); color:#fff; border-radius:12px 12px 0 0; border-bottom:1px solid rgba(255,255,255,.08);}
        .app-title{font-weight:800; margin:0;}
        .app-sub{color:rgba(255,255,255,.78); margin:0; font-size:13px;}
        .btn{border-radius:8px; padding:.55rem .9rem;}
        .btn-navy{background:var(--navy); border-color:var(--navy); color:#fff;}
        .btn-navy:hover{background:var(--navy-2); border-color:var(--navy-2); color:#fff;}
        .btn-orange{background:var(--orange); border-color:var(--orange); color:#111;}
        .btn-orange:hover{filter:brightness(.95); color:#111;}
        .btn-outline-navy{border-color:var(--navy); color:var(--navy); background:#fff;}
        .btn-outline-navy:hover{background:var(--navy); color:#fff;}
        .table{border-color:var(--border);}
        .table thead th{background:var(--navy); color:#fff; border-color:rgba(255,255,255,.15);}
        .table tbody tr:hover{background:#f7f9fc;}
        .badge-pill{background:rgba(244,123,32,.12); color:var(--orange); border:1px solid rgba(244,123,32,.28);}
        .name-cell{font-weight:600; color:#233049;}
    </style>
</head>
<body>

<div class="py-5">
    <div class="container">

        <div class="app-card shadow-sm">
            <div class="app-header p-4 d-flex align-items-center justify-content-between flex-wrap gap-2">
                <div>
                    <h3 class="app-title">Products Data</h3>
                    <p class="app-sub">Manage your products and details</p>
                </div>
                <a class="btn btn-orange" href="<c:url value='/addProduct'/>">Add New Product</a>
            </div>

            <div class="p-4">
                <div class="table-responsive">
                    <table class="table table-bordered align-middle text-center mb-0">
                        <thead>
                        <tr>
                            <th style="width: 70px;">#</th>
                            <th>Name</th>
                            <th style="width: 160px;">Show Details</th>
                            <th style="width: 180px;">Add/Update</th>
                            <th style="width: 120px;">Delete</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="p" items="${productsList}" varStatus="s">
                            <tr>
                                <td>${s.count}</td>
                                <td class="name-cell">${p.name}</td>

                                <td>
                                    <a class="btn btn-navy btn-sm"
                                       href="<c:url value='/showProductDetails'><c:param name='id' value='${p.id}'/></c:url>">
                                        View Details
                                    </a>
                                </td>

                                <td>
                                    <a class="btn btn-outline-navy btn-sm"
                                       href="<c:url value='/updateProduct'><c:param name='id' value='${p.id}'/></c:url>">
                                        Add/Update Details
                                    </a>
                                </td>

                                <td>
                                    <a class="btn btn-danger btn-sm"
                                       href="<c:url value='/deleteProduct'><c:param name='id' value='${p.id}'/></c:url>"
                                       onclick="return confirm('Are you sure you want to delete this product?');">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>

    </div>
</div>

</body>
</html>