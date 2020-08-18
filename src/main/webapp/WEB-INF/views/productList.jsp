<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <%@ page session="false" %> --%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<jsp:include page="statik/adminheader-ust.jsp"/>
<jsp:include page="statik/adminheader-alt.jsp"/>

<ol class="breadcrumb">
 <li><a href="${pageContext.request.contextPath}/admin"style="color:#4a4a4a;"><strong>Anasayfa</strong></a></li>
 <li>Ürün Bilgi Listesi</li>
</ol>
<form method="post" action="${pageContext.request.contextPath}/admin/searchUrun?pageId=1">
<div class="row" style="margin-bottom: 20px;">
  <div class="col-sm-2">		
  <label for="aramagenel">Arama</label>
  </div>
  <div class="col-sm-8">
		  <input type="text" name="searchVal" class="form-control" placeholder="Arama" />
		</div>
	<div class="col-sm-2">
	<button type="submit" class="btn btn-success">Ara</button>
	</div>
</div>
<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>    
</form>
<div class="row">
<div class="col-md-12">
<div class="table-responsive">
<table class="table table-hover" id="productlist">
<thead>
	<tr>
		<th>Ürün Ad</th>
		<th>Ürün Kod</th>
		<th>Kategori</th>
		<th>Ürün Alış Fiyat</th>
		<th>Adet</th>
		<th>Resim</th>
		<th colspan="4">İşlem</th>
	</tr>
</thead>
<c:forEach var="i" items="${urunList}">
<tr>
<td>${i.getUrunAdi()}</td>
<td>${i.getUrunKod()}</td>
<td>${i.getKategoriAdi()}</td>
<td>${i.getUrunAlisFiyat()} TL</td>
<td>${i.getAdet()}</td> 
<td><img src="${i.getDosyaThumbString()}" class="productListImage img-responsive" ></td>
<td><a class="btn btn-info" href="${pageContext.request.contextPath}/admin/urunDuzenle/${i.getUrunID()}"><i class="glyphicon glyphicon-pencil"></i> Düzenle</a></td>
<td><button class="btn btn-danger" data-toggle="modal" id="${i.getUrunID()}" data-target="#delProductModal_${i.getUrunID()}"><i class="glyphicon glyphicon-trash"></i> Sil</button></td>
<td><button class="btn btn-warning" data-toggle="modal" id="${i.getUrunID()}" data-target="#UpdateModal_${i.getUrunID()}"><i class="glyphicon glyphicon-refresh"></i> Stok Güncelle</button></td>

</tr>
<!-- delete -->
<div class="modal fade" id="delProductModal_${i.getUrunID()}" tabindex="-1" role="dialog" aria-labelledby="delProductModal" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="exampleModalLabel"><strong>${i.getUrunAdi()} Silinecek</strong></h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Silmek istediğinize emin misiniz?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/deleteProduct?UrunID=${i.getUrunID()}">
         <i class="glyphicon glyphicon-trash"></i> Sil</a>
      </div>
    </div>
  </div>
</div>
<!-- update -->
<div class="modal fade" id="UpdateModal_${i.getUrunID()}" tabindex="-1" role="dialog" aria-labelledby="UpdateModal" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     	<form class="form-horizontal" name="stokModel" method="Post" action="${pageContext.request.contextPath}/admin/stokUpdate?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
			<input type="hidden" class="form-control" value="${i.getStokID() }" id="StokID" name="StokID">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          				<span aria-hidden="true">&times;</span>
        			</button>
      			</div>
      			<div class="modal-body">
					<p>Adet</p>
		    			<c:if test="${not empty i}">
			    			<input name="Adet" id="Adet" type="text" class="form-control" placeholder="Adet" value="${i.getAdet()}" required>
			    		</c:if>
			    		<c:if test="${empty i}">
			   				 <input name="Adet" id="Adet" type="text" class="form-control" placeholder="Adet" value="" required>
			    		</c:if>
		    	</div>
      			<div class="modal-footer">
       				 <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>          
					 <button type="submit" class="btn btn-success">Güncelle</button>	
      			</div>
      	</form>   
    </div>
  </div>
</div>
</c:forEach>
</table>
<nav aria-label="Navigation for productList" style="text-align:center;">
    <ul class="pagination">
        <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link" 
                href="${pageContext.request.contextPath}/admin/urunler?pageId=${currentPage-1}">
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
                        href="${pageContext.request.contextPath}/admin/urunler?pageId=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link" 
                href="${pageContext.request.contextPath}/admin/urunler?pageId=${currentPage+1}">       
                 <span aria-hidden="true">&raquo;</span>
        		<span class="sr-only">Next</span></a>
            </li>
        </c:if>              
    </ul>
</nav>
</div>
</div>
</div>
<script>
jQuery(function ($) {
	$('#productcall').keyup(function () {
	    var valThis = $("#productcall").val().toLowerCase();
	    $('#productlist>tbody>tr').each(function () {
	        var text = $(this).text().toLowerCase();
	        (text.indexOf(valThis) >= 0) ? $(this).show() : $(this).hide();
	    });
	});
});
</script>
 <jsp:include page="statik/adminfooter.jsp"/>