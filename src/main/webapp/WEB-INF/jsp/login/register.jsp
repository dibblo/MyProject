<!DOCTYPE html>
<html lang="en-ZH">
    <%@page contentType="utf-8" %>
    <head>
        <title>注册咯</title>
        <meta http-equiv="X-UA-Compatible" content="IE=Edge" charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <script src="/js/core.js"></script>
    <script>
        $(function () {
            $("#signup").click(function () {
                window.location = "/tologin";
            });
        });
    </script>
</head>
<body>
<form>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-4 column">
            </div>
            <div class="col-md-4 column">
                <form role="form" method="post" action="/registermd5">
                    <div class="form-group">
                        <label for="userName">Account</label><input type="input" class="form-control"
                                                                    id="userName" name="userName"/>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label><input type="password" class="form-control"
                                                                     id="password" name="password"/>
                    </div>
<%--                    <div class="form-group">
                        <label for="repassword">Repassword</label><input type="password" class="form-control"
                                                                         id="repassword" name="repassword"/>
                    </div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="exampleInputFile">File input</label><input type="file" id="exampleInputFile"/>--%>
                        <%--<p class="help-block">--%>
                            <%--Example block-level help text here.--%>
                        <%--</p>--%>
                    <%--</div>--%>
                    <%--<div class="checkbox">--%>
                        <%--<label><input type="checkbox"/>Check me out</label> --%>
                    <%--</div>--%>
                    <button type="submit" class="btn btn-default">Submit</button>
                    <button type="button" id="signup" class="btn btn-default">登录</button>
                </form>
            </div>
            <div class="col-md-4 column">
            </div>
        </div>
    </div>
</form>
</body>
</html>
