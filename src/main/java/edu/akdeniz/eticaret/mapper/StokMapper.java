package edu.akdeniz.eticaret.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.akdeniz.eticaret.model.StokModel;

public interface StokMapper {

	@Insert("INSERT INTO stok(UrunId, Adet) VALUES (${UrunId}, ${Adet})")
	public Integer urunStok(
			@Param("UrunId") Integer UrunId,
			@Param("Adet") Integer Adet);
	
	@Update("UPDATE stok SET Adet=${Adet} WHERE StokID=${StokID}")
	public Integer updtStok(
			@Param("Adet") Integer Adet,
			@Param("StokID") Integer StokID);
	
	@Select("SELECT * FROM stok WHERE UrunId=${UrunId}")
	public StokModel getAdet(@Param("UrunId") Integer UrunId);
	 
}
