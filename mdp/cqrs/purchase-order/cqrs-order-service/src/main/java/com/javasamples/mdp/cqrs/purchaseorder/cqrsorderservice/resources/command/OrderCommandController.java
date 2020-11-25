package com.javasamples.mdp.cqrs.purchaseorder.cqrsorderservice.resources.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javasamples.mdp.cqrs.purchaseorder.cqrsorderservice.dto.OrderCommandDTO;
import com.javasamples.mdp.cqrs.purchaseorder.cqrsorderservice.service.OrderCommandService;

@RestController
@RequestMapping("po")
public class OrderCommandController {

	@Autowired
	private OrderCommandService orderCommandService;

	@PostMapping("/sale")
	public void placeOrder(@RequestBody OrderCommandDTO dto) {

		this.orderCommandService.createOrder(dto.getUserIndex(), dto.getProductIndex());
	}

	@DeleteMapping("/cancelorder/{orderId}")
	public void cancelOrder(@PathVariable long orderId) {

		this.orderCommandService.cancelOrder(orderId);
	}
}
