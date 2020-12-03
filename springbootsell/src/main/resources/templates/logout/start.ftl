<html>
<#include "../common/dl.ftl">
<body>
<div id="wrapper" class="toggled">
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <h1 align="center">卖家后端管理登录界面</h1>
                    <form role="form" method="post" action="/seller/logout/save">
                        <div class="form-group">
                            <label for="exampleInputEmail1">用户名</label>
                            <input name="categoryName" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">密码</label>
                            <input name="categoryType" type="text" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-default">登录</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
