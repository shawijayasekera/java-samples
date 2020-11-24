package com.javasamples.mdp.cqrs.purchaseorder.orderservice.dto;

public class PurchaseOrderSummaryDTO {

	private String state;
	private double totalSale;

	public PurchaseOrderSummaryDTO() {
	}

	public PurchaseOrderSummaryDTO(String state, double totalSale) {
		this.state = state;
		this.totalSale = totalSale;
	}

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
