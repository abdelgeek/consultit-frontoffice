package com.consultitnow.model;

public class PurchaseOrderModel {

	
	private QuotationModel quotationModel;
	private EquipmentModel equipmentModel;
	private String placeOrderDate;
	
	
	public QuotationModel getQuotationModel() {
		return quotationModel;
	}
	public void setQuotationModel(QuotationModel quotationModel) {
		this.quotationModel = quotationModel;
	}
	public EquipmentModel getEquipmentModel() {
		return equipmentModel;
	}
	public void setEquipmentModel(EquipmentModel equipmentModel) {
		this.equipmentModel = equipmentModel;
	}
	public String getPlaceOrderDate() {
		return placeOrderDate;
	}
	public void setPlaceOrderDate(String placeOrderDate) {
		this.placeOrderDate = placeOrderDate;
	}
	@Override
	public String toString() {
		return "PurchaseOrderModel [quotationModel=" + quotationModel + ", equipmentModel=" + equipmentModel
				+ ", placeOrderDate=" + placeOrderDate + "]";
	}
	
	
	
	
}
