package edu.akdeniz.eticaret.model;

import java.io.Serializable;

public class KayitModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String isim, Soyisim,Email,MusteriAdres,KullaniciAdi,Sifre,SifreTekrar;
	
	
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
	public String getKullaniciAdi() {
		return KullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		KullaniciAdi = kullaniciAdi;
	}
	public String getSifre() {
		return Sifre;
	}
	public void setSifre(String sifre) {
		Sifre = sifre;
	}
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getSifreTekrar() {
		return SifreTekrar;
	}
	public void setSifreTekrar(String sifreTekrar) {
		SifreTekrar = sifreTekrar;
	}
}
