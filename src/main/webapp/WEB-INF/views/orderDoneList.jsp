<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ page session="false" %> --%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<jsp:include page="statik/adminheader-ust.jsp"/>
<jsp:include page="statik/adminheader-alt.jsp"/>

<ol class="breadcrumb">
 <li><a href="${pageContext.request.contextPath}/admin"style="color:#4a4a4a;"><strong>Anasayfa</strong></a></li>
 <li>Teslim Edilen Siparişler</li>
</ol>
<%-- <c:out value="${pageContext.request.session}"/> --%>
<form method="post" action="${pageContext.request.contextPath}/admin/searchDoneOrders">
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
<table class="table table-hover" id="orderList">
<thead>
	<tr>
		<th>Sipariş No</th>
		<th>Kullanıcı Adı</th>
		<th>Ad/Soyad</th>
		<th>E-mail</th>
		<th>Adres</th>
		<th>Telefon</th>
		<th>Toplam Tutar</th>
		<th>Siparis Tarihi</th>
		<th colspan="4">İşlem</th>
	</tr>
</thead>
<c:forEach var="i" items="${orderList}">
<tr>
<td>${i.getSiparisID() }</td>
<td>${i.getKullaniciAdi()}</td>
<td>${i.getIsim()} ${i.getSoyisim()}</td>
<td>${i.getEmail() }</td>
<td>${i.getSiparisAdres()}</td>
<td>${i.getTelefon()}</td>
<td>${i.getToplamTutar()} TL</td>
<td>${i.getSiparisTarihi()}</td>
<td><button type="button" class="btn buttonProducts openBtn_${i.getKullaniciId()}">Ürünleri Gör</button></td>
<%-- <td><button type="button" class="btn buttonProducts updateBtn_${i.getKullaniciId()}" ">Durum Güncelle</button></td> --%>
</tr>
<div class="modal fade" id="myModal_${i.getKullaniciId()}" role="dialog">
    <div class="modal-dialog modal-lg">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">${i.getIsim()} ${i.getSoyisim()} Sipariş Ürünleri</h4>
            </div>
            <div class="modal-body products">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script>
$('.openBtn_${i.getKullaniciId()}').on('click',function(){
    $('.products').load('${pageContext.request.contextPath}/admin/orderProductsDone?SiparisID=${i.getSiparisID()}',function(){
        $('#myModal_${i.getKullaniciId()}').modal({
        	show:true
        	});
    });
   
});	
$('.updateBtn_${i.getKullaniciId()}').on('click',function(){
        $('#UpdateModal_${i.getSiparisID()}').modal({
        	show:true
        	});   
});	
$.ajaxPrefilter(function( options, original_Options, jqXHR ) {
    options.async = true;
});

</script>

<%-- <div class="modal fade" id="UpdateModal_${i.getSiparisID()}" tabindex="-1" role="dialog" aria-labelledby="UpdateModal" aria-hidden="true"> --%>
<!--   <div class="modal-dialog" role="document"> -->
<!--     <div class="modal-content"> -->
<%--      	<form class="form-horizontal" name="orderModel" method="Post" action="${pageContext.request.contextPath}/admin/updateState/${i.getSiparisID()}?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data"> --%>
<!--       			<div class="modal-header"> -->
<!--         			<button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
<%--           				<span aria-hidden="true">&times;</span> --%>
<!--         			</button> -->
<!--       			</div> -->
<!--       			<div class="modal-body"> -->
<%-- 			<select name="SiparisDurumId" id="SiparisDurumId" class="custom categorySelect selectBox" autocomplete="off" facet-event="true" facet-force="true""> --%>
<!-- 	 			<option>Durum Güncelle</option> -->
<%-- 	 			<c:forEach var="i" items="${stateList}"> --%>
<%-- 	 				<option id="${i.getSiparisDurumId() }"  value="${i.getSiparisDurumId() }" title="${i.getSiparisDurumAdi()}"> --%>
<%-- 	 				${i.getSiparisDurumAdi()}</option> --%>
<%-- 	 			</c:forEach>			 --%>
<%-- 	 		</select> --%>
<!-- 		    	</div> -->
<!--       			<div class="modal-footer"> -->
<!--        				 <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>           -->
<!-- 					 <button type="submit" class="btn btn-success">Güncelle</button>	 -->
<!--       			</div> -->
<!--       	</form>    -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->
</c:forEach>
</table>

<nav aria-label="Navigation for productList" style="text-align:center;">
    <ul class="pagination">
        <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link" 
                href="${pageContext.request.contextPath}/admin/tamamlananSiparisler?pageId=${currentPage-1}">
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
                        href="${pageContext.request.contextPath}/admin/tamamlananSiparisler?pageId=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link" 
                href="${pageContext.request.contextPath}/admin/tamamlananSiparisler?pageId=${currentPage+1}">       
                 <span aria-hidden="true">&raquo;</span>
        		<span class="sr-only">Next</span></a>
            </li>
        </c:if>              
    </ul>
</nav>
</div>
</div>
</div>

 <jsp:include page="statik/adminfooter.jsp"/>
