package edu.akdeniz.eticaret.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PatchMapping;

import edu.akdeniz.eticaret.helper.model.IdentityCurrentModel;
import edu.akdeniz.eticaret.model.StokModel;
import edu.akdeniz.eticaret.model.UrunModel;


public interface ProductMapper {

	@Select("Select * from Urun")                                        
	public List<UrunModel> getUrunler();	
	
	@Insert("INSERT INTO urun(UrunAdi,UrunKod,Aciklama,ISBN,yazarAdi,sayfaSayisi,basýmYili,EklenmeTarihi,IslemTarihi,KullaniciId,"
			+ "DosyaId,DosyaThumbId,KategoriId,UrunAlisFiyat) VALUES ('${UrunAdi}','${UrunKod}','${Aciklama}','${ISBN}','${yazarAdi}',"
			+ "'${sayfaSayisi}','${basýmYili}',NOW(),NOW(),${KullaniciId},${DosyaId},${DosyaThumbId},${KategoriId},${UrunAlisFiyat})")
	@Options(useGeneratedKeys = true, keyProperty = "UrunID")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "UrunId.IdCurrent",before = false , resultType = int.class)
	public Integer urunInsert(@Param("UrunAdi") String UrunAdi,
			@Param("UrunKod") String UrunKod,
			@Param("Aciklama") String Aciklama,
			@Param("ISBN") String ISBN,
			@Param("yazarAdi") String yazarAdi,
			@Param("sayfaSayisi") String sayfaSayisi,
			@Param("basýmYili") String basýmYili,
			@Param("KullaniciId") Integer KullaniciId,
			@Param("DosyaId") Integer DosyaId,
			@Param("DosyaThumbId") Integer DosyaThumbId,
			@Param("KategoriId") Integer KategoriId,
			@Param("UrunAlisFiyat") float UrunAlisFiyat,
			@Param("UrunId") IdentityCurrentModel UrunId);
	
	@Update("Update urun set UrunAdi='${UrunAdi}',UrunKod='${UrunKod}',Aciklama='${Aciklama}',ISBN='${ISBN}',yazarAdi='${yazarAdi}',"
			+ "sayfaSayisi='${sayfaSayisi}',basýmYili = '${basýmYili}',IslemTarihi=NOW(),KullaniciId=${KullaniciId}, "
			+ "DosyaId=${DosyaId},DosyaThumbId=${DosyaThumbId},KategoriId=${KategoriId},UrunAlisFiyat=${UrunAlisFiyat} where UrunID=${UrunID}")
	public Integer productUpdate(
			@Param("UrunAdi") String UrunAdi,
			@Param("UrunKod") String UrunKod,
			@Param("Aciklama") String Aciklama,
			@Param("ISBN") String ISBN,
			@Param("yazarAdi") String yazarAdi,
			@Param("sayfaSayisi") String sayfaSayisi,
			@Param("basýmYili") String basýmYili,
			@Param("KullaniciId") Integer KullaniciId,
			@Param("DosyaId") Integer DosyaId,
			@Param("DosyaThumbId") Integer DosyaThumbId,
			@Param("KategoriId") Integer KategoriId,
			@Param("UrunAlisFiyat") float UrunAlisFiyat,
			@Param("UrunID") Integer UrunID);
//	Lists
	
	@Select("SELECT * from urun as u left outer JOIN kategori as k on u.KategoriId=k.KategoriID left outer join dosya as d "
			+ "on d.DosyaID=u.DosyaId left outer join dosyathumb as dt on dt.DosyaThumbID = u.DosyaThumbId "
			+ "left outer join stok as s on s.UrunId=u.UrunID LIMIT ${pageId-1} , ${total}")                                        
	public List<UrunModel> getProductList(@Param("pageId") Integer pageId,@Param("total") Integer total);
	
	@Select("SELECT * from urun as u left outer JOIN kategori as k on u.KategoriId=k.KategoriID left outer join"
			+ " dosya as d on d.DosyaID=u.DosyaId left outer join dosyathumb as dt on dt.DosyaThumbID = u.DosyaThumbId"
			+ " left outer join stok as s on s.UrunId=u.UrunID ORDER BY EklenmeTarihi DESC LIMIT 0,3")//row sayýsý deðiþmeli                                        
	public List<UrunModel> getProductListSon1();
	
	@Select("SELECT * from urun as u left outer JOIN kategori as k on u.KategoriId=k.KategoriID left outer join "
			+ "dosya as d on d.DosyaID=u.DosyaId left outer join dosyathumb as dt on dt.DosyaThumbID = u.DosyaThumbId"
			+ " left outer join stok as s on s.UrunId=u.UrunID ORDER BY EklenmeTarihi DESC LIMIT 3,5")  
	//row sayýsý kontrol edilmeli controllerda aktive edilmeli
	public List<UrunModel> getProductListSon2();
	
