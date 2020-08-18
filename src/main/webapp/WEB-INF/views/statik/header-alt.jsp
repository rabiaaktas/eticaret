<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

</head>
<body>



<div class="main">
	
<div class="gsfcontent">
		<div class="loginRegisterButtons">
			<a href="${pageContext.request.contextPath}/user/login" class="btn loginNav">Giriş Yap</a>
			<a href="${pageContext.request.contextPath}/kayitOl" class="btn loginNav">Kayıt Ol</a>
			<a  class="btn loginNav basket" href="#"><i class="glyphicon glyphicon-shopping-cart"></i>(${sessionScope.cart.size() })Sepet</a>
		</div>
	<div class="header">
		<a href="${pageContext.request.contextPath}/" >	
			<img class="logo" src="${pageContext.request.contextPath}/resources/bootstrap/images/logo.png" />
		</a>
		 <div class="headeralt hidden-xs">
<!-- 	 		<p class="headeralt-p">AKDENİZ ÜNİVERSİTESİ</p> -->
		</div>
	<div class="loginSearch">
	<script type="text/javascript">
	$(document).ready(function() {
	    //attach autocomplete
	    $("#tagQuery").autocomplete({
	        minLength: 1,
	        delay: 500,
	        //define callback to format results
	        source: function (request, response) {
	            $.getJSON("${pageContext.request.contextPath }/search", request, function(result) {
	                response($.map(result, function(item) {
	                    return {
	                        // following property gets displayed in drop down
	                        label: item.urunAdi,
	                        // following property gets entered in the textbox
	                        value: item.urunAdi,
	                        price: item.urunAlisFiyat,
	                        // following property is added for our own use
	                        tag_url: "/eticaret/"+item.urunAdi+"?UrunID="+item.urunID
	                    }
	                }));
	            });
	        },

	        //define select handler
	        select : function(event, ui) {
	            if (ui.item) {
	            	  event.preventDefault();
	                  $("#selected_tags span").append('<a href=" + ui.item.tag_url + " target="_blank">'
	                		  + ui.item.label - ui.item.value +'</a>');
	            	  window.location.href = ui.item.tag_url;
	            }
	        }
	    });
	});
// 		$(document).ready(function() {
// 			$('#productName').autocomplete({
// 				source : '${pageContext.request.contextPath }/search'
// 			});
// 		});
	</script>
		<div class="search-container ">
    			<form action="${pageContext.request.contextPath }/searchProduct?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data" cssClass="form-horizontal">
      				<input type="text" placeholder="Search.." name="searchVal" id="tagQuery">
      				<button type="submit">Ara
      				</button>
   				 </form>
  			</div>
  	</div>
	</div>

<nav class="navbar navbar-default ">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
     <div class="navbar-header">   
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
     </div>

<!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">		
		<ul class="nav navbar-nav">
			  <li class="nav-item">      
			  <a class="nav-link home" href="${pageContext.request.contextPath}/" >
			  <i class="glyphicon glyphicon-home"></i>Anasayfa</a>
			  </li>
	    	  <li class="nav-item dropdown">
				   <a class="nav-link" href="${pageContext.request.contextPath}/kategori/kitap?pageId=1"><i class="glyphicon glyphicon-book"></i>Kitap</a>
			  </li>
	      	  <c:if test="${pageContext.request.userPrincipal.name != null}">
	      		<li class="nav-item nav-link"><a  href="#"><i class="glyphicon glyphicon-user"></i>Profil</a></li>
	      	  </c:if>      	  
	     </ul>
   		 <ul class="nav navbar-nav navbar-right">

  			 </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

  