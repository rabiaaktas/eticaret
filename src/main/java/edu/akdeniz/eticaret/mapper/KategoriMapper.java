package edu.akdeniz.eticaret.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.akdeniz.eticaret.model.KategoriModel;

public interface KategoriMapper {
	
	@Select("Select * from Kategori")
	public List<KategoriModel> getKategori();
	
	@Select("SELECT COUNT(*) FROM kategori")
	public Integer NumOfCategories();

	@Insert("INSERT INTO kategori(KategoriAdi,KategoriKod,Aciklama) VALUES ('${KategoriAdi}','${KategoriKod}','${Aciklama}')")
	public Integer kategoriEkle(@Param("KategoriAdi") String KategoriAdi,
								@Param("KategoriKod") String KategoriKod,
								@Param("Aciklama") 	  String Aciklama);
	
	
	@Select("Select * From Kategori Where KategoriID=${KategoriID}")
	public KategoriModel getKategoriByID(@Param("KategoriID") Integer KategoriID);
	
	@Update("UPDATE kategori SET KategoriAdi='${KategoriAdi}',KategoriKod='${KategoriKod}',Aciklama='${Aciklama}' WHERE KategoriID=${KategoriID}")
	public Integer kategoriUpdate(@Param("KategoriAdi") String KategoriAdi,
								  @Param("KategoriKod") String KategoriKod,
								  @Param("Aciklama") String Aciklama,
								  @Param("KategoriID") Integer KategoriID);
	
	@Delete("DELETE FROM kategori WHERE KategoriID = ${KategoriID}")
	public Integer kategoriDelete(
			@Param("KategoriID") Integer KategoriID
			);
	
	@Select("Select * from Kategori WHERE KategoriAdi LIKE '%${searchVal}%'")
	public List<KategoriModel> CategorySearch(@Param("searchVal") String searchVal);
}
