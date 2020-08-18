<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%-- <%@ page session="false" %> --%>
<jsp:include page="header-ust.jsp"/>
<jsp:include page="header-alt.jsp"/>


<div class="row mainCarousel">
<!-- 	<div class="col-md-12"> -->


	<div id="myCarousel" class="carousel slide" data-ride="carousel">
<!--       Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1" ></li>
      </ol>
     	 <div class="carousel-inner" role="listbox">
       		 <div class="item active">
          		<img alt="" src="${pageContext.request.contextPath}/resources/bootstrap/images/anasayfa.png" class="img-responsive">
          		<div class="container">
            			<div class="carousel-caption"></div>
          		</div>
        	</div> 
        	<div class="item">
          		<img alt="" src="${pageContext.request.contextPath}/resources/bootstrap/images/kitap.jpg" class="img-responsive">
          			<div class="container">
           				 <div class="carousel-caption"></div>
          			</div>
       		</div> 
        </div> 
         <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	        <span class="sr-only">Previous</span>
	      </a>
	      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	        <span class="sr-only">Next</span>
	      </a>                     
      </div>
	     
<!--     </div> -->
</div>
<div class="container indexItems">
<div class="latestDiv">
    <h1 class="indexTitle"><strong>Son Eklenenler</strong></h1>
     <div class="owl-carousel owl-theme">
      	<c:forEach var="i" items="${son1}">
            <div class="item">
                 <div class="carouselImg"> 
            			<a href="${pageContext.request.contextPath}/${i.getUrunAdi()}?UrunID=${i.getUrunID()}" id="${i.getUrunID()}">>               
            	 				<img class ="img-responsive" src="${i.getDosyaThumbString()}"/>
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
         		<a class="btn btnSepet" href="${pageContext.request.contextPath}/sepet/buy/${i.getUrunID()}">Sepete Ekle</a>
         		</div>
           </div>
     </c:forEach>
    </div>
	 <div class="owl-carousel owl-theme" style="margin-top:20px;">
     	 <c:forEach var="i" items="${son2}">
            <div class="item">
                 <div class="carouselImg"> 
            			<a href="${pageContext.request.contextPath}/${i.getUrunAdi()}?UrunID=${i.getUrunID()}" id="${i.getUrunID()}">>               
            	 				<img class ="img-responsive" src="${i.getDosyaThumbString()}"/>
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
 
 <div class="cokSatanDiv ">
 	<h1 class="indexTitle"><strong> Çok Satanlar</strong></h1>
  			<div class="owl-carousel owl-theme" style="margin-top:20px;">
     	 <c:forEach var="i" items="${urunler}">
            <div class="item">
                 <div class="carouselImg"> 
            			<a href="${pageContext.request.contextPath}/${i.getUrunAdi()}?UrunID=${i.getUrunID()}" id="${i.getUrunID()}">>               
            	 				<img class ="img-responsive" src="${i.getDosyaThumbString()}"/>
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
</div>
	<script  type="text/javascript">
            $(document).ready(function() {
            	$('.owl-carousel').owlCarousel({
            		autoplay: true,
        		    autoplayTimeout: 8000,
        		    autoplaySpeed: 1000,
        		    autoplayHoverPause: false,
        		    loop:true,
        		    margin:10,
        		    responsiveClass:true,
//        		    navText: ["<span></span>", "<span></span>"],
        		    responsive:{
        		        0:{
        		            items:1,
        		            nav:true
        		        },
        		        600:{
        		            items:3,
        		            nav:false
        		        },
        		        1000:{
        		            items:5,
        		            nav:false,
        		            loop:false
        		        }
        		    }
            	})
            })
          </script>
	
<jsp:include page="footer.jsp"/>