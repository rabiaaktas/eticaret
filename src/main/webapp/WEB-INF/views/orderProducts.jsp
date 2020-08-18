<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ page session="false" %> --%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="row">
<div class="col-md-12">
<div class="table-responsive">
<table class="table table-hover" id="orderlist">
<thead>
	<tr>
		<th></th>
		<th>Ürün Adı</th>
		<th>ISBN</th>
		<th>Adet</th>
		<th>Birim Fiyat</th>
		<th>Siparis Tarihi</th>
	</tr>
</thead>
<c:forEach var="i" items="${products}">
<tr>
<td><img src="${i.getDosyaThumbString()}" class="productListImage img-responsive" ></td>
<td>${i.getUrunAdi()}</td>
<td>${i.getISBN()}</td>
<td>${i.getAdet()}</td>
<td>${i.getBirimFiyat()}</td>
<td>${i.getSiparisTarihi()}</td>
</tr>
</c:forEach>
</table>
<nav aria-label="Navigation for productList" style="text-align:center;">
    <ul class="pagination">
        <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link" 
                href="${pageContext.request.contextPath}/admin/orderList?pageId=${currentPage-1}">
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
                        href="${pageContext.request.contextPath}/admin/orderList?pageId=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link" 
                href="${pageContext.request.contextPath}/admin/orderList?pageId=${currentPage+1}">       
                 <span aria-hidden="true">&raquo;</span>
        		<span class="sr-only">Next</span></a>
            </li>
        </c:if>              
    </ul>
</nav>
</div>
</div>
</div>
