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
<li> <a href="${pageContext.request.contextPath}/kategori/kitap?pageId=1" style="color:#4a4a4a;">Kategoriler</a></li>
   <c:if test="">
 <li></li>
 </c:if>
</ol>
<div class="search">
<div class="row">
<div class="col-md-12 searchInf">
	<p class="searchTitle">"${searchVal}" için arama sonuçları</p>
</div>
<div class="col-lg-9 col-md-8 col-sm-12 col-xs-12 container" style="margin-top: 30px;">
<div class="productListContent row">
	<div class="products">
		<section class="shelf">
			<div class="container">
				<div class="row">
				<div class="col-md-12">				
		<c:forEach var="i" items="${urunList}">		
					<div class="col-12 col-xl-3 col-lg-3 col-md-6 col-sm-6 col-xs-12 productItems">
						<div class="box" >						
						<div data-id="${i.getUrunID()}"  class="">
							<div class="productImage">
								<a href="${pageContext.request.contextPath}/${i.getUrunAdi()}?UrunID=${i.getUrunID()}" id="${i.getUrunID()}">               
            	 				<img src="${i.getDosyaThumbString()}" class="img-responsive" style="margin:auto;"/>
            					</a>
            			</div>
								<div class="product-cart">
									<div class="productName">        
                						<p class="nameOfProduct">${i.getUrunAdi()}</p>
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
							</div>
						</div>
					
					</div>
		</c:forEach>
				</div>
		
		</div>
			</div>
		
		</section>
	</div>
</div>
</div>
</div>

<nav aria-label="Navigation for searchResult" style="text-align:center;">
    <ul class="pagination">
        <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link" 
                href="${pageContext.request.contextPath}/searchProduct?searchVal=${searchVal}&pageId=${currentPage-1}">
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
                        href="${pageContext.request.contextPath}/searchProduct?searchVal=${searchVal}&pageId=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link" 
                href="${pageContext.request.contextPath}/searchProduct?searchVal=${searchVal}&pageId=${currentPage+1}">       
                 <span aria-hidden="true">&raquo;</span>
        		<span class="sr-only">Next</span></a>
            </li>
        </c:if>              
    </ul>
</nav>
</div>
 <jsp:include page="statik/footer.jsp"/>