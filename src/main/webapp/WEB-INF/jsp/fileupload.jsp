<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en-ZH">
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<head>
    <title>登录咯</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/js/core.js"></script>
    <script type="text/javascript">
        $(function () {

        });
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">
            <form role="form" method="post" enctype="multipart/form-data" action="/upload">
                <div class="form-group">
                    <label for="file">选择文件</label>
                    <input type="file" name="file" id="file" />
                </div>
                <button type="submit" class="btn btn-default">上传</button>
            </form>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
        </div>
    </div>
</div>
</body>
</html>