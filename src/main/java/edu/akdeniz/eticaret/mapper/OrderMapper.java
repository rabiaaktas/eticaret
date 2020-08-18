package edu.akdeniz.eticaret.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.akdeniz.eticaret.model.OrderModel;

public interface OrderMapper {
	
	@Update("UPDATE siparis SET SiparisDurumId=${SiparisDurumId} WHERE SiparisID= ${SiparisId}")
	public Integer updateOrderState(@Param("SiparisId") Integer SiparisId,
			@Param("SiparisDurumId") Integer SiparisDurumId); 
	
	@Select("SELECT * FROM siparisdurum ")
	public List<OrderModel> getSiparisDurumList();

	@Select("SELECT * FROM siparis AS s LEFT OUTER JOIN siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID "
			+ "LEFT OUTER JOIN odemesecenek AS o ON s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID "
			+ "LEFT OUTER JOIN kullanici AS k ON m.musteriID=k.MusteriId WHERE sd.siparisDurumKod = 'Hazýrlanýyor' ORDER BY SiparisTarihi DESC "
			+ "LIMIT ${pageId-1},${total}")
	public List<OrderModel> getOrderList(@Param("pageId") Integer pageId,@Param("total") Integer total);
	
	@Select("SELECT COUNT(*) FROM siparis AS s LEFT OUTER JOIN siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID LEFT OUTER JOIN "
			+ "odemesecenek AS o ON s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID "
			+ "LEFT OUTER JOIN kullanici AS k ON m.musteriID=k.MusteriId  WHERE sd.siparisDurumKod = 'Hazýrlanýyor' "
			+ "ORDER BY SiparisTarihi DESC")
	public Integer getOrderListCount();
	

	@Select("SELECT COUNT(su.SiparisId) FROM siparis AS s LEFT OUTER JOIN siparisurun AS su ON s.SiparisID=su.SiparisId " + 
			"LEFT OUTER JOIN siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID LEFT OUTER JOIN " + 
			"odemesecenek AS o ON s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID " + 
			"LEFT OUTER JOIN kullanici AS k ON m.musteriID=k.MusteriId WHERE sd.siparisDurumKod = 'Hazýrlanýyor'")
	public Integer getUrunCount();
	

	@Select("SELECT * FROM siparis AS s LEFT OUTER JOIN siparisurun AS su ON s.SiparisID=su.SiparisId " + 
			"LEFT OUTER JOIN siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID LEFT OUTER JOIN "
			+ "odemesecenek AS o ON s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID "
			+ "LEFT OUTER JOIN kullanici AS k ON m.musteriID=k.MusteriId LEFT OUTER JOIN urun u ON su.UrunId=u.UrunID "
			+ "LEFT OUTER JOIN dosya AS d ON d.DosyaID=u.DosyaId LEFT OUTER JOIN dosyathumb AS dt ON "
			+ "dt.DosyaThumbID = u.DosyaThumbId WHERE s.SiparisID = ${SiparisID} AND sd.siparisDurumKod = 'Hazýrlanýyor'")
	public List<OrderModel> getSiparisUrunler(@Param("SiparisID") Integer SiparisID);
	
	@Select("SELECT * FROM siparis AS s LEFT OUTER JOIN siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID LEFT OUTER JOIN " + 
			"odemesecenek AS o ON s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID " + 
			"LEFT OUTER JOIN kullanici AS k ON m.musteriID=k.MusteriId  WHERE  sd.siparisDurumKod = 'Hazýrlanýyor'"
			+ " AND (Isim LIKE '%${searchVal}%' OR Soyisim LIKE '%${searchVal}%' OR  KullaniciAdi LIKE '%${searchVal}%' OR Email LIKE '%${searchVal}%')"
			+ " ORDER BY SiparisTarihi DESC LIMIT ${pageId-1},${total}")
	public List<OrderModel> searchedOrders(@Param("searchVal") String searchVal,
			@Param("pageId") Integer pageId,
			@Param("total") Integer total);
	
	@Select("SELECT * FROM siparis AS s LEFT OUTER JOIN siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID "
			+ "LEFT OUTER JOIN odemesecenek AS o ON s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID "
			+ "LEFT OUTER JOIN kullanici AS k ON m.musteriID=k.MusteriId WHERE sd.siparisDurumKod = 'Kargoda' ORDER BY SiparisTarihi DESC "
			+ " LIMIT ${pageId-1},${total}")
	public List<OrderModel> getOrderListKargo(@Param("pageId") Integer pageId,@Param("total") Integer total);
	
	@Select("SELECT COUNT(*) FROM siparis AS s LEFT OUTER JOIN siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID LEFT OUTER JOIN "
			+ "odemesecenek AS o ON s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID "
			+ "LEFT OUTER JOIN kullanici AS k ON m.musteriID=k.MusteriId WHERE sd.siparisDurumKod = 'Kargoda'"
			+ " ORDER BY SiparisTarihi DESC")
	public Integer getOrderListKargoCount();
	
	@Select("SELECT COUNT(su.SiparisId) FROM siparis AS s LEFT OUTER JOIN siparisurun AS su ON s.SiparisID=su.SiparisId " + 
			"LEFT OUTER JOIN siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID LEFT OUTER JOIN " + 
			"odemesecenek AS o ON s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID " + 
			"LEFT OUTER JOIN kullanici AS k ON m.musteriID=k.MusteriId WHERE sd.siparisDurumKod = 'Kargoda'")
	public Integer getCargoUrunCount();
	
