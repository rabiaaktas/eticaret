package edu.akdeniz.eticaret.model;

import java.io.Serializable;

public class UserInfModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer KullaniciId,musteriID,KullaniciRolId,aktif;
	private String KullaniciAdi,Isim,Soyisim,Email,MusteriAdres,RolAdi,Sifre,Musteritelefon;
	public Integer getKullaniciId() {
		return KullaniciId;
	}
	public void setKullaniciId(Integer kullaniciId) {
		KullaniciId = kullaniciId;
	}
	public Integer getMusteriID() {
		return musteriID;
	}
	public void setMusteriID(Integer musteriID) {
		this.musteriID = musteriID;
	}
	public Integer getKullaniciRolId() {
		return KullaniciRolId;
	}
	public void setKullaniciRolId(Integer kullaniciRolId) {
		KullaniciRolId = kullaniciRolId;
	}
	public String getKullaniciAdi() {
		return KullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		KullaniciAdi = kullaniciAdi;
	}
	public String getIsim() {
		return Isim;
	}
	public void setIsim(String isim) {
		Isim = isim;
	}
	public String getSoyisim() {
		return Soyisim;
	}
	public void setSoyisim(String soyisim) {
		Soyisim = soyisim;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMusteriAdres() {
		return MusteriAdres;
	}
	public void setMusteriAdres(String musteriAdres) {
		MusteriAdres = musteriAdres;
	}
	public String getRolAdi() {
		return RolAdi;
	}
	public void setRolAdi(String rolAdi) {
		RolAdi = rolAdi;
	}
	public String getSifre() {
		return Sifre;
	}
	public void setSifre(String sifre) {
		Sifre = sifre;
	}
	public Integer getAktif() {
		return aktif;
	}
	public void setAktif(Integer aktif) {
		this.aktif = aktif;
	}
	public String getMusteritelefon() {
		return Musteritelefon;
	}
	public void setMusteritelefon(String musteritelefon) {
		Musteritelefon = musteritelefon;
	}
	

}
