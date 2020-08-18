package edu.akdeniz.eticaret.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import edu.akdeniz.eticaret.helper.model.IslemSonucModel;
import edu.akdeniz.eticaret.model.KategoriModel;
import edu.akdeniz.eticaret.model.KayitModel;
import edu.akdeniz.eticaret.model.OrderModel;
import edu.akdeniz.eticaret.model.StokModel;
import edu.akdeniz.eticaret.model.UrunModel;
import edu.akdeniz.eticaret.model.UserInfModel;

public interface EticaretService {
	
//	Inserts
	public IslemSonucModel insertKayit(KayitModel kayitModel);
	
	public IslemSonucModel insertUrun(UrunModel urunModel);

	public IslemSonucModel insertKategori(KategoriModel kategoriModel);
	
	public IslemSonucModel stokInsert(StokModel stokModel);
	
//	public IslemSonucModel dosyaInsertUpdate(UrunModel urunModel);


//	Lists
	
	public List<KategoriModel> getKategoriList();	
	
	public List<UrunModel> getProductList(Integer pageId,Integer total);	
	
	public List<UserInfModel> getUserList(Integer pageId,Integer total);
	
	public List<OrderModel> getOrderStates();
	
	public List<OrderModel> getOrderList(Integer pageId,Integer total);
	
	public List<OrderModel> getOrderListInCargo(Integer pageId,Integer total);
	
	public List<OrderModel> getOrderListDone(Integer pageId,Integer total);
	
	public List<OrderModel> getOrderProductsDone(Integer SiparisId);
	
	public List<OrderModel> getOrderProducts(Integer SiparisId);
	
	public List<OrderModel> getOrdersInCargo(Integer SiparisId);
	
	public List<byte[]> getUrunResim(Integer DosyaId);
	
	public List<byte[]> getUrunResimThumb(Integer DosyaThumbID);

	public List<UrunModel> getCategorizedProduct(Integer KategoriId,Integer pageId,Integer total);
	
	public List<UrunModel> getProductListSonEklenen1();
	
	public List<UrunModel> getProductListSonEklenen2();

	
//	Updates
	public String productUpdate(UrunModel urunler);
	
	public String kategoriUpdt(KategoriModel kategori);
	
	public String stokUpdate(StokModel stokModel);
	
	public  String orderStateUpdate(OrderModel orderModel,Integer siparisId);

//	Gets
	
	public UrunModel getProductDetails(Integer UrunID);
	
	public KategoriModel getKategoriID(Integer KategoriID);
	
	public UserInfModel getUserById(Integer kullaniciID);
	
	public StokModel getStokAdet(Integer UrunId);
	
	public Integer getProductCount();	
	
	public Integer getOrderProductCount();
	
	public Integer getCategorizedProductCount(Integer KategoriId);
	
	public UrunModel getProduct(Integer urunID);	

	public Integer getUserCount();
	
	public Integer getCategoryCount();
	
	public Integer getOrderListCount();
	
	public Integer getOrderListInCargoCount();
	
	public Integer getOrdersDoneCount();
	
	public Integer getSearchedUserCount(String searchVal);
	
	public Integer getSearchedProductCount(String searchVal);
	
	public Integer getProductInCargoCount();
	
	public Integer getProductDoneCOunt();

	
//	Sets
	public String deactivateUser(Integer kullaniciID);
	
	public String activateUser(Integer kullaniciID);
	
	public String setUserAsAdmin(Integer kullaniciID);
	
	public String setUserAsUser(Integer kullaniciID);
	
//	Delete
	public String kategoriDel(Integer KategoriID);
	
	public String productDelete(Integer UrunID);
	
//	Search
	public List<KategoriModel> searchKategori(String searchVal);
	
	public List<UserInfModel> searchUser(String searchVal,Integer pageId,Integer total);

	public List<UrunModel> searchProduct(String searchVal,Integer pageId,Integer total);
	
	public List<OrderModel> searchOrder(String searchVal,Integer pageId,Integer total);
	
	public List<OrderModel> searchCargoOrders(String searchVal,Integer pageId,Integer total);
	
	public List<OrderModel> searchDoneOrders(String searchVal,Integer pageId,Integer total);
	
	public List<UrunModel> search(String searchVal);
	

	

}