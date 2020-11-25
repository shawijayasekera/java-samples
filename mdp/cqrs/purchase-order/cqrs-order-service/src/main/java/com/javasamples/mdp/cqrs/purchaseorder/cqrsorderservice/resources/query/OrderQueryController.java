package com.javasamples.mdp.cqrs.purchaseorder.cqrsorderservice.resources.query;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javasamples.mdp.cqrs.purchaseorder.cqrsorderservice.dto.PurchaseOrderSummaryDTO;
import com.javasamples.mdp.cqrs.purchaseorder.cqrsorderservice.service.OrderQueryService;

@RestController
@RequestMapping("po")
public class OrderQueryController {

	@Autowired
	private OrderQueryService orderQueryService;

	@GetMapping("/summary")
	public List<PurchaseOrderSummaryDTO> getSummary() {

		return this.orderQueryService.getSaleSummaryGroupByState();
	}

	@GetMapping("/summary/{state}")
	public PurchaseOrderSummaryDTO getStateSummary(@PathVariable String state) {

		return this.orderQueryService.getSaleSummaryByState(state);
	}

	@GetMapping("/total-sale")
	public Double getTotalSale() {

		return this.orderQueryService.getTotalSale();
	}
}
