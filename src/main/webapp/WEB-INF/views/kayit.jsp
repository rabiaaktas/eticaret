<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<jsp:include page="statik/header-ust.jsp"/>
<jsp:include page="statik/header-alt.jsp"/>


<ol class="breadcrumb">
 <li><strong><a href="${pageContext.request.contextPath}/" style="color:#4a4a4a;">Anasayfa</a></strong></li>
 <li>Kayıt</li>
</ol>

<div class="register container">
<div class="row">
<div class="col-md-12">
<div class="loginTitle">Üye Ol</div>
</div>
</div>
<div class="row">
<div class="col-md-5">

<c:if test="${not empty sonuc}">
	<c:if test="${sonuc.getDurum()==1}">
		<div class="alert alert-success" role="alert">
			${sonuc.getAciklama()} <div id="notice">Yönlendiriliyorsunuz... <span id="counter" >5</span> saniye...</div>
			<% response.setHeader("Refresh", "5; URL=http://localhost:8080/eticaret/login"); %>
			<script type="text/javascript">
				$(document).ready(function(){
				var i =5;
				var fade_out = function() {
				  $("#notice").fadeOut().empty();
				    clearInterval(counter);
				};
				setTimeout(fade_out, 10000);
				function count() {  $("#counter").html(i--); }
				var counter = setInterval(function(){ count(); },900);
				});
			</script>	
		</div>
	</c:if>
	<c:if test="${sonuc.getDurum()==0}">
		<div class="alert alert-danger" role="alert">
			${sonuc.getAciklama()}
		</div>
	</c:if>
</c:if>
<div class="registerSection">
<form:form class="form-signin" htmlEscape="true" commandName="kayitModel" action="${pageContext.request.contextPath}/kayitOl" method="Post" cssClass="form-horizontal">

   <div class="form-group">
    	<label  class="control-label">İsim</label>
	    <c:if test="${not empty kayitModel}">
		    <input name="isim" type="text" value="${kayitModel.getIsim()}" class="form-control" placeholder="İsim" required>
		    </c:if>
		    <c:if test="${empty kayitModel}">
		     <input name="isim" type="text" class="form-control" placeholder="İsim" required>
		    </c:if>
	</div>

	   <div class="form-group">
    	<label class="control-label">Soyad</label>
	     <c:if test="${not empty kayitModel}">
		    <input name="Soyisim" type="text" value="${kayitModel.getSoyisim()}" class="form-control" placeholder="Soyad" required>
		    </c:if>
		    <c:if test="${empty kayitModel}">
		    <input name="Soyisim" type="text" class="form-control" placeholder="Soyad" required>
		    </c:if>
	</div>
	
	 <div class="form-group">
    	<label class="control-label">E-Posta</label>
	    <c:if test="${not empty kayitModel}">
		    <input name="Email" type="text" value="${kayitModel.getEmail()}" class="form-control" placeholder="e-Posta" required>
		    </c:if>
		    <c:if test="${empty kayitModel}">
		   <input name="Email" type="text" class="form-control" placeholder="e-Posta" required>
		    </c:if>
	</div>

	 <div class="form-group">
    	<label class="control-label">Adres</label>
	      <c:if test="${not empty kayitModel}">
		    <textarea id="adres" name="MusteriAdres" placeholder="Adres" rows="3" class="form-control" required>${kayitModel.getMusteriAdres()}</textarea>
		    </c:if>
		    <c:if test="${empty kayitModel}">
		    <textarea id="adres" name="MusteriAdres" placeholder="Adres" rows="3" class="form-control" required></textarea>
		    </c:if>
	</div>

    <div class="form-group">
    	<label class="control-label">Kullanıcı Ad</label>
	     <c:if test="${not empty kayitModel}">
		    <input name="KullaniciAdi" type="text" value="${kayitModel.getKullaniciAdi()}" class="form-control" placeholder="Kullanıcı Ad" required>
		    </c:if>
		    <c:if test="${empty kayitModel}">
		     <input name="KullaniciAdi" type="text" class="form-control" placeholder="Kullanıcı Ad" required>
		    </c:if>
		    <form:errors path="KullaniciAdi" cssClass="error" ></form:errors>
	</div>
	
	 <div class="form-group">
    	<label class="control-label">Parola</label>
		    <input name="Sifre" type="password" class="form-control" placeholder="Parola" required>
		    <form:errors path="Sifre" cssClass="error" ></form:errors>
	</div>
	
	 <div class="form-group">
    	<label class="control-label">Parola (Tekrar)</label>
		    <input name="SifreTekrar" type="password" class="form-control" placeholder="Parola (Tekrar)" required>
		    <form:errors path="SifreTekrar" cssClass="error" ></form:errors>
	</div>
	
      <button id="registerButton" type="submit">Kaydet</button>
	
</form:form>
</div>

</div>
<div class="col-md-2"></div>
</div>

</div>
 <jsp:include page="statik/footer.jsp"/>