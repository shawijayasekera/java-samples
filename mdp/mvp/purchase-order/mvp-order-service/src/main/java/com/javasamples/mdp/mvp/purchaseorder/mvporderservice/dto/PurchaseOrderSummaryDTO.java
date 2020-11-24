package com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dto;

public class PurchaseOrderSummaryDTO {

	private String state;
	private double totalSale;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(double totalSale) {
		this.totalSale = totalSale;
	}
}
