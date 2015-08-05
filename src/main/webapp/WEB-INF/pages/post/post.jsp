<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/bootstrap" prefix="bt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<bt:page>
    <jsp:body>
    <form role="form" class="form-horizontal" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="container">
            <div class="row">
                <div class="col-xs-2">
                    <h2>${post.author.username}</h2>
                </div>
                <div class="col-xs-2">
                    <h3><fmt:formatDate type="both" value="${post.created}"/></h3>
                </div>
                <div class="col-xs-6">
                    <div class="form-group">
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <textarea class="form-control" rows="5" name="body">${post.body}</textarea>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <h4>${post.body}</h4>
                    </sec:authorize>
                    </div>
                </div>
                <div class="col-xs-2">
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <div class="col-sm-offset-2">
                            <button type="submit" class="btn btn-default">Edit post</button>
                        </div>
                    </sec:authorize>
                </div>
            </div>
            <input type="hidden" name="_method" value="PUT"/>
        </div>
    </form>
    </jsp:body>
</bt:page>