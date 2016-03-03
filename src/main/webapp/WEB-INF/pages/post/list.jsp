<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/bootstrap" prefix="bt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<bt:page>
    <jsp:body>
        <div class="container">
            <c:forEach var="post" items="${posts}">
            <div class="row">
                <div class="col-xs-2">
                    <h2>${post.author.username}</h2>
                </div>
                <div class="col-xs-2">
                    <h3><fmt:formatDate type="both" value="${post.created}"/></h3>
                </div>
                <div class="col-xs-6">
                    <h4>${post.body}</h4>
                </div>
                <div class="col-xs-2">
                    <form role="form" class="form-horizontal" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="hidden" name="_method" value="DELETE"/>
                        <input type="hidden" name="id" value="${post.id}"/>
                        <div class="col-sm-offset-2">
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <button type="submit" class="btn btn-default">Delete</button>
                             </sec:authorize>
                            <a href="/post/${post.id}" class="btn">Show</a>
                        </div>
                    </form>
                </div>
            </div>
            </c:forEach>
            <sec:authorize access="hasRole('ROLE_USER')">
                <div class="row">
                     <form role="form" class="form-horizontal" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="col-xs-4"></div>
                        <div class="col-xs-6">
                            <div class="form-group">
                                 <textarea class="form-control" rows="5" name="body"></textarea>
                            </div>
                            <div class="form-group">
                                <c:if test="${not empty message}">
                                    ${message}
                                </c:if>
                            </div>
                        </div>
                        <div class="col-xs-2">
                            <div class="col-sm-offset-2">
                                <button type="submit" class="btn btn-default">Add post</button>
                            </div>
                        </div>
                    </form>
                </div>
            </sec:authorize>
        </div>
    </jsp:body>
</bt:page>