		@Select("SELECT * FROM siparis AS s LEFT OUTER JOIN siparisurun AS su ON s.SiparisID=su.SiparisId LEFT OUTER JOIN "
				+ "siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID LEFT OUTER JOIN odemesecenek AS o ON "
				+ "s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID LEFT OUTER JOIN kullanici "
				+ "AS k ON m.musteriID=k.MusteriId LEFT OUTER JOIN urun u ON su.UrunId=u.UrunID LEFT OUTER JOIN dosya AS d ON "
				+ "d.DosyaID=u.DosyaId LEFT OUTER JOIN dosyathumb AS dt ON dt.DosyaThumbID = u.DosyaThumbId WHERE s.SiparisID =${SiparisId} "
				+ "AND sd.siparisDurumKod = 'Kargoda' ")
	public List<OrderModel> getCargoSiparisUrunler(@Param("SiparisId") Integer SiparisId);
		

		@Select("SELECT * FROM siparis AS s LEFT OUTER JOIN siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID LEFT OUTER JOIN " + 
				"odemesecenek AS o ON s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID " + 
				"LEFT OUTER JOIN kullanici AS k ON m.musteriID=k.MusteriId  WHERE  sd.siparisDurumKod = 'Kargoda'"
				+ " AND (Isim LIKE '%${searchVal}%' OR Soyisim LIKE '%${searchVal}%' OR  KullaniciAdi LIKE '%${searchVal}%' OR Email LIKE '%${searchVal}%')"
				+ " ORDER BY SiparisTarihi DESC LIMIT ${pageId-1},${total}")
		public List<OrderModel> searchedOrdersInCargo(@Param("searchVal") String searchVal,
				@Param("pageId") Integer pageId,
				@Param("total") Integer total);
		
		@Select("SELECT * FROM siparis AS s LEFT OUTER JOIN siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID "
				+ "LEFT OUTER JOIN odemesecenek AS o ON s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID "
				+ "LEFT OUTER JOIN kullanici AS k ON m.musteriID=k.MusteriId WHERE sd.siparisDurumKod = 'TeslimEdildi' ORDER BY SiparisTarihi DESC "
				+ " LIMIT ${pageId-1},${total}")
	public List<OrderModel> getOrderListTeslim(@Param("pageId") Integer pageId,@Param("total") Integer total);
		
		@Select("SELECT COUNT(*) FROM siparis AS s LEFT OUTER JOIN siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID LEFT OUTER JOIN "
				+ "odemesecenek AS o ON s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID "
				+ "LEFT OUTER JOIN kullanici AS k ON m.musteriID=k.MusteriId WHERE sd.siparisDurumKod = 'TeslimEdildi'"
				+ " ORDER BY SiparisTarihi DESC")
	public Integer getOrderListTeslimCount();
		
		@Select("SELECT COUNT(su.SiparisId) FROM siparis AS s LEFT OUTER JOIN siparisurun AS su ON s.SiparisID=su.SiparisId " + 
				"LEFT OUTER JOIN siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID LEFT OUTER JOIN " + 
				"odemesecenek AS o ON s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID " + 
				"LEFT OUTER JOIN kullanici AS k ON m.musteriID=k.MusteriId WHERE sd.siparisDurumKod = 'TeslimEdildi'")
	public Integer getTeslimUrunCount();
		
			@Select("SELECT * FROM siparis AS s LEFT OUTER JOIN siparisurun AS su ON s.SiparisID=su.SiparisId LEFT OUTER JOIN "
					+ "siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID LEFT OUTER JOIN odemesecenek AS o ON "
					+ "s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID LEFT OUTER JOIN kullanici "
					+ "AS k ON m.musteriID=k.MusteriId LEFT OUTER JOIN urun u ON su.UrunId=u.UrunID LEFT OUTER JOIN dosya AS d "
					+ "ON d.DosyaID=u.DosyaId LEFT OUTER JOIN dosyathumb AS dt ON dt.DosyaThumbID = u.DosyaThumbId WHERE s.SiparisID =${SiparisID} "
					+ "AND sd.siparisDurumKod = 'TeslimEdildi'")
	public List<OrderModel> getTeslimSiparisUrunler(@Param("SiparisID") Integer SiparisID);
			
			@Select("SELECT * FROM siparis AS s LEFT OUTER JOIN siparisdurum AS sd ON s.SiparisDurumId=sd.SiparisDurumID LEFT OUTER JOIN " + 
					"odemesecenek AS o ON s.OdemeSecenekId=o.OdemeSecenekID LEFT OUTER JOIN musteri AS m ON s.KisiId=m.musteriID " + 
					"LEFT OUTER JOIN kullanici AS k ON m.musteriID=k.MusteriId  WHERE  sd.siparisDurumKod = 'TeslimEdildi'"
					+ " AND (Isim LIKE '%${searchVal}%' OR Soyisim LIKE '%${searchVal}%' OR  KullaniciAdi LIKE '%${searchVal}%' OR Email LIKE '%${searchVal}%')"
					+ " ORDER BY SiparisTarihi DESC LIMIT ${pageId-1},${total}")
	public List<OrderModel> searchedOrdersInTeslim(@Param("searchVal") String searchVal,
			@Param("pageId") Integer pageId,
			@Param("total") Integer total);
		

}
