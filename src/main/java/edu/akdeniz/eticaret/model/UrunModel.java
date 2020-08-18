package edu.akdeniz.eticaret.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;
public class UrunModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer UrunID,KategoriID,DosyaId,dosyaThumbId,Adet,StokID;
	private float UrunAlisFiyat;
	private String UrunAdi,UrunKod,Aciklama,KategoriAdi,ISBN,yazarAdi,sayfaSayisi,basýmYili,KategoriKod;
	private MultipartFile urunresim,urunresimthumb;
	private String  DosyaString,DosyaThumbString;
	private byte[] dosya,dosyaThumb;
	
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
	public Integer getUrunID() {
		return UrunID;
	}
	public void setUrunID(Integer urunID) {
		UrunID = urunID;
	}
	public Integer getDosyaId() {
		return DosyaId;
	}
	public void setDosyaId(Integer dosyaId) {
		DosyaId = dosyaId;
	}

	public String getUrunKod() {
		return UrunKod;
	}
	public void setUrunKod(String urunKod) {
		UrunKod = urunKod;
	}
	public String getAciklama() {
		return Aciklama;
	}
	public void setAciklama(String aciklama) {
		Aciklama = aciklama;
	}
	public MultipartFile getUrunresim() {
		return urunresim;
	}
	public void setUrunresim(MultipartFile urunresim) {
		this.urunresim = urunresim;
	}
	public String getKategoriAdi() {
		return KategoriAdi;
	}
	public void setKategoriAdi(String kategoriAdi) {
		KategoriAdi = kategoriAdi;
	}
	public Integer getKategoriID() {
		return KategoriID;
	}
	public void setKategoriID(Integer kategoriID) {
		KategoriID = kategoriID;
	}
	public String getDosyaString() {
		return DosyaString;
	}
	public void setDosyaString(String dosyaString) {
		DosyaString = dosyaString;
	}
	public byte[] getDosya() {
		return dosya;
	}
	public void setDosya(byte[] dosya) {
		this.dosya = dosya;
	}
	public Integer getAdet() {
		return Adet;
	}
	public void setAdet(Integer adet) {
		Adet = adet;
	}
	public Integer getStokID() {
		return StokID;
	}
	public void setStokID(Integer stokID) {
		StokID = stokID;
	}
	public String getSayfaSayisi() {
		return sayfaSayisi;
	}
	public void setSayfaSayisi(String sayfaSayisi) {
		this.sayfaSayisi = sayfaSayisi;
	}
	public String getBasýmYili() {
		return basýmYili;
	}
	public void setBasýmYili(String basýmYili) {
		this.basýmYili = basýmYili;
	}
	public String getKategoriKod() {
		return KategoriKod;
	}
	public void setKategoriKod(String kategoriKod) {
		KategoriKod = kategoriKod;
	}
	public String getUrunAdi() {
		return UrunAdi;
	}
	public void setUrunAdi(String urunAdi) {
		UrunAdi = urunAdi;
	}
	public float getUrunAlisFiyat() {
		return UrunAlisFiyat;
	}
	public void setUrunAlisFiyat(float urunAlisFiyat) {
		UrunAlisFiyat = urunAlisFiyat;
	}
	public MultipartFile getUrunresimthumb() {
		return urunresimthumb;
	}
	public void setUrunresimthumb(MultipartFile urunresimthumb) {
		this.urunresimthumb = urunresimthumb;
	}
	public Integer getDosyaThumbId() {
		return dosyaThumbId;
	}
	public void setDosyaThumbId(Integer dosyaThumbId) {
		this.dosyaThumbId = dosyaThumbId;
	}
	public byte[] getDosyaThumb() {
		return dosyaThumb;
	}
	public void setDosyaThumb(byte[] dosyaThumb) {
		this.dosyaThumb = dosyaThumb;
	}
	public String getDosyaThumbString() {
		return DosyaThumbString;
	}
	public void setDosyaThumbString(String dosyaThumbString) {
		DosyaThumbString = dosyaThumbString;
	}
	
}
