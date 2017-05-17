<!DOCTYPE html>
<html lang="en-ZH">
<%@page contentType="utf-8" %>
<head>
    <title>登录咯</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <script src="/js/core.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#register").click(function () {
                window.location = "/signin";
            });
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
            <form role="form" method="post" action="/signup">
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label><input type="email" class="form-control"
                                                                                id="exampleInputEmail1"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label><input type="password" class="form-control"
                                                                              id="exampleInputPassword1"/>
                </div>
                <div class="checkbox">
                    <label><input type="checkbox"/>Check me out</label>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
                <button type="button" id="register" class="btn btn-default">注册咯</button>
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