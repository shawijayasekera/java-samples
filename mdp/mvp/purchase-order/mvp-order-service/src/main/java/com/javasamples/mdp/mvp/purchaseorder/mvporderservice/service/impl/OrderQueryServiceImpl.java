package com.javasamples.mdp.mvp.purchaseorder.mvporderservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dao.PurchaseOrderSummaryRepository;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dto.PurchaseOrderSummaryDTO;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dto.domain.PurchaseOrderSummary;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.service.OrderQueryService;

@Service
public class OrderQueryServiceImpl implements OrderQueryService {

	@Autowired
	private PurchaseOrderSummaryRepository purchaseOrderSummaryRepository;

	@Override
	public List<PurchaseOrderSummaryDTO> getSaleSummaryGroupByState() {

		return this.purchaseOrderSummaryRepository.findAll().stream().map(this::entityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public PurchaseOrderSummaryDTO getSaleSummaryByState(String state) {

		return this.purchaseOrderSummaryRepository.findByState(state).map(this::entityToDto)
				.orElseGet(() -> new PurchaseOrderSummaryDTO(state, 0));
	}

	@Override
	public double getTotalSale() {

		return this.purchaseOrderSummaryRepository.findAll().stream().mapToDouble(PurchaseOrderSummary::getTotalSale)
				.sum();
	}

	private PurchaseOrderSummaryDTO entityToDto(PurchaseOrderSummary purchaseOrderSummary) {

		PurchaseOrderSummaryDTO dto = new PurchaseOrderSummaryDTO();
		dto.setState(purchaseOrderSummary.getState());
		dto.setTotalSale(purchaseOrderSummary.getTotalSale());
		return dto;
	}
}
