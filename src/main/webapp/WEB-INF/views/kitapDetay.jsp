<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<jsp:include page="statik/header-ust.jsp"/>
<jsp:include page="statik/header-alt.jsp"/>
<ol class="breadcrumb">
 <li><strong><a href="${pageContext.request.contextPath}/" style="color:#4a4a4a;">Anasayfa</a></strong></li>
 <li>
 <a href="${pageContext.request.contextPath}/kategori/kitap/${urunm.getKategoriKod()}/${urunm.getKategoriID()}?pageId=1" style="color:#4a4a4a;">
 ${urunm.getKategoriAdi()}</a>
 </li>
 <li style="color: #f5a623;">${urunm.getUrunAdi()}</li>
</ol>
<%-- <p>${urunm.getKategoriAdi() }</p> --%>

<div class="row">
<div class="col-lg-3 col-md-4 hidden-sm hidden-xs">
		<div class="categories">
		<div class="list-group">
	<p style="font-size: 20px;padding-left: 20px;
+ padding-top: 10px;"><strong>Kategoriler</strong></p>
		<c:if test="${not empty kategoriList}">
  	<c:forEach items="${kategoriList}" var="i"> 
		<a href="${pageContext.request.contextPath}/kategori/kitap/${i.getKategoriKod()}/${i.getKategoriID()}?pageId=1" class="list-group-item" title="${i.getKategoriAdi()}">
		<h5 class="list-group-item-heading"><i class="glyphicon glyphicon-chevron-right"></i>${i.getKategoriAdi()}</h5>
		</a>
  	</c:forEach>
  	 </c:if>  
		</div>
	</div>
	 </div>
	 <div class="mobileCategories ">
		<div class="col-xs-12 col-sm-12 hide-md hide-lg">
     		<select name="categorySelect" id="categorySelect" class="custom categorySelect selectBox" autocomplete="off" facet-event="true" facet-force="true" onchange="javascript:handleSelect(this)">
	 			<option>Kategori Seç</option>
	 			<c:if test="${not empty kategori }">
	 			<c:forEach var="i" items="${kategoriList}">
	 				<option id="${i.getKategoriID() }" value="${pageContext.request.contextPath}/kategori/kitap/${i.getKategoriKod()}/${i.getKategoriID()}?pageId=1" id="${i.getKategoriID() }"title="${i.getKategoriAdi()}">
	 				<a href="${pageContext.request.contextPath}/kategori/kitap/${i.getKategoriKod()}/${i.getKategoriID()}?pageId=1">
	 				${i.getKategoriAdi()}</a></option>
	 			</c:forEach>
	 		</c:if>
	 			
	 		</select>
		</div>
	</div>
<div class="col-lg-9 col-md-8 col-sm-12 col-xs-12 container detailAll">
	<div class = "detailPage">
	<div class = "row">
	<div class="detailProduct hidden-lg hidden-md hidden-sm col-xs-12">
   			<h1 class="mt0">${urunm.getUrunAdi() }</h1>
	</div>
 	<div class ="col-sm-5 col-xs-12"> <!--"col-lg-4 col-md-4 col-sm-12 col-xs-12" -->
		<div class = "detailImage" style = "width: 237px; height: 328px;">
			<a href="${urunm.getDosyaString()}" data-fancybox>
       		 	<img src="${urunm.getDosyaString()}" class="img-fluid" />
      		  </a>
   		 </div>
   	</div> 
   	<div class = "col-sm-7 col-xs-12">
   	<div class="detailContent">
   		<div class="detailTitle hidden-xs">
   			<h1 class="mt0">${urunm.getUrunAdi() }</h1>
   		</div>
   		<div class ="detailWriter">
   			<p class="detailInlinePs">Yazar Adı: <span class="detailInlineSpans"><strong> ${urunm.getYazarAdi()}</strong></span></p>
   		</div>
   		<div class = "detailPageNum">
   			<p class="detailInlinePs">Sayfa Sayısı: <span><strong class="detailInlineSpans">${urunm.getSayfaSayisi() }</strong></span></p>
   		</div>
   		<div class = "detailYear">
   			<p class="detailInlinePs">Basım Yılı: <span><strong class="detailInlineSpans">${urunm.getBasımYili() }</strong></span></p></div>

   		<div class = "detailPrice">
   			<span>&#8378;${urunm.getUrunAlisFiyat() }</span>
   		</div>
   		<div class ="detailBasketButton">
   			<a class="btn">Sepete Ekle</a>
   		</div>
   	</div>
   		 </div>
	</div>
 <div class="productDescriptionContainer">
	<div class="container">
		<div class="description">
		<div class="descriptionTitle">
			<h4>Kitap Açıklaması</h4>
		</div>
			<p class="productDescription col-lg-10"> &nbsp;&nbsp;${urunm.getAciklama()}</p>
		</div>
	</div>
 	<div> <!-- class="col-lg-8" -->
	<div class="productInfo">
		<ul>
			<li><p>Kitap Adı: <span class="bold">${urunm.getUrunAdi()}</span></p></li>
			<li><p>Yazar Adı: <span class="bold"> ${urunm.getYazarAdi()}</span></p></li>
			<li><p>Sayfa Sayısı: <span class="bold">${urunm.getSayfaSayisi() }</span></p></li>		
			<li><p>Basım Yılı: <span class="bold">${urunm.getBasımYili() }</span></p></li>
		</ul>
	</div>
	</div>
</div>

</div>


</div>
</div><!-- end of the bigger row -->
 <div class="cokSatanDiv ">
 	<h1 class="indexTitle"><strong> Çok Satanlar</strong></h1>
  			<div class="owl-carousel owl-theme" style="margin-top:20px;">
     	 <c:forEach var="i" items="${urunler}">
            <div class="item">
                 <div class="carouselImg"> 
            			<a href="${pageContext.request.contextPath}/${i.getUrunAdi()}?UrunID=${i.getUrunID()}" id="${i.getUrunID()}">>               
            	 				<img class ="img-responsive" src="${i.getDosyaString()}"/>
            			</a>       
           		 </div>
            	<div class="productName">        
                	<p>${i.getUrunAdi()}</p>
            	</div>
				<div class="desc">
					<p>${i.getYazarAdi()}</p>
				</div>
         		<p class="productPrice">
         			<span>	&#8378;${i.getUrunAlisFiyat() }</span>
         		</p>
         		<div class="basketButton">
         		<a class="btn btnSepet">Sepete Ekle</a>
         		</div>
           </div>
     </c:forEach>
			        
	</div>
</div>
	<script type="text/javascript">
		function handleSelect(elm)
		{
		window.location = elm.value;
		}
</script>
 <jsp:include page="statik/footer.jsp"/>