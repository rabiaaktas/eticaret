package edu.akdeniz.eticaret.model;

import java.io.Serializable;

public class KategoriModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer KategoriID;
	private String KategoriAdi,KategoriKod,Aciklama;
	
	public Integer getKategoriID() {
		return KategoriID;
	}
	public void setKategoriID(Integer kategoriID) {
		KategoriID = kategoriID;
	}
	public String getKategoriAdi() {
		return KategoriAdi;
	}
	public void setKategoriAdi(String kategoriAdi) {
		KategoriAdi = kategoriAdi;
	}
	public String getKategoriKod() {
		return KategoriKod;
	}
	public void setKategoriKod(String kategoriKod) {
		KategoriKod = kategoriKod;
	}
	public String getAciklama() {
		return Aciklama;
	}
	public void setAciklama(String aciklama) {
		Aciklama = aciklama;
	}


}
