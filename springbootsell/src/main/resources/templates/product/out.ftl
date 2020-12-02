<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/seller/product/change">
                        <div class="form-group">
                            <label for="exampleInputEmail1">商品名称</label>
                            <input name="productName" type="text" class="form-control"
                                   value="${(productInfo.productName)!''}" readonly="value">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">库存</label>
                            <input name="productStock" type="text" class="form-control"
                                   value="${(productInfo.productStock)!''}" readonly="value">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">商品状态（0代表上架，1代表下架）</label>
                            <input name="productStatus" type="number" class="form-control"
                                   value="${(productInfo.productStatus)!''}" min="0" max="1">
                        </div>
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">
                        <button type="submit" class="btn btn-default">确定</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>