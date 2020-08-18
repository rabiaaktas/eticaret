package edu.akdeniz.eticaret.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

import edu.akdeniz.eticaret.helper.model.IdentityCurrentModel;

public interface KayitMapper {

	@Insert("INSERT INTO musteri(Isim,Soyisim,Email,MusteriAdres,IslemTarihi) VALUES ('${Isim}','${Soyisim}','${Email}','${MusteriAdres}',NOW())")
	@Options(useGeneratedKeys = true, keyProperty = "MusteriID")
	@SelectKey(statement = "SELECT  LAST_INSERT_ID()", keyProperty = "MusteriId.IdCurrent", before = false, resultType = int.class)
	public Integer kayitMsuteri(@Param("Isim") String Isim,
							   @Param("Soyisim") String Soyisim,                                
			                   @Param("Email") String Email,
			                   @Param("MusteriAdres") String MusteriAdres,
			                   @Param("MusteriId") IdentityCurrentModel MusteriId); 
	
	
	@Insert("INSERT INTO kullanici(KullaniciAdi, KullaniciRolId, MusteriId, aktif, Sifre) VALUES ('${KullaniciAdi}',${KullaniciRolId},${MusteriId},1,'${Sifre}')")
	public Integer kayitKullanici(@Param("KullaniciAdi") String KullaniciAdi,
			                   @Param("KullaniciRolId") Integer KullaniciRolId, 
			                   @Param("MusteriId") Integer MusteriId, 
			                   @Param("Sifre") String Sifre);                           
}
