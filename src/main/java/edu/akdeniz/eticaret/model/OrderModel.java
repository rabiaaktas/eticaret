package edu.akdeniz.eticaret.model;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class OrderModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer SiparisID,KisiId,SiparisDurumId,OdemeSecenekId,SiparisDurumID,SiparisUrunID,Adet,UrunId,SiparisId,
	KullaniciId,MusteriId,sayfaSayisi,DosyaId,DosyaThumbId,KategoriId;
	private Date SiparisTarihi;
	private float BirimFiyat,ToplamTutar;
	private byte[] dosya,dosyaThumb;
	private String  DosyaString,DosyaThumbString;
	private MultipartFile urunresim,urunresimthumb;
	private String siparisAdres,telefon,OdemeSecenekAdi,OdemeSecenekKod,SiparisDurumAdi,siparisDurumKod,KullaniciAdi,
	UrunAdi,UrunKod,ISBN,yazarAdi,basýmYili,Isim,Soyisim,Email;
	
	public Integer getSiparisID() {
		return SiparisID;
	}
	public void setSiparisID(Integer siparisID) {
		SiparisID = siparisID;
	}
	public Integer getKisiId() {
		return KisiId;
	}
	public void setKisiId(Integer kisiId) {
		KisiId = kisiId;
	}
	public Integer getSiparisDurumId() {
		return SiparisDurumId;
	}
	public void setSiparisDurumId(Integer siparisDurumId) {
		SiparisDurumId = siparisDurumId;
	}
	public Integer getOdemeSecenekId() {
		return OdemeSecenekId;
	}
	public void setOdemeSecenekId(Integer odemeSecenekId) {
		OdemeSecenekId = odemeSecenekId;
	}
	public Integer getSiparisDurumID() {
		return SiparisDurumID;
	}
	public void setSiparisDurumID(Integer siparisDurumID) {
		SiparisDurumID = siparisDurumID;
	}
	public Integer getSiparisUrunID() {
		return SiparisUrunID;
	}
	public void setSiparisUrunID(Integer siparisUrunID) {
		SiparisUrunID = siparisUrunID;
	}
	public Integer getAdet() {
		return Adet;
	}
	public void setAdet(Integer adet) {
		Adet = adet;
	}
	public Integer getUrunId() {
		return UrunId;
	}
	public void setUrunId(Integer urunId) {
		UrunId = urunId;
	}
	public Integer getSiparisId() {
		return SiparisId;
	}
	public void setSiparisId(Integer siparisId) {
		SiparisId = siparisId;
	}
	public Integer getKullaniciId() {
		return KullaniciId;
	}
	public void setKullaniciId(Integer kullaniciId) {
		KullaniciId = kullaniciId;
	}
	public Date getSiparisTarihi() {
		return SiparisTarihi;
	}
	public void setSiparisTarihi(Date siparisTarihi) {
		SiparisTarihi = siparisTarihi;
	}
	public float getBirimFiyat() {
		return BirimFiyat;
	}
	public void setBirimFiyat(float birimFiyat) {
		BirimFiyat = birimFiyat;
	}
	public float getToplamTutar() {
		return ToplamTutar;
	}
	public void setToplamTutar(float toplamTutar) {
		ToplamTutar = toplamTutar;
	}
	public String getSiparisAdres() {
		return siparisAdres;
	}
	public void setSiparisAdres(String siparisAdres) {
		this.siparisAdres = siparisAdres;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getOdemeSecenekAdi() {
		return OdemeSecenekAdi;
	}
	public void setOdemeSecenekAdi(String odemeSecenekAdi) {
		OdemeSecenekAdi = odemeSecenekAdi;
	}
	public String getOdemeSecenekKod() {
		return OdemeSecenekKod;
	}
	public void setOdemeSecenekKod(String odemeSecenekKod) {
		OdemeSecenekKod = odemeSecenekKod;
	}
	public String getSiparisDurumAdi() {
		return SiparisDurumAdi;
	}
	public void setSiparisDurumAdi(String siparisDurumAdi) {
		SiparisDurumAdi = siparisDurumAdi;
	}
	public String getSiparisDurumKod() {
		return siparisDurumKod;
	}
	public void setSiparisDurumKod(String siparisDurumKod) {
		this.siparisDurumKod = siparisDurumKod;
	}
	public Integer getMusteriId() {
		return MusteriId;
	}
	public void setMusteriId(Integer musteriId) {
		MusteriId = musteriId;
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
	public Integer getSayfaSayisi() {
		return sayfaSayisi;
	}
	public void setSayfaSayisi(Integer sayfaSayisi) {
		this.sayfaSayisi = sayfaSayisi;
	}
	public Integer getDosyaId() {
		return DosyaId;
	}
	public void setDosyaId(Integer dosyaId) {
		DosyaId = dosyaId;
	}
	public Integer getDosyaThumbId() {
		return DosyaThumbId;
	}
	public void setDosyaThumbId(Integer dosyaThumbId) {
		DosyaThumbId = dosyaThumbId;
	}
	public Integer getKategoriId() {
		return KategoriId;
	}
	public void setKategoriId(Integer kategoriId) {
		KategoriId = kategoriId;
	}
	public String getUrunAdi() {
		return UrunAdi;
	}
	public void setUrunAdi(String urunAdi) {
		UrunAdi = urunAdi;
	}
	public String getUrunKod() {
		return UrunKod;
	}
	public void setUrunKod(String urunKod) {
		UrunKod = urunKod;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getYazarAdi() {
		return yazarAdi;
	}
	public void setYazarAdi(String yazarAdi) {
		this.yazarAdi = yazarAdi;
	}
	public String getBasýmYili() {
		return basýmYili;
	}
	public void setBasýmYili(String basýmYili) {
		this.basýmYili = basýmYili;
	}
	public byte[] getDosya() {
		return dosya;
	}
	public void setDosya(byte[] dosya) {
		this.dosya = dosya;
	}
	public byte[] getDosyaThumb() {
		return dosyaThumb;
	}
	public void setDosyaThumb(byte[] dosyaThumb) {
		this.dosyaThumb = dosyaThumb;
	}
	public String getDosyaString() {
		return DosyaString;
	}
	public void setDosyaString(String dosyaString) {
		DosyaString = dosyaString;
	}
	public String getDosyaThumbString() {
		return DosyaThumbString;
	}
	public void setDosyaThumbString(String dosyaThumbString) {
		DosyaThumbString = dosyaThumbString;
	}
	public MultipartFile getUrunresim() {
		return urunresim;
	}
	public void setUrunresim(MultipartFile urunresim) {
		this.urunresim = urunresim;
	}
	public MultipartFile getUrunresimthumb() {
		return urunresimthumb;
	}
	public void setUrunresimthumb(MultipartFile urunresimthumb) {
		this.urunresimthumb = urunresimthumb;
	}
}
