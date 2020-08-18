<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <%@ page session="false" %> --%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<jsp:include page="statik/adminheader-ust.jsp"/>
<jsp:include page="statik/adminheader-alt.jsp"/>

<ol class="breadcrumb">
 <li><a href="${pageContext.request.contextPath}/admin"style="color:#4a4a4a;"><strong>Anasayfa</strong></a></li>
 <li>Kategoriler</li>
</ol>

<form method="post" action="${pageContext.request.contextPath}/admin/searchKategori">
<div class="row" style="margin-bottom: 20px;">
  <div class="col-sm-2">		
  <label for="aramagenel">Arama</label>
  </div>
  <div class="col-sm-8">
		  <input type="text" name="searchVal" class="form-control" placeholder="Arama" />
		</div>
	<div class="col-sm-2">
	<button type="submit" class="btn btn-success">Ara</button>
	</div>
</div>
 <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>    
</form>
<div class="row">
<div class="col-md-12">
<div class="table-responsive">
<table class="table table-hover" id="kategoriList">
<thead>
	<tr>
		<th>Kategori Id</th>
		<th>Kategori Ad</th>
		<th>Kategori Kod</th>
		<th>Açıklama</th>
		<th colspan="2">İşlem</th>
	</tr>
</thead>
<c:forEach var="i" items="${kategoriList}">
<tr>
<td>${i.getKategoriID()}</td>
<td>${i.getKategoriAdi()}</td>
<td>${i.getKategoriKod()}</td>
<td>${i.getAciklama()}</td>
<td><a class="btn btn-info" href="${pageContext.request.contextPath}/admin/kategoriDuzenle/${i.getKategoriID()}"><i class="glyphicon glyphicon-pencil"></i> Düzenle</a></td>
<td><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteKatModal_${i.getKategoriID() }">
 <i class="glyphicon glyphicon-trash"></i> Sil
</button></td>
</tr>
<div class="modal fade" id="deleteKatModal_${i.getKategoriID() }" tabindex="-1" role="dialog" aria-labelledby="#deleteKatModal_${i.getKategoriID() }" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="exampleModalLabel"><strong>${i.getKategoriAdi()} Silinecek</strong></h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Silmek istediğinize emin misiniz?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/kategoriDelete?KategoriID=${i.getKategoriID()}"><i class="glyphicon glyphicon-trash"></i> Sil</a>
      </div>
    </div>
  </div>
</div>
</c:forEach>
</table>


</div>
</div>
<!-- </div> -->


 <jsp:include page="statik/adminfooter.jsp"/>
 