package edu.akdeniz.eticaret.model;

import java.io.Serializable;

public class StokModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int StokID,UrunId,Adet;

	public int getStokID() {
		return StokID;
	}

	public void setStokID(int stokID) {
		StokID = stokID;
	}

	public int getUrunId() {
		return UrunId;
	}

	public void setUrunId(int urunId) {
		UrunId = urunId;
	}

	public int getAdet() {
		return Adet;
	}

	public void setAdet(int adet) {
		Adet = adet;
	}

}
