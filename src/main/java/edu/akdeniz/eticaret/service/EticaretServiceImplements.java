
package edu.akdeniz.eticaret.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.akdeniz.eticaret.helper.model.IdentityCurrentModel;
import edu.akdeniz.eticaret.helper.model.IslemSonucModel;
import edu.akdeniz.eticaret.helpers.PngByteImageGenerator;
import edu.akdeniz.eticaret.mapper.DosyaMapper;
import edu.akdeniz.eticaret.mapper.KategoriMapper;
import edu.akdeniz.eticaret.mapper.KayitMapper;
import edu.akdeniz.eticaret.mapper.OrderMapper;
import edu.akdeniz.eticaret.mapper.ProductMapper;
import edu.akdeniz.eticaret.mapper.StokMapper;
import edu.akdeniz.eticaret.mapper.UserMapper;
import edu.akdeniz.eticaret.model.KategoriModel;
import edu.akdeniz.eticaret.model.KayitModel;
import edu.akdeniz.eticaret.model.OrderModel;
import edu.akdeniz.eticaret.model.StokModel;
import edu.akdeniz.eticaret.model.UrunModel;
import edu.akdeniz.eticaret.model.UserInfModel;

@Service("EticaretService")
public  class EticaretServiceImplements implements EticaretService  {
	
	@Autowired KayitMapper kayitMapper;
	@Autowired KategoriMapper kategoriMapper;
	@Autowired DosyaMapper dosyaMapper;
	@Autowired ProductMapper urunMapper;
	@Autowired UserMapper userMapper;
	@Autowired StokMapper stokMapper;
	@Autowired OrderMapper orderMapper;
	
//	Inserts
	
	public IslemSonucModel insertKayit(KayitModel kayitModel) {
		IslemSonucModel islemSonuc=new IslemSonucModel();
		IdentityCurrentModel identityCurrent=new IdentityCurrentModel();
		Integer kontrol=kayitMapper.kayitMsuteri(kayitModel.getIsim(),kayitModel.getSoyisim(),kayitModel.getEmail(),kayitModel.getMusteriAdres(),identityCurrent);
		Integer kontrol2=0;
		if(kontrol>0){
		kontrol2=kayitMapper.kayitKullanici(kayitModel.getKullaniciAdi(),1, identityCurrent.getIdCurrent(), kayitModel.getSifre());
		}
		if(kontrol2>0){
			islemSonuc.setDurum(1);
			islemSonuc.setAciklama("Ýþlem Baþarýlý");
		}
		return islemSonuc;
	}
	
	public IslemSonucModel insertUrun(UrunModel urunModel) {
		IslemSonucModel islemSonuc=new IslemSonucModel();
		islemSonuc.setAciklama("Ýþlem Baþarýsýz");
		islemSonuc.setDurum(0);
		PngByteImageGenerator rc=new PngByteImageGenerator();                   
		byte[] Dosya=null;
		byte[] DosyaThumb=null;
		try { 
			Dosya=rc.doit(urunModel.getUrunresim());
			DosyaThumb=rc.doit(urunModel.getUrunresimthumb());
		   }catch (Exception e){
		   } 
		Integer sonuc=0;
			IdentityCurrentModel identityCurrent=new IdentityCurrentModel();
			IdentityCurrentModel identityCurrent2=new IdentityCurrentModel();
			IdentityCurrentModel identityCurrent3=new IdentityCurrentModel();
			dosyaMapper.dosyaInsertThumb(DosyaThumb, 1, identityCurrent3);
			dosyaMapper.dosyaInsert(Dosya,1,identityCurrent);
		    sonuc=urunMapper.urunInsert(urunModel.getUrunAdi(), urunModel.getUrunKod(), urunModel.getAciklama(),urunModel.getISBN(),urunModel.getYazarAdi(),
				urunModel.getSayfaSayisi(),urunModel.getBasýmYili(),1, identityCurrent.getIdCurrent(), identityCurrent3.getIdCurrent(), urunModel.getKategoriID(), urunModel.getUrunAlisFiyat(),identityCurrent2);
		if(sonuc>0){
			stokMapper.urunStok(identityCurrent2.getIdCurrent(), urunModel.getAdet());
			islemSonuc.setAciklama("Ýþlem Baþarýlý");
			islemSonuc.setDurum(1);
		}
		return islemSonuc;                   
	}
	
	public IslemSonucModel insertKategori(KategoriModel kategoriModel) {
		IslemSonucModel islemSonuc=new IslemSonucModel();
		islemSonuc.setAciklama("Durum baþarýsýz.");
		islemSonuc.setDurum(0);
		Integer sonuc;
		sonuc=kategoriMapper.kategoriEkle(kategoriModel.getKategoriAdi(), kategoriModel.getKategoriKod(), kategoriModel.getAciklama());
		if(sonuc>0) {
			islemSonuc.setAciklama("Ýþlem baþarýlý.");
			islemSonuc.setDurum(1);
		}
		return islemSonuc;
		
	}
	
