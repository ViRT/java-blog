<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/bootstrap" prefix="bt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<bt:page>
    <jsp:body>
    <form:form role="form" class="form-horizontal" method="post" modelAttribute="post">
        <div class="container">
            <div class="row">
                <div class="col-xs-2">
                    <h2>${post.author.username}</h2>
                </div>
                <div class="col-xs-2">
                    <h3><fmt:formatDate type="both" value="${post.created}"/></h3>
                </div>
                <div class="col-xs-6">
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <div class="form-group">
                            <form:textarea path="body" class="form-control" rows="5"/>
                        </div>
                        <div class="form-group">
                            <form:errors path="body" cssClass="error"/>
                        </div>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <div class="form-group">
                            <h4>${post.body}</h4>
                        </div>
                    </sec:authorize>
                </div>
                <div class="col-xs-2">
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <div class="col-sm-offset-2">
                            <button type="submit" class="btn btn-default">Edit post</button>
                        </div>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </form:form>
    </jsp:body>
</bt:page>