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
   <c:if test="${not empty kategori.getKategoriAdi()}">
 <li style="color: #f5a623;">${kategori.getKategoriAdi()}</li>
 </c:if>
</ol>

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
	 			<c:if test="${not empty kategoriList }">
	 			<c:forEach var="i" items="${kategoriList}">
	 				<option id="${i.getKategoriID() }" value="${pageContext.request.contextPath}/kategori/kitap/${i.getKategoriKod()}/${i.getKategoriID()}?pageId=1" id="${i.getKategoriID() }"title="${i.getKategoriAdi()}">
	 				<a href="${pageContext.request.contextPath}/kategori/kitap/${i.getKategoriKod()}/${i.getKategoriID()}?pageId=1">
	 				${i.getKategoriAdi()}</a></option>
	 			</c:forEach>
	 		</c:if>
	 			
	 		</select>
		</div>
	</div>
<%-- <p><%= request.getParameter("ignored") %></p> --%>
<div class="col-lg-9 col-md-8 col-sm-12 col-xs-12 container" style="margin-top: 30px;">
<div class="productListContent row">
	<div class="products">
		<section class="shelf">
			<div class="clearfix">
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

<nav aria-label="Navigation for productList" style="text-align:center;">
    <ul class="pagination">
        <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link" 
                href="${pageContext.request.contextPath}/kategori/kitap/${kategoriAdi}/${KategoriId}?pageId=${currentPage-1}">
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
                        href="${pageContext.request.contextPath}/kategori/kitap/${kategoriAdi}/${KategoriId}?pageId=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link" 
                href="${pageContext.request.contextPath}/kategori/kitap/${kategoriAdi}/${KategoriId}?pageId=${currentPage+1}">       
                 <span aria-hidden="true">&raquo;</span>
        		<span class="sr-only">Next</span></a>
            </li>
        </c:if>              
    </ul>
</nav>

<script type="text/javascript">
function handleSelect(elm)
{
window.location = elm.value;
}
</script>
 <jsp:include page="statik/footer.jsp"/>