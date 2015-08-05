<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@attribute name="title" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
    <header>
        <title>
            <jsp:invoke fragment="title"/>
        </title>
        <link rel="shortcut icon" href="images/favicon.ico"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"/>
        <jsp:invoke fragment="header"/>
    </header>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                <a class="navbar-brand" href="#">Blog</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <!--<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                    <li><a href="#">Link</a></li>-->
                </ul>
                <sec:authorize access="isAnonymous()">
                    <form id="signin" class="navbar-form navbar-right" role="form" action="/loginProcess" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input id="username" type="text" class="form-control" name="username" value="" placeholder="Username"/>
                        </div>
                        <div class="input-group">
                             <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                             <input id="password" type="password" class="form-control" name="password" value="" placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-primary">Login</button>
                </form>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <form id="signin" class="navbar-form navbar-right" role="form" action="/logout" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <span class="btn">Hello, <sec:authentication property="principal.username" /></span>&nbsp;<button type="submit" class="btn btn-primary">LogOut</button>
                    </form>
                </sec:authorize>
            </div>
          </div>
        </nav>
        <jsp:doBody/>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <jsp:invoke fragment="footer"/>
  </body>
</html>