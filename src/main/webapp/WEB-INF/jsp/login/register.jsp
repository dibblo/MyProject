<%--
  Created by IntelliJ IDEA.
  User: latiflan
  Date: 2017/3/31
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册咯</title>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/js/core.js"></script>
</head>
<body>
<form>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <form role="form" action="/registermd5">
                    <div class="form-group">
                        <label for="userName">Account</label><input type="input" class="form-control"
                                                                    id="userName" name="userName"/>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label><input type="password" class="form-control"
                                                                     id="password" name="password"/>
                    </div>
                    <div class="form-group">
                        <label for="repassword">Repassword</label><input type="password" class="form-control"
                                                                         id="repassword"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputFile">File input</label><input type="file" id="exampleInputFile"/>
                        <p class="help-block">
                            Example block-level help text here.
                        </p>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox"/>Check me out</label>
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </div>
</form>
</body>
</html>
