<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ page session="false" %> --%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<jsp:include page="header-ust.jsp"/>
<jsp:include page="header-alt.jsp"/>
<style type="text/css">

</style>
<div class="login container">
	<div class="row">
		<div class="col-md-12">
			<h4 class="loginTitle">Giriş Yap</h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-5">
			<div class="loginSection">
		<form class="form-signin" method="POST" role="form" action="${pageContext.request.contextPath }/user/process-login"> 
			<div class="form-group">
			<label class="control-label">Kullanıcı Adı</label>
      		<input autocomplete="off" style="height: 40px;"  type="text" tabindex="1" name="username" class="form-control" placeholder="Kullanıcı Adı" required autofocus>
      		</div>
      		<div class="form-group">
      		<label class="control-label">Parola</label>
     		<input autocomplete="off" tabindex="2" type="password" name="password" class="form-control" placeholder="Parola" required> 
      		</div>
      		<div class="form-group">
				<a href="${pageContext.request.contextPath}/" class="forgetPass">
					Parolamı Unuttum!
				</a>
      		</div>
      		<button id="loginButton"  type="submit" >
      			GİRİŞ YAP
      		</button>    
    		<div class="kayitOl">
    			Hesabınız yok mu?
				<a href="${pageContext.request.contextPath}/kayitOl" class="registerLink">
					Üye Olun
				</a>

    		</div>
    		  <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>    
		</form>
		</div>
		</div>	
		<div class="col-md-2">${pageContext.request.userPrincipal.name}</div>
		<div class="col-md-5">ghjklşlkjhgfdsxa</div>
	</div>
</div>
 <jsp:include page="footer.jsp"/>