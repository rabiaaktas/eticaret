package edu.akdeniz.eticaret.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

import edu.akdeniz.eticaret.helper.model.IdentityCurrentModel;


public interface DosyaMapper {
	
	@Insert("insert into Dosya (Dosya,IslemTarihi,KullaniciId) "
			+ "values (#{Dosya, javaType = byte[], jdbcType = BLOB, typeHandler = org.apache.ibatis.type.BlobTypeHandler},NOW(),${KullaniciId})")
	@Options(useGeneratedKeys = true, keyProperty = "DosyaID")
	@SelectKey(statement = "SELECT  LAST_INSERT_ID()", keyProperty = "DosyaId.IdCurrent", before = false, resultType = int.class)
	public Integer dosyaInsert(@Param("Dosya") byte[] Dosya,
			@Param("KullaniciId") Integer KullaniciId,
			@Param("DosyaId") IdentityCurrentModel DosyaId);
	
	@Insert("insert into Dosyathumb (DosyaThumb,IslemTarihi,KullaniciId) "
			+ "values (#{dosyaThumb, javaType = byte[], jdbcType = BLOB, typeHandler = org.apache.ibatis.type.BlobTypeHandler},NOW(),${KullaniciId})")
	@Options(useGeneratedKeys = true, keyProperty = "DosyaID")
	@SelectKey(statement = "SELECT  LAST_INSERT_ID()", keyProperty = "DosyaThumbId.IdCurrent", before = false, resultType = int.class)
	public Integer dosyaInsertThumb(@Param("dosyaThumb") byte[] dosyaThumb,
			@Param("KullaniciId") Integer KullaniciId,
			@Param("DosyaThumbId") IdentityCurrentModel DosyaThumbId);                                 
}