	public IslemSonucModel stokInsert(StokModel stokModel) {
		IslemSonucModel sonuc = new IslemSonucModel();
		sonuc.setAciklama("Durum baþarýsýz..");
		sonuc.setDurum(0);
		Integer stok=0;
		stok=stokMapper.urunStok(stokModel.getUrunId(), stokModel.getAdet());
		if(stok>0) {
			sonuc.setAciklama("Durum Baþarýlý...");
			sonuc.setDurum(1);
		}
		return sonuc;
		
	}
	
	//	Updates	
	public String productUpdate(UrunModel urunler) {
		Integer dosyaId=null;
		Integer dosyaThumbId = null;
		PngByteImageGenerator rc=new PngByteImageGenerator();                   
		byte[] Dosya = null;
		byte[] DosyaThumb = null;
		if(urunler.getDosyaId()!=null){
			dosyaId=urunler.getDosyaId();
		}
//		if(urunler.getDosyaId() == null) {
//			IdentityCurrentModel identityCurrentModel = new IdentityCurrentModel();
//			dosyaId = identityCurrentModel.getIdCurrent();
//		}
		if(urunler.getDosyaThumbId() != null) {
			dosyaThumbId = urunler.getDosyaThumbId();
		}
//		if(urunler.getDosyaThumbId() == null) {
//			IdentityCurrentModel identityCurrentModel = new IdentityCurrentModel();
//			dosyaThumbId = identityCurrentModel.getIdCurrent();
//		}
		try { 
			Dosya=rc.doit(urunler.getUrunresim());
			DosyaThumb = rc.doit(urunler.getUrunresimthumb());
		   }catch (Exception e){
		   } 
		if(Dosya != null && Dosya.length > 0 && DosyaThumb != null && DosyaThumb.length > 0){
			IdentityCurrentModel identityCurrent=new IdentityCurrentModel();
			IdentityCurrentModel identityCurrent2=new IdentityCurrentModel();
			dosyaMapper.dosyaInsertThumb(DosyaThumb, 1, identityCurrent2);
			dosyaMapper.dosyaInsert(Dosya,1,identityCurrent);
			dosyaId=identityCurrent.getIdCurrent();
			dosyaThumbId = identityCurrent2.getIdCurrent();
		}
		System.out.println("urunýd"+urunler.getUrunID());                       
		urunMapper.productUpdate(urunler.getUrunAdi(), urunler.getUrunKod(), urunler.getAciklama(), urunler.getISBN(),urunler.getYazarAdi(),urunler.getSayfaSayisi(), urunler.getBasýmYili(), 1, dosyaId,dosyaThumbId, urunler.getKategoriID(), urunler.getUrunAlisFiyat(), urunler.getUrunID());
		return "null";
	}

	public String kategoriUpdt(KategoriModel kategori) {
		kategoriMapper.kategoriUpdate(kategori.getKategoriAdi(), kategori.getKategoriKod(), kategori.getAciklama(), kategori.getKategoriID());
		return "null";
	}
	
	public String stokUpdate(StokModel stok) {
		stokMapper.updtStok(stok.getAdet(),stok.getStokID());
		return "null";
	}
	
	public String orderStateUpdate(OrderModel orderModel,Integer siparisID) {
		orderMapper.updateOrderState(siparisID, orderModel.getSiparisDurumId());
		return "null";
	}

	
//	Lists

	public List<KategoriModel> getKategoriList() {
		return kategoriMapper.getKategori();
	}

	public List<UrunModel> getProductList(Integer pageId,Integer total) {
		return urunMapper.getProductList(pageId,total);
	}
	
	public List<OrderModel> getOrderStates() {
		return orderMapper.getSiparisDurumList();
	}

	public List<OrderModel> getOrderList(Integer pageId,Integer total) {
		return orderMapper.getOrderList(pageId,total);
	}
	
	public List<OrderModel> getOrderProducts(Integer SiparisID) {
		return orderMapper.getSiparisUrunler(SiparisID);
	}
	
	public List<OrderModel> getOrderListInCargo(Integer pageId, Integer total) {
		return orderMapper.getOrderListKargo(pageId, total);
	}

	public List<OrderModel> getOrdersInCargo(Integer SiparisId) {
		return orderMapper.getCargoSiparisUrunler(SiparisId);
	}
	
	public List<OrderModel> getOrderListDone(Integer pageId, Integer total) {
		return orderMapper.getOrderListTeslim(pageId, total);
	}
	
	public List<OrderModel> getOrderProductsDone(Integer SiparisId) {
		return orderMapper.getTeslimSiparisUrunler(SiparisId);
	}
	
	public List<UserInfModel> getUserList(Integer pageId,Integer total) {
		return userMapper.getKullaniciList(pageId,total);
	}
	
	public List<byte[]> getUrunResim(Integer DosyaID) {                               
 		return urunMapper.getDosya(DosyaID);
	}
	
