<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <%@ page session="false" %> --%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="statik/adminheader-ust.jsp"/>
<jsp:include page="statik/adminheader-alt.jsp"/>

<ol class="breadcrumb">
 <li><a href="${pageContext.request.contextPath}/admin"style="color:#4a4a4a;"><strong>Anasayfa</strong></a></li>
 <li>Kullanıcılar</li>
</ol>
<form method="post" action="${pageContext.request.contextPath}/admin/searchUser?pageId=1">
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
<table class="table table-hover" id="duyurulistesi">
<thead>
	<tr>
		<th>Kullanıcı Id</th>
		<th>Kullanıcı Adı</th>
		<th>İsim</th>
		<th>Soyisim</th>
		<th>Email</th>
		<th>Adres</th>
		<th>Telefon</th>
		<th colspan="3">İşlem</th>
	</tr>
</thead>
<c:forEach var="i" items="${userList}">
<tr>
<td>${i.getMusteriID()}</td>
<td>${i.getKullaniciAdi()}</td>
<td>${i.getIsim()}</td>
<td>${i.getSoyisim()}</td>
<td>${i.getEmail()}</td>
<td>${i.getMusteriAdres()}</td>
<td>${i.getMusteritelefon()}</td>
<td><a class="btn btn-warning" href="${pageContext.request.contextPath}/admin/userDetails?kullaniciID=${i.getKullaniciId()}">
<i class="glyphicon glyphicon-info-sign"></i> Detaylı Bilgi</a></td>
<%-- <c:set var="aktif" value="${i.getAktif()}"/> --%>
<c:if test="${i.getAktif() == 1}"><td>
<button class="btn btn-info" data-toggle="modal" data-target="#deactivate_${i.getMusteriID()}" id="abc_${i.getKullaniciId() }">
<i class="glyphicon glyphicon-eye-close"></i> Etkisizleştir</button></td>
</c:if>
<c:if test="${i.getAktif() == 0}"><td>
<button class="btn btn-info" data-toggle="modal" data-target="#activate_${i.getMusteriID()}" id="abc_${i.getKullaniciId() }">
<i class="glyphicon glyphicon-eye-open"></i> Etkinleştir</button></td>
</c:if>

<c:if test="${i.getKullaniciRolId()== 2 }"><td>
<button class="btn btn-info" data-toggle="modal" data-target="#user_${i.getMusteriID()}" id="abc_${i.getKullaniciId() }">
<i class="glyphicon glyphicon-export"></i> Normal Kullanıcı Yap</button></td>
</c:if>
<c:if test="${i.getKullaniciRolId()== 1 }"><td>
<button class="btn btn-info" data-toggle="modal" data-target="#admin_${i.getMusteriID()}" id="abc_${i.getKullaniciId() }">
<i class="glyphicon glyphicon-import"></i> Yetkili Kullanıcı Yap</button></td>
</c:if>
</tr>
<%--Active - Deactive Modals --%>
<div class="modal fade" id="deactivate_${i.getMusteriID()}" tabindex="-1" role="dialog" aria-labelledby="#deactivate" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
<%--         <h4 class="modal-title" id="exampleModalLabel"><strong>${i.getKategoriAdi()} Silinecek</strong></h4> --%>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <p> ${i.getKullaniciAdi()} etkisizleştiriyor</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Kapat</button>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/deactivateUser?kullaniciID=${i.getKullaniciId()}">
        <i class="glyphicon glyphicon-ok"></i> Onayla</a>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="activate_${i.getMusteriID()}" tabindex="-1" role="dialog" aria-labelledby="activate_${i.getMusteriID()}" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
<%--         <h4 class="modal-title" id="exampleModalLabel"><strong>${i.getKategoriAdi()} Silinecek</strong></h4> --%>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <p> ${i.getKullaniciAdi()} etkinleştiriliyor</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Kapat</button>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/activateUser?kullaniciID=${i.getKullaniciId()}">
        <i class="glyphicon glyphicon-ok"></i> Onayla</a>
      </div>
    </div>
  </div>
</div>

<%--Admin - User Modals --%>

<div class="modal fade" id="user_${i.getMusteriID()}" tabindex="-1" role="dialog" aria-labelledby="us_${i.getMusteriID()}" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
<%--         <h4 class="modal-title" id="exampleModalLabel"><strong>${i.getKategoriAdi()} Silinecek</strong></h4> --%>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <p> ${i.getKullaniciAdi()} Normal Kullanıcı Yapılıyor.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Kapat</button>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/makeUser?kullaniciID=${i.getKullaniciId()}">
        <i class="glyphicon glyphicon-ok"></i> Onayla</a>
      </div>
    </div>
  </div>
</div>


<div class="modal fade" id="admin_${i.getMusteriID()}" tabindex="-1" role="dialog" aria-labelledby="ad_${i.getMusteriID()}" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
<%--         <h4 class="modal-title" id="exampleModalLabel"><strong>${i.getKategoriAdi()} Silinecek</strong></h4> --%>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <p> ${i.getKullaniciAdi()} Yetkili Kullanıcı Yapılıyor.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Kapat</button>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/makeAdmin?kullaniciID=${i.getKullaniciId()}">
        <i class="glyphicon glyphicon-ok"></i> Onayla</a>
      </div>
    </div>
  </div>
</div>
</c:forEach>
</table>

<nav aria-label="Navigation for userList" style="text-align:center;">
    <ul class="pagination">
        <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link" 
                href="${pageContext.request.contextPath}/admin/searchUser?searchVal=${searchVal}&pageId=${currentPage-1}">
                 	<span aria-hidden="true">&laquo;</span>
       				<span class="sr-only">Previous</span>
                </a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <li class="page-item active"><a class="page-link">
                            ${i} <span class="sr-only">(current)</span></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" 
                        href="${pageContext.request.contextPath}/admin/searchUser?searchVal=${searchVal}&pageId=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link" 
                href="${pageContext.request.contextPath}/admin/searchUser?searchVal=${searchVal}&pageId=${currentPage+1}">       
                 <span aria-hidden="true">&raquo;</span>
        		<span class="sr-only">Next</span></a>
            </li>
        </c:if>              
    </ul>
</nav>
</div>
</div>
</div>


 <jsp:include page="statik/adminfooter.jsp"/>
 