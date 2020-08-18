<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ page session="false" %> --%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<jsp:include page="header-ust.jsp"/>

<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-5 adminLogin">
			<div class="login">
		<form class="form-signin" method="POST" role="form" action="${pageContext.request.contextPath }/admin/process-login"> 
			<div class="form-group">
				<c:if test="${msg !=null }">
					<label class="control-label errorLog">${msg}</label>
				</c:if>
			</div>
			<div class="form-group">
			<label class="control-label">Kullanıcı Adı</label>
      		<input autocomplete="off" style="height: 40px;"  type="text" tabindex="1" name="username" class="form-control" placeholder="Kullanıcı Adı" required autofocus>
      		</div>
      		<div class="form-group">
      		<label class="control-label">Parola</label>
     		<input autocomplete="off" tabindex="2" type="password" name="password" class="form-control" placeholder="Parola" required> 
      		</div>
      		<button id="loginButton"  type="submit" >
      			GİRİŞ YAP
      		</button> 
      		<div class="form-group">
				<a href="${pageContext.request.contextPath}/" class="forgetPass">
					Parolamı Unuttum!
				</a>
      		</div>      
		</form>
		</div>
		</div>	
		<div class="col-md-4"></div>
	</div>
</body>
</html>