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
 <li>Kategori Ekle</li>
</ol>
<div class="row">
<div class="col-md-2">
</div>
<div class="col-md-6">

<form:form htmlEscape="true" commandName="kategoriInsertModel" action="${pageContext.request.contextPath}/admin/kategoriEkle?${_csrf.parameterName}=${_csrf.token}" method="Post" cssClass="form-horizontal" enctype="multipart/form-data">
                              
	<div class="form-group">
    	<label class="col-sm-4 control-label">Kategori Adı</label>
	    <div class="col-sm-8">
		    <input name="KategoriAdi" id="KategoriAdi" type="text" class="form-control" placeholder="Kategori Ad" required>
	    </div>
	</div>
	
	<div class="form-group">
    	<label class="col-sm-4 control-label">Kategori Kodu</label>
	    <div class="col-sm-8">
		    <input name="KategoriKod" id="KategoriKod" type="text" class="form-control" placeholder="Kategori Kod" required>
	    </div>
	</div>
	<div class="form-group">
    	<label class="col-sm-4 control-label">Kategori Açıklama</label>
	    <div class="col-sm-8">
	    <textarea name="Aciklama" class="form-control" placeholder="Kategori Açıklama"></textarea>    
	    </div>
	</div>		
	<div class="form-group">
	<label class="col-sm-4 control-label"></label>
	<div class="col-sm-8">             
	<button type="submit" class="btn btn-success">Kaydet</button>
	</div>
	</div>
</form:form>

</div>
<div class="col-md-2">
</div>

</div>

 <jsp:include page="statik/adminfooter.jsp"/>