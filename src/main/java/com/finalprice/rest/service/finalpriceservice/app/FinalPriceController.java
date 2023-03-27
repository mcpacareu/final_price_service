package com.finalprice.rest.service.finalpriceservice.app;

import org.springframework.web.bind.annotation.RestController;

import com.finalprice.rest.service.finalpriceservice.app.dtos.PriceDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/final-price")
public class FinalPriceController {

	@Autowired
	private FinalPriceService finalPriceService;

	@GetMapping()
	public ResponseEntity<PriceDTO> getFinalPrice(@RequestParam("date") String date,
			@RequestParam("product-id") long productId, @RequestParam("brand-id") long brandId) {
		try {
			PriceDTO price = finalPriceService.getFinalPriceByDateAndProductIdAndBrandId(date, productId, brandId);
			return ResponseEntity.ok(price);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