	public List<byte[]> getUrunResimThumb(Integer DosyaThumbID){
		return urunMapper.getDosyaThumb(DosyaThumbID);
	}
	
	public List<UrunModel> searchProduct(String searchVal,Integer pageId,Integer total) {
		List<UrunModel> list = urunMapper.searchedProducts(searchVal,pageId,total);
		return list;
	}
	
	public List<OrderModel> searchCargoOrders(String searchVal,Integer pageId,Integer total) {
		return orderMapper.searchedOrdersInCargo(searchVal,pageId,total);
	}	
	
	public List<KategoriModel> searchKategori(String searchVal) {
		List<KategoriModel> sonuc=kategoriMapper.CategorySearch(searchVal);
		return sonuc;
	}

	public List<UserInfModel> searchUser(String searchVal,Integer pageId,Integer total) {
		List<UserInfModel> model = userMapper.searchedUsers(searchVal, pageId, total);
		return model;
	}
	
	public List<OrderModel> searchDoneOrders(String searchVal,Integer pageId,Integer total) {
		return orderMapper.searchedOrdersInTeslim(searchVal,pageId,total);
	}
	
	public List<UrunModel> getCategorizedProduct(Integer KategoriId,Integer pageId,Integer total) {
		List<UrunModel> urunler=urunMapper.getProductbyCategory(KategoriId,pageId,total);
		return urunler;
	}

	public List<UrunModel> getProductListSonEklenen1() {
		List<UrunModel> son=urunMapper.getProductListSon1();
		return son;
	}

	public List<UrunModel> getProductListSonEklenen2() {
		List<UrunModel> son=urunMapper.getProductListSon2();
		return son;
	}
	
	public List<OrderModel> searchOrder(String searchVal,Integer pageId,Integer total) {
		return orderMapper.searchedOrders(searchVal,pageId,total);
	}
	
	public List<UrunModel> search(String searchVal) {
		return urunMapper.homePageSearch(searchVal);
	}

//	Gets
	
	public UrunModel getProduct(Integer urunID) {
		return urunMapper.getProduct(urunID);
	}
	
	public KategoriModel getKategoriID(Integer KategoriID) {
		return kategoriMapper.getKategoriByID(KategoriID);
	}
	
	public UrunModel getProductDetails(Integer UrunID) {
		UrunModel urun = urunMapper.getProByID(UrunID);
		return urun;
	}

	public Integer getProductCount() {
		Integer a = urunMapper.getCountOfProducts();
		return a;
	}

	public Integer getUserCount() {
		Integer a=userMapper.NumOfUsers();
		return a;
	}

	public Integer getCategoryCount() {
		Integer a = kategoriMapper.NumOfCategories();
		return a;
	}

	public Integer getCategorizedProductCount(Integer KategoriId) {
		Integer ab = urunMapper.numOfCatProducts(KategoriId);
		return ab;
	}
	
	public UserInfModel getUserById(Integer kullaniciID) {
		return userMapper.getUserByID(kullaniciID);
	}
	
	public StokModel getStokAdet(Integer UrunId) {
		StokModel s = stokMapper.getAdet(UrunId);
		return s;
	}
	

//	Deletes

	public String kategoriDel(Integer KategoriID) {
		kategoriMapper.kategoriDelete(KategoriID);
		return "null";
	}

	public String productDelete(Integer UrunID) {
		urunMapper.productDel(UrunID);
		return "null";
	}

	//User

	public String deactivateUser(Integer kullaniciID) {
		userMapper.deAktifUs(kullaniciID);
		return "null";
	}

	public String activateUser(Integer kullaniciID) {
		userMapper.aktifUs(kullaniciID);
		return "null";
	}

	public String setUserAsAdmin(Integer kullaniciID) {
		userMapper.setAdmin(kullaniciID);
		return "null";
	}

	public String setUserAsUser(Integer kullaniciID) {
		userMapper.setUser(kullaniciID);
		return "null";
	}

//	SearchLists
	
	public Integer getSearchedUserCount(String searchVal) {
		Integer a = userMapper.NumOfSearchedUsers(searchVal);
		return a;
	}

	public Integer getSearchedProductCount(String searchVal) {
		Integer a = urunMapper.numOfsearchedPro(searchVal);
		return a;
	}

	public Integer getOrderProductCount() {
		Integer a = orderMapper.getUrunCount();
		return a;
	}

	public Integer getOrderListCount() {
		Integer a = orderMapper.getOrderListCount();
		return a;
	}

	public Integer getOrderListInCargoCount() {
		Integer a = orderMapper.getOrderListKargoCount();
		return a;
	}

	public Integer getProductInCargoCount() {
		Integer a = orderMapper.getCargoUrunCount();
		return a;
	}

	public Integer getOrdersDoneCount() {
		Integer a = orderMapper.getOrderListTeslimCount();
		return a;
	}

	public Integer getProductDoneCOunt() {
		Integer a = orderMapper.getTeslimUrunCount();
		return a;
	}

















	















}
