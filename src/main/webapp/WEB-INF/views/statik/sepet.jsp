<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%-- <%@ page session="false" %> --%>
<jsp:include page="header-ust.jsp"/>
<jsp:include page="header-alt.jsp"/>

<ol class="breadcrumb">
 <li><strong><a href="${pageContext.request.contextPath}/" style="color:#4a4a4a;">Anasayfa</a></strong></li>
 <li style="color: #f5a623;">Sepetim</li>
</ol>
<div id = "cartItems">
	<section id="basketSection">
		<div class="container">
			<form action="" method="post">
				<section class="cart">
					<div class="container">
						<div class="row">
							<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
								<div class="cartTitle">
									<h3 class="titleCart"> Sepetim <span style="font-weight:300;">(${sessionScope.cart.size()} Ürün)</span></h3>
								</div>
								<div class="cartWarn">
								</div>
								<div class="cart-detail-title">
									<div class="row hidden-xs">
										<div class="col-md-6 col-lg-6">
											<div class="col-lg-12 col-md-6 col-sm-6" style="text-align:center;font-weight: 700;">
												<span >ÜRÜN ADI</span>
											</div>
										</div>
										<div class="col-md-6 col-lg-6">
											<div class="col-lg-7 col-md-7 col-sm-6" style="text-align:right;font-weight: 700;">
												<span>ADET</span>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-6" style="text-align:right;font-weight: 700;">
												<span>FİYAT</span>
											</div>
										</div>										
									</div>
								</div>
									<c:forEach var="item" items="${sessionScope.cart}">
										<div id="${item.urunModel.getUrunID() }" class="cart-entry-list" data-id="${item.urunModel.getUrunID() }">
											<div class="cart-entry">
												<div class="row">
											 <div class = "col-lg-6 col-md-6 col-sm-8">									
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-4">
															<a href="${pageContext.request.contextPath }/${item.urunModel.getUrunAdi() }?UrunID=${item.urunModel.getUrunID() }" class="sepetImage">
															<img id="urunResim" src="${item.urunModel.getDosyaString()}" alt="${item.urunModel.getUrunAdi() }">
															</a>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-8">
															<h5 style="padding-left:5px;"><a href="${pageContext.request.contextPath }/${item.urunModel.getUrunAdi() }?UrunID=${item.urunModel.getUrunID() }"
															style="color:#4a4a4a;font-weight: bold;word-wrap: break-word;text-decoration: none;">
																${item.urunModel.getUrunAdi() }
															</a></h5>
															<div class="sepetWriter">
																${item.urunModel.getYazarAdi() }
															</div>
															<div class="sepetGenre">
																<span class="cat">${item.urunModel.getKategoriAdi() }</span>
															</div>
														</div>														
													</div>
												</div>
										<div class="col-lg-6 col-md-6 col-sm-4" style="float:right;">
											<div class="row">
												<div class="col-lg-6 col-md-3 col-sm-12 quantity">
													${item.getQuantity() }
												</div>
												<div class="col-lg-6 col-md-9 col-sm-12"  style="float:right;">
													<div class="price">
														&#8378;${item.urunModel.getUrunAlisFiyat() }
													</div>
												</div>
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
			
			</form>
		</div>
	
	</section>

</div>

<jsp:include page="footer.jsp"/>