//	Search
	
	@Select("SELECT COUNT(*) from urun as u left outer JOIN kategori as k on u.KategoriId=k.KategoriID left outer join " + 
			"dosya as d on d.DosyaID=u.DosyaId left outer join dosyathumb as dt on dt.DosyaThumbID = u.DosyaThumbId "
			+ " left outer join stok as s on s.UrunId=u.UrunID WHERE UrunAdi LIKE '%${searchVal}%' OR "
			+ "UrunKod LIKE '%${searchVal}%' OR ISBN LIKE '%${searchVal}%' OR yazarAdi LIKE '%${searchVal}%' "
			+ "OR KategoriAdi LIKE '%${searchVal}%'")
	public Integer numOfsearchedPro(@Param("searchVal") String searchVal);   
	//	gerekli deðil PAGÝNATÝON YOK
	
	@Select("SELECT * from urun as u left outer JOIN kategori as k on u.KategoriId=k.KategoriID left outer join " + 
			"dosya as d on d.DosyaID=u.DosyaId left outer join dosyathumb as dt on dt.DosyaThumbID = u.DosyaThumbId "
			+ " left outer join stok as s on s.UrunId=u.UrunID WHERE UrunAdi LIKE '%${searchVal}%' OR "
			+ "UrunKod LIKE '%${searchVal}%' OR ISBN LIKE '%${searchVal}%' OR yazarAdi LIKE '%${searchVal}%' "
			+ "OR KategoriAdi LIKE '%${searchVal}%' LIMIT ${pageId-1},${total}")
	public List<UrunModel> searchedProducts(@Param("searchVal") String searchVal,
			@Param("pageId") Integer pageId,
			@Param("total") Integer total);
	
	@Select("SELECT u.UrunAdi,u.UrunKod,u.UrunAlisFiyat,u.UrunID,k.KategoriID,k.KategoriAdi,k.KategoriKod,u.yazarAdi from urun as u left outer JOIN kategori as k on u.KategoriId=k.KategoriID "
			+ " left outer join stok as s on s.UrunId=u.UrunID WHERE UrunAdi LIKE '%${searchVal}%' OR "
			+ "UrunKod LIKE '%${searchVal}%' OR yazarAdi LIKE '%${searchVal}%' "
			+ "OR KategoriAdi LIKE '%${searchVal}%'")
	public List<UrunModel> homePageSearch(@Param("searchVal") String searchVal);
	
//	Gets
	
	@Select("SELECT COUNT(*) from urun as u left outer JOIN kategori as k on u.KategoriId=k.KategoriID left outer join dosya as "
			+ "d on d.DosyaID=u.DosyaId left outer join dosyathumb as dt on dt.DosyaThumbID = u.DosyaThumbId "
			+ " left outer join stok as s on s.UrunId=u.UrunID WHERE u.KategoriId=${KategoriId}")
	public Integer numOfCatProducts(@Param("KategoriId") Integer KategoriId);
	
	@Select("SELECT * from urun as u left outer JOIN kategori as k on u.KategoriId=k.KategoriID " + 
			"left outer join dosya as d on d.DosyaID=u.DosyaId left outer join dosyathumb as dt on dt.DosyaThumbID = u.DosyaThumbId "
			+ " left outer join stok as s on s.UrunId=u.UrunID "
			+ "WHERE u.UrunID=${UrunID}")
	public UrunModel getProByID(@Param("UrunID") Integer UrunID);
	
	@Select("SELECT COUNT(*) from urun as u left outer JOIN kategori as k on u.KategoriId=k.KategoriID " + 
			"left outer join dosya as d on d.DosyaID=u.DosyaId left outer join dosyathumb as dt on dt.DosyaThumbID = u.DosyaThumbId "
			+ " left outer join stok as s on s.UrunId=u.UrunID ")
	public Integer getCountOfProducts();
	
	@Select("SELECT * from urun as u left outer JOIN kategori as k on u.KategoriId=k.KategoriID \r\n" + 
			"			left outer join dosya as d on d.DosyaID=u.DosyaId left outer join dosyathumb as dt on dt.DosyaThumbID = u.DosyaThumbId"
			+ " left outer join stok as s on s.UrunId=u.UrunID"
			+ " WHERE u.KategoriId=${KategoriId} LIMIT ${pageId-1} , ${total}")
	public List<UrunModel> getProductbyCategory(@Param("KategoriId") Integer KategoriId,
			@Param("pageId") Integer pageId,
			@Param("total") Integer total);
	
	@Select("SELECT * from urun as u left outer JOIN kategori as k on u.KategoriId=k.KategoriID where UrunID=${UrunID}")
	public UrunModel getProduct(@Param("UrunID") Integer UrunID);
	
	@Delete("DELETE FROM urun WHERE UrunID=${UrunID}")
	public Integer productDel(@Param("UrunID") Integer UrunID);
	
//	Dosya
	
	@Delete("Delete from dosya where dosyaID=${dosyaID}")
	public Integer dosyaDelete(@Param("dosyaID") Integer dosyaID);
	
	@Delete("Delete from dosyathumb where DosyaThumbID = ${DosyaThumbID}")
	public Integer deleteDosyaThumb(@Param("DosyaThumbID") Integer DosyaThumbID);
	
	@Select("select Dosya from dosya where DosyaID=${DosyaID}")
	public List<byte[]>  getDosya(@Param("DosyaID") Integer DosyaID);
	
	@Select("SELECT DosyaThumb FROM dosyathumb WHERE DosyaThumbID = ${DosyaThumbID}")
	public List<byte[]>  getDosyaThumb(@Param("DosyaThumbID") Integer DosyaThumbID);
	

	

}
