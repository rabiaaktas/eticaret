<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ page session="false" %> --%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<jsp:include page="statik/adminheader-ust.jsp"/>
<jsp:include page="statik/adminheader-alt.jsp"/>

<ol class="breadcrumb">
 <li><a href="${pageContext.request.contextPath}/admin"style="color:#4a4a4a;"><strong>Anasayfa</strong></a></li>
 <li>Ürün Listesi</li>
 <li>Stok Durumu Güncelle</li>
</ol>

<div class="row">
<div class="col-md-2">
</div>
<div class="col-md-6">
<%-- <p>${adet.getStokID() }</p> --%>
<form class="form-horizontal" name="stokModel" method="Post" action="${pageContext.request.contextPath}/admin/stokUpdate" enctype="multipart/form-data">
<input type="hidden" class="form-control" value="${adet.getStokID() }" id="StokID" name="StokID">
<div class="form-group">
    	<label class="col-sm-4 control-label">Adet</label>
	    <div class="col-sm-8">
	    <c:if test="${not empty adet}">
		    <input name="Adet" id="Adet" type="text" class="form-control" placeholder="Adet" value="${adet.getAdet()}" required>
		    </c:if>
		    <c:if test="${empty adet}">
		    <input name="Adet" id="Adet" type="text" class="form-control" placeholder="Adet" value="" required>
		    </c:if>
	    </div>
	</div>
	<div class="form-group">
	<label class="col-sm-4 control-label"></label>
	<div class="col-sm-8">             
	<button type="submit" class="btn btn-success">Kaydet</button>
	</div>
	</div>
</form>
</div>
</div>
<jsp:include page="statik/adminfooter.jsp"/>