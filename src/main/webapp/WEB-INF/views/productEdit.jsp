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
 <li><a href="${pageContext.request.contextPath}/admin/urunler" style="color:#4a4a4a;">Ürün Listesi</a></li>
 <li>Ürün Detay Düzenle</li>
</ol>

<div class="row">
<div class="col-md-2">
</div>
<div class="col-md-6">

<form class="form-horizontal" method="Post" action="${pageContext.request.contextPath}/admin/urunDuzenle/${urunBilgileri.getUrunID()}?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
<%-- <input type="hidden" class="form-control" id="UrunID" value="${urunBilgileri.getUrunID()}" name="UrunID">  --%>
	<div class="form-group">
    	<label  class="col-sm-4 control-label">Kategori</label>
	    <div class="col-sm-8">
		  <select name="KategoriID" id="KategoriId" class="form-control">
		  	<option value="0">Seçiniz</option>
		  	<c:forEach var="i" items="${kategoriList}">
		  	<option value="${i.getKategoriID()}">${i.getKategoriAdi()}</option>
		  	</c:forEach>
			</select>
			<c:if test="${not empty urunBilgileri}">
			<script type="text/javascript">
				    var text1 = '${urunBilgileri.getKategoriID()}';
				    $("#KategoriId").val(text1);
			    </script>
			</c:if>
	    </div>
	</div>

	<div class="form-group">
    	<label class="col-sm-4 control-label">Ürün Adı</label>
	    <div class="col-sm-8">
	    <c:if test="${not empty urunBilgileri}">
		    <input name="UrunAdi" id="UrunAdi" type="text" class="form-control" placeholder="Ürün Ad" value="${urunBilgileri.getUrunAdi()}" required>
		    </c:if>
		    <c:if test="${empty urunBilgileri}">
		    <input name="UrunAdi" id="UrunAdi" type="text" class="form-control" placeholder="Ürün Ad" value="" required>
		    </c:if>
	    </div>
	</div>
	
	<div class="form-group">
    	<label class="col-sm-4 control-label">Ürün Kodu</label>
	    <div class="col-sm-8">
	    <c:if test="${not empty urunBilgileri}">
		    <input name="UrunKod" id="UrunKod" type="text" class="form-control" placeholder="Ürün Kod" value="${urunBilgileri.getUrunKod()}" required>
		    </c:if>
	    <c:if test="${empty urunBilgileri}">
		    <input name="UrunKod" id="UrunKod" type="text" class="form-control" placeholder="Ürün Kod" required>
		    </c:if>
	    </div>
	</div>
	
	<div class="form-group">
    	<label class="col-sm-4 control-label">ISBN</label>
	    <div class="col-sm-8">
	    <c:if test="${not empty urunBilgileri}">
		    <input name="ISBN" id="ISBN" type="text" class="form-control" placeholder="ISBN" value="${urunBilgileri.getISBN()}" required>
		    </c:if>
	    <c:if test="${empty urunBilgileri}">
		    <input name="ISBN" id="ISBN" type="text" class="form-control" placeholder="ISBN" required>
		    </c:if>
	    </div>
	</div>
	
	<div class="form-group">
    	<label class="col-sm-4 control-label">Yazarı</label>
	    <div class="col-sm-8">
	    <c:if test="${not empty urunBilgileri}">
		    <input name="yazarAdi" id="yazarAdi" type="text" class="form-control" placeholder="Yazar Adı" value="${urunBilgileri.getYazarAdi()}" required>
		    </c:if>
	    <c:if test="${empty urunBilgileri}">
		    <input name="yazarAdi" id="yazarAdi" type="text" class="form-control" placeholder="Yazar Adı" required>
		    </c:if>
	    </div>
	</div>
	<div class="form-group">
    	<label class="col-sm-4 control-label">Sayfa Sayısı</label>
	    <div class="col-sm-8">
	    <c:if test="${not empty urunBilgileri}">
		    <input name="sayfaSayisi" id="sayfaSayisi" type="text" class="form-control" placeholder="Sayfa Sayısı" value="${urunBilgileri.getSayfaSayisi()}" required>
		    </c:if>
	    <c:if test="${empty urunBilgileri}">
		    <input name="sayfaSayisi" id="sayfaSayisi" type="text" class="form-control" placeholder="Sayfa Sayısı" required>
		    </c:if>
	    </div>
	</div>
	<div class="form-group">
    	<label class="col-sm-4 control-label">Basım Yılı</label>
	    <div class="col-sm-8">
	    <c:if test="${not empty urunBilgileri}">
		    <input name="basımYili" id="basımYili" type="text" class="form-control" placeholder="Basım Yılı" value="${urunBilgileri.getBasımYili()}" required>
		    </c:if>
	    <c:if test="${empty urunBilgileri}">
		    <input name="basımYili" id="basımYili" type="text" class="form-control" placeholder="Basım Yılı" required>
		    </c:if>
	    </div>
	</div>
	
	<div class="form-group">
    	<label class="col-sm-4 control-label">Ürün Alış Fiyati</label>
	    <div class="col-sm-8">
	    <c:if test="${not empty urunBilgileri}">
		    <input name="UrunAlisFiyat" id="UrunAlisFiyat" type="text" class="form-control" placeholder="Ürün Alış Fiyat" value="${urunBilgileri.getUrunAlisFiyat()}" required>
		    </c:if>
		    <c:if test="${empty urunBilgileri}">
		    <input name="UrunAlisFiyat" id="UrunAlisFiyat" type="text" class="form-control" placeholder="Ürün Alış Fiyat" required>
		    </c:if>
	    </div>
	</div>

	<div class="form-group">
    	<label class="col-sm-4 control-label">Ürün Açıklama</label>
	    <div class="col-sm-8">
	    <c:if test="${not empty urunBilgileri}">
	    <textarea name="Aciklama" class="form-control" placeholder="Ürün Açıklama" required>${urunBilgileri.getAciklama()}</textarea>
	    </c:if>
	     <c:if test="${empty urunBilgileri}">
	    <textarea name="Aciklama" class="form-control" placeholder="Ürün Açıklama" required></textarea>
	    </c:if>    
	    </div>
	</div>
		<div class="form-group">
	<label class="col-sm-4 control-label">Ürün Thumbnail(164 px x 222 px)</label>
	    <div class="col-sm-8">
			  <input type="file" name="urunresimthumb" id="urunresimthumb" class="filestyle" data-size="sm">  
			  <c:if test="${not empty urunBilgileri}">
			  <input type="hidden" class="form-control" data-size="sm" id="dosyaThumbId" name="dosyaThumbId" value="${urunBilgileri.getDosyaThumbId()}">
			  <a href='#' onclick="resmigosterthumb(${urunBilgileri.getDosyaThumbId()});" style="color: red;">Ekli Resmi Göster</a>
			  </c:if>                  
	       </div>
	</div>	
	<div class="form-group">
	<label class="col-sm-4 control-label">Ürün Resim(237 px × 319 px)</label>
	    <div class="col-sm-8">
			  <input type="file" name="urunresim" id="urunresim" class="filestyle" data-size="sm">  
			  <c:if test="${not empty urunBilgileri}">
			  <input type="hidden" class="form-control" data-size="sm" id="DosyaId" name="DosyaId" value="${urunBilgileri.getDosyaId()}">
			  <a href='#' onclick="resmigoster(${urunBilgileri.getDosyaId()});" style="color: red;">Ekli Resmi Göster</a>
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

 <script type="text/javascript">
				function resmigoster(ResimDosyaId){
					 jQuery.ajax({type: "get",
			                url: "${pageContext.request.contextPath}/getUrunResim",
			                data: {  ResimDosyaId: ResimDosyaId},
			                success: function (result) {
			                    $('#resimviewer').attr('src', result);
			                    $("#ResimKontrolModal").modal({
			                    	  fadeDuration: 100
			                    });              
			               },
					});
				}
				function resmigosterthumb(ResimDosyaId){
					 jQuery.ajax({type: "get",
			                url: "${pageContext.request.contextPath}/getUrunResimThumb",
			                data: {  ResimDosyaId: ResimDosyaId},
			                success: function (result) {
			                    $('#resimviewer').attr('src', result);
			                    $("#ResimKontrolModal").modal({
			                    	  fadeDuration: 100
			                    });              
			               },
					});
				}
          </script>
<div class="modal fade bs-example-modal-lg" id="ResimKontrolModal" role="dialog" style="height: 100%">
    <div class="modal-dialog modal-lg" style="height: 100%">
    
      <!-- Modal content-->
      <div class="modal-content" style="height: 100%">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-plus"></span> Resim Kontrol</h4>
        </div>
        <div class="modal-body">
				            <img id="resimviewer" src="" class="img-responsive" style="max-width: 50%!important;text-align:center;">
				        </div>
      </div>
      
    </div>
  </div> 
<div class="col-md-2">
</div>

</div>




 <jsp:include page="statik/adminfooter.jsp"/>
