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
  <li>  Kullanıcı Detayları</li>
</ol>


	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-6">
		<div class="form-group">
			<label class="control-label col-sm-4">Kullanıcı Id</label>
				<div class="col-sm-8">
					<p>${user.getKullaniciId()}</p>
				</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4">Adı</label>
				<div class="col-sm-8">
					<p>${user.getIsim()}</p>
				</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4">Soyadı</label>
				<div class="col-sm-8">
					<p>${user.getSoyisim()}</p>
				</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-4">Kullanıcı Adı</label>
				<div class="col-sm-8">
					<p>${user.getKullaniciAdi()}</p>
				</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4">Kullanıcı Rolü</label>
				<div class="col-sm-8">
					<p>${user.getRolAdi()}</p>
				</div>
		</div>
				<div class="form-group">
			<label class="control-label col-sm-4">Kullanıcı Rol ID</label>
				<div class="col-sm-8">
					<p>${user.getKullaniciRolId()}</p>
				</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4">Telefon</label>
				<div class="col-sm-8">
					<c:if test="${user.getMusteritelefon() == null}">
						<p id="phoneNull_${user.getKullaniciId()}">00000000000</p>
					</c:if>
					<c:if test="${user.getMusteritelefon()!= null}">
						<p id="phone_${user.getKullaniciId()}">${user.getMusteritelefon()}</p>
					</c:if>	
				</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4">E-mail</label>
				<div class="col-sm-8">
					<p>${user.getEmail()}</p>
				</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4">Adres</label>
				<div class="col-sm-8">
					<p>${user.getMusteriAdres()}</p>
				</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4"></label>
				<div class="col-sm-8">
					<a class="btn btn-success" href="${pageContext.request.contextPath}/admin/kullanicilar?pageId=1">Geri Dön</a>
				</div>
		</div>
		</div>
	</div>
	

 <jsp:include page="statik/adminfooter.jsp"/>