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
<script>
// ($document).ready($("#menu-toggle").click(function(e) {

//     e.preventDefault();
//     $("#wrapper").toggleClass("active"));
// });
</script>
<div class="main">
<div class="gsfcontent">
<div id="wrapper" class="active">  
    <!-- Sidebar -->
            <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul id="sidebar_menu" class="sidebar-nav">
		<li>${pageContext.request.userPrincipal.name}</li>
		<li><a href="${pageContext.request.contextPath}/admin-panel/logout" > Çıkış Yap</a></li>
          <li class="sidebar-brand"><a id="menu-toggle" href="${pageContext.request.contextPath}/admin/">Menu</a></li>
        </ul>
        <ul class="sidebar-nav" id="sidebar">
          <li><a href="${pageContext.request.contextPath}/admin/kullanicilar?pageId=1">Kullanıcılar<i class="sub_icon glyphicon glyphicon-link"></i></a></li>
           <ul class="sidebar-nav" id="sidebar">
                <li><a href="${pageContext.request.contextPath}/admin/urunler?pageId=1">Ürün Listesi<i class="sub_icon glyphicon glyphicon-link"></i></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/kategoriler">Kategori Listesi<i class="sub_icon glyphicon glyphicon-link"></i></a></li>
          		<li><a href="${pageContext.request.contextPath}/admin/siparisler?pageId=1">Yeni Siparişler<i class="sub_icon glyphicon glyphicon-link"></i></a></li>
	            <li><a href="${pageContext.request.contextPath}/admin/kargodakiSiparisler?pageId=1">Kargodakiler<i class="sub_icon glyphicon glyphicon-link"></i></a></li>
	            <li><a href="${pageContext.request.contextPath}/admin/tamamlananSiparisler?pageId=1">Teslim Edilenler<i class="sub_icon glyphicon glyphicon-link"></i></a></li>
				<li><a href="${pageContext.request.contextPath}/admin/urunEkle">Ürün Ekle<i class="sub_icon glyphicon glyphicon-link"></i></a></li>
          		<li><a href="${pageContext.request.contextPath}/admin/kategoriEkle">Kategori Ekle<i class="sub_icon glyphicon glyphicon-link"></i></a></li>       
           </ul>      
        </ul>
      </div>
