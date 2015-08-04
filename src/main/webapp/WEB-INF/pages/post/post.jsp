<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/bootstrap" prefix="bt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<bt:page>
    <jsp:body>
    <form role="form" class="form-horizontal" method="post">
        <div class="container">
            <div class="row">
                <div class="col-xs-2">
                    <h2>${post.author.name}</h2>
                </div>
                <div class="col-xs-2">
                    <h3><fmt:formatDate type="both" value="${post.created}"/></h3>
                </div>
                <div class="col-xs-6">
                    <div class="form-group">
                        <textarea class="form-control" rows="5" name="body">${post.body}</textarea>
                    </div>
                </div>
                <div class="col-xs-2">
                    <div class="col-sm-offset-2">
                        <button type="submit" class="btn btn-default">Edit post</button>
                    </div>
                </div>
            </div>
            <input type="hidden" name="_method" value="PUT"/>
        </div>
    </form>
    </jsp:body>
</bt:page>