<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/bootstrap" prefix="bt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<bt:page>
    <jsp:body>
    <div class="container">
        <div class="row">
            <div class="col-xs-2">
                <h2>${post.author.name}</h2>
            </div>
            <div class="col-xs-2">
                <h3><fmt:formatDate type="both" value="${post.created}"/></h3>
            </div>
            <div class="col-xs-8">
                <h4>${post.body}</h4>
                <p class="tags">
                    Tagged: <span></span>
                </p>
            </div>
        </div>
    </div>
    </jsp:body>
</bt:page>