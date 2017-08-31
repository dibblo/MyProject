<!DOCTYPE html>
<html lang="en-ZH">
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<head>
    <title>登录咯</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script src="/js/core.js"></script>
    <script type="text/javascript">
        $(function () {
            var success = '${success}';
            if ('false' == success) {
                alert('${msg}');
            }
            $('#myTab a').click(function (e) {
                e.preventDefault()
                $(this).tab('show')
            })
        });
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">
            <div class="tabbable" id="tabs-939555">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="#panel-10672" data-toggle="tab">登录</a>
                    </li>
                    <li>
                        <a href="#panel-699544" data-toggle="tab">注册</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="panel-10672">
                        <p>
                        <form id="signin" role="signin" method="post" action="/signin">
                            <div class="form-group">
                                <label for="userName">Account</label>
                                <input type="text" class="form-control"
                                       id="userName" name="userName"/>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control"
                                       id="password" name="password"/>
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox"/>记住登录
                                </label>
                            </div>
                            <button type="submit" class="btn btn-default">登录首页</button>
                        </form>
                        </p>
                    </div>
                    <div class="tab-pane" id="panel-699544">
                        <p>
                        <form id="signup" role="signup" method="post" action="/signup">
                            <div class="form-group">
                                <label for="userName2">Account</label><input type="input" class="form-control"
                                                                             id="userName2" name="userName"/>
                            </div>
                            <div class="form-group">
                                <label for="password2">Password</label><input type="password" class="form-control"
                                                                              id="password2" name="password"/>
                            </div>
                            <div class="form-group">
                                <label for="repassword">Repassword</label><input type="password"
                                                                                 class="form-control"
                                                                                 id="repassword" name="repassword"/>
                            </div>
                            <button type="submit" class="btn btn-default">注册用户</button>
                        </form>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
</div>
</body>
</html>