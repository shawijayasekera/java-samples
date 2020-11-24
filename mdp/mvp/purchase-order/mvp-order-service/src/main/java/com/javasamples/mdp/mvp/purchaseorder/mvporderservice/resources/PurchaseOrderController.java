package com.javasamples.mdp.mvp.purchaseorder.mvporderservice.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dto.OrderPlaceDTO;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dto.PurchaseOrderSummaryDTO;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.service.PurchaseOrderService;

@RestController
@RequestMapping("po")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService purchaseOrderService;

	@PostMapping("/sale")
	public void placeOrder(@RequestBody OrderPlaceDTO dto) {

		this.purchaseOrderService.placeOrder(dto.getUserIndex(), dto.getProductIndex());
	}

	@GetMapping("/summary")
	public List<PurchaseOrderSummaryDTO> getSummary() {

		return this.purchaseOrderService.getSaleSummary();
	}
}
