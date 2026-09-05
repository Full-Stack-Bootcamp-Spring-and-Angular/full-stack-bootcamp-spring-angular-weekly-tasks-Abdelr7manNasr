<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Details</title>
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
        .page-wrap{min-height:100vh; display:flex; align-items:center;}
        .app-card{border:1px solid var(--border); border-radius:12px; background:var(--card);}
        .app-header{background:var(--navy); color:#fff; border-radius:12px 12px 0 0; border-bottom:1px solid rgba(255,255,255,.08);}
        .app-title{font-weight:800; margin:0;}
        .app-sub{color:rgba(255,255,255,.78); margin:0; font-size:13px;}
        .product-name{font-weight:800; color:#1e2a3f; margin:0;}
        .detail-box{border:1px solid var(--border); border-radius:10px; padding:14px; background:#fff;}
        .detail-title{font-weight:700; color:var(--muted); font-size:13px; margin-bottom:4px;}
        .detail-value{font-weight:600; color:#233049;}
        .btn{border-radius:8px; padding:.6rem 1rem;}
        .btn-orange{background:var(--orange); border-color:var(--orange); color:#111;}
        .btn-orange:hover{filter:brightness(.95); color:#111;}
        .btn-outline-navy{border-color:var(--navy); color:var(--navy); background:#fff;}
        .btn-outline-navy:hover{background:var(--navy); color:#fff;}
        .btn-navy{background:var(--navy); border-color:var(--navy); color:#fff;}
        .btn-navy:hover{background:var(--navy-2); border-color:var(--navy-2); color:#fff;}
    </style>
</head>
<body>

<div class="page-wrap py-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-lg-9 col-xl-8">

                <div class="app-card shadow-sm">
                    <div class="app-header p-4">
                        <h3 class="app-title">Product Details</h3>
                        <p class="app-sub">View product information</p>
                    </div>

                    <div class="p-4">
                        <h4 class="product-name mb-3">${productModel.name}</h4>

                        <div class="row g-3">
                            <div class="col-md-6">
                                <div class="detail-box">
                                    <div class="detail-title">Id</div>
                                    <div class="detail-value">${productModel.id}</div>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="detail-box">
                                    <div class="detail-title">Manufacturer</div>
                                    <div class="detail-value">${productModel.productDetails.manufacturer}</div>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="detail-box">
                                    <div class="detail-title">Expiration Date</div>
                                    <div class="detail-value">${productModel.productDetails.expirationDate}</div>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="detail-box">
                                    <div class="detail-title">Price</div>
                                    <div class="detail-value">${productModel.productDetails.price}</div>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="detail-box">
                                    <div class="detail-title">Availability</div>
                                    <div class="detail-value">${productModel.productDetails.available}</div>
                                </div>
                            </div>
                        </div>

                        <div class="mt-4 d-flex flex-column flex-sm-row gap-2">
                            <a class="btn btn-orange flex-fill"
                               href="<c:url value='/updateProduct'><c:param name='id' value='${productModel.id}'/></c:url>">
                                Update
                            </a>
                            <a class="btn btn-outline-navy flex-fill" href="<c:url value='/list'/>">Back</a>
                        </div>

                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>