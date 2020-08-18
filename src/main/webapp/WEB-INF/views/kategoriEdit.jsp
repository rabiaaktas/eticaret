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
 <li><a href="${pageContext.request.contextPath}/admin/kategoriler" style="color:#4a4a4a;">Kategoriler</a></li>
 <li>Kategori Düzenle</li>
</ol>

<div class="row">
<div class="col-md-2"></div>
<div class="col-md-6">
<form class="form-horizontal" method="Post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/admin/kategoriDuzenle/${kategoriBilgileri.getKategoriID() }?${_csrf.parameterName}=${_csrf.token}">
	<div class="form-group">
	<label class="col-sm-4 control-label">Kategori Adı</label>
		<div class="col-sm-8">
			<c:if test="${not empty kategoriBilgileri }">
				<input type="text" class="form-control" id="KategoriAdi" name="KategoriAdi" value="${kategoriBilgileri.getKategoriAdi() }" placeholder="Kategori Adı" required>
			</c:if>
			<c:if test="${ empty kategoriBilgileri }">
				<input type="text" class="form-control" id="KategoriAdi" name="KategoriAdi" placeholder="Kategori Adı" required>
			</c:if>
		</div>
		</div>
	<div class="form-group">
	<label class="col-sm-4 control-label">Kategori Kodu</label>
		<div class="col-sm-8">
			<c:if test="${ not empty kategoriBilgileri }">
				<input type="text" class="form-control" id="KategoriKod" name="KategoriKod" value="${kategoriBilgileri.getKategoriKod() }" placeholder="Kategori Kodu" required>
			</c:if>
			<c:if test="${ empty kategoriBilgileri }">
				<input type="text" class="form-control" id="KategoriKod" name="KategoriKod" placeholder="Kategori Kodu" required>
			</c:if>
		</div>
	</div>

	
	<div class="form-group">
	<label class="col-sm-4 control-label">Kategori Açıklaması</label>
	<div class="col-sm-8">
		<c:if test="${not empty kategoriBilgileri }">
			<textarea class="form-control" name="Aciklama" value="${kategoriBilgileri.getAciklama() }"></textarea>
		</c:if>
		<c:if test="${empty kategoriBilgileri }">
			<textarea class="form-control" name="Aciklama" value=""></textarea>
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