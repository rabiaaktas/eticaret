package edu.akdeniz.eticaret.helper.model;

import java.io.Serializable;

public class IslemSonucModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer Durum;
	private String Aciklama;
	
	public String getAciklama() {
		return Aciklama;
	}
	public void setAciklama(String aciklama) {
		Aciklama = aciklama;
	}
	public Integer getDurum() {
		return Durum;
	}
	public void setDurum(Integer durum) {
		Durum = durum;
	}

}
