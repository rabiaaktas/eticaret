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
 <li>Ürün Bilgi Girişi</li>
</ol>
<div class="row">
<div class="col-md-2">
</div>
<div class="col-md-6">

<form:form htmlEscape="true" commandName="urunInsertModel" action="${pageContext.request.contextPath}/admin/urunEkle?${_csrf.parameterName}=${_csrf.token}" method="Post" cssClass="form-horizontal" enctype="multipart/form-data">
	<div class="form-group">
    	<label  class="col-sm-4 control-label">Kategori</label>
	    <div class="col-sm-8">
		  <select name="KategoriID" id="KategoriId" class="form-control">
		  	<option value="0">Seçiniz</option>
		  	<c:forEach var="i" items="${kategoriList}">
		  	<option value="${i.getKategoriID()}">${i.getKategoriAdi()}</option>
		  	</c:forEach>
			</select>
	    </div>
	</div>

	<div class="form-group">
    	<label class="col-sm-4 control-label">Ürün Adı</label>
	    <div class="col-sm-8">
		    <input name="UrunAdi" id="UrunAdi" type="text" class="form-control" placeholder="Ürün Ad" required>
	    </div>
	</div>
	
	<div class="form-group">
    	<label class="col-sm-4 control-label">Ürün Kodu</label>
	    <div class="col-sm-8">
		    <input name="UrunKod" id="UrunKod" type="text" class="form-control" placeholder="Ürün Kod" required>
	    </div>
	</div>
	
	<div class="form-group">
    	<label class="col-sm-4 control-label">Ürün Alış Fiyati</label>
	    <div class="col-sm-8">
		    <input name="UrunAlisFiyat" id="UrunAlisFiyat" type="text" class="form-control" placeholder="Ürün Alış Fiyat" required>
	    </div>
	</div>

	<div class="form-group">
    	<label class="col-sm-4 control-label">Ürün Açıklama</label>
	    <div class="col-sm-8">
	    <textarea name="Aciklama" class="form-control" placeholder="Ürün Açıklama" required></textarea>    
	    </div>
	</div>
	<div class="form-group">
    	<label class="col-sm-4 control-label">ISBN</label>
	    <div class="col-sm-8">
		    <input name="ISBN" id="ISBN" type="text" class="form-control" placeholder="ISBN" required>
	    </div>
	</div>
	<div class="form-group">
    	<label class="col-sm-4 control-label">Yazarı</label>
	    <div class="col-sm-8">
		    <input name="yazarAdi" id="yazarAdi" type="text" class="form-control" placeholder="Yazar Adı" required>
	    </div>
	</div>
	<div class="form-group">
    	<label class="col-sm-4 control-label">Sayfa Sayısı</label>
	    <div class="col-sm-8">
		    <input name="sayfaSayisi" id="yazarAdi" type="text" class="form-control" placeholder="Sayfa Sayısı" required>
	    </div>
	</div>
	<div class="form-group">
    	<label class="col-sm-4 control-label">Basım Yılı</label>
	    <div class="col-sm-8">
		    <input name="basımYili" id="yazarAdi" type="text" class="form-control" placeholder="Basım Yılı" required>
	    </div>
	</div>
		<div class="form-group">
    	<label class="col-sm-4 control-label">Adet</label>
	    <div class="col-sm-8">
		    <input name="Adet" id="Adet" type="text" class="form-control" placeholder="Adet" required>
	    </div>
	</div>
		<div class="form-group">
	<label class="col-sm-4 control-label">Ürün Thumbnail(164 px x 222 px)</label>
	    <div class="col-sm-8">
			  <input type="file" name="urunresimthumb" id="urunresimthumb" class="filestyle" data-size="sm">                    
	       </div>
	</div>
	
	<div class="form-group">
	<label class="col-sm-4 control-label">Ürün Resim(237 px × 319 px)</label>
	    <div class="col-sm-8">
			  <input type="file" name="urunresim" id="urunresim" class="filestyle" data-size="sm">                    
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