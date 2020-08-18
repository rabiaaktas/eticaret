package edu.akdeniz.eticaret.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.security.core.userdetails.User;

import edu.akdeniz.eticaret.model.UserInfModel;

public interface UserMapper {
	
	//@Select("SELECT * FROM kullanici as k LEFT OUTER JOIN musteri m ON k.MusteriId=m.musteriID")
//	@Select("SELECT * FROM (kullanici LEFT OUTER JOIN musteri ON kullanici.MusteriId=musteri.musteriID) "
//			+ "LEFT OUTER JOIN role ON kullanici.KullaniciRolId=role.RolID")
	@Select("SELECT * FROM kullanici as k LEFT OUTER JOIN musteri as m ON k.musteriId=m.musteriID"
			+ " LEFT OUTER JOIN role as r ON k.kullaniciRolId=RolID LIMIT ${pageId-1} , ${total}")
	public List<UserInfModel> getKullaniciList(@Param("pageId") Integer pageId,@Param("total") Integer total);
	
	@Select("SELECT COUNT(*) FROM kullanici as k LEFT OUTER JOIN musteri as m ON k.musteriId=m.musteriID" + 
			" LEFT OUTER JOIN role as r ON k.kullaniciRolId=RolID")
	public Integer NumOfUsers();
	
	@Select("SELECT COUNT(*) FROM kullanici as k LEFT OUTER JOIN musteri as m ON k.musteriId=m.musteriID " + 
			" LEFT OUTER JOIN role as r ON k.kullaniciRolId=RolID WHERE KullaniciAdi LIKE '%${searchVal}%' OR Isim LIKE '%${searchVal}%'" + 
			"OR Soyisim LIKE '%${searchVal}%' OR Email LIKE '%${searchVal}%' OR MusteriAdres LIKE '%${searchVal}%'")
	public Integer NumOfSearchedUsers(@Param("searchVal") String searchVal);
	
	@Select("SELECT * FROM kullanici as k LEFT OUTER JOIN musteri as m ON k.musteriId=m.musteriID " + 
			"LEFT OUTER JOIN role as r ON k.kullaniciRolId=RolID WHERE KullaniciAdi LIKE '%${searchVal}%' OR Isim LIKE '%${searchVal}%'"
			+ "OR Soyisim LIKE '%${searchVal}%' OR Email LIKE '%${searchVal}%' OR MusteriAdres LIKE '%${searchVal}%' LIMIT ${pageId-1},${total}")
	public List<UserInfModel> searchedUsers(@Param("searchVal") String searchVal,
			@Param("pageId") Integer pageId,@Param("total") Integer total);
	
	@Update("")
	public Integer updateUser();

	@Select("SELECT * FROM (kullanici LEFT OUTER JOIN musteri ON kullanici.MusteriId=musteri.musteriID)"
			+ "LEFT OUTER JOIN role ON kullanici.KullaniciRolId=role.RolID Where kullaniciID=${kullaniciId}")
	public UserInfModel getUserByID(@Param("kullaniciId") Integer kullaniciID);
	
	@Update("UPDATE kullanici SET aktif=0 WHERE kullaniciID=${kullaniciID}")
	public Integer deAktifUs(@Param("kullaniciID") Integer kullaniciID);
	
	@Update("UPDATE kullanici SET aktif=1 WHERE kullaniciID=${kullaniciID}")
	public Integer aktifUs(@Param("kullaniciID") Integer kullaniciID);

	@Update("UPDATE kullanici SET KullaniciRolId=2 WHERE kullaniciID=${kullaniciID}")
	public Integer setAdmin(@Param("kullaniciID") Integer kullaniciID);
	
	@Update("UPDATE kullanici SET KullaniciRolId=1 WHERE kullaniciID=${kullaniciID}")
	public Integer setUser(@Param("kullaniciID") Integer kullaniciID);
	
	@Select("SELECT * FROM kullanici k LEFT OUTER JOIN role r ON k.KullaniciRolId = r.RolID "
			+ "LEFT OUTER JOIN musteri m ON k.MusteriId = m.musteriID WHERE KullaniciAdi LIKE '${userName}'")
	public UserInfModel getUserbyUsername(@Param("userName") String userName);
}