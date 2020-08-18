package edu.akdeniz.eticaret.model;

public class ItemModel {

	private UrunModel urunModel;
	private Integer quantity;
	public UrunModel getUrunModel() {
		return urunModel;
	}
	public void setUrunModel(UrunModel urunModel) {
		this.urunModel = urunModel;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public ItemModel() {
	}
	public ItemModel(UrunModel urunModel,Integer quantity) {
		this.urunModel = urunModel;
		this.quantity = quantity;
	}
}
